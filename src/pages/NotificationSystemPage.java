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
	public WebElement getMessageAlert() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]"));
	}

	// Methods
	public String getMessageText() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success')]/div/div/ul/li")).getText();
	}

	public void waitForMsgToDisappear() {
		wait.until(ExpectedConditions.attributeContains(getMessageAlert(), "hidden", "hidden"));
	}
}
