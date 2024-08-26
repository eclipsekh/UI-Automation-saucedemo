# java-selenium 
This project demonstrates the use of Selenium WebDriver with Java to automate a simple web application.


## 🚀 Getting Started

### 🚧 Prerequisites
Before you can run this project, you must have the following software installed on your computer:

- Java Development Kit (JDK) version 11 or later
- Apache Maven
- Google Chrome web browser

### 🔗 Dependencies

This project uses the following dependencies:

- Selenium Java version 3.141.59
- TestNG version 6.14.3
- Webdriver manager 5.4.1

### 🛠️ Installation
1. Clone this repository to your local machine.   
   ```
   git clone https://github.com/eclipsekh/UI-Automation-saucedemo.git 
   ```
2. Navigate to the project directory using the command line.
3. Install the dependencies and run the smoke test plan (configured).   
   ```
   mvn clean install
   ```

### 🌐 Application under test
* https://www.saucedemo.com/
  
### 👨🏼‍🔬Tests
1. This project contains 1 test case it covered end to end test
2. Get data from json using DataProvider


#### 🏃🏽How to run the tests

#### 1. By Command line
1. Navigate to the project directory using command line.
2. Run the following command mvn clean test

#### 2. By Batchfile
1. Navigate to the project directory
2. Click on file BatchFileTest


#### 2. By Jenknis
1. Install jenkins
2. Run jenkins server
3. Create new job
4. In General >> Source code mangement >> Select git
5. In Repository URL put the following https://github.com/eclipsekh/UI-Automation-saucedemo.git
