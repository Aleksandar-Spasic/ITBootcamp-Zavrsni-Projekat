package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTests extends BasicTests{

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
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(),
				"Message did not appear, meal is not added to favorites.");
	}

	@Test(priority = 5, enabled = true)
	public void clearCart() throws IOException {
		driver.get(mealsPageURL);
		locationPopupPage.selectLocation(location);

		File file = new File("data/Data.xlsx");
		FileInputStream fileStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fileStream);
		XSSFSheet sheetForm = wb.getSheet("Meals");

		String XMLmealURL;
		for (int i = 1; i < 6; i++) {
			XMLmealURL = sheetForm.getRow(i).getCell(0).getStringCellValue();
			driver.get(XMLmealURL);
			mealPage.clickOnAddToCartButton();
			sa.assertTrue(notificationPage.waitAlertSuccessToAppear(), "Message is not visible.");
		}
		wb.close();

		cartPage.clickOnClearCartButton();
		Assert.assertTrue(notificationPage.waitAlertSuccessToAppear(),
				"Message did not appear, cart items are not cleared.");

		sa.assertAll();
	}
}
