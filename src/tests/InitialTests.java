package tests;

import org.testng.annotations.Test;

import pages.LocationPopupPage;

public class InitialTests extends BasicTest {

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);

		LocationPopupPage locationPopup = new LocationPopupPage(driver, wait);
		String locationName = "Arbor Hill - Albany";

		locationPopup.selectLocation(locationName);
		
		Thread.sleep(5000);
	}
}
