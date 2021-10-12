package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.*;

abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait wait;

	// Pages
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected NotificationSystemPage notificationPage;
	protected CartSummaryPage cartPage;
	protected MealPage mealPage;
	protected ProfilePage profilePage;
	protected SearchResultPage searchResultPage;

	// URLs
	protected String baseURL = "https://demo.yo-meals.com/";
	protected String loginPageURL = baseURL + "guest-user/login-form";
	protected String profilePageURL = baseURL + "member/profile";

	// Credentials
	protected String username = "customer@dummyid.com";
	protected String password = "12345678a";

	// Avatar Path
	protected String avatarPath = "\\img\\Surda.jpg";

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		locationPopupPage = new LocationPopupPage(driver, wait);
		loginPage = new LoginPage(driver, wait);
		profilePage = new ProfilePage(driver, wait);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
