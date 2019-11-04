package utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

	static WebDriver driver;

	public static String captureScreenshot(WebDriver driver, String screenshotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = ".\\Screenshots\\" + screenshotName
				+ System.currentTimeMillis() + ".png";

		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {

			System.out.println("Failed to capture screenshots " + e.getMessage());
		}

		return destination;
	}

	public static WebElement waitForElement(WebDriverWait wait,By ele) {
		wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		return element;
	}

	public static void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	// Separate numbers from String
	public static String drawDigitsFromString(String strValue) {
		String str = strValue.trim();
		String digits = "";
		for (int i = 0; i < str.length(); i++) {
			char chrs = str.charAt(i);
			if (Character.isDigit(chrs))
				digits = digits + chrs;
		}
		return digits;
	}
	public static void dissmissPopupIfAny() {
	if(driver.switchTo().alert() != null)
	{
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
	}
}
}
