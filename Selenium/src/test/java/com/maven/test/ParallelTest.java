package com.maven.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {

	WebDriver driver;

	@Test(priority=0)
	@Parameters(value="browser")
	public void openBrowsers(String browser) {
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver_win32/chromedriver.exe");
				driver = new ChromeDriver();
		}
	}
	
	@Test(priority = 1)
	public void test() {
		driver.get("http://www.juniper.net/");
	}

	@Test(priority = 2)
	public void getLinks() {
		List<WebElement> elements = driver.findElements(By
				.xpath("//a[not(@href='')]"));

		for (WebElement element : elements) {
			System.out.println(element.getText());
		}
		System.out.println("Total Elements : " + elements.size());
	}

	@AfterTest
	public void exit(){
		driver.quit();
	}
	
}
