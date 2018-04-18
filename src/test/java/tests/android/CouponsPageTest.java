package tests.android;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.*;


public class CouponsPageTest extends Setup {

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
        basePage=new BasePage(driver);

    }


    @Test(priority = 1)

    public void testAddCoupon() throws Exception {


        homePage.clickMenu();
        menuPage.clickCoupon();
        couponsPage.clickCouponCodeArea();
        couponsPage.enterCouponCode("validcouponcode");
        AndroidDriver androidDriver= (AndroidDriver) driver;
        androidDriver.hideKeyboard();
        couponsPage.clickSaveButton();


    }

    @Test(priority = 2)

    public void testSavedCoupon() throws InterruptedException {


        if (couponsPage.checkAddedCouponMessage()) {
            System.out.println("Added coupon message displayed");
            String text=couponsPage.getAddCouponConfirmationPopupText();
            System.out.println(text);
            driver.navigate().back();
            couponsPage.clickSavedCouponsArea();
            couponsPage.clickOnSavedCoupon();
            couponsPage.clickDismissButton();

        } else
            System.out.println("Added coupon message Not displayed");


    }

    @Test(priority = 3)

    public void invalidCouponTest() throws Exception {
        couponsPage.clickEnterCouponCodeArea();
        couponsPage.enterCouponCode("random");
        AndroidDriver androidDriver=(AndroidDriver)driver;
        androidDriver.hideKeyboard();
        System.out.println(couponsPage.getAddCouponConfirmationPopupText());
        System.out.println(couponsPage.getFindMyEnterCouponText());

    }

    @Test(priority = 4)

    public void termsOfServiceTest()
    {
        couponsPage.clickEnterCouponCodeArea();
        couponsPage.clickTermOfService();
    }



}
