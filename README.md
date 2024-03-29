# Framework Documentation

## Overview

This documentation provides an overview of the Appium Java framework structure, including its directory hierarchy, key components, and configuration files. The framework is designed for mobile automation using Appium and Java.

### Directory Structure
```
- reports
- src
    - main
        - java
            - Config
                - config.properties
            - Pages
            - Utils
                - AppiumUtils
                - DriverUtils
                - MyLogger
    - test
        - java
            - testData
                - testData.json
            - tests
            - testUtils
                - ExtentReportNG
                - Listeners
                  testng.xml
                  pom.xml
```


## Key Components

### 1. `reports`

This directory stores the test execution reports generated during the test runs. It may contain HTML or other format reports generated by testing tools like TestNG, ExtentReportNG, etc.

### 2. `src/main/java/Config`

#### a. `config.properties`

This configuration file contains key-value pairs for various configuration settings used in the framework. It includes properties related to the test environment, device capabilities, and other settings.

### 3. `src/main/java/Pages`

This directory holds page object classes representing different screens or pages of the mobile application. Page objects encapsulate the locators and actions performed on a specific page.

### 4. `src/main/java/Utils`

#### a. `AppiumUtils`

This class provides utility methods related to Appium setup and configuration. It includes methods for initializing the Appium driver, handling waits, and other Appium-related operations.

#### b. `DriverUtils`

DriverUtils contains utility methods for interacting with the Appium driver, such as taking screenshots, handling device rotations, and managing the driver session.

#### c. `MyLogger`

MyLogger is a custom logging utility class for handling logging throughout the framework. It may include methods for logging different levels of messages.

### 5. `src/test/java/testData`

#### a. `testData.json`

This JSON file contains test data used by test scripts. It can include data for different test scenarios, test cases, or test steps.

### 6. `src/test/java/tests`

This directory contains test scripts that execute various test scenarios. Each test script may use the page objects and utility classes from other packages to perform actions and assertions.

### 7. `src/test/java/testUtils`

#### a. `assertionUtils`

AssertionUtils provides utility methods for performing assertions in test scripts. It may include methods for validating expected and actual results.

#### b. `ExtentReportNG`

ExtentReportNG is a utility class for generating Extent reports. It includes methods for initializing and updating the Extent report during test execution.

#### c. `Listeners`

This package includes custom TestNG listeners for capturing events during test execution, such as test pass/failure, logging, and reporting.

### 8. `src/test/testng.xml`

The TestNG XML file defines the test suite configuration, including test classes, groups, parallel execution settings, and other TestNG-related configurations.

### 9. `pom.xml`

The Maven Project Object Model (POM) file defines the project dependencies, plugins, and other build-related configurations. It ensures the necessary libraries are downloaded and included in the project during the build process.
