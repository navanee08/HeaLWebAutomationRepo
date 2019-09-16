package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library {

	public Library(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public static void sendKeys(WebDriver driver, WebElement element, int timeOut, String value) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void click(WebDriver driver, WebElement element, int timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	

}
