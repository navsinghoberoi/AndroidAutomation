package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import common.*;

public class ProfileTest extends Setup {


    private HomePage homePage;
    private Commons commons;
    private MenuPage menuPage;
    private ProfilePage profilePage;

    @BeforeClass
    public void setUp() throws Exception {
        createAndroidSession(true);
        homePage = new HomePage(driver);
        commons = new Commons(driver);
        menuPage = new MenuPage(driver);
        profilePage = new ProfilePage(driver);




    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        System.out.println("Test cases completed");
        driver.quit();
    }

    @Test(priority = 1)
    public void testProfile() throws InterruptedException {
        commons.goToHomepage();
        Thread.sleep(2000);
        homePage.clickMenu();
        //Thread.sleep(2000);
        menuPage.clickProfile();
        String Text = profilePage.getGenderText();
        Assert.assertEquals(Text, "Gender");
    }

}