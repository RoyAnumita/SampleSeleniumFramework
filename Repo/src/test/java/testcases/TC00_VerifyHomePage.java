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
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class TC00_VerifyHomePage {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUP() {

		report = new ExtentReports(".\\Reports\\HomePageReport.html", true);
		logger = report.startTest("Verify Home Page");
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
	}

	@Test
	public void testHomePage() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.getApplicationTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Raisin"));
		logger.log(LogStatus.PASS, "Home Page loaded and verified");
		home.selectRegion("Other");
		Boolean offer = home.ourOfferIsPresent();
		Boolean bank = home.bankIsPresent();
		Assert.assertTrue(offer, "Offer Link Not found");
		Assert.assertTrue(bank, "Bank Link Not found");

		logger.log(LogStatus.INFO,
				logger.addScreenCapture(Helper.captureScreenshot(driver, "Validation of links present")));

		logger.log(LogStatus.PASS, "Our Offer link is present");
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
