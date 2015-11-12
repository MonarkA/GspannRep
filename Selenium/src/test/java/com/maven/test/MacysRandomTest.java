package com.maven.test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MacysRandomTest {

	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setup() {
		driver.get("http://www.macys.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority=0)
	public void test() throws InterruptedException {
		driver.findElement(By.id("closeButton")).click();
		int noOfMainMenu = driver.findElements(By.xpath("//div[@id='globalMastheadCategoryMenu']/ul/li")).size();
		clickOnMainMenu(noOfMainMenu);
		Thread.sleep(5000);
		int noOfSubMenu = driver.findElements(By.xpath("//div[contains(@class,'flyout-on')]/descendant::a")).size();
		clickOnSubMenu(noOfSubMenu);
	}

	@Test(priority=1)
	public void checkFilterLink() {
		Assert.assertEquals("filter by", driver.findElement(By.xpath("//div[@id='globalContentContainer']//div[@id='navigation']//span[@id='navNarrowResultSpan']")).getText());
	}

	@Test(priority=2)
	public void rightArrowClickAndCheck() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='paginateTop']/a[contains(@class,'arrowRight arrowButton')]")).click();
		Thread.sleep(7000);
		Assert.assertEquals("2", driver.findElement(By.xpath("//div[@id='paginateTop']/a[@class='currentPage paginationSpacer']")).getText());
	}

	@Test(priority=3)
	public void lefrArrowClickAndCheck() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='paginateTop']/a[contains(@class,'arrowLeft arrowButton')]")).click();
		Thread.sleep(7000);
		Assert.assertEquals("1", driver.findElement(By.xpath("//div[@id='paginateTop']/a[@class='currentPage paginationSpacer']")).getText());
	}

	private void clickOnSubMenu(int noOfSubMenu) throws InterruptedException {
		String prepareRandomXpath = "//div[contains(@class,'flyout-on')]/descendant::a["+getRandomElement(noOfSubMenu)+"]";
		WebElement element = driver.findElement(By.xpath(prepareRandomXpath));
		System.out.println("Clicking on Sub Menu : "+element.getText());
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("arguments[0].click();", element);
	}

	public void clickOnMainMenu(int noOfMainMenu) {
		String prepareRandomXpath = "//div[@id='globalMastheadCategoryMenu']/ul/li["+getRandomElement(noOfMainMenu)+"]";
		WebElement element = driver.findElement(By.xpath(prepareRandomXpath));
		System.out.println("Clicking on Main Menu : "+element.getText());
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	private int getRandomElement(int maxElements) {
		return new Random().nextInt(maxElements);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
