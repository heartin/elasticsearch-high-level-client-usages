# Elasticsearch High Level Client Usages

Primary objectives of this project are:
1. Provides essential usages of various Elasticsearch APIs using the Elasticsearch High Level client.
1. Learn and understand the use of Elasticsearch High Level Java library. See and run the test cases to understand more about the usage.
1. Use the test cases within project to test compatibility with any Elasticsearch core version as soon as Elasticsearch is upgraded.
1. Provide a starter project for my session attendees to get started easily and add / correct code.

Note:
1. This project uses Spring Boot AutoConfiguration (RestClientAutoConfiguration.java).
1. Current release version of Spring Boot (2.0.2) does not support RestClientAutoConfiguration. So using the 2.1.0 snapshot. 
1. Current version of RestHighLevelClient (6.2.4) is also not very mature. You may try using version 7.0.0-alpha1 for upcoming features. 
1. I will include only a very limited number of usages in the initial commit.
1. Test cases are actually more integration style and not unit style, and do not follow most of the best practices. 
1. Contributors are welcome to add usages and/or add or correct tests.


## Usage and setup (Local machine)

Clone simple-boot-build-tools: <br>
git clone https://github.com/heartin/simple-boot-build-tools.git <br>
Run './mvnw clean install' or 'mvn clean install'

Clone experiment-starter-parent-java: <br>
git clone https://github.com/heartin/experiment-boot-parent-java.git <br>
Run './mvnw clean install' or 'mvn clean install'


### Configuring and running elasticsearch-high-level-client-usages

Clone this repo (elasticsearch-high-level-client-usages): <br>
git clone https://github.com/heartin/elasticsearch-high-level-client-usages.git <br>
Run './mvnw clean compile' or 'mvn clean compile'

Configure following properties in your application.properties file as required by RestHighLevelAutoConfiguration in Spring: <br>
spring.elasticsearch.rest.username <br>
spring.elasticsearch.rest.password <br>
spring.elasticsearch.rest.uris <br>

Notes: 
1. username is your username, password is your password and uris should refer to your endpoint. 
1. If you are using Amazon Web Services (AWS) as given in the links at references section, you might not be requiring an username / password. 
1. Please refer to additional references section below for more details on how to setup an account on the Elastic Cloud or Amazon Web Services (AWS).
1. Having passwords in application.properties may result in accidental checkin of passwords. So you may also use any of the other Spring Boot externalized configuration options instead of application.properties. 

Run './mvnw clean install' or 'mvn clean install'


## API References
6.x: https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-supported-apis.html
7.x (alpha): https://www.elastic.co/guide/en/elasticsearch/client/java-rest/master/java-rest-high-getting-started-maven.html


## Additional References (from  my blog)
1. https://cloudmaterials.com/en/book/elasticsearch-essentials
1. https://cloudmaterials.com/en/book/elasticsearch-java-clients-jest-low-level-high-level
1. https://cloudmaterials.com/en/book/amazon-elasticsearch-service-essentials
1. https://javajee.com/externalized-configuration-with-spring-boot


