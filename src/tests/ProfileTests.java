package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTests{

	@Test(priority = 1, enabled = true)
	public void editProfile() throws InterruptedException {
		driver.get(loginPageURL);
		locationPopupPage.clickOnCloseButton();
		loginPage.login(username, password);
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Login Successfull"),
				"Message did not appear, login was not successful.");
		
		driver.get(profilePageURL);
		profilePage.setFirstNameField(firstName);
		profilePage.setLastNameField(lastName);
		profilePage.setAddressField(address);
		profilePage.setPhoneField(phone);
		profilePage.setZipcodeField(zip);
		profilePage.clickOnSave();
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Setup Successful"),
				"Message did not appear, setup was not successful.");

		authorizationPage.logout();
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Logout Successfull"),
				"Message did not appear, logout was not successful.");
	}

	@Test(priority = 2, enabled = true)
	public void changeProfileImage() throws InterruptedException, AWTException {
		driver.get(loginPageURL);
		loginPage.login(username, password);
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Login Successfull"),
				"Message did not appear, login was not successful.");
		
		Thread.sleep(1500);
		driver.get(profilePageURL);
		Thread.sleep(1500);
		profilePage.uploadImage(System.getProperty("user.dir") + avatarPath);
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Uploaded Successfully"),
				"Message did not appear, image is not uploaded.");

		notificationPage.waitAlertSuccessToDisappear();
		profilePage.clickOnRemove();
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Deleted Successfully"), "Message did not appear, image is not removed.");

		notificationPage.waitAlertSuccessToDisappear();
		authorizationPage.logout();
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Logout Successfull"),
				"Message did not appear, logout was not successful.");
	}

}
