package tests.android;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.HelpPage;
import pages.android.HomePage;
import pages.android.MenuPage;

public class HelpTest extends Setup{

    final static Logger logger = Logger.getLogger(CouponsPageTest.class);
    private HomePage homePage;
    private MenuPage menuPage;
    private HelpPage helpPage;
    AndroidDriver androidDriver=(AndroidDriver)driver;

    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(true);
        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);
        helpPage=new HelpPage(driver);
        homePage.clickMenu();
        menuPage.clickHelp();

    }


    @Test(priority = 0)
    public void testFAQS()
    {
        helpPage.clickFAQS();
        helpPage.clickWhatIsAutoBookingSub();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsAutoBookingSub();
        helpPage.clickWhatIsPayPerRide();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsPayPerRide();
        helpPage.clickOneWayTwoWay();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickOneWayTwoWay();
        helpPage.clickEatInsideShuttl();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickEatInsideShuttl();
        helpPage.clickWhatIsShuttlServiceAndShuttl();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsShuttlServiceAndShuttl();
        helpPage.clickWhatIsShuttlService();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsShuttlService();
        helpPage.clickNotGettingShuttlCredits();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickNotGettingShuttlCredits();
        helpPage.clickCallUsButton();

    }

    @Test(priority = 1)
    public void testCallCustomerCareNCR()
    {
        helpPage.clickCallCustomerCareNCR();
        Assert.assertEquals(helpPage.getNumberOfNCR(),"01204760000");
    }

    @Test(priority = 2)
    public void testCallCustomerCareKolkata()
    {
        helpPage.clickCallCustomerCareKolkata();
        Assert.assertEquals(helpPage.getNumberOfKolkata(),"01204760080");
    }

    @Test(priority = 3)
    public void testEmailUS()
    {
        helpPage.clickEmailUs();
        Assert.assertEquals(helpPage.getToOfEmailUs(),"<support@shuttlemails.com>, ");
    }

    @Test(priority = 4)
    public void testWeAreHiring()
    {
        helpPage.clickweAreHiring();
        Assert.assertEquals(helpPage.openPositions(),true);
    }

    @Test(priority = 5)
    public void testTermsAndConditions()
    {
        helpPage.clickTermsAndConditions();
        Assert.assertEquals(helpPage.titleDisplayedOfTermsAndConditions(),"Terms and Conditions");
    }
}
