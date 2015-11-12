package com.src.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HotelsAndLonge {

	WebDriver driver;
	JavascriptExecutor jsx;

	public String[] topLinks = { "HOME", "TOUR PACKAGE", "FLIGHTS",
			"ACCOMMODATION", "CAB/BUS", "TOURIST TRAINS" };

	By mainMenu = By.xpath("//ul[@id='main-menu']/li[not(@class='more')]/a");
	By eCateringLink = By.xpath("//li[@class='more']/descendant::a[2]");

	public HotelsAndLonge(WebDriver driver) {
		this.driver = driver;
		jsx = (JavascriptExecutor) driver;
	}

	public ArrayList<String> getTopLinksAsList() {
		ArrayList<String> mainMenuText = new ArrayList<String>();
		List<WebElement> mainMenuLinks = driver.findElements(mainMenu);
		for (WebElement mainMenuLink : mainMenuLinks) {
			mainMenuText.add(mainMenuLink.getText().toUpperCase());
		}

		return mainMenuText;
	}

	public ECateringHome clickOnEcateringLink() {
		jsx.executeScript("arguments[0].click();", driver.findElement(eCateringLink));
		return new ECateringHome(driver);
	}

}
