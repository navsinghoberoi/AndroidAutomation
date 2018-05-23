package tests.web;
import com.sun.tools.classfile.Opcode;
import common.android.Commons;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.HelpPage;
import pages.android.HomePage;
import pages.android.MenuPage;
import pages.web.b2b.B2bSetup;
import pages.web.b2b.LoginPanelPage;
import java.net.MalformedURLException;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class LoginPanelPageTest extends Setup{

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

}
