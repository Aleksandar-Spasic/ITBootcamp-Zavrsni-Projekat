package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {
	public LocationPopupPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Elements
	public WebElement getLocationHeader() {
		return driver.findElement(By.xpath("//*[@class='location-selector']"));
	}
	public WebElement getCloseButton() {
		return driver.findElement(By.xpath("//*[@class='close-btn close-btn-white']"));
	}
	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	// Methods
	public void selectLocation(String locationName) {
		getKeyword().click();
		getLocationItem(locationName).click();
		clickOnSubmit();
	}

	// Clicks
	public void clickOnLocationHeader() {
		getLocationHeader().click();
	}
	public void clickOnSubmit() {
		getSubmit().click();
	}
	public void clickOnCloseButton() {
		getCloseButton().click();
	}
}
