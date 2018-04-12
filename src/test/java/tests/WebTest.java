package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

// PENDING -- Need to add code for deleting the user at the end

public class WebTest extends Setup {

    private LandingPage landingPage;
    private LoginPage loginPage;
    private PersonalDetails personalDetails;
    private HomeAddress homeAddress;
    private OfficeAddress officeAddress;
    private OtpPage otpPage;
    private HomePage homepage;

    @BeforeClass
    public void setUp() throws Exception {
        createBrowserSession("local");

    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        System.out.println("Test cases completed , now closing app");
        driver.quit();
    }



    @Test
    public void userSignUp() throws Exception
    {
        Thread.sleep(5000);
        driver.navigate().to("http://google.co.in");
        Thread.sleep(10000);

    }


}