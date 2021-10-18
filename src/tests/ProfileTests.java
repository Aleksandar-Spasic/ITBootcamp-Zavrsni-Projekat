package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTests{

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
		profilePage.uploadImage(System.getProperty("user.dir") + avatarPath);
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
	
}
