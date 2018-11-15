# Working with Search in Companies House

[[  Overview ]](#overview)  [[ Operation details ]](#operation-details)  [[  Sample configuration  ]](#sample-configuration)

### Overview 

The search companies operation retrieves companies which has the companies search term in there name.

**searchcompanies**
```xml
<companieshouse.searchcompanies>
    <searchTerm>{$ctx:searchTerm}</searchTerm>
    <itemsPerPage>{$ctx:itemsPerPage}</itemsPerPage>
    <startIndex>{$ctx:startIndex}</startIndex>
</companieshouse.searchcompanies>
```

**Properties**
* searchTerm: The term being searched for can be company name(Required).
* itemsPerPage: The number of search results to return per page.
* startIndex: This is for the index of the first result item to return.

**Sample request**

Following is a sample request that can be handled by the searchcompanies operation.

```json
{
    "searchTerm":"test",
    "itemsPerPage":"2",
    "startIndex":"1"
}
```

**Sample response**

Given below is a sample response for the searchcompanies operation.

```json
{
   "items_per_page":5,
   "page_number":1,
   "total_results":5784,
   "start_index":0,
   "kind":"search#companies",
   "items":[
      {
         "links":{
            "self":"/company/04301762"
         },
         "kind":"searchresults#company",
         "date_of_cessation":"2014-03-25",
         "address":{
            "postal_code":"PR3 1YB",
            "locality":"Preston",
            "premises":"The Resource Centre Bridge Street",
            "address_line_1":"Garstang",
            "region":"Lancashire"
         },
         "title":"TEST  LIMITED",
         "company_number":"04301762",
         "snippet":"",
         "address_snippet":"The Resource Centre Bridge Street, Garstang, Preston, Lancashire, PR3 1YB",
         "description_identifier":[
            "dissolved-on"
         ],
         "company_status":"dissolved",
         "company_type":"ltd",
         "date_of_creation":"2001-10-09",
         "matches":{
            "snippet":[

            ],
            "title":[
               1,
               4
            ]
         },
         "description":"04301762 - Dissolved on 25 March 2014"
      },
      .
      .
   ]
}
```
**Related Companies House documentation**
https://developer.companieshouse.gov.uk/api/docs/search/companies/companysearch.html

### Sample configuration

Following example illustrates how to connect to Companies House with the init operation and search operation.

1. Create a sample proxy as below :

```xml
<?xmlversion="1.0"encoding="UTF-8"?>
<proxy xmlns="http://ws.apache.org/ns/synapse" name="searchcompanies" transports="https,http" statistics="disable" trace="disable" startOnLoad="true">
    <target>
        <inSequence>
            <propertyexpression="json-eval($.apiKey)"name="apiKey"
                xmlns:ns="http://org.apache.synapse/xsd"/>
            <propertyexpression="json-eval($.apiUrl)"name="apiUrl"
                xmlns:ns="http://org.apache.synapse/xsd"/>
            <propertyexpression="json-eval($.searchTerm)"name="searchTerm"
                xmlns:ns="http://org.apache.synapse/xsd"/>
            <propertyexpression="json-eval($.itemsPerPage)"name="itemsPerPage"
                xmlns:ns="http://org.apache.synapse/xsd"/>
            <propertyexpression="json-eval($.startIndex)"name="startIndex"
                xmlns:ns="http://org.apache.synapse/xsd"/>
                <companieshouse.init xmlns="http://ws.apache.org/ns/synapse">
                    <apiKey>{$ctx:apiKey}</apiKey>
                    <apiUrl>{$ctx:apiUrl}</apiUrl>
                </companieshouse.init>
                <companieshouse.searchcompanies>
                    <searchTerm>{$ctx:searchTerm}</searchTerm>
                    <itemsPerPage>{$ctx:itemsPerPage}</itemsPerPage>
                    <startIndex>{$ctx:startIndex}</startIndex>
                </companieshouse.searchcompanies>
            <respond/>
        </inSequence>
        <outSequence>
        <send/>
        </outSequence>
    </target>
    <description/>
</proxy>
```

2. Create a json file named searchcompanies.json and copy the configurations given below to it:

```json
{
    "searchTerm":"test",
    "itemsPerPage":"2",
    "startIndex":"1"
}
```
3. Replace the credentials with your values.

4. Execute the following curl command:

```bash
curl http://localhost:8280/services/searchcompanies -H "Content-Type: application/json" -d @searchcompanies.json
```

5. Companies House returns a json response similar to the one shown below:
 
```json
{
   "items_per_page":5,
   "page_number":1,
   "total_results":5784,
   "start_index":0,
   "kind":"search#companies",
   "items":[
      {
         "links":{
            "self":"/company/04301762"
         },
         "kind":"searchresults#company",
         "date_of_cessation":"2014-03-25",
         "address":{
            "postal_code":"PR3 1YB",
            "locality":"Preston",
            "premises":"The Resource Centre Bridge Street",
            "address_line_1":"Garstang",
            "region":"Lancashire"
         },
         "title":"TEST  LIMITED",
         "company_number":"04301762",
         "snippet":"",
         "address_snippet":"The Resource Centre Bridge Street, Garstang, Preston, Lancashire, PR3 1YB",
         "description_identifier":[
            "dissolved-on"
         ],
         "company_status":"dissolved",
         "company_type":"ltd",
         "date_of_creation":"2001-10-09",
         "matches":{
            "snippet":[

            ],
            "title":[
               1,
               4
            ]
         },
         "description":"04301762 - Dissolved on 25 March 2014"
      },
      .
      .
   ]
}
```
