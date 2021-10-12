package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Elements
	public WebElement getUsernameField() {
		return driver.findElement(By.xpath("//*[@name='username']"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.xpath("//*[@name='password']"));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	// Methods
	public void login(String username, String password) {
		getUsernameField().clear();
		getUsernameField().sendKeys(username);
		getPasswordField().clear();
		getPasswordField().sendKeys(password);
		getSubmitButton().click();
	}
}
