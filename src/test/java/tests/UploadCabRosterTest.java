package tests;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import  pages.web.b2b.*;

public class UploadCabRosterTest extends B2bSetup{


    @Test
    public void uploadRoster() throws InterruptedException

    {
        LoginPanelPageTest loginpagetest = new LoginPanelPageTest();
        loginpagetest.verifyValidLogin();

     //   WebDriver driver = LoginPanelPageTest.driver;


        UploadCabRoster upload = new UploadCabRoster();

        waitForVisibilityOf(upload.getEmployeesPlus());

        upload.gotoEmployeesPlus();
        waitForVisibilityOf(upload.getAddrosterTab());
        upload.clickOnAddRosterTab();
        waitForVisibilityOf(upload.getAddcabroster());
        upload.clickOnAddCabRoster();
        waitForVisibilityOf(upload.getClickOnSelectFile());
        upload.setClickOnSelectFile();
       // waitForVisibilityOf(upload.getUploadRoster());
        upload.uploadRoster("/Users/admin/Downloads/Phase2_escort.xlsx");
        waitForVisibilityOf(upload.getShowdetails());
        upload.showDetails();
        waitForVisibilityOf(upload.getIgnorerec());
        upload.ignoreRec();
        waitForVisibilityOf(upload.getYestoignore());
        upload.yesToIgnore();
        Thread.sleep(5000);
        String actualtext = driver.findElement(By.xpath("//*[contains(text(), 'Successfully Uploaded')]")).getText();
        System.out.println(actualtext);
        Assert.assertEquals(actualtext," Successfully Uploaded");
    }

         //Alert alert = driver.switchTo().alert();
        // alert.accept();
        //driver.(new LocalFileDetector());
        //  WebElement element = driver.findElement(By.id("_file"));
        // element.sendKeys("/Users/admin/Downloads/escort jai (2).xlsx");


    }





