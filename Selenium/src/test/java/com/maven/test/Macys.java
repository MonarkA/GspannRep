package com.maven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Macys {
	WebDriver driver =  new FirefoxDriver();
	
	@Test
	public void searchText() throws InterruptedException{
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.macys.com/");
		
		driver.findElement(By.id("closeButton")).click();
		
		driver.findElement(By.id("globalSearchInputField")).sendKeys("Jeans");
		Thread.sleep(5000);
		driver.findElement(By.id("subnavSearchSubmit")).click();
		
		System.out.println("Url after clicking on search button : "+driver.getCurrentUrl());
		clickOnBoysCheckbox();
	}
	
	public void clickOnBoysCheckbox() {
		
		driver.findElement(By.id("GENDER")).click();
		driver.findElement(By.xpath("//span[text()='Boys']")).click();
		
	}
	
}
