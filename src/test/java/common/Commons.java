package common;

import org.openqa.selenium.WebDriver;
import pages.*;
import io.appium.java_client.android.AndroidDriver;
import tests.Setup;

import java.net.MalformedURLException;
import java.net.URL;

public class Commons extends BasePage {

    public Commons(WebDriver driver) throws MalformedURLException {
        super(driver);
    }

    private LandingPage landingPage = new LandingPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);
    private OtpPage otpPage = new OtpPage(driver);
    private HomeAddressPage homeAddressPage = new HomeAddressPage(driver);
    private OfficeAddressPage officeAddressPage = new OfficeAddressPage(driver);
    private PersonalDetailsPage personalDetails = new PersonalDetailsPage(driver);

    public void login() throws InterruptedException {
        Thread.sleep(5000);
        landingPage.clickSkipToLogin();
        //Thread.sleep(2000);
        loginPage.enterMobileNumber("9555814581");
        //loginPage.clickGetOtp();
        //loginPage.enterOtp("1111");
        loginPage.clickVerify();
        otpPage.enterOtp("2344");
        String Text = new HomePage(driver).getHeaderText();

    }

    public void goToHomepage() throws InterruptedException {
        if (!homePage.checkBuddyButton())
            login();
    }


    /* This method lets user login by specifying phonenumber and OTP*/
    public void enterUserPhoneNumberOTP(String phoneNumber, String otp) throws Exception {
        String userPhoneNumber = getValueFromPPFile(phoneNumber);
        String userOTP = getValueFromPPFile(otp);
        Thread.sleep(5000);
        landingPage.clickSkipToLogin();
        loginPage.enterMobileNumber(userPhoneNumber);
        loginPage.clickVerify();
        loginPage.continueButtonClick();
        otpPage.enterOtp(userOTP);

    }



    public void enterPersonalDetailsNewUser() throws Exception {
        personalDetails.enterUserName(getValueFromPPFile("userName") + " " + System.currentTimeMillis());
        personalDetails.selectGender(getValueFromPPFile("gender"));
        personalDetails.personalDetailSubmit();

    }

    public void enterHomeAddressDetailsNewUser() throws Exception {
        String homeText = homeAddressPage.whereDoYouLiveText();
        homeAddressPage.selectHomeLocationClick();
        homeAddressPage.searchBarClick();
        homeAddressPage.enterHomeAddress(getValueFromPPFile("homeAddress"));
        homeAddressPage.selectHomeAddress();   // Adding homeAddressPage by searching address
        homeAddressPage.useThisPlaceAddressText();
        homeAddressPage.selectLocationClick();
        /*homeAddressPage.flatNumSet(getValueFromPPFile("flatNum")); // Commenting for avoiding NPE on hidekeyboard
        androidDriver.hideKeyboard();*/
        homeAddressPage.homeAddressSubmit();
    }

    public void enterOfficeAddressDetailsNewUser() {
        officeAddressPage.whereDoYouWorkText();
        officeAddressPage.selectOfficeLocationClick();
        officeAddressPage.selectThisLocationClick();  // Adding officeAddressPage by using Select this location feature
        officeAddressPage.useThisPlaceAddressText();
        officeAddressPage.selectLocationClick();
        officeAddressPage.officeAddressSubmit();
    }

}
