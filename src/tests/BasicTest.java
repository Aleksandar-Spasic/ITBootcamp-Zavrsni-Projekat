package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
	protected AuthorizationPage authorizationPage;

	// URLs
	protected String baseURL = "https://demo.yo-meals.com/";
	protected String loginPageURL = baseURL + "guest-user/login-form";
	protected String profilePageURL = baseURL + "member/profile";
	protected String mealPageURL = baseURL + "meal/lobster-shrimp-chicken-quesadilla-combo";

	// Credentials
	protected String username = "customer@dummyid.com";
	protected String password = "12345678a";

	// Avatar Path
	protected String avatarPath = "\\img\\Surda.jpg";

	// Inputs
	protected String firstName = "Borivoje";
	protected String lastName = "Surdilovic";
	protected String address = "Topolska 18";
	protected String phone = "808080";
	protected String zip = "11000";

	@BeforeClass
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
		notificationPage = new NotificationSystemPage(driver, wait);
		cartPage = new CartSummaryPage(driver, wait);
		mealPage = new MealPage(driver, wait);
		searchResultPage = new SearchResultPage(driver, wait);
		authorizationPage = new AuthorizationPage(driver, wait);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(1000);
//		driver.quit();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
