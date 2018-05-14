package tests.web;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.web.b2b.B2bSetup;
import pages.web.b2b.TripReportPage;

import java.net.MalformedURLException;

public class TripReportTest extends B2bSetup {

    private LoginPanelPageTest loginPageTest = new LoginPanelPageTest();

    @Test(priority = 1)
    public void verifyBusTripReport() throws MalformedURLException, InterruptedException {
        loginPageTest.verifyValidLogin();
        TripReportPage tripReport = new TripReportPage();

        waitForVisibilityOf(tripReport.getBusReportTab());
        tripReport.goTOReportTab();

        waitForVisibilityOf(tripReport.getBusReportStartDateInput());
        tripReport.enterStartDate("05/09/2018");

        waitForVisibilityOf(tripReport.getBusReportEndDateInput());
        tripReport.enterEndDate();

        waitForVisibilityOf(tripReport.getBusReportEndDateInput());
        tripReport.enterEndDate("05/10/2018");

        waitForVisibilityOf(tripReport.getTrips());
        tripReport.selectTrips();

        waitForVisibilityOf(tripReport.getGetReport());
        tripReport.getReport();


        waitForVisibilityOf(tripReport.getVisibilityOfDownloadReport());
        String str = tripReport.visibilityOfDownloadReport();

        Assert.assertEquals("reportLinkBtn", str);


    }

    @Test(priority = 2)
    public void verifyCabTripReport() throws MalformedURLException, InterruptedException {
        loginPageTest.verifyValidLogin();
        TripReportPage tripReport = new TripReportPage();

        waitForVisibilityOf(tripReport.getBusReportTab());
        tripReport.goTOReportTab();

        waitForVisibilityOf(tripReport.getCabReportTab());
        tripReport.goToCabReportTab();

        waitForVisibilityOf(tripReport.getBusReportStartDateInput());
        tripReport.enterStartDate("05/01/2018");

        waitForVisibilityOf(tripReport.getBusReportEndDateInput());
        tripReport.enterEndDate();

        waitForVisibilityOf(tripReport.getBusReportEndDateInput());
        tripReport.enterEndDate("05/10/2018");

        waitForVisibilityOf(tripReport.getTrips());
        tripReport.selectTrips();

        waitForVisibilityOf(tripReport.getGetReport());
        tripReport.getReport();


        waitForVisibilityOf(tripReport.getVisibilityOfDownloadReport());
        String str = tripReport.visibilityOfDownloadReport();

        Assert.assertEquals("reportLinkBtn", str);
    }

    @Test(priority = 3)
    public void verifyBusBookingReport() throws MalformedURLException, InterruptedException {
        loginPageTest.verifyValidLogin();
        TripReportPage tripReport = new TripReportPage();

        waitForVisibilityOf(tripReport.getBusReportTab());
        tripReport.goTOReportTab();

        waitForVisibilityOf(tripReport.getCabReportTab());
        tripReport.goToCabReportTab();

        waitForVisibilityOf(tripReport.getBusReportStartDateInput());
        tripReport.enterStartDate("05/01/2018");

        waitForVisibilityOf(tripReport.getBusReportEndDateInput());
        tripReport.enterEndDate();

        waitForVisibilityOf(tripReport.getBusReportEndDateInput());
        tripReport.enterEndDate("05/10/2018");

        waitForVisibilityOf(tripReport.getBookings());
        tripReport.selectBookings();

        waitForVisibilityOf(tripReport.getGetReport());
        tripReport.getReport();

        waitForVisibilityOf(tripReport.getVisibilityOfDownloadReport());
        String str = tripReport.visibilityOfDownloadReport();

        Assert.assertEquals("reportLinkBtn", str);
    }
    @Test(priority = 4)
    public void verifyCabBookingReport() throws MalformedURLException, InterruptedException {
        loginPageTest.verifyValidLogin();
        TripReportPage tripReport = new TripReportPage();

        waitForVisibilityOf(tripReport.getBusReportTab());
        tripReport.goTOReportTab();

        waitForVisibilityOf(tripReport.getBusReportStartDateInput());
        tripReport.enterStartDate("05/01/2018");

        waitForVisibilityOf(tripReport.getBusReportEndDateInput());
        tripReport.enterEndDate();

        waitForVisibilityOf(tripReport.getBusReportEndDateInput());
        tripReport.enterEndDate("05/10/2018");

        waitForVisibilityOf(tripReport.getBookings());
        tripReport.selectBookings();

        waitForVisibilityOf(tripReport.getGetReport());
        tripReport.getReport();

        waitForVisibilityOf(tripReport.getVisibilityOfDownloadReport());
        String str = tripReport.visibilityOfDownloadReport();

        Assert.assertEquals("reportLinkBtn", str);


    }



}
