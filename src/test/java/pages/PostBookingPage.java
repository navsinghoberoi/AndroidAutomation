package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostBookingPage extends BasePage {


	public PostBookingPage(WebDriver driver) {
		super(driver);
	}

	By enroute_screen_arrow = By.id(app_package_name + "sd_arrow");
	By reschedule_button = By.id(app_package_name + "sd_reschedule");
	By en_cancel_button = By.id(app_package_name + "sd_cancel");
	By cancel_reason_button = By.id(app_package_name + "cancel_reason_text");
	By cancel_button = By.id(app_package_name + "cancel.cta");
	By cancel_booking_popup = By.id(app_package_name + "popup_notify_wa.title");
	By locate_pickup = By.xpath("//android.widget.TextView[@text='Locate pickup']");
	By locate_pickup_title_text = By.xpath("//android.widget.TextView[@text='View Pickup Stop']");
	By call_Customer_Care = By.xpath("//android.widget.TextView[@text='Call Customer Care']");
	By call_Customer_Care_Slide_Text = By.xpath("//android.widget.TextView[@text='Complete action using']");
	By menuUpIcon = By.id("pb.options_chevron");
	By toggleButton = By.id("itso.switch");
	By refreshIcon = By.id("pb_refresh_btn");
	By boardBookingID = By.xpath("//android.widget.TextView[@text='BOOKING ID']");
	By navigateButton = By.id("navigate_button");
	By toggleIcon = By.id("action_toggle");
	By helpText = By.xpath("//android.widget.TextView[@text='Help']");
	By faqLink = By.xpath("//android.widget.TextView[@text='FAQs']");
	By registrationNumber = By.id("hab.vehicle_text");
	By homecardTrackShuttl =By.id("hab.action_container");
	By currentLocation = By.id("bc_refocus_map_btn");

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
	public void clickLocatePickup(){
		waitForClickabilityOf(locate_pickup);
		driver.findElement(locate_pickup).click();
	}
	public String locatePickupText(){
		waitForClickabilityOf(locate_pickup);
		String getLocatePickupText = driver.findElement(locate_pickup).getText();
		return getLocatePickupText;
	}
	public String locatePickupTitleText(){
		waitForClickabilityOf(locate_pickup_title_text);
		String getLocatePickupTitleText = driver.findElement(locate_pickup_title_text).getText();
		return getLocatePickupTitleText;
	}
	public void clickMapsToggleIcon(){
		waitForClickabilityOf(toggleButton);
		driver.findElement(toggleButton).click();
	}
	public void clickCallCustomerCare(){
		waitForClickabilityOf(call_Customer_Care);
		driver.findElement(call_Customer_Care).click();
	}
	public String getCallCustomerCareSlideText(){
		waitForClickabilityOf(call_Customer_Care_Slide_Text);
		String callCC = driver.findElement(call_Customer_Care_Slide_Text).getText();
		return callCC;
	}
	public void clickMenuUpIcon(){
		waitForClickabilityOf(menuUpIcon);
		driver.findElement(menuUpIcon).click();
	}
	public void clickShowTraffic(){
		waitForClickabilityOf(toggleButton);
		List<WebElement> showTrafficToggel = driver.findElements(toggleButton);
		showTrafficToggel.get(1).click();
	}
	public void getShowTrafficStatus(){
		waitForClickabilityOf(toggleButton);
		List<WebElement> show_Traffic_Toggel = driver.findElements(toggleButton);

		if(show_Traffic_Toggel.get(1).getText()=="ON"){
			System.out.println("Traffic Toggel Is Enabled");
		}
		else {
			show_Traffic_Toggel.get(1).click();
			System.out.println("Clicked on Traffic Toggel");
		}

	}
	public boolean trafficToggle(){
		waitForClickabilityOf(toggleButton);
		List<WebElement> shuttle_Arrival_Bubble = driver.findElements(toggleButton);
		return shuttle_Arrival_Bubble.get(1).isDisplayed();
	}
	public void clickShuttlArrivalToggle(){
		waitForClickabilityOf(toggleButton);
		List<WebElement> shuttle_Arrival_Bubble = driver.findElements(toggleButton);
		shuttle_Arrival_Bubble.get(0).click();
	}
	public void getShuttlArrivalToggle(){
		waitForClickabilityOf(toggleButton);
		List<WebElement> shuttleArrivalBubble = driver.findElements(toggleButton);
		System.out.println(shuttleArrivalBubble);

		if (shuttleArrivalBubble.get(0).getText()=="ON"){
			System.out.println("Toggel Is Enabled");
		}
		else{
			shuttleArrivalBubble.get(0).click();
			System.out.println("Clicked on Toggel");
		}
	}
	public boolean arrivalBubble(){
		waitForClickabilityOf(toggleButton);
		List<WebElement> shuttle_Arrival_Bubble = driver.findElements(toggleButton);
		return shuttle_Arrival_Bubble.get(0).isDisplayed();
	}
	public void clickRefreshIcon(){
		waitForClickabilityOf(refreshIcon);
		driver.findElement(refreshIcon).click();

	}
	public boolean refreshIcon(){
		waitForClickabilityOf(refreshIcon);
		return driver.findElement(refreshIcon).isDisplayed();
	}
	public void getPressToBoardButton(){
		waitForClickabilityOf(boardBookingID);
		driver.findElement(boardBookingID).getText();
	}
	public String getNavigateButton(){
		waitForVisibilityOf(navigateButton);
		String getNavigateButton = driver.findElement(navigateButton).getText();
		return getNavigateButton;
	}
	public void clickNavigateButton(){
		waitForClickabilityOf(navigateButton);
		driver.findElement(navigateButton).click();
	}
	public void clickToggleIcon(){
		waitForClickabilityOf(toggleIcon);
		driver.findElement(toggleIcon).click();
	}
	public String helpText(){
		waitForVisibilityOf(helpText);
		String getHelpText = driver.findElement(helpText).getText();
		return getHelpText;
	}
	public void clickHelpText(){
		waitForClickabilityOf(helpText);
		driver.findElement(helpText).click();
	}
	public String getFaqLink(){
		waitForVisibilityOf(faqLink);
		String faqLinkText = driver.findElement(faqLink).getText();
		return faqLinkText;
	}
	public String getRegistrationNumber() {
		String rNText = null;
		waitForVisibilityOf(registrationNumber);
		boolean registrationNumberText = driver.findElement(registrationNumber).isDisplayed();
		System.out.println("Registration Number visibility on homecard is = " + registrationNumberText);

		if (registrationNumberText) {
			waitForClickabilityOf(registrationNumber);
			rNText = driver.findElement(registrationNumber).getText();
			System.out.println(registrationNumber);
		} else {
			System.out.println("Registration Number is not displayed on the booking homecard");

		}
		return rNText;
	}
		public boolean isRegistrationNumberVisible() {
			boolean registrationNumberText;
			if (checkIfElementPresent(homecardTrackShuttl, 15) == true) {
				System.out.println("TRACK SHUTTL is appearing on active ride");
				registrationNumberText = driver.findElement(homecardTrackShuttl).isDisplayed();
		} else {
				System.out.println("TRACK SHUTTL is not appearing, so no active ride on homepage");
				registrationNumberText = false;
		}

			return registrationNumberText;
		}
		public void clickCurrentLocationButton(){
		waitForClickabilityOf(currentLocation);
		driver.findElement(currentLocation).click();
	}
		public boolean currentLocationButton(){
		waitForClickabilityOf(currentLocation);
		return driver.findElement(currentLocation).isDisplayed();
	}
}