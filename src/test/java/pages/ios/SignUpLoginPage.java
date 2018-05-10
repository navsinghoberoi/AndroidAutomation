package pages.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpLoginPage extends BasePage {

    By skipToLogin = By.xpath("//XCUIElementTypeButton[@name=\"SKIP TO LOGIN \"]\n");
    By mobileNumberAtSignUpLogin = By.xpath("//XCUIElementTypeApplication[@name=\"Shuttl QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField/XCUIElementTypeTextField\n");
    By verifyButton = By.xpath("//XCUIElementTypeButton[@name=\"VERIFY\"]\n");
    By continueAtAlert = By.xpath("//XCUIElementTypeButton[@name=\"Continue\"]\n");
    By otp = By.xpath("//XCUIElementTypeApplication[@name=\"Shuttl QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther\n");
    By userNameAtSignUp = By.xpath("//XCUIElementTypeApplication[@name=\"Shuttl QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField/XCUIElementTypeTextField\n");
    By femaleGenderAtSignUp = By.xpath("//XCUIElementTypeImage[@name=\"gender_inActive0\"]\n");
    By maleGenderAtSignUp = By.xpath("//XCUIElementTypeImage[@name=\"gender_inActive1\"]\n");
    By otherGenderAtSignUp = By.xpath("//XCUIElementTypeImage[@name=\"gender_inActive2\"]\n");
    By haveAReferralCodeAtSignUp = By.xpath("//XCUIElementTypeButton[@name=\"HAVE A REFERRAL CODE?\"]\n");
    By enterReferralCodeField = By.xpath("//XCUIElementTypeApplication[@name=\"Shuttl QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField/XCUIElementTypeTextField\n");
    By referralCodeApplyButton = By.xpath("//XCUIElementTypeButton[@name=\"APPLY\"]\n");
    By continueArrow = By.xpath("//XCUIElementTypeButton[@name=\"continueArrow\"]\n");
    By selectHomeAddressAtSignUp = By.xpath("//XCUIElementTypeApplication[@name=\"Shuttl QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField/XCUIElementTypeTextField\n");
    By searchIconForAddress = By.xpath("//XCUIElementTypeButton[@name=\"Search\"]\n");
    By searchFieldForAddress = By.xpath("//XCUIElementTypeSearchField[@name=\"Search\"])[2]");
    By firstsearchResultForAddress = By.xpath("//XCUIElementTypeApplication[@name=\"Shuttl QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]\n");
    By finalsearchResultForAddress = By.xpath("//XCUIElementTypeApplication[@name=\"Shuttl QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]\n");
    By flatNumber = By.xpath("//XCUIElementTypeApplication[@name=\"Shuttl QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField/XCUIElementTypeTextField\n");
    By selectOfficeAddressAtSignUp = By.xpath("//XCUIElementTypeApplication[@name=\"Shuttl QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField/XCUIElementTypeTextField\n");
    By finalSubmitAllDetails = By.xpath("//XCUIElementTypeButton[@name=\"DONE\"]\n");



    public SignUpLoginPage(WebDriver driver) {
        super(driver);
    }

    // --------------------------    INDIVIDUAL FIELD FUNCTIONS    -------------------------------

    public void clickSkipToLogin() {
        waitForClickabilityOf(skipToLogin);
        driver.findElement(skipToLogin).click();
    }


    public void enterMobileNumber(String userPhoneNumber) throws Exception {
        waitForVisibilityOf(mobileNumberAtSignUpLogin);
        driver.findElement(mobileNumberAtSignUpLogin).sendKeys(getValueFromPPFile(userPhoneNumber));
    }


    public void clickVerify() {
        waitForClickabilityOf(verifyButton);
        driver.findElement(verifyButton).click();
    }


    public void acceptContinuepopup() {

        // If Device is already registered with us then System throws a popup  .
        try {
            waitForClickabilityOf(continueAtAlert);
            driver.findElement(continueAtAlert).click();
        } catch (Exception e) {
        }

    }


    public void enterOtp(String userOTP) {
        waitForVisibilityOf(otp);
        driver.findElement(otp).sendKeys(userOTP);
    }


    public void enterUserNameAtSignUp(String userNameKey) throws Exception {
        waitForVisibilityOf(userNameAtSignUp);
        driver.findElement(userNameAtSignUp).sendKeys(getValueFromPPFile(userNameKey));
    }


    public void selectGender(String genderKey) {

        if (genderKey.equalsIgnoreCase("F")) {
            waitForVisibilityOf(femaleGenderAtSignUp);
            driver.findElement(femaleGenderAtSignUp).click();
        } else if (genderKey.equalsIgnoreCase("M")) {
            waitForVisibilityOf(maleGenderAtSignUp);
            driver.findElement(maleGenderAtSignUp).click();
        } else if (genderKey.equalsIgnoreCase("O")) {
            waitForVisibilityOf(otherGenderAtSignUp);
            driver.findElement(otherGenderAtSignUp).click();
        } else
            System.out.println("Invalid Gender Key");


    }


    public void enterReferralCode(String referralCode) throws Exception {
        if (!referralCode.equalsIgnoreCase("")) {
            waitForClickabilityOf(haveAReferralCodeAtSignUp);
            driver.findElement(haveAReferralCodeAtSignUp).click();

            waitForVisibilityOf(enterReferralCodeField);
            driver.findElement(enterReferralCodeField).sendKeys(getValueFromPPFile(referralCode));

            waitForVisibilityOf(referralCodeApplyButton);
            driver.findElement(referralCodeApplyButton).click();
        }

    }


    public void continueToNextStep() {
        waitForClickabilityOf(continueArrow);
        driver.findElement(continueArrow).click();
    }


    public void clickToEnterHomeAddress() {
        waitForClickabilityOf(selectHomeAddressAtSignUp);
        driver.findElement(selectHomeAddressAtSignUp).click();

    }


    public void searchAddress(String addressKey) throws Exception {
        waitForVisibilityOf(searchIconForAddress);
        driver.findElement(searchIconForAddress).click();

        waitForVisibilityOf(searchFieldForAddress);
        driver.findElement(searchFieldForAddress).sendKeys(getValueFromPPFile(addressKey));

        waitForVisibilityOf(firstsearchResultForAddress);
        driver.findElement(firstsearchResultForAddress).click();

    }


    public void chooseFinalPlaceAddress() {
        waitForVisibilityOf(finalsearchResultForAddress);
        driver.findElement(finalsearchResultForAddress).click();
    }


    public void enterFlatNumber(String flatNumberKey) throws Exception {
        waitForVisibilityOf(flatNumber);
        driver.findElement(flatNumber).sendKeys(getValueFromPPFile(flatNumberKey));
    }


    public void clickToEnterofficeAddress() {
        waitForClickabilityOf(selectOfficeAddressAtSignUp);
        driver.findElement(selectOfficeAddressAtSignUp).click();

    }


    public void submitAllDetails() {
        waitForVisibilityOf(finalSubmitAllDetails);
        driver.findElement(finalSubmitAllDetails).click();
    }


    // --------------------------    INTEGRATED FUNCTIONS USING INDIVIDUAL FIELD FUNCTIONS   -------------------------------


    /* This method lets user login by specifying phonenumber and OTP*/
    public void enterUserPhoneNumberOTP(String phoneNumberKey, String otpKey) throws Exception {
        clickSkipToLogin();
        enterMobileNumber(getValueFromPPFile(phoneNumberKey));
        clickVerify();
        acceptContinuepopup();
        enterOtp(getValueFromPPFile(otpKey));


    }

    public void enterUserDetails(String userNameKey, String genderKey, String referralCodeKey) throws Exception {
        enterUserNameAtSignUp(getValueFromPPFile(userNameKey));
        selectGender(getValueFromPPFile(genderKey));
        enterReferralCode(referralCodeKey);
        continueToNextStep();

    }

    public void enterHomeAddressDetailsNewUser(String homeAddressKey, String flatNumber) throws Exception {
        clickToEnterHomeAddress();
        searchAddress(homeAddressKey);
        // Adding homeAddressPage by searching address
        chooseFinalPlaceAddress();
        enterFlatNumber(flatNumber);
        continueToNextStep();
    }

    public void enterOfficeAddressDetailsNewUser(String officeAddressKey) throws Exception {
        clickToEnterofficeAddress();
        searchAddress(officeAddressKey);
        chooseFinalPlaceAddress();  // Adding officeAddressPage by using Select this location feature
        submitAllDetails();
    }

}
