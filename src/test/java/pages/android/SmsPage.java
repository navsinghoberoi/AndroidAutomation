package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SmsPage extends BasePage {
	

	public SmsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By smsText = By.id("com.thinkyeah.message:id/messageTextView");
	
	public String readOtp() {
	waitForVisibilityOf(smsText);
	String otp = driver.findElement(smsText).getText();
	otp = otp.replaceAll("\\D+","");
	driver.navigate().back();
	return otp ;
	}
}