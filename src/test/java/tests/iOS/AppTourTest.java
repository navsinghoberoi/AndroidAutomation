package tests.ios;

import common.ios.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ios.AppTourPage;
import pages.ios.BasePage;

import java.io.IOException;

public class AppTourTest extends Setup {


    AppTourPage appTour;
    BasePage basePage;

    @BeforeClass
    public void setup() {
        createIosSession(false);
        appTour = new AppTourPage(driver);
        basePage = new BasePage(driver);


    }


    @Test(priority = 1)
    public void verifyFirstPageText() {
        String firstPageText = appTour.getAppTourFirstPageText();
        Assert.assertEquals(firstPageText, "Discover routes and buses near you for your daily office commute");


    }


    @Test(priority = 2, enabled = false)
    public void verifyFirstPageView() throws IOException {
        String firstPageScreenshotPath = appTour.getAppTourFirstPageScreenshot();
        boolean status = basePage.compareScreenshots
                (Constants.appTourExpectedScreenshots + "FirstPage.JPG", firstPageScreenshotPath);

        if (status)
            basePage.deleteFileFromDirectory(firstPageScreenshotPath);
        Assert.assertTrue(status);
    }


    @Test(priority = 3)
    public void verifySecondPageText() {
        String secondPageText = appTour.getAppTourSecondPageText();
        Assert.assertEquals(secondPageText, "Reserve a seat and track your Shuttl in real time for seamless boarding");


    }


    @Test(priority = 4, enabled = false)
    public void verifySecondPageView() throws IOException {
        String secondPageScreenshotPath = appTour.getAppTourSecondPageScreenshot();
        boolean status = basePage.compareScreenshots
                (Constants.appTourExpectedScreenshots + "SecondPage.JPG", secondPageScreenshotPath);

        if (status)
            basePage.deleteFileFromDirectory(secondPageScreenshotPath);
        Assert.assertTrue(status);

    }


    @Test(priority = 5)
    public void verifyThirdPageText() {
        String thirdPageText = appTour.getAppTourThirdPageText();
        Assert.assertEquals(thirdPageText, "Ride comfortably on an AC bus to your destination");


    }


    @Test(priority = 6, enabled = false)
    public void verifyThirdPageView() throws IOException {
        String thirdPageScreenshotPath = appTour.getAppTourThirdPageScreenshot();
        boolean status = basePage.compareScreenshots
                (Constants.appTourExpectedScreenshots + "ThirdPage.JPG", thirdPageScreenshotPath);

        if (status)
            basePage.deleteFileFromDirectory(thirdPageScreenshotPath);
        Assert.assertTrue(status);

    }


    @Test(priority = 7)
    public void verifyFourthPageText() {
        String fourthPageText = appTour.getAppTourFourthPageText();
        Assert.assertEquals(fourthPageText, "Want to skip login for now? VIEW ROUTE MAP");


    }


    @Test(priority = 8, enabled = false)
    public void verifyFourthPageView() throws IOException {
        String fourthPageScreenshotPath = appTour.getAppTourFourthPageScreenshot();
        boolean status = basePage.compareScreenshots
                (Constants.appTourExpectedScreenshots + "FourthPage.JPG", fourthPageScreenshotPath);

        if (status)
            basePage.deleteFileFromDirectory(fourthPageScreenshotPath);
        Assert.assertTrue(status);
    }


    @AfterClass
    public void tearDown() {
        System.out.println("All The Test Cases are completed");
        driver.quit();
    }

}
