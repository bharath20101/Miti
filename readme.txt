Instruction on how to run the tests:
-------------------------------------
Launch the Project in Eclipse
Open pom.xml and save the changes to build workspace and fetch the dependencies
Right click on textng.xml and choose RunAs -> TestNG Suite

Notes:
------
Test written using both TestNg and Cucumber-TestNg is configured in testng.xml file
Priority has been set on class level in testng.xml file and also using priority attribute in @Test annotation.

Scenarios Covered:
------------------
Using TestNG:
-------------
TC001_LoginWithValidCredentials
TC002_LoginWithInValidCredentials
testcases.TC003_LoginWithInEmptyMailAndPassword
TC004_LoginWithInIncorrectMailFormat
TC005_GoToCareersPageAndCheckOpeningsForTestAutomationEngineerinStockholm

Using Cucumber-TestNG:
---------------------
Login feature
Careers feature
