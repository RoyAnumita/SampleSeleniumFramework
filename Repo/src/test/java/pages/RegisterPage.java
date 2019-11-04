package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//div[@class='rate']//span")
	WebElement rateSelected;

	@FindBy(xpath = "//h3[text()='Register with Raisin now']")
	WebElement rasinRegistrationHeader;

	public String getRasinRegistrationPage() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(rasinRegistrationHeader));
		String registrationHeader = rasinRegistrationHeader.getText();
		return registrationHeader;
	}

	public String getSelectedRate() {
		String rate = rateSelected.getText();
		return rate;
	}

}
