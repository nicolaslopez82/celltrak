# Celltrak
 Automation API Testing Project in Java 8, RestAssured, TestNG and ExtentReport implementations.
 
 # **Project: Celltrak**

## **Objective**
- Create an Automation API Testing Project in Java 8 and RestAssured over [GitHub Developer REST API v3](https://developer.github.com/v3/search/).
- Implementation of Extent Report to Test Cases executed with TestNG.
- Screenshot action over Test Cases that fail, ready to be used in case of implementing a UI Testing through Selenium WebDriver.
- Logging with log4j and export in an appenderFileLog.log as well as configurable through log4j.properties in Resources folder.
- Use of Apache Maven for project management.
- Test Cases that implement DataProviders through reading JSON files from the testdata folder.
- Implementation of Excel POI library.
- Creation of Suite.xml for TestNG executions.

## **Technologies Used**
- Java 8
- RestAssured
- Hamcrest
- Extent Reports
- Maven
- JSON
- Excel POI
- Log4J Logger.
- Postman.

## **Environment to run the project:**
- Install Java 8+ and configure the JAVA_HOME in Environments variables.
- Should be installed Maven 3 in your machine, and have configured the .m2 folder with M2_Home configured in Environments variables.
- This project was developed with IntelliJ 2018.1 and in Windows 10 as OS. It hasn't be tested in Mac OS or Linux yet.

## **Installation**
**1)** Clone or download the project.
**2)** Import the project from poxm.xml file from your IDE.
**3)** Accept import dependencies or download dependencies from IDE, or a better option is through CMD running: mvn clean install from pom.xml folder location.

**4)** In case the test-output folder is not present in the project, it can be created in the following procedure (Points 5, 6, and 7):

**5)** Select the TestClass to run.

**6)** Go to "Edit Configurations..."
![test-output-config-step1](https://github.com/nicolaslopez82/celltrak/blob/master/ReadmeImages/test-output-config-step1.jpg).

**7)** Select Listeners tab, and check where says: "Use default reporters".
![test-output-config-step2](https://github.com/nicolaslopez82/celltrak/blob/master/ReadmeImages/test-output-config-step2.png).

### **Run Test-Cases**
**1)** Go to GitRepositoriesSearch_PositiveScenariosTests class in your IDE, make a right click and select Run the class as you can see in the image below. 
![how-to-run-testcases](https://github.com/nicolaslopez82/celltrak/blob/master/ReadmeImages/how-to-run-positive-testcases.jpg).

**2)** After the class with test cases is executed, open the ExtentReports folder, select ExtentReportResults.html, right click, and copy path. Then, open a browser and paste the path to see the Extent Report that shows information in detail of the test cases executed.
![how-to-see-ExtentReports](https://github.com/nicolaslopez82/celltrak/blob/master/ReadmeImages/how-to-see-ExtentReports.jpg).

**3)** For Negative TestCases, is the same procedure described before.

**4)** Proposes improvements that always is welcome. :+1:

### **Extent Reports**
![extentreport-positive-dashboard](https://github.com/nicolaslopez82/celltrak/blob/master/ReadmeImages/extentreport-positive-dashboard.png).

![extentreport-positive-details](https://github.com/nicolaslopez82/celltrak/blob/master/ReadmeImages/extentreport-positive-details.png).

![extentreport-negative-dashboard](https://github.com/nicolaslopez82/celltrak/blob/master/ReadmeImages/extentreport-negative-dashboard.png).

![extentreport-negative-details](https://github.com/nicolaslopez82/celltrak/blob/master/ReadmeImages/extentreport-negative-details.png).
