package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import common.Commons;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;


public class NotificationTest extends Setup{

    private HomePage homePage;
    private MenuPage menuPage;
    private Commons commons;
    private String className;
    private NotificationPage notificationPage;
    private MyRidesPage myRidesPage;
    private int bookingIdFromAPIForCancel;
    private int bookingIdFromAPIForCreate;

    @BeforeClass
    public void Setup() throws Exception {
        createAndroidSession(false);
        commons = new Commons(driver);
        commons.goToHomepage("old1UserPhoneNumber","OTP");
        homePage = new HomePage(driver);
        homePage.clickMenu();
        className = getClass().getSimpleName() + commons.getCurrentTime();
        notificationPage = new NotificationPage(driver);
      //  basePage = new BasePage(driver);
        myRidesPage = new MyRidesPage(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            commons.captureScreenshot(driver, className);
            System.out.println("Screenshot taken for failed testcase");
        }
    }

    @Test(priority = 1)
    public void verifyNotificationText(){
        String notification_Text = notificationPage.getNotificationText();
        notificationPage.clickNotificationText();
        Assert.assertEquals(notification_Text,"Notifications");
    }
    @Test(priority = 2)
    public void verifyNotificationLandingText(){
        String landing_Page_Text = notificationPage.getNotificationTitleText();
        Assert.assertEquals(landing_Page_Text,"Notifications");
    }
    @Test(priority = 3)
    public void verifyCreateBookingNotification()throws Exception{
        //Buy a subscription through API
        commons.subscriptionBuyViaApiEngine(getValueFromPPFile("BuyPassUserIDNewuser"));
        //Booked a ride first through API
        bookingIdFromAPIForCreate = commons.createBookingViaApiEngine(getValueFromPPFile("CreateBookingNewUserId"));
        driver.navigate().back();
        commons.enterUserPhoneNumberOTP("old1UserPhoneNumber", "OTP");
        homePage.clickMenu();
        notificationPage.clickNotificationText();
        String notificationTitleTextForCreation = notificationPage.getBookingNotification();
        String bookingCreationSubText = notificationPage.getBookingCreationNotificationSubText();
        Assert.assertTrue(notificationTitleTextForCreation.equalsIgnoreCase("Booking")
                &&  bookingIdFromAPIForCreate == Integer.parseInt(bookingCreationSubText));
    }
    @Test(priority = 4)
    public void verifyLandingFromBookingOnViewButton(){
        notificationPage.clickViewButtonOnBooking();
        String bookingViewLanding = myRidesPage.getMyRidesTitleText();
        Assert.assertEquals(bookingViewLanding, "My Rides");
    }
    @Test(priority = 5)
    public void verifyCancelBookingNotification() throws Exception{
        //Refund a subscription through API
        driver.navigate().back();
        bookingIdFromAPIForCancel = commons.cancelBookingViaApiEngine(getValueFromPPFile("CancelBookingNewUserId"));
        System.out.println(bookingIdFromAPIForCancel);
        //Cancelled a ride through API
        commons.refundSubscriptionViaApiEngine(getValueFromPPFile("RefundPassUserIdNewUser"));
        driver.navigate().back();
        driver.navigate().back();
        homePage.clickMenu();
        notificationPage.clickNotificationText();
        notificationPage.clickViewButtonOnBooking();
        myRidesPage.clickSessionExpired();
        commons.enterUserPhoneNumberOTP("old1UserPhoneNumber", "OTP");
        homePage.clickMenu();
        notificationPage.clickNotificationText();
        String notificationTitleTextForCancellation = notificationPage.getBookingNotification();
        String bookingCancellationSubText = notificationPage.getBookingCancellationNotificationSubText();
        System.out.println(bookingIdFromAPIForCancel);
        System.out.println(notificationTitleTextForCancellation);
        Assert.assertTrue(notificationTitleTextForCancellation.equalsIgnoreCase("Booking cancelled")
                &&  bookingIdFromAPIForCancel == Integer.parseInt(bookingCancellationSubText));
    }
    @Test(priority = 6)
    public void verifyLandingAfterBookingCancel(){
        String getbookingIdValue = null;
        notificationPage.clickViewButtonOnBooking();
        getbookingIdValue = notificationPage.getBookingId();
        Assert.assertEquals(getbookingIdValue, Integer.toString(bookingIdFromAPIForCreate));
    }


}
