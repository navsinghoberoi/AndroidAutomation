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


    @Test
    public void testWhatIsAutoBookingSubContent()
    {
        helpPage.clickFAQS();
        helpPage.clickWhatIsAutoBookingSub();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsAutoBookingSub();

    }

    @Test
    public void testWhatIsPayPerRideContent()
    {
        helpPage.clickFAQS();
        helpPage.clickWhatIsPayPerRide();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsPayPerRide();
    }


    @Test
    public void testOneWayTwoWayContent()
    {
        helpPage.clickFAQS();
        helpPage.clickOneWayTwoWay();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickOneWayTwoWay();
    }

    @Test
    public void testEatInsideShuttlContent()
    {
        helpPage.clickFAQS();
        helpPage.clickEatInsideShuttl();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickEatInsideShuttl();
    }

    @Test
    public void testWhatIsShuttlServiceAndShuttlContent()
    {
        helpPage.clickFAQS();
        helpPage.clickWhatIsShuttlServiceAndShuttl();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsShuttlServiceAndShuttl();
    }

    @Test
    public void testWhatIsShuttlServiceContent()
    {
        helpPage.clickFAQS();
        helpPage.clickWhatIsShuttlService();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickWhatIsShuttlService();
    }

    @Test
    public void testNotGettingShuttlCredits()
    {
        helpPage.clickFAQS();
        helpPage.clickNotGettingShuttlCredits();
        Assert.assertNotSame(helpPage.textInsideQuestions(),0);
        helpPage.clickNotGettingShuttlCredits();
    }

    @Test
    public void testCallUsButton() throws Exception {
        helpPage.clickFAQS();
        helpPage.clickCallUsButton();
        Assert.assertEquals(helpPage.getNumberOfNCR(),getValueFromPPFile("customerCareNCR"));
    }


    @Test
    public void testCallCustomerCareNCR() throws Exception {
        helpPage.clickCallCustomerCareNCR();
        Assert.assertEquals(helpPage.getNumberOfNCR(),getValueFromPPFile("customerCareNCR"));
    }

    @Test
    public void testCallCustomerCareKolkata() throws Exception {
        helpPage.clickCallCustomerCareKolkata();
        Assert.assertEquals(helpPage.getNumberOfKolkata(),getValueFromPPFile("customerCareKolkata"));
    }

    @Test
    public void testEmailUS() throws Exception {
        helpPage.clickEmailUs();
        Assert.assertEquals(helpPage.getToOfEmailUs(),getValueFromPPFile("emailUs"));
    }

    @Test
    public void testWeAreHiring()
    {
        helpPage.clickweAreHiring();
        Assert.assertEquals(helpPage.openPositions(),true);
    }

    @Test
    public void testTermsAndConditions()
    {
        helpPage.clickTermsAndConditions();
        Assert.assertEquals(helpPage.titleDisplayedOfTermsAndConditions(),"Terms and Conditions");
    }
}
