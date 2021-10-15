package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import helper.Helper;

public class InitialTests extends BasicTest {

	@Test(priority = 0, enabled = false)
	public void login() throws InterruptedException {
		driver.get(loginPageURL);
		locationPopupPage.clickOnCloseButton();
		loginPage.login(username, password);
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(),
				"Message did not appear, login was not successful.");
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
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(),
				"Message did not appear, setup was not successful.");

		authorizationPage.logout();
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(),
				"Message did not appear, logout was not successful.");
	}

	@Test(priority = 2, enabled = false, dependsOnMethods = "login")
	public void changeProfileImage() throws InterruptedException, AWTException {
		driver.get(profilePageURL);
		Thread.sleep(1500);
		profilePage.clickOnUploadAvatar();
		Helper.pressEscape();
		Thread.sleep(1500);
		profilePage.uploadAvatar(System.getProperty("user.dir") + avatarPath);
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(),
				"Message did not appear, image is not uploaded.");

		notificationPage.waitAlertSuccessToDisappear();
		profilePage.clickOnRemove();
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(), "Message did not appear, image is not removed.");

		notificationPage.waitAlertSuccessToDisappear();
		authorizationPage.logout();
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(),
				"Message did not appear, logout was not successful.");
	}

	@Test(priority = 3, enabled = false)
	public void addMealToCart() throws InterruptedException {
		driver.get(lobsterPageURL);
		locationPopupPage.clickOnCloseButton();
//		mealPage.setQuantity("3");
		mealPage.clickOnAddToCartButton();
		Assert.assertTrue(notificationPage.waitAlertDangerToAppear(),
				"Message [please select location] did not appear");
		notificationPage.waitAlertDangerToDisappear();
		locationPopupPage.clickOnLocationHeader();
		locationPopupPage.selectLocation(location);
		notificationPage.waitAlertSuccessToDisappear();
//		mealPage.setQuantity("2");
		mealPage.clickOnAddToCartButton();
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(), "Message did not appear, meal is not added.");
	}
	
	@Test(priority = 4, enabled = false)
	public void addMealToFavorite() throws InterruptedException {
		driver.get(lobsterPageURL);
		locationPopupPage.clickOnCloseButton();
		mealPage.clickOnAddToFavoriteButton();
		Assert.assertTrue(notificationPage.waitAlertDangerToAppear(), "Message [Please login first] did not appear.");
		
		driver.get(loginPageURL);
		loginPage.login(username, password);
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(),
				"Message did not appear, login was not successful.");
		
		driver.get(lobsterPageURL);
		mealPage.clickOnAddToFavoriteButton();
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(), "Message did not appear, meal is not added to favorites.");
	}
	
	@Test(priority = 5, enabled = true)
	public void clearCart() {
		driver.get(mealsPageURL);
		locationPopupPage.selectLocation(location);
	}
}
