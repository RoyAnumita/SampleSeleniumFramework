package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//a[@class='nav-main-link' and text()='Our Offers']")
	WebElement ourOfferlink;

	@FindBy(xpath = "//li//a[text()='Banks']")
	WebElement banksLink;

	@FindBy(xpath = "//a[text()='About']")
	WebElement aboutLink;

	@FindBy(xpath = "//a[text()='Become a Partner']")
	WebElement becomeAPartnerlink;

	@FindBy(xpath = "//a[@class='menu-item-link-login btn btn-secondary-ghost']")
	WebElement myAccountButton;

	@FindBy(xpath = "//a[@class='menu-item-link-register btn btn-secondary']")
	WebElement RegisterButton;

	@FindBy(xpath = "//div[@class='modal-header']//button[@class='close']//span")
	WebElement dismissAlert;

	@FindBy(xpath = "//select[@id='field-country_choice']")
	WebElement country;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()='OK']")
	WebElement okAlert;

	By heading = By.xpath("//h1[@class='cards-widget-headline text-center']");
	
	public boolean ourOfferIsPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(ourOfferlink));
		return ourOfferlink.isDisplayed();
	}
	
	public boolean bankIsPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(banksLink));
		return banksLink.isDisplayed();
	}
	
	public void clickOnOurOffer() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(ourOfferlink));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ourOfferlink);
	}

	public void clickOnBank() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(ourOfferlink));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", banksLink);
	}

	public void clickOnMyAccountLink() {
		myAccountButton.click();
	}

	public void clickOnRegisterButton() {
		RegisterButton.click();
	}

	public String getApplicationTitle() {
		return driver.getTitle();
	}

	public void dismissPopup() {
		dismissAlert.click();
	}

	public void selectRegion(String Region) {
		if (country.isDisplayed()) {
			Select drpCountry = new Select(country);
			drpCountry.selectByVisibleText(Region);
			okAlert.click();
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.presenceOfElementLocated(heading));

		} else
			dismissPopup();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(heading));
	}
}
