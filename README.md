# Companies House EI Connector

The Companies House [Connector](https://docs.wso2.com/display/EI640/Working+with+Connectors) allows you to access the [Companies House REST API](https://developer.companieshouse.gov.uk/api/docs/index/gettingStarted.html) through WSO2 Enterprise Integrator (WSO2 EI). The Companies House API lets you retrieve information about limited companies (and other companies that fall within the Companies Act 2006). The data returned is live and real­time, and is simple to use and understand.

## Compatibility

| Connector version  | Supported WSO2 ESB/EI version |
| ------------- | ------------- |
| [1.0.3](https://github.com/wso2-extensions/esb-connector-companieshouse/tree/org.wso2.carbon.connector.companieshouse-1.0.3) | ESB 4.9.0, ESB 5.0.0, EI 6.2.0, EI 6.3.0, EI 6.4.0    |

## Getting started

#### Download and install the connector

1. Download the connector from the [WSO2 Store](https://store.wso2.com/store/assets/esbconnector/details/0ce6304d-820d-41f8-a5de-08c3b32b457e) by clicking the Download Connector button.
2. Then you can follow this [Documentation](https://docs.wso2.com/display/EI640/Working+with+Connectors+via+the+Management+Console) to add and enable the connector via the Management Console in your EI instance.
3. For more information on using connectors and their operations in your EI configurations, see [Using a Connector](https://docs.wso2.com/display/EI640/Using+a+Connector).
4. If you want to work with connectors via EI tooling, see [Working with Connectors via Tooling](https://docs.wso2.com/display/EI640/Working+with+Connectors+via+Tooling).

#### Configuring the connector operations

To get started with Companies House connector and their operations, see [Configuring Companies House Operations](docs/config.md).

## Building From the Source

Follow the steps given below to build the Companies House connector from the source code:

1. Get a clone or download the source from [Github](https://github.com/wso2-extensions/esb-connector-companieshouse).
2. Run the following Maven command from the `esb-connector-companieshouse` directory: `mvn clean install`.
3. The Companies House connector zip file is created in the `esb-connector-companieshouse/target` directory

## How You Can Contribute

As an open source project, WSO2 extensions welcome contributions from the community.
Check the [issue tracker](https://github.com/wso2-extensions/esb-connector-companieshouse/issues) for open issues that interest you. We look forward to receiving your contributions.
