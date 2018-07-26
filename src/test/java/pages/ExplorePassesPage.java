package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExplorePassesPage extends BasePage {

    By offerLabel = By.id("lptf.text");
    By numOfPassRides = By.id("cpt.rides");
    By pricePerPassRide = By.id("cpt.price");
    By passValidity = By.id("cpt.validity");
    By pageHeading = By.className("android.widget.TextView");
    By passRulesPopup = By.id("sspa_button");

    public ExplorePassesPage(WebDriver driver) {
        super(driver);
    }


    public String getOfferLabelText(int index) {
        waitForClickabilityOf(offerLabel);
        String text = driver.findElements(offerLabel).get(index).getText();
        return text;
    }


    public String getNumOfPassRides(int index) {
        waitForClickabilityOf(numOfPassRides);
        String text = driver.findElements(numOfPassRides).get(index).getText();
        return text;
    }

    public String getPricePerRide(int index) {
        waitForClickabilityOf(pricePerPassRide);
        String text = driver.findElements(pricePerPassRide).get(index).getText();
        return text;
    }

    public String getPassValidity(int index) {
        waitForClickabilityOf(passValidity);
        String text = driver.findElements(passValidity).get(index).getText();
        return text;
    }

    public int passesCount() {
        waitForClickabilityOf(passValidity);
        List<WebElement> passCount = driver.findElements(passValidity);
        int size = passCount.size();
        System.out.println("Total number of passes available on this route are = " + size);
        return size;
    }


    public void openPass(int index) {
        waitForVisibilityOf(offerLabel);
        driver.findElements(offerLabel).get(index).click();
    }

    public void getPassDetails(int index) throws Exception {
        String rides = getNumOfPassRides(index);
        String pricePerRide = getPricePerRide(index);
        String passValidity = getPassValidity(index);
        String offerLabel = getOfferLabelText(index);
        System.out.println("Total number of rides in pass is = " + rides);
        System.out.println("Price per ride of pass is = " + pricePerRide);
        System.out.println("Validity of pass is = " + passValidity);
        System.out.println("Offer label text of pass is = " + offerLabel);
    }

    public String getPageTitle() {
        waitForVisibilityOf(pageHeading);
        return driver.findElement(pageHeading).getText();
    }


    public boolean isDismissPassRulesPopupDisplayed() {
        boolean result;
        if (checkIfElementPresent(passRulesPopup, 10) == true) {
            System.out.println("Pass Rules Popup is displayed");
            result = driver.findElement(passRulesPopup).isDisplayed();
        } else {
            System.out.println("Pass Rules Popup is not displayed");
            result = false;
        }
            return result;
    }


    public void dismissPassRulesPopup() {
        if (checkIfElementPresent(passRulesPopup, 4) == true) {
            System.out.println("Pass Rules Popup is displayed");
            driver.findElement(passRulesPopup).click();
        } else {
            System.out.println("Pass Rules Popup is not displayed");
        }

    }




}
