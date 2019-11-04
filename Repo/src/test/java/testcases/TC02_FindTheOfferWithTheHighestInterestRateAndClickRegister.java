package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.OfferPage;
import pages.RegisterPage;
import utility.Helper;

public class TC02_FindTheOfferWithTheHighestInterestRateAndClickRegister {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUP() {

		report = new ExtentReports(".\\Reports\\LoginPageReport.html", true);
		logger = report.startTest("Find The Offer With The Highest Interest Rate And Click Register");
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
	public void testOfferWithHighestInterest() {

		OfferPage offer = PageFactory.initElements(driver, OfferPage.class);
		RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
		logger.log(LogStatus.INFO, "Test Story 2");
		logger.log(LogStatus.INFO, "Check the Easy Access checkbox");
		offer.clickEasyAccessCheck();
		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "Clicked on Easy Access Check box")));
		logger.log(LogStatus.INFO, "Find the offer with the highest Interest rate in the list");
		offer.clickshowMoreOffersButton();
		double getHighestRate = offer.clickRegisterNowWithHighestInterestRates();
		System.out.println(getHighestRate);
		String highRATE = Double.toString(getHighestRate);
		System.out.println("highRATE"+highRATE);
		String header = register.getRasinRegistrationPage();
		System.out.println(header);
		String rate = register.getSelectedRate();
		Assert.assertEquals(header, "Register with Raisin now", "The Header is incorrect");
		Assert.assertEquals(rate, highRATE, "The Rate is incorrect");
		logger.log(LogStatus.INFO, logger.addScreenCapture(
				Helper.captureScreenshot(driver, "Clicked on Register Now for highest Interest Rates")));
		logger.log(LogStatus.PASS, "Page Redirected to the Register form");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		/* Take screenshot for failed test cases */
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		/* Close driver */
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
