/*
 * Copyright (c) 2016 EMC Corporation. All Rights Reserved.
 */
package com.emc.ia.sdk.support.rest;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;


public class RestClient implements Closeable, StandardLinkRelations {

  private final HttpClient httpClient;
  private List<Header> headers;

  public RestClient() {
    this(new HttpClient());
  }

  public RestClient(HttpClient client) {
    this.httpClient = Objects.requireNonNull(client, "Missing HTTP client");
  }

  public void setHeaders(List<Header> headers) {
    this.headers = headers;
  }

  public <T> T get(String uri, final Class<T> type) throws IOException {
    return httpClient.execute(httpClient.httpGetRequest(uri, headers), type);
  }

  @Override
  public void close() {
    httpClient.close();
  }

  public <T> T post(String uri, HttpEntity entity, Class<T> type) throws IOException {
    return post(uri, headers, entity, type);
  }

  public <T> T post(String uri, List<Header> httpHeaders, HttpEntity entity, Class<T> type) throws IOException {
    HttpPost postRequest = httpClient.httpPostRequest(uri, httpHeaders);
    postRequest.setEntity(entity);
    return httpClient.execute(postRequest, type);
  }

  public <T> T put(String uri, Class<T> type) throws IOException {
    return httpClient.execute(httpClient.httpPutRequest(uri, headers), type);
  }

  public <T> T follow(LinkContainer state, String relation, Class<T> type) throws IOException {
    Objects.requireNonNull(state, "Missing state");
    return get(linkIn(state, relation).getHref(), type);
  }

  private Link linkIn(LinkContainer state, String relation) {
    Link result = state.getLinks().get(relation);
    Objects.requireNonNull(result, String.format("Missing link %s in %s", relation, state));
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T> T createCollectionItem(LinkContainer collection, String addLinkRelation, T item) throws IOException {
    String uri = linkIn(collection, addLinkRelation).getHref();
    T result = (T)post(uri, withContentType(MediaTypes.HAL), toJson(item), item.getClass());
    Objects.requireNonNull(result, String.format("Could not create item in %s%n%s", uri, item));
    return result;
  }

  public List<Header> withContentType(String contentType) {
    List<Header> result = new ArrayList<>(headers);
    result.add(new BasicHeader("Content-Type", contentType));
    return result;
  }

  private StringEntity toJson(Object object) throws IOException {
    return new StringEntity(new JsonFormatter().format(object));
  }

  @SuppressWarnings("unchecked")
  public <T extends LinkContainer> T refresh(T state) throws IOException {
    return (T)follow(state, LINK_SELF, state.getClass());
  }

}