package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GetFreeRide extends BasePage {
	public GetFreeRide(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By verifyGetFreeRidePage = By.xpath("//android.widget.TextView[@text='Get Free Rides']");
	
	public String VerifyGetFreePage() {
		waitForVisibilityOf(verifyGetFreeRidePage);
		String text=driver.findElement(verifyGetFreeRidePage).getText();
		return text;
	}

}