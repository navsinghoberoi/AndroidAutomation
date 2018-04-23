package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostBooking extends BasePage {


	public PostBooking(WebDriver driver) {
		super(driver);
	}

	By enroute_screen_arrow = By.id(app_package_name + "sd_arrow");
	By reschedule_button = By.id(app_package_name + "sd_reschedule");
	By en_cancel_button = By.id(app_package_name + "sd_cancel");
	By cancel_reason_button = By.id(app_package_name + "cancel_reason_text");
	By cancel_button = By.id(app_package_name + "cancel.cta");
	By cancel_booking_popup = By.id(app_package_name + "popup_notify_wa.title");

	public void clickArrow() throws InterruptedException {
		waitForVisibilityOf(enroute_screen_arrow);
		driver.findElement(enroute_screen_arrow).click();
		Thread.sleep(2000);
	}

	public void clickReschedule() throws InterruptedException {
		waitForClickabilityOf(reschedule_button);
		driver.findElement(reschedule_button).click();
		Thread.sleep(2000);
	}

	public void en_clickCancel() throws InterruptedException {
		waitForClickabilityOf(en_cancel_button);
		driver.findElement(en_cancel_button).click();
		Thread.sleep(5000);
	}

	public void cancleReason() throws InterruptedException {
		waitForClickabilityOf(cancel_reason_button);
		driver.findElement(cancel_reason_button).click();
		Thread.sleep(2000);
	}

	public void clickCancel() throws InterruptedException {
		waitForClickabilityOf(cancel_button);
		driver.findElement(cancel_button).click();
		Thread.sleep(1000);
	}

	public String cancelBookingPopup() {
		waitForClickabilityOf(cancel_booking_popup);
		String text = driver.findElement(cancel_booking_popup).getText();
		return text;
	}
}