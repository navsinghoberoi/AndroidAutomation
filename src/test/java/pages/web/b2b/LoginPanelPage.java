package pages.web.b2b;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPanelPage extends BasePage {

    private By userName = By.id("user-name");
    private By passWord = By.id("pwd");
    private By submitLogin = By.id("loginBtn");

    public LoginPanelPage(WebDriver driver) {
        super(driver);
    }

    public void typeUsername(String user_name)

    {
        waitForVisibilityOf(userName);
        driver.findElement(userName).sendKeys(user_name);
    }

    public void typePassword(String pass) {
        waitForVisibilityOf(passWord);
        driver.findElement(passWord).sendKeys(pass);
    }

    public void clickLogin() {
        waitForVisibilityOf(submitLogin);
        driver.findElement(submitLogin).click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By getUserName() {
        return userName;
    }

    public void setUserName(By userName) {
        this.userName = userName;
    }

    public By getPassWord() {
        return passWord;
    }

    public void setPassWord(By passWord) {
        this.passWord = passWord;
    }

    public By getSubmitLogin() {
        return submitLogin;
    }

    public void setSubmitLogin(By submitLogin) {
        this.submitLogin = submitLogin;
    }
}


