package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {
	public NotificationSystemPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Elements
	public WebElement getMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	}

	// Methods
	public boolean waitForMsgToDisappear() {
		try {
			wait.until(ExpectedConditions.attributeContains(getMessage(), "style", "none"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean waitForMsgToAppear() {
		try {
			wait.until(ExpectedConditions.attributeContains(getMessage(), "style", "block"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
