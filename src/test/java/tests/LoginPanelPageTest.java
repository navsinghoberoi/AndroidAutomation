package tests;
import org.testng.annotations.Test;
import pages.web.b2b.B2bSetup;
import pages.web.b2b.LoginPanelPage;


public class LoginPanelPageTest extends B2bSetup{

    @Test
    public void verifyValidLogin() {

        LoginPanelPage loginb2b = new LoginPanelPage();

        loginb2b.launchBrowser();
        waitForVisibilityOf(loginb2b.getUsername());
        waitForVisibilityOf(loginb2b.getPassword());
        waitForVisibilityOf(loginb2b.getSubmitLogin());

        loginb2b.typeUsername("sumeet.joon");
        loginb2b.typePassword("sumeet");
        loginb2b.pressLoginButton();

    }

}
