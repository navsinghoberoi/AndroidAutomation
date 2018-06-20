package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewRoutePage extends BasePage {

    By cta = By.id("pd.make_payment_button");
    By pageHeading = By.className("android.widget.TextView");
    By ridesDaysCount = By.className("android.widget.TextView");

    public ReviewRoutePage(WebDriver driver) {
        super(driver);
    }

    public void submitReviewRouteDetails() {
        waitForVisibilityOf(cta);
        driver.findElement(cta).click();
    }


    public String getPageHeading() {
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

}
