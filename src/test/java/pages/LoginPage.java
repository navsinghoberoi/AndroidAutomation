package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	By mobileNumber_button = By.id("login.phone_input");
	By verifycheckBox = By.id("login.personal_data_consent_checkbox");
	By referralCode_button = By.id("reg_referral");
	By getOtp_button = By.className("android.widget.Button");
	By enterOtp_button = By.id("verify_reg_otp");
	By verify_button = By.id("login.verify_button");
	By continueButton = By.id("button1");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterMobileNumber(String number) {
		waitForVisibilityOf(mobileNumber_button);
		driver.findElement(mobileNumber_button).sendKeys(number);
	}

	public void clickVerifyCheckBox() {

		if (checkIfElementPresent(verifycheckBox, 15) == true) {
			driver.findElement(verifycheckBox).click();
		} else {

			System.out.println("Login Checkbox is not present");
		}
	}

	public void clickGetOtp() {
		waitForVisibilityOf(getOtp_button);
		driver.findElement(getOtp_button).click();

	}

	public void enterOtp(String otp) {
		waitForVisibilityOf(enterOtp_button);
		driver.findElement(enterOtp_button).sendKeys(otp);
	}

	public void clickVerify() {
		waitForVisibilityOf(verify_button);
		driver.findElement(verify_button).click();

	}

	/*public void continueButtonClick()
	{
		waitForVisibilityOf(continueButton);
		driver.findElement(continueButton).click();
	}*/


    public void continueButtonClick()
    {
        {
            if(checkIfElementPresent(continueButton,5) == true){
                waitForVisibilityOf(continueButton);
                driver.findElement(continueButton).click();}
            else{
                System.out.println("Continue button is not displayed , skip continue button");
            }
        }
    }



}
