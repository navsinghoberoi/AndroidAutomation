package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseBenefitsPage extends BasePage {

    By cta = By.id("pb.cta");

    public ChooseBenefitsPage(WebDriver driver) {
        super(driver);
    }

    public void submitPassBenefitsDetails() {
        waitForVisibilityOf(cta);
        driver.findElement(cta).click();
    }


}
