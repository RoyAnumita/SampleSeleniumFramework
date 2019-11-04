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
import pages.BankPage;
import pages.HomePage;
import pages.RegisterPage;
import utility.Helper;

public class TC03_VerifyInvestNowButtonIsRedirectingToTheRegisterForm {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUP() {

		report = new ExtentReports(".\\Reports\\BankPageReport.html", true);
		logger = report.startTest("Verify Invest Now Button Is Redirecting To The Register Form");
		/* Launch the browser */
		driver = BrowserFactory.getBrowser("Chrome");
		/* Go to Raisin landing page (www.raisin.com) */
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		logger.log(LogStatus.INFO, "Application is up and running");
		/* Choose Other from the list of regions */
		home.selectRegion("Other");
		logger.log(LogStatus.INFO, "Click on Bank link");
		home.clickOnBank();
	}

	@Test
	public void testOfferWithHighestInterest() {
		BankPage bank = PageFactory.initElements(driver, BankPage.class);
		RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
		logger.log(LogStatus.INFO, "Test Story 3");
		logger.log(LogStatus.INFO, "Look for the bank with a Moody's Country rating = A1");
		String getRate=bank.clickLearnMoreForMoodysCountryRating("A1");
		Assert.assertEquals(getRate, "A1", "The Rating is not found");
		logger.log(LogStatus.PASS, "Rating found as expected");
		bank.clickinvestNowButton();
		String header = register.getRasinRegistrationPage();
		Assert.assertEquals(header, "Register with Raisin now", "The Header is incorrect");
		logger.log(LogStatus.PASS, "Page Redirected to  the Register form");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		/* Take screenshot for failed test cases */
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}

		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
