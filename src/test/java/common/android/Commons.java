package common.android;

import org.openqa.selenium.WebDriver;
import pages.android.*;
import pages.android.*;
import tests.android.Setup;

import java.net.MalformedURLException;

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
    private SelectLocationPage selectLocationPage = new SelectLocationPage(driver);
    private SlotsPage slotsPage = new SlotsPage(driver);
    private ExplorePassesPage explorePassesPage = new ExplorePassesPage(driver);
    private ChooseBenefitsPage chooseBenefitsPage = new ChooseBenefitsPage(driver);
    private ReviewRoutePage reviewRoutePage = new ReviewRoutePage(driver);
    private PassCompletePaymentPage passCompletePaymentPage = new PassCompletePaymentPage(driver);
    private PassDetailsPage passDetailsPage = new PassDetailsPage(driver);
    private RefundPassPage refundPassPage = new RefundPassPage(driver);


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


    public void clickSearchBar()
    {
       homePage.clickSearchBar();
    }

    public void closeSearchPopup()
    {
        homePage.closeSearchPopup();
    }


    public void buySubscriptionViaShuttlCredits(String homeAddress, String officeAddress, int slotIndex, int optionIndex,int menuItemIndex) throws Exception
    {
        clickSearchBar();
        homePage.clickFromLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile(homeAddress), 0);
        homePage.clickToLocation();
        selectLocationPage.selectSearchLocation(getValueFromPPFile(officeAddress), 0);
        homePage.clickFindMyShuttl();
        slotsPage.selectOptionFromContinueCTA(slotIndex, optionIndex);
        explorePassesPage.openPass(menuItemIndex);
        chooseBenefitsPage.submitPassBenefitsDetails();
        reviewRoutePage.submitReviewRouteDetails();
        passCompletePaymentPage.getPassCompletepageInfo();
        passCompletePaymentPage.clickPayNowButton();
        passCompletePaymentPage.clickPassPurchaseSuccessfulCTA();
    }

    public void refundSubscription(int menuItemIndex,int ridesIndex,int validityIndex, int reasonForPassDelete,int refundPassValueIndex)
    {
        homePage.openMyPass(menuItemIndex); // User will be redirected to Pass details page directly (from version 36000+)
        passDetailsPage.getRidesValidityData(ridesIndex, validityIndex);
        passDetailsPage.deletePass(reasonForPassDelete);
        refundPassPage.clickDiscontinuePassButton(refundPassValueIndex);
        String refundPassText = refundPassPage.clickPassRefundSuccessfulCTA();
        System.out.println(refundPassText);
    }










}
