package com.maven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KohlsTest1 {

	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest(){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void setup() {
		driver.get("https://www.kohls.com/");
	}
	
	@Test(priority=1)
	public void assertMenTextURL() throws InterruptedException{
		driver.findElement(By.xpath("//a[text()='Men']")).click();
		Assert.assertTrue(IsURLContainsText(driver.getCurrentUrl(), "mens-clothing"));
	}
	
	@Test(priority=2)
	public void assertJeansTextURL() throws InterruptedException{
		driver.findElement(By.id("search")).sendKeys("Jeans");
		driver.findElement(By.name("submit-search")).click();
		Assert.assertTrue(IsURLContainsText(driver.getCurrentUrl(), "Jeans"));
	}
	
	public static boolean IsURLContainsText(String url, String textToMatch){
		return url.contains(textToMatch);
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}
	
}
