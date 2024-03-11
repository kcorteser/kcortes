# kcortes

This is a demo project for Spring Boot, utilizing various dependencies for web development, database management, security, and testing.

## Dependencies

- **Spring Boot Starter Data JPA**: For easy integration of Spring Data JPA with Hibernate for database operations.
- **Spring Boot Starter Web**: For building web applications with Spring MVC.
- **Spring Boot DevTools**: Provides fast application restarts, LiveReload, and more.
- **H2 Database**: In-memory database for development and testing purposes.
- **Spring Boot Starter Test**: For writing unit and integration tests.
- **Springdoc OpenAPI**: For generating OpenAPI documentation for RESTful APIs.
- **Spring Boot Starter Security**: For securing the application using Spring Security.
- **Spring Boot Starter Mail**: For sending emails.
- **JJWT (Java JWT)**: For JSON Web Token implementation.
- **Logback Classic**: For logging.
- **Lombok**: Reduces boilerplate code in Java classes.
- **MapStruct**: For mapping Java beans.

## Configuration

### H2 Configuration

This section outlines the configuration properties for the H2 in-memory database and other related settings.

#### DataSource Configuration

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=test
spring.datasource.password=ts

- **spring.datasource.url**: Specifies the JDBC URL for connecting to the H2 in-memory database.
- **spring.datasource.driverClassName**: Specifies the JDBC driver class name.
- **spring.datasource.username**: Specifies the username for connecting to the database.
- **spring.datasource.password**: Specifies the password for connecting to the database.

#### JPA Configuration

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop

- **spring.jpa.database-platform**: Specifies the Hibernate dialect for H2.
- **spring.jpa.hibernate.ddl-auto**: Specifies the DDL mode. In this case, it's set to `create-drop`, which means Hibernate will create the database schema on startup and drop it when the application shuts down.

#### Server Configuration

server.port=8082

- **server.port**: Specifies the port on which the embedded Tomcat server will run.

#### Springdoc OpenAPI Configuration

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html

- **springdoc.api-docs.path**: Specifies the URL path for accessing the OpenAPI documentation in JSON format.
- **springdoc.swagger-ui.path**: Specifies the URL path for accessing the Swagger UI for interactive API documentation.

## Build and Run

To build the project, you can use Maven:

mvn clean install

To run the application:

mvn spring-boot:run

Feel free to modify these properties according to your requirements.
