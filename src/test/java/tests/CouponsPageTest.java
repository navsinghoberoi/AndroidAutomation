package tests;

import common.Commons;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CouponsPage;
import pages.HomePage;
import pages.MenuPage;


public class CouponsPageTest extends Setup {

    final static Logger logger = Logger.getLogger(CouponsPageTest.class);


    private CouponsPage couponsPage;
    private HomePage homePage;
    private MenuPage menuPage;
    private Commons commons;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(true);
        couponsPage = new CouponsPage(driver);
        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);
        commons = new Commons(driver);
        commons.goToHomepage("9999315652","oldUserOTP");
    }


    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("Test case completed");
        driver.quit();
    }


    @Test(priority = 1)

    public void testAddCoupon() throws Exception {
        homePage.clickMenu();
        menuPage.clickCoupon();
        boolean addedCouponMessage;
        couponsPage.clickCouponCodeArea();
        couponsPage.enterCouponCode("couponcode");
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.hideKeyboard();
        couponsPage.clickSaveButton();

        try {
            addedCouponMessage = couponsPage.checkAddedCouponMessage();
            String text = couponsPage.getAddCouponConfirmationPopupText();
            logger.info(text);
            driver.navigate().back();
        }
        catch (Exception e)
        {
            addedCouponMessage=false;
        }
        Assert.assertEquals(addedCouponMessage,true);

    }

    @Test(priority = 2)

    public void testSavedCoupon() throws InterruptedException {
        homePage.clickMenu();
        menuPage.clickCoupon();
        boolean offer_details;
        couponsPage.clickSavedCouponsArea();
        try {
            couponsPage.clickOnSavedCoupon();
            offer_details = couponsPage.offerDetailVisibility();
            couponsPage.clickDismissButton();
        }
        catch (Exception e)
        {
            offer_details=false;
        }
        Assert.assertEquals(offer_details,true);

    }

    @Test(priority = 3)

    public void invalidCouponTest() throws Exception {
        homePage.clickMenu();
        menuPage.clickCoupon();
        couponsPage.clickEnterCouponCodeArea();
        couponsPage.enterCouponCode("random");
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.hideKeyboard();
        couponsPage.clickSaveButton();
        Assert.assertEquals(couponsPage.getWrongCouponPopup(),getValueFromPPFile("invalidCouponMessage"));
        logger.info(couponsPage.getFindMyEnterCouponText());

    }

    @Test(priority = 4)

    public void termsOfServiceTest() {
        homePage.clickMenu();
        menuPage.clickCoupon();
        couponsPage.clickEnterCouponCodeArea();
        couponsPage.clickTermOfService();
        String title=couponsPage.getTermsOfServiceTitle();
        Assert.assertEquals(title,"Terms and Conditions");

    }


}
