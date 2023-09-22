# Kaiburr Task 2: Swagger Codegen REST API Implementation

## Description
In Task 2, we will implement a REST API using Swagger Codegen. This task involves creating a RESTful API based on a Swagger/OpenAPI definition and generating server code from that definition. The API will be implemented in Java using a chosen server or server framework. This README provides a guide on how to complete Task 2 step by step.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Requirements](#requirements)
- [How the Task is Done](#how-the-task-is-done)

## Features
- Generate a REST API server from a Swagger/OpenAPI definition.
- Implement CRUD (Create, Read, Update, Delete) operations for API endpoints.
- Test the API using Postman, Curl, or other HTTP clients.

## Technologies Used
- Swagger/OpenAPI
- Java
- Spring Boot (or your chosen Java-based server)
- MongoDB (or your chosen database, if applicable)

## Requirements
- Access to Swagger Editor: https://editor.swagger.io/
- Java development environment (JDK, IDE)
- Maven or Gradle build tool (if using Spring Boot)
- MongoDB (if using MongoDB as the database)
- Postman or Curl for API testing

## How the Task is Done

1. Swagger Definition Creation:

- Created a Swagger/OpenAPI definition for the REST API at https://editor.swagger.io/.
- Defined API endpoints, request/response parameters, and saved the Swagger definition in YAML format.

2. Server Code Generation:

- Visited the Swagger Codegen repository at https://github.com/swagger-api/swagger-codegen.
- Followed provided documentation to generate the server stub for the chosen Java-based server framework.
- Utilized the command-line tool as instructed, resulting in a project structure containing API controllers and models.

3. Functionality Implementation:

- Opened the generated server code project in the Java IDE IntelliJ.
- Located the API controller classes for the defined endpoints.
- Implemented functionality for each endpoint based on the Swagger definition.
- Created business logic to handle incoming HTTP requests and responses.

4. Application Deployment:

- Built the Java application using the IDE or build tool Maven.
- Deployed and ran the application, either on a server or locally, ensuring it was accessible via HTTP.

5. Testing with Postman/Curl:

- Validated the implementation using Postman, Curl, or another HTTP client.
- Sent requests to the defined endpoints and verified that the responses met expectations.

With these steps, the task of creating a REST API using Swagger Codegen was successfully completed.
