# AndroidAutomation :
For every app/backend release, QA team needs to run sanity/regression tests manually everytime. This app automation repo will help in saving time and efforts by running automation tests whenever required.

# Getting Started :
Below mentioned instructions will get you a copy of the project up and running on your local machine for testing purposes.

# Prerequisites :

IntelliJ Idea - IDE Download
Java 8 - Programming Language Download
Appium - For Mobile App Testing Download here or install using homebrew brew install appium
TestNG - Testing Framework and Reporting Download or Install using maven
Installing : Please follow the below mentioned steps to get a working repo :

Clone the repository via ssh/http.
Go to the folder -- cd AndroidAutomation/
You will see two folders a) src b) target
You can now proceed to run the automated tests


# Running the tests :

Automated tests :
To run the automated tests, follow the steps -

Go to AndroidAutomation/src/test/java folder
To run the testcases, execute Tests.xml file.

# Built With :
Appium, Java, Maven, TestNG

# Contributing :
Please read Gitflow@Shuttl for details on our code of conduct, and the process for submitting pull requests to us.

# Authors :
Navpreet Singh
Arpit Gandhi

# Add test cases :
Remember below mentioned points before creating new pages or scenarios --
Page class should be created in src/test/java/pages package. Also name of the page class should end with suffix Page ex SignupPage
Scenario class should be created in src/test/java/tests/android package. Also name of the scenario class should end with suffix Test. Ex SignupTest
Common methods should be added in common package , Commons.java class
createAndroidSession(boolean noreset) method of Setup class should be used to create session for android.

Set value of noreset variable as true >> Don't reset app state before starting this session.
Set value of noreset variable as false >> Reset app state before starting this session