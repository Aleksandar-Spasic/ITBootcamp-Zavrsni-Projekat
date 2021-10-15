package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {

	public CartSummaryPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Elements
	public WebElement getClearCartButton() {
		return driver.findElement(By.xpath("//div[@class='cart-head']/a[2]"));
	}

	// Click
	public void clickOnClearCartButton() {
		getClearCartButton().click();
	}
}
