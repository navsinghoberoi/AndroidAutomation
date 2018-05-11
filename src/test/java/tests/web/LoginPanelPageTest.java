package tests.web;
import org.testng.annotations.Test;
import pages.web.b2b.B2bSetup;
import pages.web.b2b.LoginPanelPage;
import java.net.MalformedURLException;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class LoginPanelPageTest extends B2bSetup{

    @Test
    public void verifyValidLogin() throws MalformedURLException, InterruptedException {

        LoginPanelPage loginb2b = new LoginPanelPage();

        loginb2b.launchBrowser();
        waitForVisibilityOf(loginb2b.getUserName());
        waitForVisibilityOf(loginb2b.getPassWord());
        waitForVisibilityOf(loginb2b.getSubmitLogin());

        loginb2b.typeUsername("sumeet.joon");
        loginb2b.typePassword("sumeet");
        loginb2b.click();
        Thread.sleep(1000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Shuttl B2B Home";
        assertEquals(expectedTitle,actualTitle);

    }

}
