A Brief Helper File & Instruction to Run Test Script
=========================
## Description
The QA Tech Challenge has three user stories. Please refer README.md for more details. The automated framework has been created using Selenium with Java and Maven as build Tool. I have used Eclipse Java 2018-12. However, you can use as per your choice.

## 1. Project Components

* Test case standardization using Page Object Model.
* Configuration file used to easily modify the parameters.
* Helper and Utilty package for reusablity.
* Test case execution engin using POM.xml file.
* Reporting utility is done using extend reports.

## 2. Steps to Run the code base
1. Import the Project in any IDE.
2. Check the path from Config.properties file and change if required, though I have given relative path.
3. If Browser slected as IE then please change the Protection mode.
4. Please change the jdk path in POM.xml file.
5. You can run the testcases one by one from src/test/java "testcases" package.
	* TC01_VerifyEasyAccessFunctionalityInOurOfferPage for Story 1
	* TC02_FindTheOfferWithTheHighestInterestRateAndClickRegister for Story 2.
	* TC03_VerifyInvestNowButtonIsRedirectingToTheRegisterForm for Story 3.
6. Right click and run as TestNG Test.
7. You can directly run using pom.xml file,  Run As -> Maven clean -> Maven Install
8. Five mannual test cases has been captured in *MannualTestCase.md* file.

## 3. Future Enhancements 
* Break the user stories in more detailed test cases and create automation tests for the same.
* Scheduling Jenkins job.
* Error logging for production readyness.
