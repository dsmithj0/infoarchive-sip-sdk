/*
 * Copyright (c) 2016 EMC Corporation. All Rights Reserved.
 */
package com.emc.ia.sdk.configurer;

public interface InfoArchiveConfiguration {

  String PREFIX = "ia.";
  String NAME = "name";
  String NAMES = "names";
  String TYPE = "type";
  String DESCRIPTION = "description";

  String SERVER_PREFIX = PREFIX + "server.";
  String SERVER_AUTENTICATON_TOKEN = SERVER_PREFIX + "authentication.token";
  String SERVER_AUTHENTICATION_USER = SERVER_PREFIX + "authentication.user";
  String SERVER_AUTHENTICATION_PASSWORD = SERVER_PREFIX + "authentication.password";
  String SERVER_AUTHENTICATION_GATEWAY = SERVER_PREFIX + "authentication.gateway";
  String SERVER_CLIENT_ID = SERVER_PREFIX + "client_id";
  String SERVER_CLIENT_SECRET = SERVER_PREFIX + "client_secret";
  String SERVER_URI = SERVER_PREFIX + "uri";

  String TENANT_NAME = PREFIX + "tenant." + NAME;

  String XDB_PREFIX = PREFIX + "xdb.";
  String FEDERATION_PREFIX = XDB_PREFIX + "federation.";
  String FEDERATION_NAME = FEDERATION_PREFIX + NAME;
  String FEDERATION_SUPERUSER_PASSWORD = FEDERATION_PREFIX + "superuser.password";
  String FEDERATION_BOOTSTRAP = FEDERATION_PREFIX + "bootstrap.uri";

  String DATABASE = XDB_PREFIX + "database.";
  String DATABASE_NAME = DATABASE + NAME;
  String DATABASE_ADMIN_PASSWORD = DATABASE + "admin.password";

  String APPLICATION_PREFIX = PREFIX + "application.";
  String OLD_APPLICATION_NAME = PREFIX + "applicaton." + NAME;
  String APPLICATION_NAME = APPLICATION_PREFIX + NAME;
  String APPLICATION_DESCRIPTION = APPLICATION_PREFIX + DESCRIPTION;
  String APPLICATION_CATEGORY = APPLICATION_PREFIX + "category";

  String HOLDING_PREFIX = PREFIX + "holding.";
  String HOLDING_NAME = HOLDING_PREFIX + NAME;

  String FILE_SYSTEM_FOLDER = "filesystemfolder.name";

  String STORE_NAME = "store.name";
  String STORE_STORETYPE = "store.storetype";
  String STORE_FOLDER = "store.folder";
  String STORE_TYPE = "store.type";

  String AIC_PREFIX = PREFIX + "aic.";
  String AIC_NAME = AIC_PREFIX + NAME;

  String CRITERIA_PREFIX = AIC_PREFIX + "criteria.";
  String CRITERIA_NAME = CRITERIA_PREFIX + NAME;
  String CRITERIA_LABEL = CRITERIA_PREFIX + "label";
  String CRITERIA_TYPE = CRITERIA_PREFIX + TYPE;
  String CRITERIA_PKEYMINATTR = CRITERIA_PREFIX + "pkeyminattr";
  String CRITERIA_PKEYMAXATTR = CRITERIA_PREFIX + "pkeymaxattr";
  String CRITERIA_PKEYVALUESATTR = CRITERIA_PREFIX + "pkeyvaluesattr";
  String CRITERIA_INDEXED = CRITERIA_PREFIX + "indexed";

  String QUERY_PREFIX = PREFIX + "query.";
  String QUERY_NAME = QUERY_PREFIX + NAME;
  String QUERY_NAMESPACE_PREFIX_TEMPLATE = QUERY_PREFIX + "%s.namespace.prefix";
  String QUERY_NAMESPACE_URI_TEMPLATE = QUERY_PREFIX + "%s.namespace.uri";

  String QUERY_RESULT_ROOT_ELEMENT_TEMPLATE = QUERY_PREFIX + "%s.result.root.element";
  String QUERY_RESULT_ROOT_NS_ENABLED_TEMPLATE = QUERY_PREFIX + "%s.result.root.ns.enabled";
  String QUERY_RESULT_SCHEMA_TEMPLATE = QUERY_PREFIX + "%s.result.schema";

  String QUERY_XDBPDI_ENTITY_PATH_TEMPLATE = QUERY_PREFIX + "%s.xdbpdi.entity.path";
  String QUERY_XDBPDI_SCHEMA_TEMPLATE = QUERY_PREFIX + "%s.xdbpdi.schema";
  String QUERY_XDBPDI_TEMPLATE_TEMPLATE = QUERY_PREFIX + "%s.xdbpdi.template";

  String QUERY_XDBPDI_OPERAND_PREFIX = QUERY_PREFIX + "%s.xdbpdi[%s].operand.";
  String QUERY_XDBPDI_OPERAND_NAME = QUERY_XDBPDI_OPERAND_PREFIX + NAME;
  String QUERY_XDBPDI_OPERAND_PATH = QUERY_XDBPDI_OPERAND_PREFIX + "path";
  String QUERY_XDBPDI_OPERAND_TYPE = QUERY_XDBPDI_OPERAND_PREFIX + TYPE;
  String QUERY_XDBPDI_OPERAND_INDEX = QUERY_XDBPDI_OPERAND_PREFIX + "index";

  String QUOTA_PREFIX = PREFIX + "quota.";
  String QUOTA_NAME = QUOTA_PREFIX + NAME;
  String QUOTA_AIU = QUOTA_PREFIX + "aiu";
  String QUOTA_AIP = QUOTA_PREFIX + "aip";
  String QUOTA_DIP = QUOTA_PREFIX + "dip";

  String RESULT_HELPER_PREFIX = PREFIX + "result.helper.";
  String RESULT_HELPER_SCHEMA_TEMPLATE = RESULT_HELPER_PREFIX + "%s.result.schema";
  String RESULT_HELPER_XML = RESULT_HELPER_PREFIX + "%s.xml";
  String RESULT_HELPER_NAME = RESULT_HELPER_PREFIX + NAME;

  String SEARCH_PREFIX = PREFIX + "search.";
  String SEARCH_NAME = SEARCH_PREFIX + NAME;
  String SEARCH_DESCRIPTION = SEARCH_PREFIX + "%s.description";
  String SEARCH_NESTED = SEARCH_PREFIX + "%s.nestedsearch";
  String SEARCH_STATE = SEARCH_PREFIX + "%s.state";
  String SEARCH_INUSE = SEARCH_PREFIX + "%s.inuse";
  String SEARCH_AIC = SEARCH_PREFIX + "%s.aic";
  String SEARCH_QUERY = SEARCH_PREFIX + "%s.query";
  String SEARCH_COMPOSITION_PREFIX = SEARCH_PREFIX + "%s.composition.";
  String SEARCH_COMPOSITION_NAME = SEARCH_COMPOSITION_PREFIX + NAME;
  String SEARCH_COMPOSITION_XFORM = SEARCH_COMPOSITION_PREFIX + "xform";
  String SEARCH_COMPOSITION_XFORM_NAME = SEARCH_COMPOSITION_XFORM + "." + NAME;
  String SEARCH_DEFAULT_RESULT_MASTER = SEARCH_PREFIX + "default.result.master";
  String SEARCH_DEFAULT_SEARCH = SEARCH_PREFIX + "default";

  String SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_PREFIX = SEARCH_COMPOSITION_PREFIX + "%s.result.main.";
  String SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_NAME = SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_PREFIX + NAME;
  String SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_LABEL = SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_PREFIX + "label";
  String SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_PATH = SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_PREFIX + "path";
  String SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_TYPE = SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_PREFIX + TYPE;
  String SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_SORT = SEARCH_COMPOSITION_RESULT_MAIN_COLUMN_PREFIX + "sort";

  String SEARCH_COMPOSITION_RESULT_MAIN_EXPORT_ENABLED_TEMPLATE = SEARCH_COMPOSITION_PREFIX + "exportenabled";
  String SEARCH_COMPOSITION_RESULT_MAIN_EXPORT_CONFIG_TEMPLATE = SEARCH_COMPOSITION_PREFIX + "exportconfigs";

  String RETENTION_POLICY_NAME = PREFIX + "retention.policy.name";

  String PDI_PREFIX = PREFIX + "pdi.";
  String PDI_XML = PDI_PREFIX + "xml";
  String PDI_SCHEMA = PDI_PREFIX + "schema";
  String PDI_SCHEMA_NAME = PDI_SCHEMA + ".name";

  String JOB_PREFIX = PREFIX + "job.";
  String JOB_DEFINITION_NAME = JOB_PREFIX + "definition";
  String JOB_CONFIRMATION = "Confirmation";

  String INGEST_XML = PREFIX + "ingest.xml";

  String HTTP_CLIENT_CLASSNAME = PREFIX + "http.client";

  String EXPORT_PIPELINE_PREFIX = PREFIX + "exportpipeline.";
  String EXPORT_PIPELINE_TEMPLATE_PREFIX = PREFIX + "exportpipeline.%s.";
  String EXPORT_PIPELINE_NAME = EXPORT_PIPELINE_PREFIX + NAMES;
  String EXPORT_PIPELINE_COMPOSITE_TEMPLATE = EXPORT_PIPELINE_TEMPLATE_PREFIX + "composite";
  String EXPORT_PIPELINE_CONTENT_TEMPLATE = EXPORT_PIPELINE_TEMPLATE_PREFIX + "content";
  String EXPORT_PIPELINE_DESCRIPTION_TEMPLATE = EXPORT_PIPELINE_TEMPLATE_PREFIX + DESCRIPTION;
  String EXPORT_PIPELINE_ENVELOPE_FORMAT_TEMPLATE = EXPORT_PIPELINE_TEMPLATE_PREFIX + "envelopeformat";
  String EXPORT_PIPELINE_INCLUDES_CONTENT_TEMPLATE = EXPORT_PIPELINE_TEMPLATE_PREFIX + "includescontent";
  String EXPORT_PIPELINE_OUTPUT_FORMAT_TEMPLATE = EXPORT_PIPELINE_TEMPLATE_PREFIX + "outputformat";
  String EXPORT_PIPELINE_INPUT_FORMAT_TEMPLATE = EXPORT_PIPELINE_TEMPLATE_PREFIX + "inputformat";
  String EXPORT_PIPELINE_TYPE_TEMPLATE = EXPORT_PIPELINE_TEMPLATE_PREFIX + TYPE;
  String EXPORT_PIPELINE_COLLECTION_BASED_TEMPLATE = EXPORT_PIPELINE_TEMPLATE_PREFIX + "collectionbased";

  String EXPORT_CONFIG_PREFIX = PREFIX + "exportconfig.";
  String EXPORT_CONFIG_TEMPLATE_PREFIX = PREFIX + "exportconfig.%s.";
  String EXPORT_CONFIG_NAME = EXPORT_CONFIG_PREFIX + NAMES;
  String EXPORT_CONFIG_TYPE_TEMPLATE = EXPORT_CONFIG_TEMPLATE_PREFIX + TYPE;
  String EXPORT_CONFIG_PIPELINE_TEMPLATE = EXPORT_CONFIG_TEMPLATE_PREFIX + "pipeline";
  String EXPORT_CONFIG_TRANSFORMATIONS_TEMPLATE_PREFIX = EXPORT_CONFIG_TEMPLATE_PREFIX + "transformations.";
  String EXPORT_CONFIG_TRANSFORMATIONS_TEMPLATE_TEMPLATE_PREFIX = EXPORT_CONFIG_TEMPLATE_PREFIX + "transformations.%s.";
  String EXPORT_CONFIG_TRANSFORMATIONS_TEMPLATE_NAME = EXPORT_CONFIG_TRANSFORMATIONS_TEMPLATE_PREFIX + NAMES;
  String EXPORT_CONFIG_TRANSFORMATIONS_TEMPLATE_PORTNAME_TEMPLATE = EXPORT_CONFIG_TRANSFORMATIONS_TEMPLATE_TEMPLATE_PREFIX + "portname";
  String EXPORT_CONFIG_TRANSFORMATIONS_TEMPLATE_TRANSFORMATION_TEMPLATE = EXPORT_CONFIG_TRANSFORMATIONS_TEMPLATE_TEMPLATE_PREFIX + "transformation";
  String EXPORT_CONFIG_OPTIONS_TEMPLATE_XSL_RESULTFORMAT_TEMPLATE = EXPORT_CONFIG_TEMPLATE_PREFIX + "options.xslresultformat.value";
  String EXPORT_CONFIG_OPTIONS_TEMPLATE_XQUERY_RESULTFORMAT_TEMPLATE = EXPORT_CONFIG_TEMPLATE_PREFIX + "options.xqueryresultformat.value";
  String EXPORT_CONFIG_OPTIONS_TEMPLATE_PREFIX = EXPORT_CONFIG_TEMPLATE_PREFIX + "options.";
  String EXPORT_CONFIG_OPTIONS_TEMPLATE_TEMPLATE_PREFIX = EXPORT_CONFIG_TEMPLATE_PREFIX + "options.%s.";
  String EXPORT_CONFIG_OPTIONS_TEMPLATE_NAME = EXPORT_CONFIG_OPTIONS_TEMPLATE_PREFIX + NAMES;
  String EXPORT_CONFIG_OPTIONS_TEMPLATE_VALUE_TEMPLATE = EXPORT_CONFIG_OPTIONS_TEMPLATE_TEMPLATE_PREFIX + "value";
  String EXPORT_CONFIG_ENCRYPTED_OPTIONS_TEMPLATE_PREFIX = EXPORT_CONFIG_TEMPLATE_PREFIX + "encryptedoptions.";
  String EXPORT_CONFIG_ENCRYPTED_OPTIONS_TEMPLATE_TEMPLATE_PREFIX = EXPORT_CONFIG_TEMPLATE_PREFIX + "encryptedoptions.%s.";
  String EXPORT_CONFIG_ENCRYPTED_OPTIONS_TEMPLATE_NAME = EXPORT_CONFIG_ENCRYPTED_OPTIONS_TEMPLATE_PREFIX + NAMES;
  String EXPORT_CONFIG_ENCRYPTED_OPTIONS_TEMPLATE_VALUE_TEMPLATE = EXPORT_CONFIG_ENCRYPTED_OPTIONS_TEMPLATE_TEMPLATE_PREFIX + "value";

  String EXPORT_TRANSFORMATION_PREFIX = PREFIX + "exporttransformation.";
  String EXPORT_TRANSFORMATION_TEMPLATE_PREFIX = PREFIX + "exporttransformation.%s.";
  String EXPORT_TRANSFORMATION_NAME = EXPORT_TRANSFORMATION_PREFIX + NAMES;
  String EXPORT_TRANSFORMATION_DESCRIPTION_TEMPLATE = EXPORT_TRANSFORMATION_TEMPLATE_PREFIX + DESCRIPTION;
  String EXPORT_TRANSFORMATION_TYPE_TEMPLATE = EXPORT_TRANSFORMATION_TEMPLATE_PREFIX + TYPE;
  String EXPORT_TRANSFORMATION_MAIN_PATH_TEMPLATE = EXPORT_TRANSFORMATION_TEMPLATE_PREFIX + "mainpath";

  String CRYPTO_OBJECT_PREFIX = PREFIX + "crypto.object.";
  String CRYPTO_OBJECT_NAME = CRYPTO_OBJECT_PREFIX + NAME;
  String CRYPTO_OBJECT_SECURITY_PROVIDER = CRYPTO_OBJECT_PREFIX + "security.provider";
  String CRYPTO_OBJECT_KEY_SIZE = CRYPTO_OBJECT_PREFIX + "key.size";
  String CRYPTO_OBJECT_IN_USE = CRYPTO_OBJECT_PREFIX + "in.use";
  String CRYPTO_OBJECT_ENCRYPTION_MODE = CRYPTO_OBJECT_PREFIX + "encryption.mode";
  String CRYPTO_OBJECT_PADDING_SCHEME = CRYPTO_OBJECT_PREFIX + "padding.scheme";
  String CRYPTO_OBJECT_ENCRYPTION_ALGORITHM = CRYPTO_OBJECT_PREFIX + "encryption.algorithm";

  String PDI_CRYPTO_PREFIX = PREFIX + "pdi.crypto.";
  String PDI_CRYPTO_NAME = PDI_CRYPTO_PREFIX + NAME;

  String HOLDING_CRYPTO_PREFIX = PREFIX + "holding.crypto.";
  String HOLDING_CRYPTO_NAME = HOLDING_CRYPTO_PREFIX + NAME;
  String HOLDING_CRYPTO_ENCODING = HOLDING_CRYPTO_PREFIX + "encoding";
  String HOLDING_CRYPTO_ENABLED = HOLDING_CRYPTO_PREFIX + "enabled";

  String STORAGE_END_POINT_PREFIX = PREFIX + "storage.end.point.";
  String STORAGE_END_POINT_NAME = STORAGE_END_POINT_PREFIX + NAME;
  String STORAGE_END_POINT_TYPE = STORAGE_END_POINT_PREFIX + TYPE;
  String STORAGE_END_POINT_DESCRIPTION = STORAGE_END_POINT_PREFIX + DESCRIPTION;
  String STORAGE_END_POINT_URL = STORAGE_END_POINT_PREFIX + "url";
  String STORAGE_END_POINT_PROXY_URL = STORAGE_END_POINT_PREFIX + "proxy.url";

  String CUSTOM_STORAGE_PREFIX = PREFIX + "custom.storage.";
  String CUSTOM_STORAGE_NAME = CUSTOM_STORAGE_PREFIX + NAME;
  String CUSTOM_STORAGE_DESCRIPTION = CUSTOM_STORAGE_PREFIX + DESCRIPTION;
  String CUSTOM_STORAGE_FACTORY_SERVICE_NAME = CUSTOM_STORAGE_PREFIX + "factory.service.name";
  String CUSTOM_STORAGE_PROPERTY_NAME = CUSTOM_STORAGE_PREFIX + "property.name";
  String CUSTOM_STORAGE_PROPERTY_VALUE = CUSTOM_STORAGE_PREFIX + "property.value";

  String CONTENT_ADDRESSED_STORAGE_PREFIX = PREFIX + "content.addressed.storage.";
  String CONTENT_ADDRESSED_STORAGE_NAME = CONTENT_ADDRESSED_STORAGE_PREFIX + NAME;
  String CONTENT_ADDRESSED_STORAGE_CONNEXION_STRING = CONTENT_ADDRESSED_STORAGE_PREFIX + "connexion.string";
  String CONTENT_ADDRESSED_STORAGE_PEA_NAME = CONTENT_ADDRESSED_STORAGE_PREFIX + "pea.name";
  String CONTENT_ADDRESSED_STORAGE_PEA_VALUE = CONTENT_ADDRESSED_STORAGE_PREFIX + "pea.value";

}
