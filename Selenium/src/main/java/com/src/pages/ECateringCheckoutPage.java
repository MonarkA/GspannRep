package com.src.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ECateringCheckoutPage {

	WebDriver driver;
	By checkoutButton = By.className("cartbtn");
	By replanOrder = By.xpath("//div[@id='headnavR']/a[3]");
	By totalAmount = By.xpath(".//*[@id='totalAmount']/h2/strong");

	public String expectedAlertText = "Your Cart is empty.Please select some product before checkout.";

	public ECateringCheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnCheckoutBtn() {
		driver.findElement(checkoutButton).click();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void clickOnReplanOrder() {
		driver.findElement(replanOrder).click();
	}

	public String getTotalAmmount() {
		return driver.findElement(totalAmount).getText();
	}

}
