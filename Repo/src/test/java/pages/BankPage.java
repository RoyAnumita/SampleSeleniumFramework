package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankPage {

	WebDriver driver;

	public BankPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	By countryRatingLabel = By.xpath("//span[@class='bank-archive-item-country-rating-score']");
	By getBanksLabel = By.xpath("//div[@class='bank-archive-vertical-align']//a");
	@FindBy(xpath = "//a[@class='bank-product-cta btn btn-primary btn-lg' and text()='Invest now']")
	WebElement investNowButton;

	public String clickLearnMoreForMoodysCountryRating(String rating)

	{
		List<WebElement> countryRating = driver.findElements(countryRatingLabel);
		List<WebElement> getBanks = driver.findElements(getBanksLabel);
		String getRates = null;
		for (int i = 0; i < countryRating.size(); i++) {
			getRates = countryRating.get(i).getText();
			if (getRates.equals(rating)) {
				System.out.println(countryRating.get(i).getText());
				getBanks.get(i).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}

		}
		return getRates;

	}

	public void clickinvestNowButton() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(investNowButton));
		investNowButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
