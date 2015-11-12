package com.maven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KohlsTest2 {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://www.kohls.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void assertMenTextURL() throws InterruptedException{
		driver.findElement(By.xpath("//a[text()='Men']")).click();
		Assert.assertTrue(KohlsTest1.IsURLContainsText(driver.getCurrentUrl(), "mens-clothing"));
	}
	
	@Test(priority=2)
	public void assertJeansTextURL() throws InterruptedException{
		driver.findElement(By.id("search")).sendKeys("Jeans");
		driver.findElement(By.name("submit-search")).click();
		Assert.assertTrue(KohlsTest1.IsURLContainsText(driver.getCurrentUrl(), "Jeans"));
	}
	
	@AfterMethod
	public void afterTest(){
		driver.quit();
	}
	
}
