package com.src.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ECateringHome {

	WebDriver driver;

	By stationCodeTextbox = By.id("stnCode");
	By delhiCode = By.xpath("//li[@class='ui-menu-item'][text()='DELHI (DLI)']");
	By searchButton = By.xpath("//input[@id='stnCode']/following-sibling::input");

	public ECateringHome(WebDriver driver) {
		this.driver = driver;
	}

	public void enterStationCodeDelhi(String station) {
		driver.findElement(stationCodeTextbox).sendKeys(station);
	}

	public void selectDLICode() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(delhiCode).click();
	}
	
	public ECateringCheckoutPage clickSearchButton() {
		driver.findElement(searchButton).click();
		return new ECateringCheckoutPage(driver);
	}

}
