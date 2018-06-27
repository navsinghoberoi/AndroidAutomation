package tests;

import common.Commons;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

/*
Intent of this class is to check new implementations or amend existing implementation
*/

public class TestClass extends Setup {
    private LandingPage landingPage;
    private LoginPage loginPage;
    private PersonalDetailsPage personalDetails;
    private HomeAddressPage homeAddressPage;
    private OfficeAddressPage officeAddressPage;
    private OtpPage otpPage;
    private HomePage homepage;
    private Commons commons;
    private SelectLocationPage selectLocationPage;
    private SlotsPage slotsPage;
    private ExplorePassesPage explorePassesPage;
    private ChooseBenefitsPage chooseBenefitsPage;
    private ReviewRoutePage reviewRoutePage;
    private PassCompletePaymentPage passCompletePaymentPage;
    private PassDetailsPage passDetailsPage;
    private RefundPassPage refundPassPage;
    private String className;

    @BeforeClass
    public void setUp() throws Exception {
    //    createAndroidSession(true);
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        personalDetails = new PersonalDetailsPage(driver);
        homeAddressPage = new HomeAddressPage(driver);
        officeAddressPage = new OfficeAddressPage(driver);
        otpPage = new OtpPage(driver);
        homepage = new HomePage(driver);
        commons = new Commons(driver);
        selectLocationPage = new SelectLocationPage(driver);
        slotsPage = new SlotsPage(driver);
        explorePassesPage = new ExplorePassesPage(driver);
        chooseBenefitsPage = new ChooseBenefitsPage(driver);
        reviewRoutePage = new ReviewRoutePage(driver);
        passCompletePaymentPage = new PassCompletePaymentPage(driver);
        passDetailsPage = new PassDetailsPage(driver);
        refundPassPage = new RefundPassPage(driver);
        className = getClass().getSimpleName() + commons.getCurrentTime();
    }


    @Test(priority = 1,enabled = true)
    public void testQAUMSDBConnection() throws Exception{
        String dbValue = commons.connectSQLDbAndFetchValue(getValueFromPPFile("umsQaDbIP"), getValueFromPPFile("umsQaDbUserName"), getValueFromPPFile("umsQaDbPassword"), getValueFromPPFile("umsQaDbName"), getValueFromPPFile("umsQaDbSqlQuery"), getValueFromPPFile("umsQaDbColumnName"));
        System.out.println("Value fetched from qa database = "+dbValue);
        System.out.println("------------ End of test 1 ----------------");
    }


    @Test(priority = 2,enabled = true)
    public void testProdUMSDBConnection() throws Exception{
        String dbValue = commons.connectSQLDbAndFetchValue(getValueFromPPFile("umsProdDbIP"), getValueFromPPFile("umsProdDbUserName"), getValueFromPPFile("umsProdDbPassword"), getValueFromPPFile("umsProdDbName"), getValueFromPPFile("umsProdDbSqlQuery"), getValueFromPPFile("umsProdDbColumnName"));
        System.out.println("Value fetched from prod database = "+dbValue);
        System.out.println("------------ End of test 2 ----------------");
    }


}
