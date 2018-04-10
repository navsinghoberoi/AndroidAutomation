package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

// PENDING -- Need to add code for deleting the user at the end

public class Signup extends Setup {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private PersonalDetails personalDetails;
    private HomeAddress homeAddress;
    private OfficeAddress officeAddress;
    private OtpPage otpPage;
    private HomePage homepage;

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        personalDetails = new PersonalDetails(driver);
        homeAddress = new HomeAddress(driver);
        officeAddress = new OfficeAddress(driver);
        otpPage = new OtpPage(driver);
        homepage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }



    @Test
    public void userSignUp() throws Exception
    {
        Thread.sleep(5000);
        landingPage.clickSkipToLogin();

        loginPage.enterMobileNumber(loadPropertyFile().getProperty("phoneNumber"));
        loginPage.clickVerify();
        loginPage.continueButtonClick();

        otpPage.enterOtp(loadPropertyFile().getProperty("OTP"));

        personalDetails.enterUserName(loadPropertyFile().getProperty("userName") + " " + System.currentTimeMillis());
        personalDetails.selectGenderFemale();
        personalDetails.personalDetailSubmit();

        String homeText = homeAddress.whereDoYouLiveText();
     // Assert.assertEquals(homeText, "Where Do You Live");
        homeAddress.selectHomeLocationClick();
        homeAddress.searchBarClick();
        homeAddress.enterHomeAddress(loadPropertyFile().getProperty("homeAddress"));
        homeAddress.selectHomeAddress();   // Adding homeAddress by searching address
        homeAddress.useThisPlaceAddressText();
        homeAddress.selectLocationClick();
        homeAddress.flatNumSet(loadPropertyFile().getProperty("flatNum"));
        driver.hideKeyboard();
        homeAddress.homeAddressSubmit();

        officeAddress.whereDoYouWorkText();
        officeAddress.selectOfficeLocationClick();
        officeAddress.selectThisLocationClick();  // Adding officeAddress by using Select this location feature
        officeAddress.useThisPlaceAddressText();
        officeAddress.selectLocationClick();
        officeAddress.officeAddressSubmit();

        String Text = homepage.getHeaderText();
        Assert.assertEquals(Text, "Search for a route");
        System.out.println("User has signed up successfully");

    }


}