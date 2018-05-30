package tests;

import common.Commons;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;


public class ScrollTest extends Setup {

    private ProfilePage profilePage;


    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(true);
        profilePage = new ProfilePage(driver);



    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        System.out.println("Test cases  completed");
        driver.quit();
    }

    @Test(priority = 1)
    public void signIn() throws Exception {

        Thread.sleep(20000);
        profilePage.scrollToEmail();


    }



}