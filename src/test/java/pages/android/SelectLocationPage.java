package pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectLocationPage extends BasePage {

	By searchLocation_button = By.id("sr_search_input");
 	By yourLocation_button = By.id(app_package_name + "linear_layout_your_location");	
 	By searchResult_button = By.id("sr_li_name");
 	
 	
	public SelectLocationPage(WebDriver driver) {
		super(driver);
	}


	public void selectSearchLocation(String Location,int index) throws InterruptedException {
		waitForClickabilityOf(searchLocation_button);
		driver.findElement(searchLocation_button).sendKeys(Location);
		Thread.sleep(3000);
		waitForVisibilityOf(searchResult_button);
		Thread.sleep(5000);
		driver.findElements(searchResult_button).get(index).click();
	}






}