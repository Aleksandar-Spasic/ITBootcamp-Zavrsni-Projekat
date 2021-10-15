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
	public WebElement getAlertSuccess() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	}
	public WebElement getAlertDanger() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--danger')]"));
	}

	// Methods
	public boolean waitAlertSuccessToDisappear() {
		try {
			wait.until(ExpectedConditions.attributeContains(getAlertSuccess(), "style", "none"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean waitAlertSuccessToAppear() {
		try {
			wait.until(ExpectedConditions.attributeContains(getAlertSuccess(), "style", "block"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean waitAlertDangerToDisappear() {
		try {
			wait.until(ExpectedConditions.attributeContains(getAlertDanger(), "style", "none"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean waitAlertDangerToAppear() {
		try {
			wait.until(ExpectedConditions.attributeContains(getAlertDanger(), "style", "block"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
