package tests;

import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

// Precondition -- Rate your ride popup is appearing on opening app   (createTrip, createBooking > Boarding > endTrip)

public class TripRatingTest extends Setup {

    private Commons commons;
    private TripRatingPage tripRatingPage;
    private String className;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(true);
        commons = new Commons(driver);
        tripRatingPage = new TripRatingPage(driver);
        commons.goToHomepage("userWithoutSubsPhoneNumber", "userWithoutSubsOTP");
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            commons.captureScreenshot(driver, className + " " + iTestResult.getMethod().getMethodName());
            System.out.println("Screenshot taken for failed testcase");
        }
        driver.quit();
    }


    @Test(priority = 1)
    public void verifyTripRatePageTitle() {
        String pageTitle = tripRatingPage.getPageTitle();
        Assert.assertEquals(pageTitle, "Rate Your Last Ride");
    }

    @Test(priority = 2)
    public void verifyPickupPointName() {
        String ppNameOnTripRatingPage = tripRatingPage.getPickupPointName();
        String ppNameOfRide = "Rithala Metro Station";   // get this data before boarding ride
        Assert.assertEquals(ppNameOnTripRatingPage, ppNameOfRide);
    }

    @Test(priority = 3)
    public void verifyDropPointName() {
        String dpNameOnTripRatingPage = tripRatingPage.getDropPointName();
        String dpNameOfRide = "CD Chowk (Spaze IT park)";   // get this data before boarding ride
        Assert.assertEquals(dpNameOnTripRatingPage, dpNameOfRide);
    }


    @Test(priority = 4)
    public void verifySubmitCTANotDisplayedWithoutSelectingRating() {
        boolean isSubmitButtonDisplayed = tripRatingPage.isSubmitTripRatingButtonDisplayed();
        Assert.assertEquals(isSubmitButtonDisplayed, false);
    }


    @Test(priority = 5)
    public void verifySubmitCTANotDisplayedAfterSelectingRating() {
        tripRatingPage.selectRatingStars();
        boolean isSubmitButtonDisplayed = tripRatingPage.isSubmitTripRatingButtonDisplayed();
        System.out.println(isSubmitButtonDisplayed);
        Assert.assertEquals(isSubmitButtonDisplayed, false);

    }

    @Test(priority = 6)
    public void verifySubmitCTADisabledAfterSelectingCategory() {
        tripRatingPage.selectRatingStars();
        tripRatingPage.selectTripCategory(0);
        boolean isSubmitButtonEnabled = tripRatingPage.isSubmitTripRatingButtonEnabled();
        Assert.assertEquals(isSubmitButtonEnabled, false);
    }


    @Test(priority = 7)
    public void verifySubmitCTAEnabled() {
        tripRatingPage.selectRatingStars();
        tripRatingPage.selectTripCategory(0);
        tripRatingPage.selectTripSubcategory(0);
        boolean isSubmitButtonEnabled = tripRatingPage.isSubmitTripRatingButtonEnabled();
        Assert.assertEquals(isSubmitButtonEnabled, true);
    }


    @Test(priority = 8)
    public void verifySubmitRatingCTAName() {
        tripRatingPage.selectRatingStars();
        tripRatingPage.selectTripCategory(0);
        tripRatingPage.selectTripSubcategory(0);
        tripRatingPage.enterComments("Test comment for trip rating feedback");
        tripRatingPage.submitTripRating();
        String popupMessage = tripRatingPage.getSubmitRatingPopupMessage();
        System.out.println(popupMessage);
        String ctaName = tripRatingPage.getSubmitRatingPopupCTAName();
        tripRatingPage.clickSubmitRatingPopupCTA();
        Assert.assertEquals(ctaName, "Continue");
    }


}
