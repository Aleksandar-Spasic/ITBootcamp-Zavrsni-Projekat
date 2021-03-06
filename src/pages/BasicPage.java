package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BasicPage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	protected JavascriptExecutor js;

	public BasicPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		js = (JavascriptExecutor) this.driver;
	}
}
