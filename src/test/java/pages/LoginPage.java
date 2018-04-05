package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	By mobileNumber_button = By.id(app_package_name + "login.phone_input");
	By referralCode_button = By.id(app_package_name + "reg_referral");
	By getOtp_button = By.className("android.widget.Button");
	By enterOtp_button = By.id(app_package_name + "verify_reg_otp");
	By verify_button = By.id("login.verify_button");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterMobileNumber(String number) {
		waitForVisibilityOf(mobileNumber_button);
		driver.findElement(mobileNumber_button).sendKeys(number);
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
	
}
