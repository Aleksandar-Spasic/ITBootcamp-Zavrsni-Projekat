package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTests extends BasicTests {

	@Test(priority = 1, enabled = true)
	public void addMealToCart() throws InterruptedException {
		driver.get(lobsterPageURL);
		locationPopupPage.clickOnCloseButton();
		mealPage.setQuantity("3");
		mealPage.clickOnAddToCartButton();
		notificationPage.waitAlertDangerToAppear();
		Assert.assertTrue(notificationPage.getAlertDangerText().contains("Please Select Location"),
				"Message [please select location] did not appear");

		notificationPage.waitAlertDangerToDisappear();
		locationPopupPage.clickOnLocationHeader();
		locationPopupPage.selectLocation(location);
		notificationPage.waitAlertSuccessToDisappear();
		mealPage.setQuantity("2");
		mealPage.clickOnAddToCartButton();
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Meal Added To Cart"),
				"Message did not appear, meal is not added.");
	}

	@Test(priority = 2, enabled = true)
	public void addMealToFavorite() throws InterruptedException {
		driver.get(lobsterPageURL);
		mealPage.clickOnAddToFavoriteButton();
		Assert.assertTrue(notificationPage.getAlertDangerText().contains("Please login first!"),
				"Message [Please login first] did not appear.");

		driver.get(loginPageURL);
		loginPage.login(username, password);
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Login Successfull"),
				"Message did not appear, login was not successful.");

		driver.get(lobsterPageURL);
		mealPage.clickOnAddToFavoriteButton();
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Product has been added to your favorites."),
				"Message did not appear, meal is not added to favorites.");
		
		authorizationPage.logout();
		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("Logout Successfull"),
				"Message did not appear, logout was not successful.");
	}

	@Test(priority = 3, enabled = true)
	public void clearCart() throws IOException {
		driver.get(mealsPageURL);

		File file = new File("data/Data.xlsx");
		FileInputStream fileStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fileStream);
		XSSFSheet sheetForm = wb.getSheet("Meals");

		String XMLmealURL;
		for (int i = 1; i < 6; i++) {
			XMLmealURL = sheetForm.getRow(i).getCell(0).getStringCellValue();
			driver.get(XMLmealURL);
			mealPage.clickOnAddToCartButton();
//			notificationPage.waitAlertSuccessToAppear();
			sa.assertTrue(notificationPage.getAlertSuccessText().contains("Meal Added To Cart"),
					"Message did not appear, meal is not added.");
		}
		wb.close();

		cartPage.clickOnClearCartButton();
//		notificationPage.waitAlertSuccessToAppear();
		Assert.assertTrue(notificationPage.getAlertSuccessText().contains("All meals removed from Cart successfully"),
				"Message did not appear, cart items are not cleared.");

		sa.assertAll();
	}
}
