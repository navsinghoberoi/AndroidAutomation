package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Setup;

import java.util.HashMap;

public class BasePage extends Setup {


    public WebDriver driver;
    public AndroidDriver androidDriver;
    String app_package_name = "app.goplus.in.myapplication.qa:id/";
    String app_package_name_android_gms = "com.google.android.gms:id/";
    private static final int DEFAULT_FIND_ELEMENT_TIMEOUT = 60;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean waitForVisibilityOf(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }
        catch(Exception e){
            System.out.println("Element Is not visible");
            return false;
        }
    }


    protected boolean waitForClickabilityOf(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
    }

    protected  void scrollToText(String visibleText) {
        androidDriver = (AndroidDriver) driver;
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
    }

    public void hideKeyboard()
    {
        androidDriver = (AndroidDriver) driver;
        androidDriver.hideKeyboard();
    }


    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.50);
        swipeObject.put("startY", 0.95);
        swipeObject.put("endX", 0.50);
        swipeObject.put("endY", 0.01);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }


    public void swipeLeftToRight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.01);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.9);
        swipeObject.put("endY", 0.6);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeFirstCarouselFromRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.2);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.2);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void performTapAction(WebElement elementToTap) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", (double) 360); // in pixels from left
        tapObject.put("y", (double) 170); // in pixels from top
        tapObject.put("element", Double.valueOf(((RemoteWebElement) elementToTap).getId()));
        js.executeScript("mobile: tap", tapObject);
    }
    public void clear(By locator) {
        WebElement we = driver.findElement(locator);
        String text = we.getText();
        System.out.println(text);
        int maxChars = text.length();
//        for (int i = maxChars; i >= 0; i--) {
//            ((AndroidDriver<WebElement>) driver).sendKeyEvent(67);
//        }
    }


    public WebElement getElementWhenVisible(By locater, long... waitSeconds) {
        assert waitSeconds.length <= 1;
        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : DEFAULT_FIND_ELEMENT_TIMEOUT;

        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
        return element;
    }

    public WebElement getElementWhenClickable(By locator, long... waitSeconds) {
        assert waitSeconds.length <= 1;
        long seconds = waitSeconds.length > 0 ? waitSeconds[0] : DEFAULT_FIND_ELEMENT_TIMEOUT;

        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public boolean checkIfElementPresent(By locator, long... waitSeconds) {
        try {
            getElementWhenVisible(locator, waitSeconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean checkIfElementClickable(By locator, long... waitSeconds) {
        try {
            getElementWhenClickable(locator, waitSeconds);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
