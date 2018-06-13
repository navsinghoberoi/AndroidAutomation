package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
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
//Precondition -- No user should be logged in app

public class SignupTest extends Setup {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private PersonalDetailsPage personalDetails;
    private HomeAddressPage homeAddressPage;
    private OfficeAddressPage officeAddressPage;
    private OtpPage otpPage;
    private HomePage homepage;
    private Commons commons;
    private String className;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(true);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        personalDetails = new PersonalDetailsPage(driver);
        homeAddressPage = new HomeAddressPage(driver);
        officeAddressPage = new OfficeAddressPage(driver);
        otpPage = new OtpPage(driver);
        homepage = new HomePage(driver);
        commons = new Commons(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (ITestResult.FAILURE == iTestResult.getStatus()){
            commons.captureScreenshot(driver,className);
            System.out.println("Screenshot taken for failed testcase");
        }
    }


    @AfterClass
    public void quit() {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }


    @Test(priority = 1)
    public void verifyUserNotRegistered() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        boolean result = personalDetails.isUserOnPersonalDetailsPage();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 2)
    public void verifyPersonalDetailsHeadingText() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        String result = personalDetails.getPersonalDetailsPageHeading();
        Assert.assertEquals(result, "Personal Details", "test case failed");
    }


    @Test(priority = 3)
    public void verifyPersonalDetailsSubheadingText() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        String result = personalDetails.getPersonalDetailsPageSubheading();
        Assert.assertEquals(result, "Help us know your better", "test case failed");
    }


    @Test(priority = 4)
    public void verifyGenderOptionsAvailable() throws Exception {
        boolean result;
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        int count = personalDetails.getAvailableGendersCount();
        if (count == 3) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertEquals(result, true, "test case failed");

    }


    @Test(priority = 5)
    public void verifyHaveAReferralCodeDisplayedOnPersonalDetailsPage() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        boolean result = personalDetails.isHaveAReferralCodeDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 6)
    public void verifyReferralPopupHeadingText() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        personalDetails.haveAReferralCodeClick();
        String result = personalDetails.getReferralCodePopupHeading();
        Assert.assertEquals(result, "Enter your referral/coupon code here to get free rides", "test case failed");
    }


    @Test(priority = 7)
    public void verifyErrorPromptOnEnteringIncorrectReferralCode() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        personalDetails.haveAReferralCodeClick();
        String result = personalDetails.getReferralCodeErrorPrompt();
        Assert.assertEquals(result, "This device has already been used by another user, hence you will not receive any discounted rides valid for new users.", "test case failed");
    }


    @Test(priority = 8)
    public void verifySubmitArrowNotDisplayedWithoutEnteringPersonalDetails() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        boolean result = personalDetails.isPersonalDetailsSubmitArrowDisplayed();
        Assert.assertEquals(result, false, "test case failed");
    }


    @Test(priority = 9)
    public void verifySubmitArrowDisplayedAfterEnteringPersonalDetails() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        personalDetails.enterUserNameAtSignUp(getValueFromPPFile("userName"));
        personalDetails.selectGender(getValueFromPPFile("gender"));
        boolean result = personalDetails.isPersonalDetailsSubmitArrowDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 10)
    public void verifyWhereYouLiveHeadingText() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        String result = homeAddressPage.whereDoYouLiveText();
        Assert.assertEquals(result, "Where Do You Live", "test case failed");
    }

    @Test(priority = 11)
    public void verifyWhereYouLiveSubheadingText() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        String result = homeAddressPage.whereDoYouLiveSubtext();
        Assert.assertEquals(result, "Help us find the right route for you", "test case failed");
    }


    @Test(priority = 12)
    public void verifyBackButtonClickOnHomeAddressPage() throws Exception {

        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        homeAddressPage.backIconClick();
        String result = personalDetails.getPersonalDetailsPageHeading();
        Assert.assertEquals(result, "Personal Details", "test case failed");
    }


    @Test(priority = 13)
    public void verifySelectHomeLocationFieldIsDisplayed() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        boolean result = homeAddressPage.isSelectHomeLocationFieldDisplayed();
        Assert.assertEquals(result, true, "test case failed");

    }


    @Test(priority = 14)
    public void verifySubmitArrowNotDisplayedWithoutEnteringHomeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        boolean result = homeAddressPage.isHomeLocationDetailsSubmitArrowDisplayed();
        Assert.assertEquals(result, false, "test case failed");
    }

    @Test(priority = 15)
    public void verifySearchBarDisplayedOnClickOfSelectHomeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        homeAddressPage.selectHomeLocationClick();
        boolean result = homeAddressPage.isSearchBarDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 16)
    public void verifySelectThisLocationDisplayedOnClickOfSelectHomeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        homeAddressPage.selectHomeLocationClick();
        boolean result = homeAddressPage.isSelectThisLocationDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 17)
    public void verifyNearbyPlacesDisplayedOnClickOfSelectHomeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        homeAddressPage.selectHomeLocationClick();
        boolean result = homeAddressPage.isNearbyPlacesDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 18)
    public void verifyMyLocationDisplayedOnClickOfSelectHomeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        homeAddressPage.selectHomeLocationClick();
        boolean result = homeAddressPage.isMyLocationIconDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 19)
    public void verifyUseThisLocationDisplayedAfterSelectingHomeAddress() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        homeAddressPage.selectHomeLocationClick();
        homeAddressPage.searchBarClick();
        homeAddressPage.enterHomeAddress(getValueFromPPFile("homeAddress"));
        homeAddressPage.selectHomeAddress();
        String result = homeAddressPage.getUseThisPlaceHeading();
        Assert.assertEquals(result, "Use this place?", "test case failed");
    }


    @Test(priority = 20)
    public void verifyHomeLocationData() throws Exception {
        boolean result;
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        homeAddressPage.selectHomeLocationClick();
        homeAddressPage.searchBarClick();
        homeAddressPage.enterHomeAddress(getValueFromPPFile("homeAddress"));
        homeAddressPage.selectHomeAddress();
        homeAddressPage.selectLocationClick();
        String addressData = homeAddressPage.geHomeLocationEnteredText();
        if (addressData.contains(getValueFromPPFile("homeAddress"))) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 21)
    public void verifySubmitArrowDisplayedAfterEnteringHomeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        homeAddressPage.selectHomeLocationClick();
        homeAddressPage.searchBarClick();
        homeAddressPage.enterHomeAddress(getValueFromPPFile("homeAddress"));
        homeAddressPage.selectHomeAddress();
        homeAddressPage.selectLocationClick();
        boolean result = homeAddressPage.isHomeLocationDetailsSubmitArrowDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 22)
    public void verifyWhereYouWorkHeadingText() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        String result = officeAddressPage.whereDoYouWorkText();
        Assert.assertEquals(result, "Where Do You Work", "test case failed");
    }

    @Test(priority = 23)
    public void verifyWhereYouWorkSubheadingText() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        String result = officeAddressPage.whereDoYouWorkSubtext();
        Assert.assertEquals(result, "Help us find the right route for you", "test case failed");
    }


    @Test(priority = 24)
    public void verifyBackButtonClickOnOfficeAddressPage() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        officeAddressPage.backIconClick();
        String result = homeAddressPage.whereDoYouLiveText();
        Assert.assertEquals(result, "Where Do You Live", "test case failed");
    }


    @Test(priority = 25)
    public void verifySelectOfficeLocationFieldIsDisplayed() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        boolean result = officeAddressPage.isSelectOfficeLocationFieldDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 26)
    public void verifySubmitArrowNotDisplayedWithoutEnteringOfficeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        boolean result = officeAddressPage.isOfficeLocationDetailsSubmitButtonDisplayed();
        Assert.assertEquals(result, false, "test case failed");
    }


    @Test(priority = 27)
    public void verifySearchBarDisplayedOnClickOfSelectOfficeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        officeAddressPage.selectOfficeLocationClick();
        boolean result = officeAddressPage.isSearchBarDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 28)
    public void verifySelectThisLocationDisplayedOnClickOfSelectOfficeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        officeAddressPage.selectOfficeLocationClick();
        boolean result = officeAddressPage.isSelectThisLocationDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 29)
    public void verifyNearbyPlacesDisplayedOnClickOfSelectOfficeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        officeAddressPage.selectOfficeLocationClick();
        boolean result = officeAddressPage.isNearbyPlacesDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 30)
    public void verifyMyLocationDisplayedOnClickOfSelectOfficeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        officeAddressPage.selectOfficeLocationClick();
        boolean result = officeAddressPage.isMyLocationIconDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 31)
    public void verifyUseThisLocationDisplayedAfterSelectingOfficeAddress() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        officeAddressPage.selectOfficeLocationClick();
        officeAddressPage.searchBarClick();
        officeAddressPage.enterOfficeAddress(getValueFromPPFile("officeAddress"));
        officeAddressPage.selectOfficeAddress();
        String result = officeAddressPage.getUseThisPlaceHeading();
        Assert.assertEquals(result, "Use this place?", "test case failed");
    }


    @Test(priority = 32)
    public void verifyOfficeLocationData() throws Exception {
        boolean result;
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        officeAddressPage.selectOfficeLocationClick();
        ;
        officeAddressPage.searchBarClick();
        officeAddressPage.enterOfficeAddress(getValueFromPPFile("officeAddress"));
        officeAddressPage.selectOfficeAddress();
        officeAddressPage.selectLocationClick();
        String addressData = officeAddressPage.getOfficeLocationEnteredText();
        if (addressData.contains(getValueFromPPFile("officeAddress"))) {
            result = true;
        } else {
            result = false;
        }
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 33)
    public void verifySubmitArrowDisplayedAfterEnteringOfficeLocation() throws Exception {
        commons.enterUserPhoneNumberOTP("newUserPhoneNumber", "OTP");
        commons.enterUserDetails("userName", "gender");
        commons.enterHomeAddressDetailsNewUser("homeAddress");
        officeAddressPage.selectOfficeLocationClick();
        ;
        officeAddressPage.searchBarClick();
        officeAddressPage.enterOfficeAddress(getValueFromPPFile("officeAddress"));
        officeAddressPage.selectOfficeAddress();
        officeAddressPage.selectLocationClick();
        boolean result = officeAddressPage.isOfficeLocationDetailsSubmitButtonDisplayed();
        Assert.assertEquals(result, true, "test case failed");
    }


    @Test(priority = 34)
    public void verifySignupComplete() throws Exception {
        commons.signUp("newUserPhoneNumber", "OTP",
                "gender", "userName",
                "homeAddress");
        boolean result = homepage.isFindRouteButtonEnabled();
        System.out.println(result);
        Assert.assertEquals(result, true, "test case failed");
    }


}