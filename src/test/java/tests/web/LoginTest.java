package tests.web;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.web.b2b.LoginPanelPage;
import java.net.MalformedURLException;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

class LoginPanelPageTest extends Setup{

    private  LoginPanelPage loginPanelPage;

    @BeforeClass
    public void setUp() throws Exception {
        createBrowserSession("local");
        loginPanelPage = new LoginPanelPage(driver);


    }


    @Test
    public void verifyValidLogin() throws MalformedURLException, InterruptedException {
        loginPanelPage.typeUsername("sumeet.joon");
        loginPanelPage.typePassword("sumeet");
        loginPanelPage.clickLogin();
        Thread.sleep(1000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Shuttl B2B Home";
        Assert.assertEquals(expectedTitle,actualTitle);

    }


    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("Test cases completed , now closing browser");
        driver.quit();
    }

}
