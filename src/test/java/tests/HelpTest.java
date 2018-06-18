package tests;

import common.Commons;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HelpPage;
import pages.HomePage;
import pages.MenuPage;

public class HelpTest extends Setup{

    final static Logger logger = Logger.getLogger(CouponsPageTest.class);
    private HomePage homePage;
    private MenuPage menuPage;
    private HelpPage helpPage;
    private Commons commons;
    private String className;

    @BeforeMethod
    public void setUp() throws Exception {
        createAndroidSession(true);
        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);
        helpPage=new HelpPage(driver);
        commons = new Commons(driver);
        homePage.clickMenu();
        menuPage.clickHelp();
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (ITestResult.FAILURE == iTestResult.getStatus()){
            commons.captureScreenshot(driver,className);
            System.out.println("Screenshot taken for failed testcase");
        }
    }


    @AfterClass
    public void quit() {
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }

    @Test(priority = 4)
    public void testWhatIsAutoBookingSubContent()
    {
        helpPage.clickFAQS();
        helpPage.clickWhatIsAutoBookingSub();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsAutoBookingSub();

    }

    @Test(priority = 5)
    public void testWhatIsPayPerRideContent()
    {
        helpPage.clickFAQS();
        helpPage.clickWhatIsPayPerRide();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsPayPerRide();
    }


    @Test(priority = 6)
    public void testOneWayTwoWayContent()
    {
        helpPage.clickFAQS();
        helpPage.clickOneWayTwoWay();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickOneWayTwoWay();
    }

    @Test(priority = 7)
    public void testEatInsideShuttlContent()
    {
        helpPage.clickFAQS();
        helpPage.clickEatInsideShuttl();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickEatInsideShuttl();
    }

    @Test(priority = 8)
    public void testWhatIsShuttlServiceAndShuttlContent()
    {
        helpPage.clickFAQS();
        helpPage.clickWhatIsShuttlServiceAndShuttl();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsShuttlServiceAndShuttl();
    }

    @Test(priority = 9)
    public void testWhatIsShuttlServiceContent()
    {
        helpPage.clickFAQS();
        helpPage.clickWhatIsShuttlService();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsShuttlService();
    }

    @Test(priority = 10)
    public void testNotGettingShuttlCredits()
    {
        helpPage.clickFAQS();
        helpPage.clickNotGettingShuttlCredits();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickNotGettingShuttlCredits();
    }

    @Test(priority = 11)
    public void testCallUsButton() throws Exception {
        String callus=null;
        try {
            helpPage.clickFAQS();
            helpPage.clickCallUsButton();
            callus=helpPage.getNumberOfNCR();
        }catch (Exception e) {}

        Assert.assertEquals(callus,getValueFromPPFile("customerCareNCR"));
    }


    @Test(priority = 1)
    public void testCallCustomerCareNCR() throws Exception {

        String number=null;
        try {
            helpPage.clickCallCustomerCareNCR();
            number=helpPage.getNumberOfNCR();

        }catch (Exception e){}
        Assert.assertEquals(number,getValueFromPPFile("customerCareNCR"));
    }

    @Test(priority = 2)
    public void testCallCustomerCareKolkata() throws Exception {
        String number=null;
        try {
            helpPage.clickCallCustomerCareKolkata();
            number=helpPage.getNumberOfKolkata();
        }catch (Exception e){}

        Assert.assertEquals(number,getValueFromPPFile("customerCareKolkata"));
    }

    @Test(priority = 3)
    public void testEmailUS() throws Exception {
        String email=null;

        try {

            helpPage.clickEmailUs();
            email=helpPage.getToOfEmailUs();

        }catch (Exception e){}

        System.out.println(email);
        Assert.assertEquals(email,getValueFromPPFile("emailUs"));
    }

    @Test(priority = 12)
    public void testWeAreHiring()
    {
        boolean check=false;

            helpPage.clickweAreHiring();
            check=helpPage.openPositions();

        driver.navigate().back();

        Assert.assertEquals(check,true);
    }


}
