package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectLocationPage extends BasePage {

	By searchLocation_button = By.id("sr_search_input");
 	By yourLocation_button = By.id(app_package_name + "linear_layout_your_location");	
 	By searchResult_button = By.id("sr_li_name");
 	By shuttlSearchResult = By.id("sr_li_description");

	public SelectLocationPage(WebDriver driver) {
		super(driver);
	}


	public void selectSearchLocation(String Location,int index) throws InterruptedException {
		waitForClickabilityOf(searchLocation_button);
		driver.findElement(searchLocation_button).sendKeys(Location);
	//	Thread.sleep(3000);
		waitForVisibilityOf(searchResult_button);
	//	Thread.sleep(5000);
		driver.findElements(searchResult_button).get(index).click();
	}


	public void enterSearchLocation(String Location) {
		waitForClickabilityOf(searchLocation_button);
		driver.findElement(searchLocation_button).sendKeys(Location);
	}


	public boolean isSearchLocationResultsAppearing(){
		if (checkIfElementPresent(searchResult_button, 10) == true) {
			System.out.println("Search results are displayed");
			getCountOfAllSearchLocations();
			return true;
		} else {
			System.out.println("Search results are not displayed");
			return false;
		}

	}

	public int getCountOfShuttlSearchLocations(){
		waitForClickabilityOf(shuttlSearchResult);
		int searchResults = driver.findElements(shuttlSearchResult).size();
		System.out.println("Count of search results via shuttl only = "+searchResults);
		for(int i=0;i<searchResults;i++)
		{
			String locName = driver.findElements(shuttlSearchResult).get(i).getText();
			System.out.println("Search result " + (i+1)+ " location name (shuttl) = "+locName);
		}
		return searchResults;
	}

	public int getCountOfAllSearchLocations(){
		waitForClickabilityOf(searchResult_button);
		int searchResults = driver.findElements(searchResult_button).size();
		System.out.println("Count of total search results are = "+searchResults);
		for(int i=0;i<searchResults;i++)
		{
			String locName = driver.findElements(searchResult_button).get(i).getText();
			System.out.println("Search result " + (i+1)+ " location name (total) = "+locName);
		}
		return searchResults;
	}


}