package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	By searchBar = By.id("booking.search_bar");
	By buddyButton = By.id("buddy");
	By findRoutebutton = By.id("cfts.button");
	By fromLocationButton = By.id("cfts.from");
	By toLocationButton = By.id("cfts.to");
	By locationSwapButton = By.id("cfts.swap");
	By menuButton = By.className("android.widget.ImageButton");
	By wallet_button = By.id(app_package_name + "design_menu_item_text");
	By clickGetFreeRide = By.xpath("//android.widget.CheckedTextView[@text='Get Free Rides']");
	By closeSearchPopup = By.id("hso.close_icon");
	By myPass = By.id("design_menu_item_text");

	public String getHeaderText() {
		waitForVisibilityOf(searchBar);
		String HeaderText =  driver.findElement(searchBar).getText();
		return HeaderText;
	}

	public void clickFromLocation() {
		waitForClickabilityOf(fromLocationButton);
		driver.findElement(fromLocationButton).click();
	}

	public String getFromLocationText() {
		waitForClickabilityOf(fromLocationButton);
		return driver.findElement(fromLocationButton).getText();
	}

	public String getToLocationText() {
		waitForClickabilityOf(toLocationButton);
		return driver.findElement(toLocationButton).getText();
	}

	public void clickToLocation() {
		waitForClickabilityOf(toLocationButton);
		driver.findElement(toLocationButton).click();
	}

	public void clickFindMyShuttl() {
		waitForClickabilityOf(findRoutebutton);
		driver.findElement(findRoutebutton).click();
	}

	public void clickMenu() {

		waitForClickabilityOf(menuButton);
		driver.findElement(menuButton).click();
	}

	public void clickWallet() {
		waitForClickabilityOf(wallet_button);
		driver.findElements(wallet_button).get(4).click();
	}

	public void clickLocationSwap() {
		waitForClickabilityOf(locationSwapButton);
		driver.findElement(locationSwapButton).click();
	}

	public void clickGetFreeRide() {
		waitForClickabilityOf(clickGetFreeRide);
		driver.findElement(clickGetFreeRide).click();

	}
	
	public void clickCoupon() {
		waitForClickabilityOf(wallet_button);
		driver.findElements(wallet_button).get(3).click();
	}


	public boolean checkBuddyButton() {
		if (checkIfElementPresent(buddyButton))
		return true;
		else
			return false;

	}

	public void clickBuddy() {
		checkIfElementPresent(buddyButton,10);
	}


	public boolean checkSearchBar()
	{
		if(checkIfElementPresent(searchBar,10) == true){
			System.out.println("Search bar is displayed i.e. old user");
			return true;}
		else{
			System.out.println("Search bar is not displayed i.e. new user");
			return false;
		}
	}

	public void clickSearchBar()
	{
		if(checkIfElementPresent(searchBar,10) == true){
			System.out.println("Search bar is displayed, need to open search bar");
			waitForClickabilityOf(searchBar);
			driver.findElement(searchBar).click();
			}
		else{
			System.out.println("Search bar is not displayed");
		}
	}

	public void closeSearchPopup()
	{
		waitForClickabilityOf(closeSearchPopup);
		driver.findElement(closeSearchPopup).click();
	}

	public void openMyPass(int index)     // index will be the menuitem number to be opened
	{
		waitForClickabilityOf(myPass);
		driver.findElements(myPass).get(index).click();
	}




}

