package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewRoutePage extends BasePage {

    By cta = By.id("pd.make_payment_button");
    By pageHeading = By.className("android.widget.TextView");
    By ridesDaysCount = By.className("android.widget.TextView");
    By selectTimeRangeOption = By.id("sc.time_range_container");
    By selectTimeRangeValues = By.id("container");
    By selectTimeRangeDoneButton = By.id("cancel.cta");

    public ReviewRoutePage(WebDriver driver) {
        super(driver);
    }

    public void submitReviewRouteDetails() {
        waitForVisibilityOf(cta);
        driver.findElement(cta).click();
    }


    public String getPageTitle() {
        waitForVisibilityOf(pageHeading);
        return driver.findElement(pageHeading).getText();
    }


    public String getCTAName(){
        waitForVisibilityOf(cta);
        return driver.findElement(cta).getText();
    }


    public String getRidesDaysData()
    {
        waitForVisibilityOf(ridesDaysCount);
        return driver.findElements(ridesDaysCount).get(1).getText();
    }


    public boolean isCTAEnabled() {
        boolean result;
        if (checkIfElementPresent(cta, 10) == true) {
            result = driver.findElement(cta).isEnabled();
        } else {
            result = false;
        }
        return result;
    }


    public void selectTimeRangeMorningSession(int timeRangeIndex) {

        waitForVisibilityOf(selectTimeRangeOption);
        driver.findElements(selectTimeRangeOption).get(0).click();
        waitForVisibilityOf(selectTimeRangeValues);
        driver.findElements(selectTimeRangeValues).get(timeRangeIndex).click();
        waitForVisibilityOf(selectTimeRangeDoneButton);
        driver.findElement(selectTimeRangeDoneButton).click();
    }

    public void selectTimeRangeEveningSession(int timeRangeIndex) {

        waitForVisibilityOf(selectTimeRangeOption);
        driver.findElements(selectTimeRangeOption).get(1).click();
        waitForVisibilityOf(selectTimeRangeValues);
        driver.findElements(selectTimeRangeValues).get(timeRangeIndex).click();
        waitForVisibilityOf(selectTimeRangeDoneButton);
        driver.findElement(selectTimeRangeDoneButton).click();
    }

}
