package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.Helper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pages.HomePage;
import pages.OfferPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class TC01_VerifyEasyAccessFunctionalityInOurOfferPage {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUP() {

		report = new ExtentReports(".\\Reports\\LogiEasyAccessFunctionalityReport.html", true);

		logger = report.startTest("Verify Easy Access Functionality In Our Offer Page");
		/* Launch the browser */
		driver = BrowserFactory.getBrowser("Chrome");
		/* Go to Raisin landing page (www.raisin.com) */
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
		/* Choose Other from the list of regions */
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.selectRegion("Other");
		logger.log(LogStatus.INFO, "Click on Our Offer link");
		home.clickOnOurOffer();
	}

	@Test
	public void testEasyAccessFunctionalityInOurOfferPage() {
		
		OfferPage offer = PageFactory.initElements(driver, OfferPage.class);
		logger.log(LogStatus.INFO, "Test Story 1");
		logger.log(LogStatus.INFO, "Check the Easy Access checkbox");
		offer.clickEasyAccessCheck();
		logger.log(LogStatus.INFO, logger
				.addScreenCapture(Helper.captureScreenshot(driver, "Validation1 - Able to click on Easy Access Check box")));
		logger.log(LogStatus.INFO,
				"Need to verify that the message regarding the total of offers that match the search is correctly shown in the blue bar just below the search filter.");
		offer.checkBarColor();
		String label = offer.getEasyAccessLabel();
		System.out.println(label);
		String totalOffers = Helper.drawDigitsFromString(label);
		String label2 = offer.getOfferMatchfromSearch();
		String totalOfferMatchfromSearch = Helper.drawDigitsFromString(label2);
		System.out.println("Total Offers Match fromSearch"+totalOfferMatchfromSearch);
		Assert.assertEquals(totalOffers, totalOfferMatchfromSearch,
				"The total of offers did not matched the search correctly shown in the blue bar");
		
		 offer.clickshowMoreOffersButton(); int totOffer = offer.getTotalOffer();
		 String sTotOffer=String.valueOf(totOffer);
		 System.out.println("Total offers fetched from list:"+sTotOffer);
		 Assert.assertEquals(totalOfferMatchfromSearch, sTotOffer,
		 "The total of offers in the  search did not mactch from the total result displayed"); 
		 logger.log(LogStatus.PASS, "The message regarding the total of offers that match the search is correctly shown.");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}

		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
