package pages.iOS;

import commons.iOS.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends SetUp {


    By allownotifications = By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]\n");
    By dontAllownotifications = By.xpath("//XCUIElementTypeButton[@name=\"Don’t Allow\"]\n");

    public WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }


    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void allowAppNotifications() {
        waitForVisibilityOf(allownotifications);
        driver.findElement(allownotifications).click();
    }

    public void dontAllowAppNotifications() {
        waitForVisibilityOf(dontAllownotifications);
        driver.findElement(dontAllownotifications).click();
    }
}
