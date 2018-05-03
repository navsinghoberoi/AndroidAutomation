# Precondition for starting UI automation includes --

- IntelliJ Idea - IDE Download
- Java 8 - Programming Language Download 
- Selenium WebDriver - For Web App Testing Download or Install using maven
- Appium - For Mobile App Testing Download here or install using homebrew brew install appium
- TestNG - Testing Framework and Reporting Download or Install using maven 

# Remember below mentioned points before creating new pages or scenarios --

For Android --
- Page class should be created in src/test/java/pages.android package. Also name of the page class should end with suffix Page ex SignupPage
- Scenario class should be created in src/test/java/tests/android package. Also name of the scenario class should end with suffix Test. Ex SignupTest
- Common methods should be added in common.andoid package , Commons java class
- createAndroidSession(boolean noreset) method of Setup class should be used to create session for android.
Set value of noreset as true >> Dont reset app state before starting this session
Set value of noreset variable as false >> Reset app state before starting this session


For iOS --
- Page class should be created in src/test/java/pages.ios package. Also name of the page class should end with suffix Page ex SignupPage
- Scenario class should be created in src/test/java/tests/ios package. Also name of the scenario class should end with suffix Test. Ex SignupTest
- Common methods should be added in common.ios package , Commons java class
- createIosSession(boolean noreset) method of Setup class should be used to create session for ios.
Set value of noreset as true >> Dont reset app state before starting this session
Set value of noreset variable as false >> Reset app state before starting this session


For web browser --
- Page class should be created in src/test/java/pages.web package. Also name of the page class should end with suffix Page ex SignupPage
- Scenario class should be created in src/test/java/tests/web package. Also name of the scenario class should end with suffix Test. Ex SignupTest
- Common methods should be added in common.web package , Commons java class
- createBrowserSession(String env) method of Setup class should be used to create session for ios.
Set value of env as local >> If you want to run test on local machine
Set value of env variable as remote (anything except local)  >> If you want to run test on remote machine
 
