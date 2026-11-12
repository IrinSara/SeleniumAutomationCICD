# Selenium Test Automation Framework (E-Commerce)

![Java](https://img.shields.io/badge/Java-25-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.45-green) ![TestNG](https://img.shields.io/badge/TestNG-7.12-red) ![Cucumber](https://img.shields.io/badge/Cucumber-7.34-brightgreen) ![Maven](https://img.shields.io/badge/Maven-build-blue)

An end-to-end UI test automation framework for a web-based e-commerce application, built with **Java, Selenium WebDriver, TestNG and Maven** using the **Page Object Model (POM)**. It supports **JSON-driven test data**, **BDD scenarios with Cucumber**, **multiple test suites run through Maven profiles**, and **Extent Reports** for clear pass/fail results.

---

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Application Under Test](#application-under-test)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Tests](#running-the-tests)
- [Test Reports](#test-reports)
- [Scenarios Covered](#scenarios-covered)
- [Framework Design](#framework-design)
- [Roadmap](#roadmap)
- [Author](#author)

---

## Features
- **Page Object Model:** reusable page classes for login, product selection, cart, checkout and order validation.
- **Data-driven testing:** test inputs are read from JSON files (parsed with Jackson), so one test runs with many data sets.
- **Cross-browser support:** driver binaries are managed by **WebDriverManager**, with no manual driver downloads.
- **Multiple suites:** regression, purchase flow and error-validation suites, each run through its own Maven profile.
- **BDD with Cucumber:** business-readable scenarios executed through a TestNG runner.
- **Extent Reports:** an HTML report for every run.
- **Screenshots:** screenshots are saved in the `Screenshots/` folder. **[ADD: say when, e.g. "on test failure"]**

## Tech Stack
| Area | Tool | Version |
|---|---|---|
| Language | Java | 25 |
| UI automation | Selenium WebDriver | 4.45.0 |
| Test runner | TestNG | 7.12.0 |
| BDD | Cucumber (cucumber-java, cucumber-testng) | 7.34.8 |
| Driver management | WebDriverManager | 6.3.4 |
| Test data | Jackson Databind (JSON) | 2.22.2 |
| Reporting | Extent Reports | 5.1.2 |
| Build tool | Maven + Surefire | 3.2.5 |

## Application Under Test
**[ADD: name and URL of the site you test]**. This is a demo/practice site used only for learning.

## Project Structure
```
SeleniumAutomationCICD
├── src
│   ├── main/java/TestAutomationFramework
│   │   ├── Resources
│   │   │   ├── ExtentReporterNG.java    # Extent Reports setup
│   │   │   └── GlobalData.properties    # Global configuration values
│   │   ├── CommonUtil.java              # Reusable helper methods shared by all pages
│   │   ├── Registration.java            # Page object: user registration
│   │   ├── Login.java                   # Page object: login
│   │   ├── ProductDetails.java          # Page object: product selection
│   │   ├── CartPage.java                # Page object: cart
│   │   ├── FinalCheckout.java           # Page object: checkout
│   │   ├── ConfirmationPage.java        # Page object: order confirmation
│   │   └── Orders.java                  # Page object: order history
│   └── test/java
│       ├── Cucumber                     # BDD feature files, step definitions and TestNG runner
│       └── TestAutomationFramework      # TestNG test classes
├── Testsuits                            # TestNG suite files (testng.xml, Purchase.xml, Errorvalidation.xml)
├── Screenshots                          # Screenshots captured during runs
├── reports                              # Generated reports
├── pom.xml                              # Dependencies and Maven profiles
└── README.md
```

## Prerequisites
- **JDK 25** (the project is compiled with `maven.compiler.release=25`)
- Maven 3.8+
- Google Chrome (or another supported browser)
- Git

```bash
java -version
mvn -version
```

## Setup
```bash
git clone https://github.com/IrinSara/SeleniumAutomationCICD.git
cd SeleniumAutomationCICD
mvn clean install -DskipTests
```

## Running the Tests
Each suite has its own Maven profile defined in `pom.xml`:

| Profile | What it runs | Command |
|---|---|---|
| `Regression` | Full regression suite (`Testsuits/testng.xml`) | `mvn clean test -PRegression` |
| `Purchase` | Purchase flow (`Testsuits/Purchase.xml`) | `mvn clean test -PPurchase` |
| `Errorvalidation` | Negative and error-validation tests (`Testsuits/Errorvalidation.xml`) | `mvn clean test -PErrorvalidation` |
| `CucumberTests` | Cucumber scenarios via `TestNGTestRunner` | `mvn clean test -PCucumberTests` |

## Test Reports
After a run, open the Extent Report in a browser:

```
[ADD: exact file path, e.g. reports/index.html]
```

Maven Surefire reports are in `target/surefire-reports/`.

**[ADD: a screenshot of your report, e.g. `![Extent Report](Screenshots/report.png)`]**

## Scenarios Covered
| # | Scenario | Suite |
|---|---|---|
| 1 | User registration | **[ADD]** |
| 2 | Login with valid and invalid data | **[ADD]** |
| 3 | Product selection and add to cart | Purchase |
| 4 | Checkout and order placement | Purchase |
| 5 | Order history verification | **[ADD]** |
| 6 | Error and validation messages | Errorvalidation |

> [ADD: edit this table to match your real test cases.]

## Framework Design
- **Page layer:** one class per page (`Registration`, `Login`, `ProductDetails`, `CartPage`, `FinalCheckout`, `ConfirmationPage`, `Orders`), holding locators and actions. Tests never touch locators directly.
- **Utility layer:** `CommonUtil` holds reusable helper methods shared by all pages. `ExtentReporterNG` sets up reporting and `GlobalData.properties` holds global configuration.
- **Test layer:** TestNG tests and Cucumber step definitions that call page methods and hold the assertions.
- **Data layer:** JSON files keep test data separate from code.
- **Suite layer:** TestNG XML files plus Maven profiles let you run the right set of tests on demand.

## Roadmap
- [ ] Add a CI pipeline (Jenkins or GitHub Actions) that runs a Maven profile on every push
- [ ] Parallel execution
- [ ] Attach failure screenshots to the Extent Report

## Author
**Irin Sara Mathew**: Quality Engineering Lead (8+ years in QA)
GitHub: [IrinSara](https://github.com/IrinSara)
