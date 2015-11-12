package com.maven.test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IRCTCtest {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// div[@id='bluemenu']
	}

	@Test(priority = 0)
	public void clickOnFlights() throws InterruptedException {
		driver.get("https://www.irctc.co.in/");
		String parentWindowHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[text()='Flights']")).click();

		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentWindowHandle))
				driver.switchTo().window(windowHandle);
		}

		fillForm();
	}

	@Test(priority = 1)
	public void checkTotalFlights() {
		List<WebElement> elements = driver.findElements(By
				.xpath("//div[@id='flightListResult']/div"));
		System.out.println("Total flights are : " + elements.size());
	}

	@Test(priority = 2)
	public void checkMaxPrice() throws InterruptedException {
		// click on price header
		driver.findElement(By.id("minPrice")).click();
		Thread.sleep(3000);
		WebElement element = driver
				.findElement(By
						.xpath("//div[@id='flightListResult']/div[1]//span[@class='onewayprice'][1]"));
		System.out.println("Max price is : " + element.getText());
		Assert.assertTrue(checkPrice(Integer.parseInt(element.getText())));

	}

	public boolean checkPrice(int priceFrmUI) {
		if (priceFrmUI > 50000)
			return false;
		else
			return true;
	}

	public void fillForm() throws InterruptedException {
		driver.findElement(By.id("origin")).sendKeys("Delhi");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Delhi (New Delhi),DEL']"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.id("destination")).sendKeys("Jaipur,JAI");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Jaipur,JAI']")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("departDate")).sendKeys("13/11/2015");
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("noOfAdult")))
				.selectByVisibleText("2");
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("noOfChild")))
				.selectByVisibleText("1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='showdometic']/div[6]")).click();
		Thread.sleep(3000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
