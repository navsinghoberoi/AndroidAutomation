package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

// PENDING -- Need to add code for deleting the user at the end

public class SignupTest extends Setup {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private PersonalDetailsPage personalDetails;
    private HomeAddressPage homeAddressPage;
    private OfficeAddressPage officeAddressPage;
    private OtpPage otpPage;
    private HomePage homepage;

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium(true);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        personalDetails = new PersonalDetailsPage(driver);
        homeAddressPage = new HomeAddressPage(driver);
        officeAddressPage = new OfficeAddressPage(driver);
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
    public void verifyUserSignUp() throws Exception
    {
        Thread.sleep(5000);
        landingPage.clickSkipToLogin();

        loginPage.enterMobileNumber(getValueFromPPFile("phoneNumber"));
        loginPage.clickVerify();
        loginPage.continueButtonClick();

        otpPage.enterOtp(getValueFromPPFile("OTP"));

          personalDetails.enterUserName(getValueFromPPFile("userName") + " " + System.currentTimeMillis());

        personalDetails.selectGenderFemale();
        personalDetails.personalDetailSubmit();

        String homeText = homeAddressPage.whereDoYouLiveText();
     // Assert.assertEquals(homeText, "Where Do You Live");
        homeAddressPage.selectHomeLocationClick();
        homeAddressPage.searchBarClick();
        homeAddressPage.enterHomeAddress(getValueFromPPFile("homeAddress"));
        homeAddressPage.selectHomeAddress();   // Adding homeAddressPage by searching address
        homeAddressPage.useThisPlaceAddressText();
        homeAddressPage.selectLocationClick();
        homeAddressPage.flatNumSet(getValueFromPPFile("flatNum"));
        driver.hideKeyboard();
        homeAddressPage.homeAddressSubmit();

        officeAddressPage.whereDoYouWorkText();
        officeAddressPage.selectOfficeLocationClick();
        officeAddressPage.selectThisLocationClick();  // Adding officeAddressPage by using Select this location feature
        officeAddressPage.useThisPlaceAddressText();
        officeAddressPage.selectLocationClick();
        officeAddressPage.officeAddressSubmit();

        String Text = homepage.getHeaderText();
        Assert.assertEquals(Text, "Search for a route");
        System.out.println("User has signed up successfully");

    }


}