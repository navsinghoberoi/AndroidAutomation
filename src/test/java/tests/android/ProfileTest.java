package tests.android;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.android.*;
import common.android.*;

public class ProfileTest extends Setup {


    private HomePage homePage;
    private Commons commons;
    private MenuPage menuPage;
    private ProfilePage profilePage;
    private PersonalDetailsPage personalDetailsPage ;

    private AndroidDriver androidDriver ;

    @BeforeClass
    public void setUp() {

        try
        {
            createAndroidSession(true);
            androidDriver = (AndroidDriver) driver ;

            commons = new Commons(driver);
//            common.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
//            common.enterPersonalDetailsNewUser();
//            common.enterHomeAddressDetailsNewUser();
//            common.enterOfficeAddressDetailsNewUser();

            //common.goToHomepage();



            homePage = new HomePage(driver);
            homePage.clickMenu();

            menuPage = new MenuPage(driver);
            menuPage.clickProfile();

            profilePage = new ProfilePage(driver);
            personalDetailsPage = new PersonalDetailsPage(driver);


        }
        catch(Exception e )
        {
            e.printStackTrace();
        }

    }


    @Test(priority = 1 , groups = {"New User"})
    public void verifyNewUserDefaultNumber() throws Exception {
        String defaultNumber = profilePage.getNumber();
        Assert.assertEquals(defaultNumber, "+91"+getValueFromPPFile("newUserPhoneNumber"));
    }


    @Test(priority = 2 , groups = {"New User"})
    public void verifyNewUserDefaultName() throws Exception {
        String defaultName = profilePage.getName();
        Assert.assertEquals(defaultName, getValueFromPPFile("userName"));
    }


    @Test(priority = 3 , groups = {"New User"})
    public void verifyNewUserDefaultProfilePicture() {
        String defaultProfileSRC = profilePage.getProfileImage();
        System.out.println("Profile SRC : " + defaultProfileSRC);
        Assert.assertEquals(defaultProfileSRC, "");
    }


    @Test(priority = 4 , groups = {"New User"})
    public void verifyNewUserDefaultGender() throws Exception {
        String defaultGender = profilePage.getGender();
        if (getValueFromPPFile("gender").equalsIgnoreCase("F"))
            Assert.assertEquals(defaultGender, "Female");
        else if (getValueFromPPFile("gender").equalsIgnoreCase("M"))
            Assert.assertEquals(defaultGender, "Male");
    }


    @Test(priority = 5 , groups = {"New User"})
    public void verifyNewUserDefaultEmail(){
        String defaultEmail = profilePage.getEmail();
        Assert.assertEquals(defaultEmail, "");
    }


    @Test(priority = 6 , groups = {"New User"})
    public void verifyNewUserDefaultBirthday(){
        androidDriver.scrollTo("Birthday");
        String defaultBirthDate = profilePage.getBirthday();
        Assert.assertEquals(defaultBirthDate, "");
    }


    @Test(priority = 7 , groups = {"New User"})
    public void verifyNewUserDefaultHomeAddress(){
        androidDriver.scrollTo("Home Address");
        String defaultHomeAddress = profilePage.getHomeAddress();
        System.out.println("Home Address : " + defaultHomeAddress);
        Assert.assertEquals(defaultHomeAddress, "");
    }


    @Test(priority = 8 , groups = {"New User"})
    public void verifyNewUserDefaultHomeLeaveTime(){
        String defaultHomeLeaveTime = profilePage.getHomeLeaveTime();
        System.out.println("Home Leave Time : " + defaultHomeLeaveTime);
        Assert.assertEquals(defaultHomeLeaveTime, "");
    }


    @Test(priority = 9 , groups = {"New User"})
    public void verifyNewUserDefaultOfficeAddress() {
        androidDriver.scrollTo("Office Address");
        String defaulOfficeAddress = profilePage.getOfficeAddress();
        System.out.println("Office Address : " + defaulOfficeAddress);
        Assert.assertEquals(defaulOfficeAddress, "Office Address");
    }


    @Test(priority = 10 , groups = {"New User"})
    public void verifyNewUserDefaulOfficeLeaveTime() {
        String defaultOfficeLeaveTime = profilePage.getOfficeLeaveTime();
        System.out.println("Office Leave Time  : " + defaultOfficeLeaveTime);
        Assert.assertEquals(defaultOfficeLeaveTime, "");
    }


    @Test(priority = 11 , groups = {"New User"})
    public void verifyNewUserDefaultCorporateEmail(){
        androidDriver.scrollTo("CORPORATE ACCOUNT");
        String defaultCorporateEmail = profilePage.getCorporateEmail();
        System.out.println("Corporate Email : " + defaultCorporateEmail);
        Assert.assertEquals(defaultCorporateEmail, "");
    }



    // -----------------------    CHECK FIELD VALIDATIONS     ---------------------------


    @Test(priority = 1 , groups = {"Edit User"} , dataProvider = "enterDifferentName")
    public void verifyNameValidation(String name , String expected){
        personalDetailsPage.enterUserName(name);
        System.out.println("Error Message : " + defaultCorporateEmail);
        Assert.assertEquals(defaultCorporateEmail, "");
    }


    @DataProvider
    public Object[][] enterDifferentName()
    {
        Object [][] nameError = new String[5][2];

        nameError[0][0] = "   ";
        nameError[0][1] = "";

        nameError[1][0] = ";'[]";
        nameError[1][1] = "";

        nameError[2][0] = "a";
        nameError[2][1] = "";

        nameError[3][0] = "     Test Spaces";
        nameError[3][1] = "";

        nameError[4][0] = "Correct Name";
        nameError[4][1] = "";

        return nameError;
    }



    @Test(priority = 2 , groups = {"Edit User"} , dataProvider = "enterDifferentEmail")
    public void verifyPersonalEmailValidation(String personalEmail , String expected){
        personalDetailsPage.enterUserName(personalEmail);
        System.out.println("Error Message : " + defaultCorporateEmail);
        Assert.assertEquals(defaultCorporateEmail, "");
    }


    @DataProvider
    public Object[][] enterDifferentEmail()
    {
        Object [][] emailError = new String[5][2];

        emailError[0][0] = "   ";
        emailError[0][1] = "";

        emailError[1][0] = "  @  .com";
        emailError[1][1] = "";

        emailError[2][0] = "ugiguiihuk";
        emailError[2][1] = "";

        emailError[3][0] = ".@.";
        emailError[3][1] = "";

        emailError[4][0] = "test@shuttl.com";
        emailError[4][1] = "";

        return emailError;
    }

    @Test(priority = 11 , groups = {"Edit User"} , dataProvider = "enterDifferentEmail")
    public void verifyCorporateEmailValidation(String corporateEmail , String expected){
        personalDetailsPage.enterUserName(corporateEmail);
        System.out.println("Error Message : " + defaultCorporateEmail);
        Assert.assertEquals(defaultCorporateEmail, "");
    }



    // -----------------------    CHECK EACH FIELD FOR EXISTING USER    -----------------------



    @Test(priority = 1 , groups = {"Existing User"})
    public void verifyExistingUserDefaultNumber() throws Exception {
        String defaultNumber = profilePage.getNumber();
        Assert.assertEquals(defaultNumber, "+91"+getValueFromPPFile("newUserPhoneNumber"));
    }


    @Test(priority = 2 , groups = {"Existing User"})
    public void verifyExistingUserDefaultName() throws Exception {
        String defaultName = profilePage.getName();
        Assert.assertEquals(defaultName, getValueFromPPFile("userName"));
    }


    @Test(priority = 3 , groups = {"Existing User"})
    public void verifyExistingUserDefaultProfilePicture() {
        String defaultProfileSRC = profilePage.getProfileImage();
        System.out.println("Profile SRC : " + defaultProfileSRC);
        Assert.assertEquals(defaultProfileSRC, "");
    }


    @Test(priority = 4 , groups = {"Existing User"})
    public void verifyExistingUserDefaultGender() throws Exception {
        String defaultGender = profilePage.getGender();
        if (getValueFromPPFile("gender").equalsIgnoreCase("F"))
            Assert.assertEquals(defaultGender, "Female");
        else if (getValueFromPPFile("gender").equalsIgnoreCase("M"))
            Assert.assertEquals(defaultGender, "Male");
    }


    @Test(priority = 5 , groups = {"Existing User"})
    public void verifyExistingUserDefaultEmail(){
        String defaultEmail = profilePage.getEmail();
        Assert.assertEquals(defaultEmail, "");
    }


    @Test(priority = 6 , groups = {"Existing User"})
    public void verifyExistingUserDefaultBirthday(){
        androidDriver.scrollTo("Birthday");
        String defaultBirthDate = profilePage.getBirthday();
        Assert.assertEquals(defaultBirthDate, "");
    }


    @Test(priority = 7 , groups = {"Existing User"})
    public void verifyExistingUserDefaultHomeAddress(){
        androidDriver.scrollTo("Home Address");
        String defaultHomeAddress = profilePage.getHomeAddress();
        System.out.println("Home Address : " + defaultHomeAddress);
        Assert.assertEquals(defaultHomeAddress, "");
    }


    @Test(priority = 8 , groups = {"Existing User"})
    public void verifyExistingUserDefaultHomeLeaveTime(){
        String defaultHomeLeaveTime = profilePage.getHomeLeaveTime();
        System.out.println("Home Leave Time : " + defaultHomeLeaveTime);
        Assert.assertEquals(defaultHomeLeaveTime, "");
    }


    @Test(priority = 9 , groups = {"Existing User"})
    public void verifyExistingUserDefaultOfficeAddress() {
        androidDriver.scrollTo("Office Address");
        String defaulOfficeAddress = profilePage.getOfficeAddress();
        System.out.println("Office Address : " + defaulOfficeAddress);
        Assert.assertEquals(defaulOfficeAddress, "Office Address");
    }


    @Test(priority = 10 , groups = {"Existing User"})
    public void verifyExistingUserDefaulOfficeLeaveTime() {
        String defaultOfficeLeaveTime = profilePage.getOfficeLeaveTime();
        System.out.println("Office Leave Time  : " + defaultOfficeLeaveTime);
        Assert.assertEquals(defaultOfficeLeaveTime, "");
    }


    @Test(priority = 11 , groups = {"Existing User"})
    public void verifyExistingUserDefaultCorporateEmail(){
        androidDriver.scrollTo("CORPORATE ACCOUNT");
        String defaultCorporateEmail = profilePage.getCorporateEmail();
        System.out.println("Corporate Email : " + defaultCorporateEmail);
        Assert.assertEquals(defaultCorporateEmail, "");
    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        System.out.println("Test cases completed");
        driver.quit();
    }


}
