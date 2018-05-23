package common.web.b2b;

import org.openqa.selenium.WebDriver;
import pages.android.BasePage;

public class commons extends BasePage {
    public commons(WebDriver driver) {
        super(driver);
    }


    public void login() throws InterruptedException {
        loginPanelPage.typeUsername("sumeet.joon");
        loginPanelPage.typePassword("sumeet");
        loginPanelPage.clickLogin();

    }
}
