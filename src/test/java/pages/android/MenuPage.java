package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }


    By profile_button = By.id("drawer.user_name");
    By menu_tray = By.id("design_menu_item_text");


    public void clickProfile() {
        waitForClickabilityOf(profile_button);
        driver.findElement(profile_button).click();
    }


    public void clickMyPasses() {
        waitForClickabilityOf(menu_tray);
        driver.findElements(menu_tray).get(0).click();
    }

    public void clickMyRides() {
        waitForClickabilityOf(menu_tray);
        driver.findElements(menu_tray).get(1).click();
    }
    public void clickWallets() {
        waitForClickabilityOf(menu_tray);
        driver.findElements(menu_tray).get(2).click();
    }

    public void clickRefer() {
        waitForClickabilityOf(menu_tray);
        driver.findElements(menu_tray).get(3).click();
    }
    public void clickCoupon() {
        waitForClickabilityOf(menu_tray);
        driver.findElements(menu_tray).get(4).click();
    }

    public void clickSafetyFeatures() {
        waitForClickabilityOf(menu_tray);
        driver.findElements(menu_tray).get(5).click();
    }

    public void clickExploreRoutes() {
        waitForClickabilityOf(menu_tray);
        driver.findElements(menu_tray).get(6).click();
    }

    public void clickHelp() {
        waitForClickabilityOf(menu_tray);
        driver.findElements(menu_tray).get(7).click();
    }

}
