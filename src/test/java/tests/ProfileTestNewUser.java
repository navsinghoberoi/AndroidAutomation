package tests;

import common.Commons;
import common.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPage;
import pages.PersonalDetailsPage;
import pages.ProfilePage;

import java.text.SimpleDateFormat;
import java.util.Date;



public class ProfileTestNewUser extends Setup {


    private Commons common;
    private ProfilePage profilePage;
    private PersonalDetailsPage personalDetailsPage;

    private String userFinalGender, userFinalOfficeLeaveTime, userFinalHomeLeaveTime
            , userFinalBirthdate, userFinalPersonalEmail, userFinalCorporateEmail, userFinalName;

    private boolean profileSaved = false;


    @BeforeClass
    public void setUp() throws Exception {

        createAndroidSession(false);
        common = new Commons(driver);


        common.signUp("newUserPhoneNumber", "OTP",
                      "gender", "userName",
                      "homeAddress");


        HomePage homePage = new HomePage(driver);
        homePage.clickMenu();

        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickProfile();

        profilePage = new ProfilePage(driver);
        personalDetailsPage = new PersonalDetailsPage(driver);


    }


    // ----------------------------       TEST CASES FOR NEW USER       ----------------------------


    @Test(priority = 1)
    public void verifyNewUserDefaultNumber() throws Exception {
        String defaultNumber = profilePage.getNumber();
        Assert.assertEquals(defaultNumber, "+91" + getValueFromPPFile("newUserPhoneNumber"));
    }


    @Test(priority = 2)
    public void verifyNewUserDefaultName() throws Exception {
        String defaultName = profilePage.getName();
        Assert.assertEquals(defaultName, getValueFromPPFile("userName"));
    }


    @Test(priority = 3)
    public void verifyNewUserDefaultProfilePicture() {
        String defaultProfileSRC = profilePage.getProfileImage();
        Assert.assertEquals(defaultProfileSRC, "");
    }


    @Test(priority = 4)
    public void verifyNewUserDefaultGender() throws Exception {
        String defaultGender = profilePage.getGender();
        if (getValueFromPPFile("gender").equalsIgnoreCase("F"))
            Assert.assertEquals(defaultGender, "Female");
        else if (getValueFromPPFile("gender").equalsIgnoreCase("M"))
            Assert.assertEquals(defaultGender, "Male");
    }


    @Test(priority = 5)
    public void verifyNewUserDefaultEmail() {
        String defaultEmail = profilePage.getEmail();
        Assert.assertEquals(defaultEmail, "");
    }


    @Test(priority = 6)
    public void verifyNewUserDefaultBirthday() {
        String defaultBirthDate = profilePage.getBirthday();
        Assert.assertEquals(defaultBirthDate, "");
    }


    @Test(priority = 7)
    public void verifyNewUserDefaultHomeAddress() throws Exception {
        boolean corrrectAddress = false;
        String defaultHomeAddress = profilePage.getHomeAddress();
        if (defaultHomeAddress.contains(getValueFromPPFile("homeAddress")))
            corrrectAddress = true;
        Assert.assertTrue(corrrectAddress);
    }


    @Test(priority = 8)
    public void verifyNewUserDefaultHomeLeaveTime() {
        String defaultHomeLeaveTime = profilePage.getHomeLeaveTime();
        Assert.assertEquals(defaultHomeLeaveTime, "");
    }


    @Test(priority = 9)
    public void verifyNewUserDefaultOfficeAddress() {
        // Just Checking if Office Address field is empty or not  . It is not supposed to be empty  as per System.
        boolean officeAddressIsEmpty = false;
        String defaulOfficeAddress = profilePage.getOfficeAddress();
        if (defaulOfficeAddress.length() == 0)
            officeAddressIsEmpty = true;
        Assert.assertFalse(officeAddressIsEmpty);
    }


    @Test(priority = 10)
    public void verifyNewUserDefaulOfficeLeaveTime() {
        String defaultOfficeLeaveTime = profilePage.getOfficeLeaveTime();
        Assert.assertEquals(defaultOfficeLeaveTime, "");
    }


    @Test(priority = 11)
    public void verifyNewUserDefaultCorporateEmail() {
        String defaultCorporateEmail = profilePage.getCorporateEmail();
        // Click Edit button to open profile into edit mode . (Will be needed in next test case)
        profilePage.checkEditButton();
        Assert.assertEquals(defaultCorporateEmail, "Add corporate email");
    }


    // -------------------     TEST CASES TO CHECK FIELD VALIDATIONS AND EDIT USER DETAILS    --------------------


    @Test(priority = 20)
    public void verifyGenderByChangingValue() throws Exception {

        // Choose opposite gender to that of written in properties file .
        if (getValueFromPPFile("gender").equalsIgnoreCase("F")) {
            personalDetailsPage.selectGenderMaleAtProfile();
            userFinalGender = "Male";
        } else if (getValueFromPPFile("gender").equalsIgnoreCase("M")) {
            personalDetailsPage.selectGenderFemaleAtProfile();
            userFinalGender = "Female";
        } else {
            personalDetailsPage.selectGenderOtherAtProfile();
            userFinalGender = "Other";
        }


    }


    @Test(priority = 21, dataProvider = "enterDifferentEmail")
    public void verifyPersonalEmailValidation(String personalEmail, String expected) {
        personalDetailsPage.clearPersonalEmailField();
        personalDetailsPage.enterPersonalEmail(personalEmail);

        // No Error Message Expected means Entered Value will be correct .
        // Therefore writing it into text file for Old User Profile comparison in next step  .
        if (expected.equalsIgnoreCase(""))
            userFinalPersonalEmail = personalEmail;

        String errorPersonalEmailMessage = personalDetailsPage.getPersonalEmailErrorMessage();
        Assert.assertEquals(errorPersonalEmailMessage, expected);

    }


    @Test(priority = 22, dataProvider = "enterDifferentName")
    public void verifyNameValidation(String name, String expected) {
        personalDetailsPage.clearNameField();
        personalDetailsPage.enterUserNameAtProfile(name);

        // No Error Message Expected means Entered Value will be correct .
        // Therefore writing it into text file for Old User Profile comparison in next step  .
        if (expected.equalsIgnoreCase(""))
            userFinalName = name;

        String nameErrorMessage = personalDetailsPage.getNameErrorMessage();
        Assert.assertEquals(nameErrorMessage, expected);
    }


    @Test(priority = 23)
    public void verifyBirthDayField() {
        // Current date will be selected as birth date .
        personalDetailsPage.enterBirthDay();
        String selectedBirthDate = profilePage.getBirthday();
        userFinalBirthdate = selectedBirthDate;

        // If date is selected succcessfully then birth date field will not be empty
        Assert.assertNotEquals(0, selectedBirthDate.length());

    }


    @Test(priority = 24)
    public void verifyHomeLeavingTime() {
        personalDetailsPage.enterHomeLeaveTime();
        String selectedHomeLeaveTime = profilePage.getHomeLeaveTime();
        userFinalHomeLeaveTime = selectedHomeLeaveTime;

        // If time is selected succcessfully then time field will not be empty
        Assert.assertNotEquals(0, selectedHomeLeaveTime.length());
    }


    @Test(priority = 25)
    public void verifyOfficeLeavingTime() {
        personalDetailsPage.enterOfficeLeaveTime();
        String selectedOfficeLeaveTime = profilePage.getOfficeLeaveTime();
        userFinalOfficeLeaveTime = selectedOfficeLeaveTime;

        // If time is selected succcessfully then time field will not be empty
        Assert.assertNotEquals(0, selectedOfficeLeaveTime.length());

    }


    /*
         --> One Test Case for corporate email field is missing  .
         When Email id is valid email id but not a partner email  .
         System throws an error "No partner registered for provided email Id" .
         --> Facebook Test Is Pending
     */


    @Test(priority = 26)
    public void verifyCorporateEmailWindow() {
        personalDetailsPage.goToActualCorporateEmail();
        String corporateEmailField = personalDetailsPage.verifyCorporateEmailNewWindow();
        Assert.assertEquals(corporateEmailField, "Add corporate email");
    }


    @Test(priority = 27, dataProvider = "enterDifferentEmail")
    public void verifyCorporateEmailValidation(String corporateEmail, String expected) {
        personalDetailsPage.clearCorporateEmailField();
        personalDetailsPage.enterCorporateEmail(corporateEmail);

        String errorEmailMessage = personalDetailsPage.getCorporateEmailErrorMessage();

        if (errorEmailMessage.equalsIgnoreCase("")) {
            userFinalCorporateEmail = corporateEmail;
            personalDetailsPage.clickOkButtonToAcceptTheBox();
        }

        Assert.assertEquals(errorEmailMessage, expected);
    }


    @Test(priority = 28)
    public void verifyProfileSubmit() {
        String savedProfileConfirmationText = personalDetailsPage.personalDetailSubmitAtProfile();
        if (savedProfileConfirmationText.equalsIgnoreCase("Profile Updated Successfully")) {
            profileSaved = true;
        }

        Assert.assertEquals(savedProfileConfirmationText, "Profile Updated Successfully");

    }


    // -----------------------------       ALL DATA PROVIDER FUNCTIONS        -----------------------------


    @DataProvider
    public Object[][] enterDifferentName() {

        Object[][] nameError = new String[4][2];

        nameError[0][0] = "   ";
        nameError[0][1] = "Name cannot be empty";

        nameError[1][0] = ";'[]";
        nameError[1][1] = "Invalid Name";

        nameError[2][0] = "a";
        nameError[2][1] = "Name must have atleast 2 characters ";

        nameError[3][0] = "Test Correct Name";
        nameError[3][1] = "";

        return nameError;

    }


    @DataProvider
    public Object[][] enterDifferentEmail() {
        Object[][] emailError = new String[5][2];

        emailError[0][0] = "   ";
        emailError[0][1] = "Enter a valid Email Address";

        emailError[1][0] = "  @  .com";
        emailError[1][1] = "Enter a valid Email Address";

        emailError[2][0] = "ugiguiihuk";
        emailError[2][1] = "Enter a valid Email Address";

        emailError[3][0] = ".@.";
        emailError[3][1] = "Enter a valid Email Address";

        emailError[4][0] = "test@shuttl.com";
        emailError[4][1] = "";


        return emailError;

    }


    // -----------------------------       END OF TEST CASES       -----------------------------


    @AfterClass
    public void tearDown() throws Exception {


        // If Profile is Saved Succcessfully (profileSaved must be true) then only write values in text file
        if (profileSaved) {

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , "Profile Test Run Date : "
                                         + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , "phoneNumber = " + "+91" + getValueFromPPFile("newUserPhoneNumber"));

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , userFinalGender);

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , userFinalPersonalEmail);

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , "latestName = " + userFinalName);

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , "latestBirthdayDate = " + userFinalBirthdate);

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , "latestHomeLeaveTime = " + userFinalHomeLeaveTime);

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , "latestOfficeLeaveTime = " + userFinalOfficeLeaveTime);

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , "latestCorporateEmail = " + userFinalCorporateEmail);

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , " ------------------    PROFILE TESTS ENDED    ------------------ ");

            common.writeTextFile(Constants.finalProfileDataTextFile
                    , "");
        }

        System.out.println("New User Profile Test cases completed");
        driver.quit();
    }


}
