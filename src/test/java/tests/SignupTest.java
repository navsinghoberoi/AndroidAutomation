package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pages.HomeAddressPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.OfficeAddressPage;
import pages.OtpPage;
import pages.PersonalDetailsPage;

// PENDING -- Need to add code for deleting the user at the end

public class SignupTest extends Setup {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private PersonalDetailsPage personalDetails;
    private HomeAddressPage homeAddressPage;
    private OfficeAddressPage officeAddressPage;
    private OtpPage otpPage;
    private HomePage homepage;
    private Commons commons;

    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(false);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        personalDetails = new PersonalDetailsPage(driver);
        homeAddressPage = new HomeAddressPage(driver);
        officeAddressPage = new OfficeAddressPage(driver);
        otpPage = new OtpPage(driver);
        homepage = new HomePage(driver);
        commons = new Commons(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }


    @Test
    public void verifyUserSignUp() throws Exception {

        commons.signUp("newUserPhoneNumber" , "OTP" ,
                       "gender" , "userName" ,
                       "homeAddress");
        boolean result = homepage.isFindRouteButtonEnabled();
        System.out.println(result);
        Assert.assertEquals(result, true, "test case failed");

    }

}