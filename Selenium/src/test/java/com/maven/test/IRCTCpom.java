package com.maven.test;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.src.pages.ECateringCheckoutPage;
import com.src.pages.ECateringHome;
import com.src.pages.HomePage;
import com.src.pages.HotelsAndLonge;

public class IRCTCpom {

	WebDriver driver;
	private String parentWindow;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/");
	}

	@Test
	public void testIRCTC() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		setParentWindow(driver.getWindowHandle());
		homePage.hoverOverHotels();

		HotelsAndLonge hotelLonge = homePage.clickOnHotelsAndLonge();
		switchToChildWindow();
		Assert.assertEquals(Arrays.asList(hotelLonge.topLinks),	hotelLonge.getTopLinksAsList());

		ECateringHome eCater = hotelLonge.clickOnEcateringLink();
		eCater.enterStationCodeDelhi("Delhi");
		eCater.selectDLICode();

		ECateringCheckoutPage eCaterCheckOut = eCater.clickSearchButton();
		eCaterCheckOut.clickOnCheckoutBtn();
		Assert.assertEquals(eCaterCheckOut.expectedAlertText, eCaterCheckOut.getAlertText());
		eCaterCheckOut.acceptAlert();
		eCaterCheckOut.clickOnReplanOrder();
		Assert.assertEquals("Rs. 0", eCaterCheckOut.getTotalAmmount());
	}

	public void switchToChildWindow() {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(getParentWindow()))
				driver.switchTo().window(window);
		}
	}

	public String getParentWindow() {
		return parentWindow;
	}

	public void setParentWindow(String parentWindow) {
		this.parentWindow = parentWindow;
	}

	@AfterTest
	public void exit() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
