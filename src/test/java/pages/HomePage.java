package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}


	By findMyShuttl_button = By.id(app_package_name + "booking.find_my_shuttl_button");
	By fromLocation_button = By.id(app_package_name + "booking.from_input");
	By toLocation_button = By.id(app_package_name + "booking.to_input");
	By locationSwap_button = By.id(app_package_name + "booking.to_from_switch");
	By menu_button = By.className("android.widget.ImageButton");
	By wallet_button = By.id(app_package_name + "design_menu_item_text");
	By clickGetFreeRide = By.xpath("//android.widget.CheckedTextView[@text='Get Free Rides']");


	public String getFindMyShuttlText() {
		waitForVisibilityOf(findMyShuttl_button);
		String FindMyShuttlText =  driver.findElement(findMyShuttl_button).getText();
		return FindMyShuttlText;
	}

	public void clickFromLocation() {
		waitForClickabilityOf(fromLocation_button);
		driver.findElement(fromLocation_button).click();
	}

	public String getFromLocationText() {
		waitForClickabilityOf(fromLocation_button);
		return driver.findElement(fromLocation_button).getText();
	}

	public String getToLocationText() {
		waitForClickabilityOf(toLocation_button);
		return driver.findElement(toLocation_button).getText();
	}

	public void clickToLocation() {
		waitForClickabilityOf(toLocation_button);
		driver.findElement(toLocation_button).click();
	}

	public void clickFindMyShuttl() {
		waitForClickabilityOf(findMyShuttl_button);
		driver.findElement(findMyShuttl_button).click();
	}

	public void clickMenu() {
		waitForClickabilityOf(menu_button);
		driver.findElement(menu_button).click();
	}

	public void clickWallet() {
		waitForClickabilityOf(wallet_button);
		driver.findElements(wallet_button).get(4).click();
	}

	public void clickLocationSwap() {
		waitForClickabilityOf(locationSwap_button);
		driver.findElement(locationSwap_button).click();
	}

	public void clickGetFreeRide() {
		waitForClickabilityOf(clickGetFreeRide);
		driver.findElement(clickGetFreeRide).click();

	}
	
	public void clickCoupon() {
		waitForClickabilityOf(wallet_button);
		driver.findElements(wallet_button).get(3).click();
	}



}

