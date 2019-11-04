package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.Helper;

public class OfferPage {

	WebDriver driver;
	WebDriverWait wait;

	public OfferPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//input[@id='early_termination_cb']")
	WebElement easyAccessCheck;
	@FindBy(xpath = "//input[@id='local_currency_cb']")
	WebElement onlyEUROOfferCheck;
	@FindBy(xpath = "//button[text()='Show more offers']")
	WebElement showMoreOffersButton;
	@FindBy(xpath = "//label[@class='label-checkbox ng-binding']")
	WebElement easyAccessLabel;
	@FindBy(xpath = "//button[@ng-click='click_show_more_button()']")
	WebElement showMoreOffersVisibility;
	@FindBy(xpath = "//div[@class='row no-gutters']")
	WebElement barColor;
	By interestRates = By.xpath("//div[@class='prot-offer-header-interest-value ng-binding']");
	public By offerLoadHeader = By.xpath("//div[starts-with(@id,'prot-item')]");
	public By listRegisterNow = By.xpath("//a[@class='product-cta ng-scope']");
	public By tenthRate = By.xpath("(//div[@class='prot-offer-header-interest-rate'])[10]");

	public void clickEasyAccessCheck() {
		easyAccessCheck.click();
		Helper.implicitWait(20);
	}

	public void clickonlyEUROOfferCheck() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(onlyEUROOfferCheck));
		onlyEUROOfferCheck.click();
		Helper.implicitWait(10);
	}

	public void clickshowMoreOffersButton() {
		showMoreOffersVisibility.click();
		wait = new WebDriverWait(driver, 20);
		Helper.waitForElement(wait, tenthRate);
	}

	public String getEasyAccessLabel() {
		String easyAccessText = easyAccessLabel.getText();
		return easyAccessText;

	}

	public String getOfferMatchfromSearch() {
		String OfferMatchfromSearchText = easyAccessLabel.getText();
		return OfferMatchfromSearchText;
	}

	public int getTotalOffer() {
		List<WebElement> forms = driver.findElements(offerLoadHeader);
		int count = forms.size();
		return count;
	}

	public double getHighestInterestRates() {
		double maxInterest = 0;

		List<WebElement> rates = driver.findElements(interestRates);
		for (int i = 0; i < rates.size(); i++) {
			System.out.println(rates.get(i).getText());
			if (maxInterest <= Double.parseDouble(rates.get(i).getText())) {
				maxInterest = Double.parseDouble(rates.get(i).getText());
			}
		}
		return maxInterest;
	}

	public double clickRegisterNowWithHighestInterestRates() {
		double maxInterest = 0;
		List<WebElement> rates = driver.findElements(interestRates);
		List<WebElement> liRegisterNow = driver.findElements(listRegisterNow);
		for (int i = 0; i < rates.size(); i++) {
			System.out.println(rates.get(i).getText());
			if (maxInterest <= Double.parseDouble(rates.get(i).getText())) {
				maxInterest = Double.parseDouble(rates.get(i).getText());
				System.out.println("The highest Interest Rate from the list is " + maxInterest);
				liRegisterNow.get(i).click();
				Helper.implicitWait(20);
				break;
			}
		}

		return maxInterest;
	}

	public void checkBarColor() {
		String barCol = barColor.getCssValue("color");
		Assert.assertEquals(barCol, "rgba(64, 64, 64, 1)", "The color is not Blue");

	}
}