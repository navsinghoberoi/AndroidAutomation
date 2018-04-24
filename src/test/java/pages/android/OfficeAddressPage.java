package pages.android;

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



}
