package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtpPage extends BasePage {

	By enterOtp_button = By.id("auth.otp_input");

	public OtpPage(WebDriver driver) {
		super(driver);
	}


	
	public void enterOtp(String otp) {
		waitForVisibilityOf(enterOtp_button);
		driver.findElement(enterOtp_button).sendKeys(otp);
	}

}
