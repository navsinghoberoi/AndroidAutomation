package common.web.b2b;

import org.openqa.selenium.WebDriver;
import pages.android.BasePage;
import pages.web.b2b.LoginPanelPage;

public class Commons extends BasePage {
    public Commons(WebDriver driver) {
        super(driver);
    }
    private LoginPanelPage loginPanelPage = new LoginPanelPage(driver);


    LoginPanelPage loginPanelPage = new LoginPanelPage(driver);
    public void login() throws InterruptedException {
        loginPanelPage.typeUsername("sumeet.joon");
        loginPanelPage.typePassword("sumeet");
        loginPanelPage.clickLogin();

    }
}
