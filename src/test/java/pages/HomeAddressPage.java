package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeAddressPage extends BasePage {

    By whereDoYouLiveText = By.id("frag_usr_reg2.title");
    By selectHomeLocation = By.id("frag_usr_reg2.location_input");
    By searchBar = By.id(app_package_name_android_gms + "search_bar");
    By enterAddress = By.id(app_package_name_android_gms + "edit_text");
    By selectAddress = By.id(app_package_name_android_gms + "place_autocomplete_prediction_secondary_text");
    By selectThisLocation = By.id(app_package_name_android_gms + "select_marker_location");
    By useThisPlaceAddress = By.id(app_package_name_android_gms + "place_address");
    By changeLocation = By.id(app_package_name_android_gms + "cancel_button");
    By selectLocation = By.id(app_package_name_android_gms + "confirm_button");
    By flatNum = By.id("frag_usr_reg2.address_input");
    By submit = By.id("frag_usr_reg2.action_next");
    By subtitleText = By.id("frag_usr_reg2.sub_title");
    By backIcon = By.id("frag_usr_reg2.back");
    By myLocationButton = By.id(app_package_name_android_gms + "my_location_button");
    By nearbyPlaces = By.id(app_package_name_android_gms + "place_name");
    By useThisPlaceHeading = By.id(app_package_name_android_gms + "card_title");
    By homeAddressDetailsSubmitAtSignup = By.id("frag_usr_reg2.action_next");


    public HomeAddressPage(WebDriver driver)  {
        super(driver);
    }


    public String whereDoYouLiveText()
    {
        waitForVisibilityOf(whereDoYouLiveText);
        String text = driver.findElement(whereDoYouLiveText).getText();
        System.out.println("Where do you live text displayed on page = "+text);
        return text;

    }


    public void selectHomeLocationClick()
    {
        waitForVisibilityOf(selectHomeLocation);
        driver.findElement(selectHomeLocation).click();

    }

    public void searchBarClick()
    {
        waitForVisibilityOf(searchBar);
        driver.findElement(searchBar).click();

    }


    public void enterHomeAddress(String address)
    {
        waitForVisibilityOf(enterAddress);
        driver.findElement(enterAddress).sendKeys(address);
    }


    public String selectHomeAddress()
    {
        waitForVisibilityOf(selectAddress);
        String address =  driver.findElement(selectAddress).getText();
        System.out.println("Selected home address by user = " +address);
        driver.findElement(selectAddress).click();
        return address;
    }


    public void selectThisLocationClick()
    {
        waitForVisibilityOf(selectThisLocation);
        driver.findElement(selectThisLocation).click();
    }


    public String useThisPlaceAddressText()
    {
        waitForVisibilityOf(useThisPlaceAddress);
        String address =  driver.findElement(useThisPlaceAddress).getText();
        System.out.println("Address written on the use this place popup for home address = " +address);
        return address;

    }


    public void changeLocationClick()
    {
        waitForVisibilityOf(changeLocation);
        driver.findElement(changeLocation).click();

    }

    public void selectLocationClick()
    {
        waitForVisibilityOf(selectLocation);
        driver.findElement(selectLocation).click();

    }


    public void flatNumSet(String flatNo)
    {
        waitForVisibilityOf(flatNum);
        driver.findElement(flatNum).sendKeys(flatNo);
    }



    public void homeAddressSubmit()
    {
        waitForVisibilityOf(submit);
        driver.findElement(submit).click();
    }


    public String whereDoYouLiveSubtext()
    {
        waitForVisibilityOf(subtitleText);
        return driver.findElement(subtitleText).getText();
    }


    public boolean isSelectHomeLocationFieldDisplayed(){
        boolean result;
        if (checkIfElementPresent(selectHomeLocation, 10) == true) {
            System.out.println("Select Home Location field is displayed on home address page");
            result = driver.findElement(selectHomeLocation).isDisplayed();
            return result;
        } else {
            System.out.println("Select Home Location field is not displayed");
            result = false;
            return result;
        }
    }

    public void backIconClick(){
        waitForClickabilityOf(backIcon);
        driver.findElement(backIcon).click();

    }



    public boolean isSearchBarDisplayed(){

        boolean result;
        if (checkIfElementPresent(searchBar, 10) == true) {
            System.out.println("Search bar field is displayed after clicking select home location");
            result = driver.findElement(searchBar).isDisplayed();
            return result;
        } else {
            System.out.println("Search bar field is not displayed");
            result = false;
            return result;
        }
    }


    public boolean isSelectThisLocationDisplayed(){

        boolean result;
        if (checkIfElementPresent(selectThisLocation, 10) == true) {
            System.out.println("Select this location field is displayed");
            result = driver.findElement(selectThisLocation).isDisplayed();
            return result;
        } else {
            System.out.println("Select this location field is not displayed");
            result = false;
            return result;
        }
    }


    public boolean isNearbyPlacesDisplayed(){

        boolean result;
        if (checkIfElementPresent(nearbyPlaces, 10) == true) {
            System.out.println("Nearby places are displayed");
            result = driver.findElement(nearbyPlaces).isDisplayed();
            return result;
        } else {
            System.out.println("Nearby places are displayed");
            result = false;
            return result;
        }
    }



    public boolean isMyLocationIconDisplayed(){

        boolean result;
        if (checkIfElementPresent(myLocationButton, 10) == true) {
            System.out.println("My location icon is displayed on map");
            result = driver.findElement(myLocationButton).isDisplayed();
            return result;
        } else {
            System.out.println("My location icon is displayed on map");
            result = false;
            return result;
        }
    }



    public String getUseThisPlaceHeading(){
        waitForVisibilityOf(useThisPlaceHeading);
        return driver.findElement(useThisPlaceHeading).getText();
    }


    public String geHomeLocationEnteredText(){
        waitForVisibilityOf(selectHomeLocation);
        return driver.findElement(selectHomeLocation).getText();
    }


    public boolean isHomeLocationDetailsSubmitArrowDisplayed(){
        boolean result;
        if (checkIfElementPresent(homeAddressDetailsSubmitAtSignup, 10) == true) {
            System.out.println("Submit arrow is appearing on Select Home Location page");
            result = driver.findElement(homeAddressDetailsSubmitAtSignup).isDisplayed();
            return result;
        } else {
            System.out.println("Submit arrow is not appearing on Select Home Location page");
            result = false;
            return result;
        }

    }






}
