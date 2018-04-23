package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShuttlEnRoutePage extends BasePage {

	public ShuttlEnRoutePage(WebDriver driver) {
		super(driver);
	}

	By bookingConfirmationPopup_button = By.id(app_package_name + "popup_notify_wa.title");

	public String getBookingConfirmationPopupText() {
		waitForVisibilityOf(bookingConfirmationPopup_button);
		String Text = driver.findElement(bookingConfirmationPopup_button).getText();
		return Text;
		
	}
}