package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignUpLoginPage extends BasePage {


    // ----------    USING STRING CLASS   ----------


    // ByIosNsPredicate
    String userNameAtSignUp = "type == \"XCUIElementTypeTextField\" AND value == \"Enter your name\"";
    String enterReferralCodeField = "type == \"XCUIElementTypeTextField\" AND value == \"Referral/Coupon Code\"";
    String homeAddressAtSignup = "type == \"XCUIElementTypeTextField\" AND value == \"Select Home Location\"";
    String searchResultsForAddress = "type == \"XCUIElementTypeCell\"";
    String flatNumber = "type == \"XCUIElementTypeTextField\" AND value == \"Flat / House No.\"";
    String officeAddressAtSignup = "type == \"XCUIElementTypeTextField\" AND value == \"Select Office Location\"";


    // ByXpath
    String otp = "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
    String searchFieldForAddress = "(//XCUIElementTypeSearchField[@name=\"Search\"])[1]";

    // ByAccessibilityId
    String skipToLogin = "SKIP TO LOGIN   ";
    String verifyButtonClick = "VERIFY";
    String continueAtAlert = "Continue";
    String femaleGenderAtSignUp = "gender_inActive0";
    String maleGenderAtSignUp = "gender_inActive1";
    String otherGenderAtSignUp = "gender_inActive2";
    String haveAReferralCodeAtSignUp = "HAVE A REFERRAL CODE?";
    String referralCodeApplyButton = "APPLY";
    String continueArrow = "continueArrow";
    String searchIcon = "Search";
    String finalSubmitAllDetails = "DONE";


    // ByClassName
    String mobileNumberAtSignupLogin = "XCUIElementTypeTextField";


    public SignUpLoginPage(IOSDriver driver) {

        super(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    // --------------------------    INDIVIDUAL FIELD FUNCTIONS    -------------------------------

    public void clickSkipToLogin() {
        WebElement skipToLoginButton = driver.findElementByAccessibilityId(skipToLogin);
        //waitForClickabilityOf();
        skipToLoginButton.click();
    }


    public void enterMobileNumber(String userPhoneNumber) throws Exception {
        WebElement mobileNumber = driver.findElementByClassName(mobileNumberAtSignupLogin);
        //waitForVisibilityOf();
        mobileNumber.sendKeys(getValueFromPPFile(userPhoneNumber));
    }


    public void clickVerify() {
        WebElement verifyButton = driver.findElementByAccessibilityId(verifyButtonClick);
        //waitForClickabilityOf();
        verifyButton.click();
        acceptContinuePopup();
    }


    public void acceptContinuePopup() {

        // If Device is already registered with us then System throws a popup  .
        try {
            WebElement continueAlert = driver.findElementByAccessibilityId(continueAtAlert);
            //waitForClickabilityOf();
            continueAlert.click();
        } catch (Exception e) {
        }

    }


    public void enterOtp(String userOTP) throws Exception {
        WebElement otpField = driver.findElementByXPath(otp);
        //waitForVisibilityOf();
        otpField.sendKeys(getValueFromPPFile("OTP"));
    }


    public void enterUserNameAtSignUp(String userNameKey) throws Exception {
        WebElement userName = driver.findElementByIosNsPredicate(userNameAtSignUp);
        //waitForVisibilityOf();
        userName.sendKeys(getValueFromPPFile(userNameKey));
        hideKeyboard();
    }


    public void selectGender(String genderKey) throws Exception {

        if (getValueFromPPFile(genderKey).equalsIgnoreCase("F")) {
            WebElement gender = driver.findElementByAccessibilityId(femaleGenderAtSignUp);
            //waitForVisibilityOf(gender);
            gender.click();
        } else if (getValueFromPPFile(genderKey).equalsIgnoreCase("M")) {
            WebElement gender = driver.findElementByAccessibilityId(maleGenderAtSignUp);
            //waitForVisibilityOf(gender);
            gender.click();
        } else if (getValueFromPPFile(genderKey).equalsIgnoreCase("O")) {
            WebElement gender = driver.findElementByAccessibilityId(otherGenderAtSignUp);
            //waitForVisibilityOf(gender);
            gender.click();
        } else
            System.out.println("Invalid Gender Key");


    }


    public void enterReferralCode(String referralCode) throws Exception {
        if (!getValueFromPPFile(referralCode).equalsIgnoreCase("")) {
            WebElement haveReferCode = driver.findElementByAccessibilityId(haveAReferralCodeAtSignUp);
            //waitForClickabilityOf(haveReferCode);
            haveReferCode.click();

            WebElement referCodeTextField = driver.findElementByAccessibilityId(enterReferralCodeField);
            //waitForVisibilityOf(referCodeTextField);
            referCodeTextField.sendKeys(getValueFromPPFile(referralCode));
            hideKeyboard();

            WebElement referCodeApply = driver.findElementByAccessibilityId(referralCodeApplyButton);
            //waitForVisibilityOf(referCodeApply);
            referCodeApply.click();
        } else
            System.out.println("No Referral Code For This Signup");

    }


    public void continueToNextStep() {
        WebElement continueButton = driver.findElementByAccessibilityId(continueArrow);
        //waitForClickabilityOf(continueButton);
        continueButton.click();
    }


    public void clickToEnterHomeAddress() {
        WebElement homeAddressTextField = driver.findElementByIosNsPredicate(homeAddressAtSignup);
        //waitForClickabilityOf(homeAddressTextField);
        homeAddressTextField.click();
        try {
            allowAppNotifications();
        } catch (Exception e) {
        }

    }


    public void searchAddress(String addressKey) throws Exception {
        WebElement searchIconAtLeft = driver.findElementByAccessibilityId(searchIcon);
        //waitForVisibilityOf(search);
        searchIconAtLeft.click();


        WebElement searchTextField = driver.findElementByAccessibilityId(searchIcon);
        searchTextField.click();


        searchTextField = driver.findElementByXPath(searchFieldForAddress);
        //waitForVisibilityOf(search);
        searchTextField.sendKeys(getValueFromPPFile(addressKey));


        List<WebElement> firstSearchResult = driver.findElementsByIosNsPredicate(searchResultsForAddress);
        //waitForVisibilityOf(search);
        // Choose the first location
        firstSearchResult.get(0).click();

    }


    public void chooseFinalPlaceAddress() {
        List<WebElement> firstSearchResult = driver.findElementsByIosNsPredicate(searchResultsForAddress);
        //waitForVisibilityOf(search);
        // Choose the first location
        firstSearchResult.get(0).click();
    }


    public void enterFlatNumber(String flatNumberKey) throws Exception {
        WebElement flatNumberAtSignup = driver.findElementByIosNsPredicate(flatNumber);
        //waitForVisibilityOf(flatNumberAtSignup);
        flatNumberAtSignup.sendKeys(getValueFromPPFile(flatNumberKey));
        hideKeyboard();
    }


    public void clickToEnterOfficeAddress() {
        WebElement officeAddress = driver.findElementByIosNsPredicate(officeAddressAtSignup);
        //waitForClickabilityOf(officeAddress);
        officeAddress.click();

    }


    public void submitAllDetails() {
        WebElement submitDetails = driver.findElementByAccessibilityId(finalSubmitAllDetails);
        //waitForVisibilityOf(submitDetails);
        submitDetails.click();
        try {
            allowAppNotifications();
            System.out.println("Clicked");
        } catch (Exception e) {
        }
        

    }


    // --------------------------    INTEGRATED FUNCTIONS USING INDIVIDUAL FIELD FUNCTIONS   -------------------------------


    /* This method lets user login String specifying phonenumber and OTP*/
    public void enterUserPhoneNumberOTP(String phoneNumberKey, String otpKey) throws Exception {
        clickSkipToLogin();
        enterMobileNumber(phoneNumberKey);
        clickVerify();
        acceptContinuePopup();
        enterOtp(getValueFromPPFile(otpKey));


    }

    public void enterUserDetails(String userNameKey, String genderKey, String referralCodeKey) throws Exception {
        enterUserNameAtSignUp(userNameKey);
        selectGender(genderKey);
        enterReferralCode(referralCodeKey);
        continueToNextStep();

    }

    public void enterHomeAddressDetailsNewUser(String homeAddressKey, String flatNumber) throws Exception {
        clickToEnterHomeAddress();
        searchAddress(homeAddressKey);
        // Adding homeAddressPage String searching address
        chooseFinalPlaceAddress();
        enterFlatNumber(flatNumber);
        continueToNextStep();
    }

    public void enterOfficeAddressDetailsNewUser(String officeAddressKey) throws Exception {
        clickToEnterOfficeAddress();
        searchAddress(officeAddressKey);
        chooseFinalPlaceAddress();  // Adding officeAddressPage String using Select this location feature
        submitAllDetails();
    }

}
