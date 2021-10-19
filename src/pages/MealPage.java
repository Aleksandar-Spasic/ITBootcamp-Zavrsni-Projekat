package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{
	public MealPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	
	}

	// Elements
	public WebElement getQuantityInput() {
		return driver.findElement(By.xpath("//input[@name='product_qty']"));
	}
	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'js-proceedtoAddInCart')]"));
	}
	public WebElement getAddToFavoriteButton() {
		return driver.findElement(By.xpath("//a[@id='item_119']"));
	}
	
	// Set
	public void setQuantity(String value) {
		getQuantityInput().click();
		getQuantityInput().sendKeys(Keys.chord(Keys.CONTROL + "a"));
		getQuantityInput().sendKeys(value);
	}

	// Clicks
	public void clickOnAddToCartButton() {
		getAddToCartButton().click();
	}
	public void clickOnAddToFavoriteButton() {
		getAddToFavoriteButton().click();
	}
}
