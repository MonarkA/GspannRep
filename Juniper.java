package com.maven.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Juniper {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 120);
	}

	@Test(priority = 0)
	public void test() {
		driver.get("http://www.juniper.net/");
		waitForPageLoad();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));
	}

	@Test(priority = 1)
	public void getLinks() {
		List<WebElement> elements = driver.findElements(By
				.xpath("//a[not(@href='')]"));

		for (WebElement element : elements) {
			System.out.println(element.getText());
		}
		System.out.println("Total Elements : " + elements.size());
	}

	public void waitForPageLoad() {

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor jsExec = (JavascriptExecutor) driver;
				return (Boolean) jsExec.executeScript(
						"return document.readyState").equals("complete");
			}
		});

	}
}
