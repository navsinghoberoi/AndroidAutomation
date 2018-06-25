package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseBenefitsPage extends BasePage {

    By cta = By.id("pb.cta");
    By pageHeading = By.className("android.widget.TextView");

    public ChooseBenefitsPage(WebDriver driver) {
        super(driver);
    }

    public void submitPassBenefitsDetails() {
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


}
