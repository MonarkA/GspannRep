package com.src.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	WebDriver driver;
	By hotelsLink = By.id("hotelsAndLounges");
	By hotelsAndLonge = By.xpath("//a[@id='hotelsAndLounges']/../descendant::a[2]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void hoverOverHotels() {
		new Actions(driver).moveToElement(driver.findElement(hotelsLink)).build().perform();
	}

	public HotelsAndLonge clickOnHotelsAndLonge() {
		driver.findElement(hotelsAndLonge).click();
		return new HotelsAndLonge(driver);
	}

}
