package tests.web;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.LandingPage;

// PENDING -- Need to add code for deleting the user at the end

public class WebTest extends Setup {

    private LandingPage landingPage;

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