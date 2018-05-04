package tests.android;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.CouponsPage;
import pages.android.HelpPage;
import pages.android.HomePage;
import pages.android.MenuPage;

public class HelpTest extends Setup{

    final static Logger logger = Logger.getLogger(CouponsPageTest.class);
    private HomePage homePage;
    private MenuPage menuPage;
    private HelpPage helpPage;

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
       /* helpPage.clickWhatIsSubscription();
        helpPage.clickWhatIsAutoBookingSub();
        helpPage.clickWhatIsPayPerRide();
        helpPage.clickOneWayTwoWay();
        helpPage.clickEatInsideShuttl();
        helpPage.clickWhatIsShuttlServiceAndShuttl();
        helpPage.clickWhatIsShuttlService();
        helpPage.clickNotGettingShuttlCredits();
        helpPage.clickCallUsButton();*/
    }

    @Test(priority = 1)
    public void testCallCustomerCareNCR()
    {
        helpPage.clickCallCustomerCareNCR();
    }

    @Test(priority = 2)
    public void testCallCustomerCareKolkata()
    {
        helpPage.clickCallCustomerCareKolkata();
    }

    @Test(priority = 3)
    public void testEmailUS()
    {
        helpPage.clickEmailUs();
    }

    @Test(priority = 4)
    public void testWeAreHiring()
    {
        helpPage.clickweAreHiring();
    }

    @Test(priority = 4)
    public void testTermsAndConditions()
    {
        helpPage.clickTermsAndConditions();
    }
}
