package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetails extends BasePage {

    By userName = By.id("frag_usr_reg1.name_input");
    By genderFemale = By.id("frag_usr_reg1.gender_female");
    By genderMale = By.id("frag_usr_reg1.gender_male");
    By genderOthers = By.id("frag_usr_reg1.gender_other");
    By haveReferralCode = By.id("frag_usr_reg1.have_referral_code");
    By enterReferralCode = By.id("ref_code.input");
    By submitReferralCode = By.id("ref_code.submit");
    By invalidReferralCodeError = By.id("textinput_error");
    By personalDetailsSubmit = By.id("frag_usr_reg1.action");



    public PersonalDetails(WebDriver driver)  {
        super(driver);
    }


    public void enterUserName(String name)
    {
        waitForVisibilityOf(userName);
        driver.findElement(userName).sendKeys(name);
    }


    public void selectGenderFemale()
    {
        waitForVisibilityOf(genderFemale);
        driver.findElement(genderFemale).click();

    }


    public void selectGenderMale()
    {
        waitForVisibilityOf(genderMale);
        driver.findElement(genderMale).click();

    }


    public void selectGenderOther()
    {
        waitForVisibilityOf(genderOthers);
        driver.findElement(genderOthers).click();

    }


    public void referralCodeClick()
    {
        waitForVisibilityOf(haveReferralCode);
        driver.findElement(haveReferralCode).click();
    }


    public void referralCodeEnter(String referralCode)
    {
        waitForVisibilityOf(enterReferralCode);
        driver.findElement(enterReferralCode).sendKeys(referralCode);
    }


    public void referralCodeSubmit()
    {

        waitForVisibilityOf(submitReferralCode);
        driver.findElement(submitReferralCode).click();
    }


    public String referralCodeInvalidText()
    {
        waitForVisibilityOf(invalidReferralCodeError);
        String invalidCouponText = driver.findElement(invalidReferralCodeError).getText();
        System.out.println("Text for invalid referral code = " +invalidCouponText);
        return invalidCouponText;
    }


    public void personalDetailSubmit()
    {
        waitForVisibilityOf(personalDetailsSubmit);
        driver.findElement(personalDetailsSubmit).click();
    }




}
