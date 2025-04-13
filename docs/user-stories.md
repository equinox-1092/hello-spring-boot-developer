# User Stories

This document contains the technical stories for the `hello-spring-boot-developer` REST API from the perspective of a developer interacting with it though HTTP requests.

## TS002: Create Greeting via POST Request
**As a** developer, 
**I want to** create a greeting by providing first and last names, 
**So that** I can receive a personalized greeting message.
### Acceptance Criteria
- **Scenario 1: Anonymous Greeting**
    - **Given** a developer has not provided any names,
    - **When** the developer submits a greeting creation request via POST,
    - **Then** the developer receives a creation confirmation with the message 'Welcome Anonymous Spring Boot Developer'.
- **Scenario 2: Personalized Greeting**
    - **Given** a developer has provided first and last names,
    - **When** the developer submits a greeting creation request via POST,
    - **Then** the developer receives a creation confirmation with the message 'Congrats {firstName} {lastName}! You are a Spring Boot Developer'.