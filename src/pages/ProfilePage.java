package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {
	public ProfilePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.actions = new Actions(driver);
	}

	// Elements
	public WebElement getFirstNameField() {
		return driver.findElement(By.xpath("//*[@name='user_first_name']"));
	}
	public WebElement getLastNameField() {
		return driver.findElement(By.xpath("//*[@name='user_last_name']"));
	}
	public WebElement getAddressField() {
		return driver.findElement(By.xpath("//*[@name='user_address']"));
	}
	public WebElement getPhoneField() {
		return driver.findElement(By.xpath("//*[@name='user_phone']"));
	}
	public WebElement getZipcodeField() {
		return driver.findElement(By.xpath("//*[@name='user_zip']"));
	}
	public WebElement getAvatar() {
		return driver.findElement(By.xpath("//*[@class='avatar']/img"));
	}
	public WebElement getUploadButton() {
		return driver.findElement(By.xpath("//*[@title='Uplaod']"));
	}
	public WebElement getRemoveButton() {
		return driver.findElement(By.xpath("//*[@title='Remove']"));
	}	
	public WebElement getAvatarInput() {
		return driver.findElement(By.xpath("//body/form/input"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[@id='profileInfoFrmBlock']//input[@name='btn_submit']"));
	}
	
	// Click
	public void clickOnSave() {
		getSaveButton().click();
	}
	
	// Select
	public Select getCountry() {
		return new Select(driver.findElement(By.id("user_country_id")));
	}
	public Select getState() {
		return new Select(driver.findElement(By.id("user_state_id")));
	}
	public Select getCity() {

		return new Select(driver.findElement(By.id("user_city")));
	}
	
	// Methods
	public void clickOnUploadAvatar() {
		actions.moveToElement(driver.findElement(By.xpath("//*[@class='avatar']"))).perform();
		getUploadButton().click();
	}
	public void clickOnRemove() {
		actions.moveToElement(driver.findElement(By.xpath("//*[@class='avatar']"))).perform();
		getRemoveButton().click();
	}
	public void uploadAvatar(String path) {
		getAvatarInput().sendKeys(path);
	}
	
	// Set
	public void setFirstNameField(String string) {
		getFirstNameField().clear();
		getFirstNameField().sendKeys(string);;
	}
	public void setLastNameField(String string) {
		getLastNameField().clear();
		getLastNameField().sendKeys(string);;
	}
	public void setAddressField(String string) {
		getAddressField().clear();
		getAddressField().sendKeys(string);;
	}
	public void setPhoneField(String string) {
		getPhoneField().clear();
		getPhoneField().sendKeys(string);;
	}
	public void setZipcodeField(String string) {
		getZipcodeField().clear();
		getZipcodeField().sendKeys(string);;
	}
	public void setCountry(String string) {
		getCountry().selectByVisibleText(string);
	}
	public void setState(String string) {
		getState().selectByVisibleText(string);
	}
	public void setCity(String string) {
		getCity().selectByVisibleText(string);
	}
	
	//
	public void uploadImage(String image) throws InterruptedException {
		js.executeScript("arguments[0].click();", getUploadButton());
		Thread.sleep(2000);
		WebElement input = driver.findElement(By.xpath("//*[@id='form-upload']/input"));
		input.sendKeys(image);
	}
}
