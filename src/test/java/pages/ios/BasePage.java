package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.ios.Setup;

public class BasePage extends Setup {


    By allownotifications = By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]\n");
    By dontAllownotifications = By.xpath("//XCUIElementTypeButton[@name=\"Don’t Allow\"]\n");

    String keyBoardReturnButton = "Return";

    public IOSDriver driver;

    public BasePage(IOSDriver driver)
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


    public void hideKeyboard() {
        driver.findElementByAccessibilityId(keyBoardReturnButton).click();
    }
}
