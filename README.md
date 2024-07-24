# OrangeHRM Automation

## Overview

This project is an automation test suite for the open-source demo OrangeHRM application, using Selenium with Java. The tests cover the Login, Admin, and Leave modules of the application.

## Project Setup

### Prerequisites

- Java 11 or higher
- Maven
- Git
- [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)
- [TestNG](https://testng.org/doc/)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)

### Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/sisirqa/OrangeHRM.git
```
### Install Dependencies
Navigate to the project directory and install the required dependencies:

```bash
cd OrangeHRM
mvn install
```
### Run Tests
To run the test suite, use Maven:

```bash
mvn test
```

You can also run tests in parallel across multiple browser instances by configuring TestNG XML files.

### Project Structure
```bash
src/test/java - Contains the test scripts.

src/test/resources - Contains configuration files and TestNG XML files.

pom.xml - Maven configuration file.

README.md - This file.
```
