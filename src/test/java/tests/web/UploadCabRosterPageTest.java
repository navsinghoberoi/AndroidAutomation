package tests.web;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.web.b2b.*;
import tests.web.LoginPanelPageTest;

import java.net.MalformedURLException;

public class UploadCabRosterPageTest extends B2bSetup {

    private LoginPanelPageTest loginPageTest = new LoginPanelPageTest();

    @Test
    public void uploadRoster() throws InterruptedException, MalformedURLException

    {
        loginPageTest.verifyValidLogin();

        UploadCabRosterPage upload = new UploadCabRosterPage();

        waitForVisibilityOf(upload.getEmployeesPlus());

        upload.gotoEmployeesPlus();
        waitForVisibilityOf(upload.getAddRosterTab());
        upload.clickOnAddRosterTab();
        waitForVisibilityOf(upload.getAddCabRoster());
        upload.clickOnAddCabRoster();
        waitForVisibilityOf(upload.getClickOnSelectFile());
        upload.setClickOnSelectFile();
        // waitForVisibilityOf(upload.getUploadRoster());
        upload.uploadRoster("/Users/admin/Downloads/Phase2_escort.xlsx");
        waitForVisibilityOf(upload.getShowDetails());
        upload.showDetails();
        waitForVisibilityOf(upload.getIgnoreRec());
        upload.ignoreRec();
        waitForVisibilityOf(upload.getYesToIgnore());
        upload.yesToIgnore();
        Thread.sleep(5000);
        String actualtext = driver.findElement(By.xpath("//*[contains(text(), 'Successfully Uploaded')]")).getText();
        Assert.assertEquals(actualtext, " Successfully Uploaded");
    }

}





