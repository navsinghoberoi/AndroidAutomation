package tests.android;

import common.android.Commons;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.HomePage;
import pages.android.MenuPage;
import pages.android.PersonalDetailsPage;
import pages.android.ProfilePage;

public class NewUserProfileTest extends Setup {


    private HomePage homePage;
    private Commons common;
    private MenuPage menuPage;
    private ProfilePage profilePage;
    private AndroidDriver androidDriver;


    @BeforeClass
    public void setUp() throws Exception {


        createAndroidSession(false);
        androidDriver = (AndroidDriver) driver;
        common = new Commons(driver);

        common.signUp("newUserPhoneNumber", "OTP",
                      "gender", "userName",
                      "homeAddress");

        homePage = new HomePage(driver);
        homePage.clickMenu();

        menuPage = new MenuPage(driver);
        menuPage.clickProfile();

        profilePage = new ProfilePage(driver);


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
        androidDriver.scrollTo("Birthday");
        String defaultBirthDate = profilePage.getBirthday();
        Assert.assertEquals(defaultBirthDate, "");
    }


    @Test(priority = 7)
    public void verifyNewUserDefaultHomeAddress() throws Exception {
        androidDriver.scrollTo("YOUR PLACES");

        boolean corrrectAddress = false;
        String defaultHomeAddress = profilePage.getHomeAddress();
        if (defaultHomeAddress.contains(getValueFromPPFile("homeAddress")))
            corrrectAddress = true;

        Assert.assertEquals(corrrectAddress, true);
    }


    @Test(priority = 8)
    public void verifyNewUserDefaultHomeLeaveTime() {
        String defaultHomeLeaveTime = profilePage.getHomeLeaveTime();
        Assert.assertEquals(defaultHomeLeaveTime, "");
    }


    @Test(priority = 9)
    public void verifyNewUserDefaultOfficeAddress() {
        androidDriver.scrollTo("Office Address");

        // Just Checking if Office Address field is empty or not  . It is not supposed to be empty  as per System.
        boolean officeAddressIsEmpty = false;
        String defaulOfficeAddress = profilePage.getOfficeAddress();
        if (defaulOfficeAddress.length() == 0)
            officeAddressIsEmpty = true;
        Assert.assertEquals(officeAddressIsEmpty, false);
    }


    @Test(priority = 10)
    public void verifyNewUserDefaulOfficeLeaveTime() {
        String defaultOfficeLeaveTime = profilePage.getOfficeLeaveTime();
        Assert.assertEquals(defaultOfficeLeaveTime, "");
    }


    @Test(priority = 11)
    public void verifyNewUserDefaultCorporateEmail() {
        androidDriver.scrollTo("CORPORATE ACCOUNT");
        String defaultCorporateEmail = profilePage.getCorporateEmail();
        Assert.assertEquals(defaultCorporateEmail, "Add corporate email");
    }


    // -----------------------------       END OF TEST CASES       -----------------------------


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        System.out.println("New User Profile Test cases completed");
        driver.quit();
    }


}
