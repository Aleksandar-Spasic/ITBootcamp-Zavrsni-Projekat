package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage extends BasicPage{
	public AuthorizationPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}
	
	// Elements
	public WebElement getUserMenu() {
		return driver.findElement(By.xpath("//*[@id='header']//*[@class='filled ']/a"));
	}
	public WebElement getLogoutLink() {
		return driver.findElement(By.xpath("//*[@id='header']//*[@class='my-account-dropdown']/ul/li[2]"));
	}
	
	// Click
	public void clickOnUserMenu() {
		getUserMenu().click();
	}
	public void clickOnLogoutLink() {
		getLogoutLink().click();
	}

	// Methods
	public void logout() throws InterruptedException {
		clickOnUserMenu();
		Thread.sleep(500);
		clickOnLogoutLink();
	}
}
