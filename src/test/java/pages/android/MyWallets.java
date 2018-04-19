package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyWallets extends BasePage {



    By shuttlCreditsBalance = By.id("item_wallet.balance");
    By shuttlCreditsAvailable = By.id("item_wallet.available");
    By shuttlCreditsPage = By.id("item_coupon.parent");
    By shuttlCreditsCurrentTab = By.xpath("//*[contains(text(),'Current')]");
    By shuttlCreditsHeadline = By.id("wallet_shuttl.top.header.text");
    By shuttlCreditsPageBalance = By.id("wallet_shuttl.balance"); // Should be equal to shuttl balance on wallets page
    By shuttlCreditsCashbackAmount = By.xpath(("(//*[@id= 'amount'])[1]"));
    By shuttlCreditsRefundabeAmount = By.xpath(("(//*[@id= 'amount'])[2]"));
    By shuttlCreditsPageFooter = By.id("wallet_shuttl.credit.footer");
    By shuttlCreditsHistoryTab = By.xpath("//*[contains(text(),'History')]");
    By shuttlCreditsHistoryLastTransactionType = By.id("rh_name");
    By shuttlCreditsHistoryLastTransactionAmount = By.id("rh_credit_amount");
    By shuttlCreditsHistoryLastTransactionDate = By.id("rh_date");
    By paytmWalletMessage = By.xpath(("(//*[@id= 'item_wallet.message'])[1]"));
    By paytmWalletConnect = By.xpath(("(//*[@id= 'item_wallet.connect'])[1]"));
    By mobikwikWalletMessage = By.xpath(("(//*[@id= 'item_wallet.message'])[2]"));
    By mobikwikWalletConnect = By.xpath(("(//*[@id= 'item_wallet.connect'])[2]"));


    public MyWallets(WebDriver driver)  {
        super(driver);
    }


    public String shuttlCreditsBalanceGet()
    {
        waitForVisibilityOf(shuttlCreditsBalance);
        String bal = driver.findElement(shuttlCreditsBalance).getText();
        System.out.println("Shuttl credits balance on My Wallets page = "+bal);
        return bal;
    }

    public String shuttlCreditsAvailableGet()
    {
        waitForVisibilityOf(shuttlCreditsAvailable);
        String status = driver.findElement(shuttlCreditsAvailable).getText();
        System.out.println("Shuttl credits status on My Wallets page = "+status);
        return status;
    }



    public void shuttlCreditsPageOpen()
    {
        waitForVisibilityOf(shuttlCreditsPage);
        driver.findElement(shuttlCreditsPage).click();
    }


    public void shuttlCreditsCurrentTabOpen()
    {
        waitForVisibilityOf(shuttlCreditsCurrentTab);
        driver.findElement(shuttlCreditsCurrentTab).click();
    }

    public String shuttlCreditsHeadlineGet()
    {
        waitForVisibilityOf(shuttlCreditsHeadline);
        String creditsHeadline = driver.findElement(shuttlCreditsHeadline).getText();
        System.out.println("Shuttl credits status on My Wallets page = "+creditsHeadline);
        return creditsHeadline;
    }





}
