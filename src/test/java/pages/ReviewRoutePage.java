package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewRoutePage extends BasePage {

    By cta = By.id("pd.make_payment_button");

    public ReviewRoutePage(WebDriver driver) {
        super(driver);
    }

    public void submitReviewRouteDetails() {
        waitForVisibilityOf(cta);
        driver.findElement(cta).click();
    }


}
