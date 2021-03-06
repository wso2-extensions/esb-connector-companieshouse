## Integration tests for WSO2 EI Companies House connector

### Pre-requisites:

 - Maven 3.x
 - Java 1.8
 - The org.wso2.esb.integration.integration-base project is required. The test suite has been configured to download this project automatically. If the automatic download fails, download the following project and compile it using the mvn clean install command to update your local repository:
   https://github.com/wso2-extensions/esb-integration-base

### Tested Platform: 

 - UBUNTU 16.04
 - WSO2 EI 6.4.0
 - Java 1.8
 
Steps to follow in setting integration test.

 1. Download and place the wso2ei-6.4.0.zip and file in to location "<COMPANIESHOUSE_HOME>/repository/".
    If you need to add the certificate to keystores, extract the certificate from browser(Mozilla Firefox) by navigating to Companieshouse account url and place it to {EI_Connector_Home}/repositiry/.

 2. Create companieshouse account with https://account.companieshouse.gov.uk/.
    To obtain an API key, go to Your applications and register the application with the Companies House Developer Hub
    (https://developer.companieshouse.gov.uk/developer/application)as an API Key application.

 3. Update the companieshouse properties file at location "<COMPANIESHOUSE_HOME>/src/test/resources/artifacts/ESB/connector/config" as below.
	
	    i)  apiUrl         - Endpoint URL of the API. Use http://api.companieshouse.gov.uk
	    ii) apiKey         - API Key obtained via 2.

 4. Navigate to "<COMPANIESHOUSE_HOME>/" and run the following command.<br/>
      ```$ mvn clean install -Dskip-tests=false```

		
