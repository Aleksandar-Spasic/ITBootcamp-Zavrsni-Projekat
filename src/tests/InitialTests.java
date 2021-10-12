package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.testng.annotations.Test;

public class InitialTests extends BasicTest {

	@Test(priority = 0, enabled = false)
	public void test() {
		driver.get(baseURL);

		locationPopupPage.clickOnCloseButton();
	}

	@Test(priority = 0, enabled = false)
	public void locationPopup() throws InterruptedException {
		driver.get(baseURL);

		String locationName = "Arbor Hill - Albany";
		locationPopupPage.selectLocation(locationName);

		Thread.sleep(5000);
	}

	@Test(priority = 0, enabled = true)
	public void login() throws InterruptedException, AWTException {
		driver.get(loginPageURL);

		locationPopupPage.clickOnCloseButton();
		loginPage.login(username, password);

		driver.get(profilePageURL);
		Thread.sleep(1500);
		profilePage.clickOnUploadAvatar();

//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.ESCAPE);
//		actions.perform();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		Thread.sleep(2000);
		System.out.println(System.getProperty("user.dir"));
		profilePage.uploadAvatar(System.getProperty("user.dir") + avatarPath);

	}
}
