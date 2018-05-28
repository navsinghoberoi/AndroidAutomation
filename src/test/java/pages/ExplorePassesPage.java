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


    public ExplorePassesPage(WebDriver driver) {
        super(driver);
    }


    public String getOfferLabelText(int index) throws Exception {
        waitForClickabilityOf(offerLabel);
        Thread.sleep(2000);
        String text = driver.findElements(offerLabel).get(index).getText();
        Thread.sleep(2000);
        return text;
    }


    public String getNumOfPassRides(int index) throws Exception {
        waitForClickabilityOf(numOfPassRides);
        Thread.sleep(2000);
        String text = driver.findElements(numOfPassRides).get(index).getText();
        Thread.sleep(2000);
        return text;
    }

    public String getPricePerRide(int index) throws Exception {
        waitForClickabilityOf(pricePerPassRide);
        Thread.sleep(2000);
        String text = driver.findElements(pricePerPassRide).get(index).getText();
        Thread.sleep(2000);
        return text;
    }

    public String getPassValidity(int index) throws Exception {
        waitForClickabilityOf(passValidity);
        Thread.sleep(2000);
        String text = driver.findElements(passValidity).get(index).getText();
        Thread.sleep(2000);
        return text;
    }

    public int passesCount() throws Exception {
        waitForClickabilityOf(passValidity);
        Thread.sleep(2000);
        List<WebElement> passCount = driver.findElements(passValidity);
        int size = passCount.size();
        System.out.println("Total number of passes available on this route are = " + size);
        Thread.sleep(2000);
        return size;
    }


    public void openPass(int index) throws Exception {
        waitForClickabilityOf(offerLabel);
        Thread.sleep(2000);
        driver.findElements(offerLabel).get(index).click();
        Thread.sleep(2000);
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


}
