package tests.web;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.web.b2b.B2bSetup;
import pages.web.b2b.ViewCabTripsPage;

import java.net.MalformedURLException;

    public class DeleteCabSlotTest extends B2bSetup {
    private LoginPanelPageTest loginPageTest = new LoginPanelPageTest();

    @Test
    public void deleteCabSlotTest() throws MalformedURLException, InterruptedException {
        loginPageTest.verifyValidLogin();
        ViewCabTripsPage deleteTrip = new ViewCabTripsPage();
        waitForVisibilityOf(deleteTrip.getEmployeesPlus());
        deleteTrip.clickOnEmployeePlus();

        waitForVisibilityOf(deleteTrip.getViewCabTrips());
        deleteTrip.clickOnViewCabTrips();

        waitForVisibilityOf(deleteTrip.getViewSlotTime());
        String slotTime = deleteTrip.getSlotTime();

        waitForVisibilityOf(deleteTrip.getDeleteTrip());
        deleteTrip.deleteTrip();

        waitForVisibilityOf(deleteTrip.getDeleteWarning());
        deleteTrip.deleteWarningAccepted();

        Thread.sleep(2000);
        waitForVisibilityOf(deleteTrip.getViewSlotTime());
        Assert.assertNotEquals(slotTime,deleteTrip.getSlotTime());

    }
}
