/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.connector.integration.test.companieshouse;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.connector.integration.test.base.ConnectorIntegrationTestBase;
import org.wso2.connector.integration.test.base.RestResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CompanieshouseConnectorIntegrationTest extends ConnectorIntegrationTestBase {

    private Map<String, String> esbRequestHeadersMap = new HashMap<String, String>();

    private Map<String, String> apiRequestHeadersMap = new HashMap<String, String>();

    /**
     * Set up the environment.
     */
    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {

        addCertificatesToEIKeyStore("client-truststore.jks", "wso2carbon");
        String connectorName = System.getProperty("connector_name") + "-connector-" +
                System.getProperty("connector_version") + ".zip";
        init(connectorName);
        getApiConfigProperties();

        esbRequestHeadersMap.put("Accept-Charset", "UTF-8");
        esbRequestHeadersMap.put("Content-Type", "application/json");
        esbRequestHeadersMap.put("Accept", "application/json");
        apiRequestHeadersMap.putAll(esbRequestHeadersMap);

        final String authorizationString = connectorProperties.getProperty("apiKey");
        apiRequestHeadersMap.put("Authorization", "Basic "
                + new String(Base64.encodeBase64(authorizationString.getBytes())));
    }

    /**
     * Positive test case for searchcompanies method with mandatory parameters.
     */
    @Test(groups = {"wso2.esb"}, description =
            "searchcompanies integration test with mandatory" + " parameters.")
    public void testSearchcompaniesWithMandatoryParameters() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:companieshouse");

        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap,
                        "esb_companieshouse_mandatory.json");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/search/companies?q="
                + connectorProperties.getProperty("searchTerm");

        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(apiRestResponse.getBody().getString("kind"), esbRestResponse.getBody().getString("kind"));
        Assert.assertEquals(apiRestResponse.getBody().getString("total_results"), esbRestResponse.getBody().getString("total_results"));
    }

    /**
     * Positive test case for searchcompanies method with optional parameters.
     */
    @Test(groups = {"wso2.esb"}, description = "searchcompanies integration test with optional parameters.")
    public void testSearchcompaniesWithOptionalParameters() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:companieshouse");

        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap,
                        "esb_companieshouse_optional.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/search/companies?q="
                + connectorProperties.getProperty("searchTerm") + "&items_per_page="
                + connectorProperties.getProperty("itemsPerPage") + "&start_index="
                + connectorProperties.getProperty("startIndex");

        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(apiRestResponse.getBody().getString("kind"), esbRestResponse.getBody().getString("kind"));
        Assert.assertEquals(apiRestResponse.getBody().getString("total_results"), esbRestResponse.getBody().getString("total_results"));
    }

    /**
     * Negative test case for searchcompanies method.
     */
    @Test(groups = {"wso2.esb"}, description = "searchcompanies integration test with negative case.")
    public void testSearchcompaniesWithNegativeCase() throws IOException, JSONException {

        esbRequestHeadersMap.put("Action", "urn:companieshouse");

        RestResponse<JSONObject> esbRestResponse =
                sendJsonRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_companieshouse_negative.json");

        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/search/companies?q="
                + "";

        RestResponse<JSONObject> apiRestResponse =
                sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);

        Assert.assertEquals(apiRestResponse.getBody().getString("kind"), esbRestResponse.getBody().getString("kind"));
        Assert.assertEquals(apiRestResponse.getBody().getString("total_results"), esbRestResponse.getBody().getString("total_results"));
    }
}