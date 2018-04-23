package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SlotsPage extends BasePage {

	public SlotsPage(WebDriver driver) {
		super(driver);
	}

	By selectSlots_button = By.id(app_package_name + "ts_item_parent");
	By selectSlots_button1 = By.id(app_package_name + "time_tv");
	By selectRoute_button = By.id(app_package_name + "next_shuttl_container");
	By clickBook_button = By.id(app_package_name + "booking_btn_book");
	By confirm_popup = By.id(app_package_name + "popup_notify_wa.title");
	By slotTime = By.id(app_package_name + "ts_item_time");

	public void clickSlot() {
		waitForClickabilityOf(selectSlots_button);
		selectedSlot();
		driver.findElements(selectSlots_button).get(selectedSlot()).click();
	}
	
	public void clickRoute() throws InterruptedException {
		waitForClickabilityOf(selectRoute_button);
		driver.findElement(selectRoute_button).click();
		Thread.sleep(5000);
	}
	
	public void clickSlot1(int index) throws InterruptedException {
		waitForClickabilityOf(selectSlots_button1);
		Thread.sleep(2000);
		driver.findElements(selectSlots_button1).get(index).click();
		Thread.sleep(2000);
	}

	public void clickBook() throws InterruptedException {
		waitForVisibilityOf(clickBook_button);
		driver.findElement(clickBook_button).click();
		Thread.sleep(3000);
	}
	
	public String confirmBookingPopup() {
		waitForVisibilityOf(confirm_popup);
		String text=driver.findElement(confirm_popup).getText();
		return text;
		
	}
	
	int selectedSlot() {
		List<WebElement> availableSlots = driver.findElements(slotTime);
		int a = availableSlots.size();
		int i =0;
		//int selected = 0;
		System.out.println(a);
		for(i=0; i< a ;i ++) {
			String slot =  availableSlots.get(i).getAttribute("text");
			int selected = Integer.parseInt(slot);
			System.out.println("Slot time is" + selected);

			if (selected > 8){
				System.out.println("Slot time is" + selected);
				break;
				//return i;	
			}
		}
		return i;

	}
}