package com.maven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MavenDemo {
	
	@Test
	public void testGmailLogin() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com");

		driver.findElement(By.id("Email")).sendKeys("arora.monark111@gmail.com");
		driver.findElement(By.id("next")).click();
		
		driver.findElement(By.id("Passwd")).sendKeys("XYZ");
		driver.findElement(By.id("signIn")).click();
		
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		
		jsx.executeScript("arguments[0].innerHTML='shubham.mathur@gspann.com';", driver.findElement(By.xpath("//div[text()='Send']/ancestor::table[3]//form/descendant::div[4]/textarea")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		
	}
	
}
