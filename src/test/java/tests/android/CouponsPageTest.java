package tests.android;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.BasePage;
import pages.android.CouponsPage;
import pages.android.HomePage;
import pages.android.MenuPage;


public class CouponsPageTest extends Setup {

    final static Logger logger = Logger.getLogger(CouponsPageTest.class);


    private CouponsPage couponsPage;
    private HomePage homePage;
    private MenuPage menuPage;
    private BasePage basePage;


    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(true);
        couponsPage = new CouponsPage(driver);
        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);
        basePage = new BasePage(driver);
        homePage.clickMenu();
        menuPage.clickCoupon();

    }


    @Test(priority = 1)

    public void testAddCoupon() throws Exception {

        couponsPage.clickCouponCodeArea();
        couponsPage.enterCouponCode("couponcode");
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.hideKeyboard();
        couponsPage.clickSaveButton();
        Assert.assertEquals(couponsPage.checkAddedCouponMessage(),true);
        String text = couponsPage.getAddCouponConfirmationPopupText();
        logger.info(text);
        driver.navigate().back();

    }

    @Test(priority = 2)

    public void testSavedCoupon() throws InterruptedException {

        couponsPage.clickSavedCouponsArea();
        couponsPage.clickOnSavedCoupon();
        Assert.assertEquals(couponsPage.offerDetailVisibility(),true);
        couponsPage.clickDismissButton();

    }

    @Test(priority = 3)

    public void invalidCouponTest() throws Exception {
        couponsPage.clickEnterCouponCodeArea();
        couponsPage.enterCouponCode("random");
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.hideKeyboard();
        couponsPage.clickSaveButton();
        Assert.assertEquals(couponsPage.getWrongCouponPopup(),"SORRY CAN'T PROCESS. TO KNOW MORE GOTO HTTP://COMPLIANCE.SHUTTL.COM/");
        logger.info(couponsPage.getFindMyEnterCouponText());

    }

    @Test(priority = 4)

    public void termsOfServiceTest() {
        couponsPage.clickEnterCouponCodeArea();
        couponsPage.clickTermOfService();
        Assert.assertEquals(couponsPage.getTermsOfServiceTitle(),"Terms and Conditions");

    }


}
