package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPage extends BasePage {

    By userNameAtProfile = By.id("edit_profile_name");
    By userNameWhileSignUp = By.id("frag_usr_reg1.name_input");
    By genderFemale = By.id("frag_usr_reg1.gender_female");
    By genderMale = By.id("frag_usr_reg1.gender_male");
    By genderOthers = By.id("frag_usr_reg1.gender_other");
    By personalDetailsSubmitAtSignup = By.id("frag_usr_reg1.action");
    By personalDetailsSubmitAtProfile = By.id("action_edit_profile");
    By nameErrorMessageField = By.id("textinput_error");
    By personalEmailField = By.id("edit_profile_email");
    By personalEmailErrorMessageField = By.id("textinput_error");
    By corporateEmailErrorMessageField = By.id("connected_account_validation_error_tv");
    By corporateEmailField = By.id("profile_connected_account_tv");
    By enterCorporateEmailField = By.id("connected_accounts_auto_ct");
    By birthdayField = By.id("edit_profile_birthday");
    By homeLeaveTime = By.id("profile_home_time_user");
    By officeLeaveTime = By.id("profile_office_edit_time");
    By okButton = By.id("button1");
    By submitCorporateEmail = By.id("add_account_btn");
    By partnerErrorMessageInCorporateEmail = By.id("snackbar_text");
    By backButton = By.className("android.widget.ImageButton");
    By addCorporateEmailFieldInNewWindow = By.id("email_float_label");
    By genderMaleProfile = By.id("radioButtonMale");
    By genderFemaleProfile = By.id("radioButtonFemale");
    By genderOtherProfile = By.id("profile.gender_other");
    By textAfterSavingProfile = By.id("message");
    By titleText = By.id("frag_usr_reg1.title");
    By subtitleText = By.id("frag_usr_reg1.sub_title");
    By genderIcon = By.id("urg.gender_icon");
    By haveReferralCode = By.id("frag_usr_reg1.have_referral_code");
    By referralCodePopupHeading = By.id("ref_code.label");
    By referralCodeField = By.id("ref_code.input");
    By referralCodeSubmit = By.id("ref_code.submit");
    By referralCodeErrorText = By.id("textinput_error");

    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
    }


    public void enterBirthDay() {
        scrollToText("Birthday");
        waitForClickabilityOf(birthdayField);
        driver.findElement(birthdayField).click();
        clickOkButtonToAcceptTheBox();

    }


    public void goToActualCorporateEmail() {
        scrollToText("CORPORATE ACCOUNT");
        waitForClickabilityOf(corporateEmailField);
        driver.findElement(corporateEmailField).click();
    }


    public String verifyCorporateEmailNewWindow() {
        waitForVisibilityOf(addCorporateEmailFieldInNewWindow);
        return driver.findElement(addCorporateEmailFieldInNewWindow).getText();

    }


    public void enterOfficeLeaveTime() {
        scrollToText("Time you leave from office");
        waitForClickabilityOf(officeLeaveTime);
        driver.findElement(officeLeaveTime).click();

        clickOkButtonToAcceptTheBox();
    }


    public void enterHomeLeaveTime() {
        scrollToText("Time you leave from home");
        waitForClickabilityOf(homeLeaveTime);
        driver.findElement(homeLeaveTime).click();

        clickOkButtonToAcceptTheBox();
    }


    public void enterUserNameAtSignUp(String name) {
        waitForVisibilityOf(userNameWhileSignUp);
        driver.findElement(userNameWhileSignUp).sendKeys(name);

    }


    public void enterUserNameAtProfile(String name) {
        waitForVisibilityOf(userNameAtProfile);
        driver.findElement(userNameAtProfile).sendKeys(name);
        hideKeyboard();

    }

    public void enterCorporateEmail(String corporateEmail) {
        waitForVisibilityOf(enterCorporateEmailField);
        driver.findElement(enterCorporateEmailField).sendKeys(corporateEmail);

        waitForClickabilityOf(submitCorporateEmail);
        driver.findElement(submitCorporateEmail).click();

    }


    public void enterPersonalEmail(String personalEmail) {
        waitForVisibilityOf(personalEmailField);
        driver.findElement(personalEmailField).sendKeys(personalEmail);
        hideKeyboard();
    }


    public void selectGenderFemale() {
        waitForVisibilityOf(genderFemale);
        driver.findElement(genderFemale).click();

    }


    public void selectGenderMale() {
        waitForVisibilityOf(genderMale);
        driver.findElement(genderMale).click();

    }


    public void selectGenderOther() {
        waitForVisibilityOf(genderOthers);
        driver.findElement(genderOthers).click();

    }


    public void selectGenderFemaleAtProfile() {
        waitForVisibilityOf(genderFemaleProfile);
        driver.findElement(genderFemaleProfile).click();

    }


    public void selectGenderMaleAtProfile() {
        waitForVisibilityOf(genderMaleProfile);
        driver.findElement(genderMaleProfile).click();

    }


    public void selectGenderOtherAtProfile() {
        waitForVisibilityOf(genderOtherProfile);
        driver.findElement(genderOtherProfile).click();

    }


    public void selectGender(String gender) {
        if (gender.equals("F")) {
            selectGenderFemale();
        } else if (gender.equals("M")) {
            selectGenderMale();
        } else if (gender.equals("O")) {
            selectGenderOther();
        }

    }


    public void personalDetailSubmitAtSignup() {
        waitForVisibilityOf(personalDetailsSubmitAtSignup);
        driver.findElement(personalDetailsSubmitAtSignup).click();
    }


    public String personalDetailSubmitAtProfile() {

        String savingProfileText = "";
        try {
            waitForVisibilityOf(personalDetailsSubmitAtProfile);
            driver.findElement(personalDetailsSubmitAtProfile).click();

            waitForVisibilityOf(textAfterSavingProfile);
            savingProfileText = driver.findElement(textAfterSavingProfile).getText();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return savingProfileText;

    }


    // -------------------------    ERROR MESSAGES FIELDS FUNCTIONS     ------------------------


    public String getNameErrorMessage() {

        try {
            waitForVisibilityOf(nameErrorMessageField);
            return driver.findElement(nameErrorMessageField).getText();
        } catch (Exception e) {
            // If error message is not found that means there is no error message occurred in System .
            return "";
        }


    }


    public String getPersonalEmailErrorMessage() {

        try {
            waitForVisibilityOf(personalEmailErrorMessageField);
            return driver.findElement(personalEmailErrorMessageField).getText();
        } catch (Exception e) {
            // If error message is not found that means there is no error message occurred in System .
            return "";
        }
    }


    public String getCorporateEmailErrorMessage() {
        try {
            waitForVisibilityOf(corporateEmailErrorMessageField);
            return driver.findElement(corporateEmailErrorMessageField).getText();
        } catch (Exception e) {
            // If error message is not found that means there is no error message occurred in System .
            return "";
        }
    }


    public String getCorporateEmailPartnerErrorMessage() {
        try {
            waitForVisibilityOf(partnerErrorMessageInCorporateEmail);
            return driver.findElement(partnerErrorMessageInCorporateEmail).getText();
        } catch (Exception e) {
            // If error message is not found that means there is no error message occurred in System .
            return "";
        }
    }


    public void clickOkButtonToAcceptTheBox() {
        waitForClickabilityOf(okButton);
        driver.findElement(okButton).click();
    }


    public void goBack() {
        waitForClickabilityOf(backButton);
        driver.findElement(backButton).click();
    }


    // -------------------------    CLEAR FIELDS FUNCTIONS     ------------------------


    public void clearNameField() {
        driver.findElement(userNameAtProfile).clear();
    }

    public void clearPersonalEmailField() {
        scrollToText("Birthday");
        driver.findElement(personalEmailField).clear();
    }

    public void clearCorporateEmailField() {
        driver.findElement(enterCorporateEmailField).clear();
    }


    public boolean isUserOnPersonalDetailsPage(){
        boolean result;
        if (checkIfElementPresent(titleText, 5) == true) {
            System.out.println("User is on personal details page");
            result = driver.findElement(titleText).isEnabled();
            return result;
        } else {
            System.out.println("User is not on personal details page");
            result = false;
            return result;
        }
    }


    public String getPersonalDetailsPageHeading(){

        waitForVisibilityOf(titleText);
        return driver.findElement(titleText).getText();
    }


    public String getPersonalDetailsPageSubheading(){

        waitForVisibilityOf(subtitleText);
        return driver.findElement(subtitleText).getText();
    }


    public int getAvailableGendersCount(){

        waitForClickabilityOf(genderIcon);
        int size =   driver.findElements(genderIcon).size();
        System.out.println("Number of gender options available are = "+size);
        return size;
    }


    public boolean isHaveAReferralCodeDisplayed(){
        boolean result;
        if (checkIfElementPresent(haveReferralCode, 5) == true) {
            System.out.println("Have a Referral Code ? is displayed");
            result = driver.findElement(haveReferralCode).isDisplayed();
            return result;
        } else {
            System.out.println("Have a Referral Code ? is not displayed");
            result = false;
            return result;
        }
    }


    public void haveAReferralCodeClick(){

        waitForClickabilityOf(haveReferralCode);
        driver.findElement(haveReferralCode).click();
    }


    public String getReferralCodePopupHeading(){
        waitForVisibilityOf(referralCodePopupHeading);
        return  driver.findElement(referralCodePopupHeading).getText();
    }


    public String getReferralCodeErrorPrompt(){

        waitForClickabilityOf(referralCodeField);
        driver.findElement(referralCodeField).sendKeys("123");
        waitForClickabilityOf(referralCodeSubmit);
        driver.findElement(referralCodeSubmit).click();
        waitForVisibilityOf(referralCodeErrorText);
        String errorText = driver.findElement(referralCodeErrorText).getText();
        return errorText;
    }



    public boolean isPersonalDetailsSubmitArrowDisplayed(){
        boolean result;
        if (checkIfElementPresent(personalDetailsSubmitAtSignup, 5) == true) {
            System.out.println("Submit arrow is appearing on Personal details page");
            result = driver.findElement(personalDetailsSubmitAtSignup).isDisplayed();
            return result;
        } else {
            System.out.println("Submit arrow is appearing on Personal details page");
            result = false;
            return result;
        }

    }


}

