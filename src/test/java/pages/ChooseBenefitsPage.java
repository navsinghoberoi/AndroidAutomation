package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseBenefitsPage extends BasePage {

    By cta = By.id("pb.cta");
    By pageHeading = By.xpath("//android.widget.TextView[@text='Choose Benefits With']");
    By addonName = By.id("aoi.title");
    By addAddon = By.id("aoi.button");

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

    public String getAddonName(){
        waitForVisibilityOf(addonName);
        return driver.findElement(addonName).getText();
    }

    public String selectAddonForAdditionalBenefits(){
        waitForVisibilityOf(addAddon);
        driver.findElement(addAddon).click();
        return driver.findElement(addAddon).getText(); // Addon price
    }
}
