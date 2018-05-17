package pages.ios;

import common.ios.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AppTourPage extends BasePage {


    // ByIosNsPredicate
    String pageText = "type == 'XCUIElementTypeStaticText'";

    // ByAccessibilityId
    String userNumberPage = "Want to skip login for now? VIEW ROUTE MAP";


    // Other Variables
    String time = new SimpleDateFormat("HHmmss").format(new Date());

    public AppTourPage(IOSDriver driver) {
        super(driver);
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
    }


    public String getAppTourFirstPageText() {
        MobileElement firstPageStaticText = (MobileElement) driver.findElementByIosNsPredicate(pageText);
        String firstPageText = firstPageStaticText.getText();
        swipeToDirection(firstPageStaticText, "left");
        return firstPageText;
    }


    public String getAppTourSecondPageText() {
        MobileElement secondPageStaticText = (MobileElement) driver.findElementByIosNsPredicate(pageText);
        String secondPageText = secondPageStaticText.getText();
        swipeToDirection(secondPageStaticText, "left");
        return secondPageText;
    }

    public String getAppTourThirdPageText() {
        MobileElement thirdPageStaticText = (MobileElement) driver.findElementByIosNsPredicate(pageText);
        String thirdPageText = thirdPageStaticText.getText();
        swipeToDirection(thirdPageStaticText, "left");
        return thirdPageText;
    }


    public String getAppTourFourthPageText() {
        MobileElement fourthPageStaticText = (MobileElement) driver.findElementByAccessibilityId(userNumberPage);
        String fourthPageText = fourthPageStaticText.getText();
        swipeToDirection(fourthPageStaticText, "left");
        return fourthPageText;
    }


    public String getAppTourFirstPageScreenshot() throws IOException {
        MobileElement firstPageStaticText = (MobileElement) driver.findElementByIosNsPredicate(pageText);
        String firstScreenshotPath = Constants.appTourErrorScreenshots + "/firstPage" + time + ".JPG";
        takeScreenshot(firstScreenshotPath);
        swipeToDirection(firstPageStaticText, "left");
        return firstScreenshotPath;
    }


    public String getAppTourSecondPageScreenshot() throws IOException {
        MobileElement secondPageStaticText = (MobileElement) driver.findElementByIosNsPredicate(pageText);
        String secondScreenshotPath = Constants.appTourErrorScreenshots + "/secondPage" + time + ".JPG";
        takeScreenshot(secondScreenshotPath);
        swipeToDirection(secondPageStaticText, "left");
        return secondScreenshotPath;

    }


    public String getAppTourThirdPageScreenshot() throws IOException {
        MobileElement thirdPageStaticText = (MobileElement) driver.findElementByIosNsPredicate(pageText);
        String thirdScreenshotPath = Constants.appTourErrorScreenshots + "/thirdPage" + time + ".JPG";
        takeScreenshot(thirdScreenshotPath);
        swipeToDirection(thirdPageStaticText, "left");
        return thirdScreenshotPath;
    }


    public String getAppTourFourthPageScreenshot() throws IOException {
        String fourthScreenshotPath = Constants.appTourErrorScreenshots + "/fourthPage" + time + ".JPG";
        takeScreenshot(fourthScreenshotPath);
        return fourthScreenshotPath;

    }


}

