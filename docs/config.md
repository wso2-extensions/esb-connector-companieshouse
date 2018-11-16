# Configuring Companies House Operations

[[Prerequisites]](#Prerequisites) [[Initializing the Connector]](#initializing-the-connector)

## Prerequisites

To use the companies house connector, add the <companieshouse.init> element in your configuration before carrying out any other companies house operations.

This will keep the API key and API URL to be used in the subsequent Companies House operations. Companies House authenticates the application and authorizes access using basic authentication where the apiKey is base64 encoded and that will be used to generate the authorization header. apiUrl is a optional parameter the default value is “api.companieshouse.gov.uk”.(https://developer.companieshouse.gov.uk/api/docs/index/gettingStarted/apikey_authorisation.html)

### Using the Companies House API

* **Follow the steps below to using the Companies House API:**

    1. To obtain an API key, go to Your applications and register the application with the Companies House Developer Hub
           (https://developer.companieshouse.gov.uk/developer/application) as an API Key application.

## Initializing the Connector

Specify the init method as follows:

**init**
```xml
<companieshouse.init>
    <apiUrl>{$ctx:apiUrl}</apiUrl>
    <apiKey>{$ctx:apiKey}</apiKey>
</companieshouse.init>
```
**Properties** 
* apiKey: The companies api key.
* apiUrl: Refers to the application URL.

Now that you have connected to Companies House, use the information in the following topics to perform various operations with the connector:

[Working with Search in Companies House](search.md)
