package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfficeAddressPage extends BasePage {

    By whereDoYouWorkText = By.id("frag_usr_reg2.title");
    By selectOfficeLocation = By.id("frag_usr_reg2.location_input");
    By searchBar = By.id(app_package_name_android_gms + "search_bar");
    By enterAddress = By.id(app_package_name_android_gms + "edit_text");
    By selectAddress = By.id(app_package_name_android_gms + "place_autocomplete_prediction_secondary_text");
    By selectThisLocation = By.id(app_package_name_android_gms + "select_marker_location");
    By useThisPlaceAddress = By.id(app_package_name_android_gms + "place_address");
    By changeLocation = By.id(app_package_name_android_gms + "cancel_button");
    By selectLocation = By.id(app_package_name_android_gms + "confirm_button");
    By submit = By.id("frag_usr_reg2.action_done");
    By subtitleText = By.id("frag_usr_reg2.sub_title");
    By backIcon = By.id("frag_usr_reg2.back");
    By myLocationButton = By.id(app_package_name_android_gms + "my_location_button");
    By nearbyPlaces = By.id(app_package_name_android_gms + "place_name");
    By useThisPlaceHeading = By.id(app_package_name_android_gms + "card_title");

    public OfficeAddressPage(WebDriver driver)  {
        super(driver);
    }

    public String whereDoYouWorkText()
    {
        waitForVisibilityOf(whereDoYouWorkText);
        String text = driver.findElement(whereDoYouWorkText).getText();
        return text;

    }


    public void selectOfficeLocationClick()
    {
        waitForVisibilityOf(selectOfficeLocation);
        driver.findElement(selectOfficeLocation).click();

    }

    public void searchBarClick()
    {
        waitForVisibilityOf(searchBar);
        driver.findElement(searchBar).click();

    }


    public void enterOfficeAddress(String address)
    {
        waitForVisibilityOf(enterAddress);
        driver.findElement(enterAddress).sendKeys(address);
    }


    public String selectOfficeAddress()
    {
        waitForVisibilityOf(selectAddress);
        String address =  driver.findElement(selectAddress).getText();
        System.out.println("Selected office address by user = " +address);
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
        System.out.println("Address written on the use this place popup for office address = " +address);
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


    public void officeAddressSubmit()
    {
        waitForVisibilityOf(submit);
        driver.findElement(submit).click();
    }

    public String whereDoYouWorkSubtext(){
        waitForVisibilityOf(subtitleText);
        return driver.findElement(subtitleText).getText();
    }


    public void backIconClick(){
        waitForClickabilityOf(backIcon);
        driver.findElement(backIcon).click();

    }

    public boolean isSelectOfficeLocationFieldDisplayed(){
        boolean result;
        if (checkIfElementPresent(selectOfficeLocation, 10) == true) {
            System.out.println("Select Office Location field is displayed on office address page");
            result = driver.findElement(selectOfficeLocation).isDisplayed();
            return result;
        } else {
            System.out.println("Select Office Location field is not displayed");
            result = false;
            return result;
        }
    }


    public boolean isOfficeLocationDetailsSubmitButtonDisplayed(){
        boolean result;
        if (checkIfElementPresent(submit, 10) == true) {
            System.out.println("Submit button (DONE) is appearing on Select Office Location page");
            result = driver.findElement(submit).isDisplayed();
            return result;
        } else {
            System.out.println("Submit button is not appearing on Select Office Location page");
            result = false;
            return result;
        }

    }


    public boolean isSearchBarDisplayed(){

        boolean result;
        if (checkIfElementPresent(searchBar, 10) == true) {
            System.out.println("Search bar field is displayed after clicking select office location");
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

    public String getOfficeLocationEnteredText(){
        waitForVisibilityOf(selectOfficeLocation);
        return driver.findElement(selectOfficeLocation).getText();
    }





}
