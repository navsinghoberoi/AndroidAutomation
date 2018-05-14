package pages.web.b2b;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPanelPage extends B2bSetup {

    private By userName = By.id("user-name");
    private By passWord = By.id("pwd");
    private By submitLogin = By.id("loginBtn");

    public void typeUsername(String user_name)

    {
        driver.findElement(userName).sendKeys(user_name);
    }

    public void typePassword(String pass) {
        driver.findElement(passWord).sendKeys(pass);
    }

    public void click() {
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


