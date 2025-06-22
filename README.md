
# Cucumber BDD Framework (Java + JUnit)

This repository contains a collection of sample projects and libraries that demonstrate how to use selenium-cucumber-java, a **Behavior-Driven Development (BDD)** framework with **Cucumber and Java**. The projects showcase automation script development and utilise various reporters such as HTML, and JSON. Additionally, it offers the ability to capture screenshots for tests and generate error shots for failed test cases.

The tests are written using the **Cucumber Framework** in Gherkin, which allows for BDD-style scenarios. JUnit is used as the test runner to execute the feature files.

![Framework Structure](https://raw.githubusercontent.com/HsynHsyn/Cucumber-BDD-Framework-Java-JUnit/master/src/test/resources/uiImages/BDD_frameworkStructure.png)

## 📌 Project Overview

This project demonstrates how to build a basic **Selenium WebDriver testing framework in Java**. The repository contains:

- **Driver management** with **WebDriver instances.**
- **Reusable UI methods** and **Page Object Model (POM)** implementations.
- **Cucumber-based feature files** for defining test scenarios in **BDD-style**.
- **Test runners are using JUnit** for executing feature files.
- **Various sample test scenarios** covering different web components.

---

## ⚙️ Installation & Prerequisites

To set up and run this project, ensure that you have the following installed:

- **JDK 1.8+** (Ensure that the Java class path is properly set)
- **Maven**&#x20;
- **IntelliJ** (or any preferred IDE that supports Java and Maven)
- **Required Plugins:**
  - **Maven**
  - **Cucumber**
- **Browser Driver** (Ensure that you have the appropriate browser driver for your desired browser and that the class path is correctly configured)

---

## 📂 Project Structure

```
Sample-Cucumber-BDD-Framework-Java-JUnit

├── .github/workflows/test-runner.yml      # CI/CD workflow for GitHub Actions
├── src                                    # Source code directory 
├── test
│   ├── java
│   │   ├── projectName                    # Project-specific packages
│   │   ├── projectLogs
│   │   │   └── log.txt                    # Log file
│   │   └── uAutomation                    # Main test automation package
│   │       ├── pages                      # Page Object Model classes
│   │       │   ├── CommonPageElements.java
│   │       │   ├── DashboardPage.java
│   │       │   ├── HomePage.java
│   │       │   └── Pagentializer.java
│   │       ├── runners                    # Cucumber test runners
│   │       │   ├── CukesRunner.java
│   │       │   └── FailedTestRunner.java
│   │       ├── step_definitions           # Step Definitions for feature files
│   │       │   ├── DashboardStepDefs.java
│   │       │   ├── TestStepDefs.java
│   │       │   ├── Hooks.java
│   │       │   └── ProductsStepDefs.java
│   │       └── utilities                  # Utility classes
│   │           ├── CommonUISteps.java
│   │           ├── ConfigurationReader.java
│   │           ├── Driver.java
│   │           └── Log.java
│   └── resources
│       ├── uiFeatures                     # Feature files for Cucumber
│       │   ├── sample.feature
│       │   └── sampleUIFeature.feature
│       └── ultimages
│           └── log4j.properties           # Logging configuration
├── target                                 # Compiled test output
├── .gitignore                             # Ignored files for Git
├── configuration.properties               # Configuration file
└── pom.xml                              # Maven POM file
```

---

## 🏗 Framework Components

### 1️⃣ Driver Management

- **Driver.java**: Manages WebDriver instances and configurations.
- **ConfigurationReader.java**: Reads configurations from properties files.

### 2️⃣ Page Object Model (POM)

- **CommonPageElements.java**: Common UI components across pages.
- **DashboardPage.java**: Contains methods for interacting with the dashboard.
- **HomePage.java**: Represents the home page and its elements.

### 3️⃣ Cucumber Step Definitions

- **DashboardStepDefs.java**: Step definitions for dashboard-related scenarios.
- **EbayStepDefs.java**: Step definitions for eBay UI testing.
- **ProductsStepDefs.java**: Step definitions for product-related interactions.

### 4️⃣ Test Execution

- **CukesRunner.java/FailedTestRunner.java**: Cucumber JUnit test runners.
- **Hooks.java**: Manages setup and teardown of tests using `@Before` and `@After` hooks.

---

## 📝 Writing Feature Files

Feature files are located in `test/resources/uiFeatures/`. Example:

```gherkin
Feature: Performing a Google Search

    As a user on the Google search page
    I want to search for Selenium-Webdriver
    Because I want to learn more about it

    Background:
        Given I am on the search page

    Scenario: Performing a search operation
        When I enter "Selenium Webdriver" into the search box
        And I click the search button
        Then I should see a list of search results
```

---

## 🚀 Running Tests

### Using Maven

Run all tests:

```sh
mvn test or mvn clean test
```
```
npx allure generate allure-results --clean


```
Run tests with a specific tag:

```sh
mvn test -Dcucumber.options="--tags @test001"
```

### Using JUnit

You can execute tests using JUnit runners (`CukesRunner.java` or `FailedTestRunner.java`) inside your IDE.

---

## 📊 How to View Allure Report

1. **Generate the HTML report **:

   ```bash
   npx allure generate allure-results --clean -o allure-report
   ```

2. **Open the report in your browser**:

   ```bash
   npx allure serve allure-results  
   ```
---

## 📊 Test Reports

After running the tests, **reports** are generated in the `target` directory:

- **HTML Reports**: Provides a detailed test execution overview.
- **JUnit Reports**: XML-based results for CI/CD integrations.

---

