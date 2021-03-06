/*
 * Copyright (c) 2016-2017 by OpenText Corporation. All Rights Reserved.
 */
package com.opentext.ia.sdk.support.http.apache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Locale;

import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.opentext.ia.sdk.support.http.BinaryPart;
import com.opentext.ia.sdk.support.http.Header;
import com.opentext.ia.sdk.support.http.HttpException;
import com.opentext.ia.sdk.support.http.ResponseFactory;
import com.opentext.ia.sdk.support.http.TextPart;
import com.opentext.ia.test.TestCase;


public class WhenMakingHttpCallsUsingApache extends TestCase {

  private final TestApacheHttpClient httpClient = new TestApacheHttpClient();
  private final HttpResponse response = mock(HttpResponse.class);
  private final StatusLine statusLine = mock(StatusLine.class);

  @Before
  public void init() throws IOException {
    when(response.getStatusLine()).thenReturn(statusLine);
    when(statusLine.getStatusCode()).thenReturn(200);
  }

  @After
  public void done() {
    httpClient.close();
  }

  @Test
  public void shouldGet() throws IOException {
    String uri = randomString();
    httpClient.setResponse(uri);
    String header = randomString();
    String value = randomString();

    String actual = httpClient.get(uri, Collections.singleton(new Header(header, value)), String.class);

    assertEquals("Response", uri, actual);
    HttpUriRequest request = assertRequest(uri, HttpGet.class);
    org.apache.http.Header[] headers = request.getAllHeaders();
    assertEquals("# headers", 1, headers.length);
    assertEquals("Header name", header, headers[0].getName());
    assertEquals("Header value", value, headers[0].getValue());
  }

  private <T extends HttpUriRequest> T assertRequest(String expectedUri, Class<T> expectedClass) {
    HttpUriRequest request = httpClient.getExecutedRequest();
    assertEquals("Request", expectedClass, request.getClass());
    assertEquals("Request URI", expectedUri, request.getURI().toString());
    return expectedClass.cast(request);
  }

  @Test(expected = HttpException.class)
  public void shouldThrowExceptionOnNonOkStatusCode() throws IOException {
    when(statusLine.getStatusCode()).thenReturn(400);

    getResponse(null);
  }

  private <T> T getResponse(Class<T> type) throws IOException {
    return httpClient.getResponseHandler(randomString(), randomString(), new org.apache.http.Header[0], type)
        .handleResponse(response);
  }

  @Test
  public void shouldReturnNullWhenNoEntity() throws IOException {
    Object body = getResponse(null);

    assertNull(body);
  }

  @Test
  public void shouldReturnBodyAsString() throws IOException {
    String expected = randomString();
    returnBody(expected);

    String actual = getResponse(String.class);

    assertEquals(expected, actual);
  }

  private void returnBody(String body) throws UnsupportedEncodingException {
    when(response.getEntity()).thenReturn(new StringEntity(body));
  }

  @Test
  public void shouldReturnBodyAsJson() throws IOException {
    String expected = randomString();
    returnBody("{ \"bar\": \"" + expected + "\" }");

    Foo actual = getResponse(Foo.class);

    assertEquals(expected, actual.getBar());
  }

  @Test
  public void shouldAllowCustomProcessingOfResponse() throws IOException {
    String uri = "http://google.com";
    String expected = randomString();
    ResponseFactory<String> responseFactory = (resp, closer) -> {
      return expected;
    };

    try {
      String actual = httpClient.get(uri, Collections.emptyList(), responseFactory);

      assertEquals("Response", expected, actual);
    } catch (HttpException e) {
      if (e.getCause() instanceof SSLHandshakeException) {
        // This can happen when on a VPN and the company blocks certain TLS traffic
        return;
      }
      throw e;
    }
  }

  @Test
  public void shouldPut() throws IOException {
    String uri = randomString();

    httpClient.put(uri, Collections.emptyList(), null);

    assertRequest(uri, HttpPut.class);
  }

  @Test
  public void shouldPost() throws IOException {
    String uri = randomString();
    String payload = randomString();

    httpClient.post(uri, Collections.emptyList(), null, payload);

    HttpPost request = assertRequest(uri, HttpPost.class);
    assertEquals("Payload", payload, EntityUtils.toString(request.getEntity()));
  }

  @Test
  public void shouldPostMultiPart() throws IOException {
    String uri = randomString();
    String data = randomString();
    try (InputStream stream = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8))) {
      httpClient.post(uri, Collections.emptyList(), null, new TextPart(randomString(), randomString()),
          new BinaryPart(randomString(), stream, randomString()));
    }

    HttpEntity entity = assertRequest(uri, HttpPost.class).getEntity();
    assertTrue("Is multi part", entity.getClass().getSimpleName().toLowerCase(Locale.ENGLISH).contains("multipart"));
  }

  @Test
  public void shouldBuildUris() {
    assertEquals("http://google.com/?q=foo+bar",
        httpClient.uri("http://google.com").addParameter("q", "foo bar").build());
  }

  @Test
  public void shouldBuildUrisWithParameters() {
    assertEquals("http://google.com/?q=foo",
        httpClient.uri("http://google.com/?q=foo").build());
  }

  @Test
  public void shouldAddRequestParameterOnlyOnce() {
    assertEquals("http://google.com/?q=bar",
        httpClient.uri("http://google.com/?q=foo").addParameter("q", "bar").build());
  }

  @Test
  public void shouldAddRequestParameterMultipleTimes() {
    assertEquals("http://google.com/?q=foo&q=bar",
        httpClient.uri("http://google.com/").addParameter("q", "foo").addParameter("q", "bar").build());
  }

  @Test
  public void shouldDelete() throws Exception {
    String uri = randomString();

    httpClient.delete(uri, Collections.emptyList());

    assertRequest(uri, HttpDelete.class);
  }


  public static class Foo {

    private String bar;

    public String getBar() {
      return bar;
    }

    public void setBar(String bar) {
      this.bar = bar;
    }

  }


  private static class TestApacheHttpClient extends ApacheHttpClient {

    private Object preparedResponse;
    private HttpUriRequest executedRequest;

    public HttpUriRequest getExecutedRequest() {
      return executedRequest;
    }

    public void setResponse(Object response) {
      preparedResponse = response;
    }

    @Override
    protected <T> T execute(HttpRequestBase request, Class<T> type) throws IOException {
      executedRequest = request;
      return type == null ? null : type.cast(preparedResponse);
    }

  }

}
