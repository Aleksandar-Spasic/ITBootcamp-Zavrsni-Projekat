package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import helper.Helper;

public class InitialTests extends BasicTest {

	@Test(priority = 0, enabled = true)
	public void login() throws InterruptedException {
		driver.get(loginPageURL);
		locationPopupPage.clickOnCloseButton();
		loginPage.login(username, password);
		Assert.assertTrue(notificationPage.waitForMsgToAppear(), "Message did not appear, login was not successful.");
	}

	@Test(priority = 1, enabled = false, dependsOnMethods = "login")
	public void editProfile() throws InterruptedException {
		driver.get(profilePageURL);
		profilePage.setFirstNameField(firstName);
		profilePage.setLastNameField(lastName);
		profilePage.setAddressField(address);
		profilePage.setPhoneField(phone);
		profilePage.setZipcodeField(zip);
		profilePage.clickOnSave();
		Assert.assertTrue(notificationPage.waitForMsgToAppear(), "Message did not appear, setup was not successful.");

		authorizationPage.logout();
		Assert.assertTrue(notificationPage.waitForMsgToAppear(), "Message did not appear, logout was not successful.");
	}

	@Test(priority = 2, enabled = false, dependsOnMethods = "login")
	public void changeProfileImage() throws InterruptedException, AWTException {
		driver.get(profilePageURL);
		Thread.sleep(1500);
		profilePage.clickOnUploadAvatar();
		Helper.pressEscape();
		Thread.sleep(1500);
		profilePage.uploadAvatar(System.getProperty("user.dir") + avatarPath);
		Assert.assertTrue(notificationPage.waitForMsgToAppear(), "Message did not appear, image is not uploaded.");

		notificationPage.waitForMsgToDisappear();
		profilePage.clickOnRemove();
		Assert.assertTrue(notificationPage.waitForMsgToAppear(), "Message did not appear, image is not removed.");

		notificationPage.waitForMsgToDisappear();
		authorizationPage.logout();
		Assert.assertTrue(notificationPage.waitForMsgToAppear(), "Message did not appear, logout was not successful.");
	}

	@Test(priority = 3, enabled = true)
	public void addMealToCart() {
		driver.get(mealPageURL);
		locationPopupPage.clickOnCloseButton();
		mealPage.setQuantity("3");

	}
}
