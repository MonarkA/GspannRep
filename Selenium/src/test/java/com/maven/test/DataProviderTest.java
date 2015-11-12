package com.maven.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority=0)
	public void test() throws InterruptedException {
		driver.get("https://www.irctc.co.in/");
		Thread.sleep(3000);
	}

	@Test(priority=1,dataProvider="loginData")
	public void testLogin(Object username, Object password) throws InterruptedException {
		driver.findElement(By.id("usernameId")).clear();
		driver.findElement(By.id("usernameId")).sendKeys(String.valueOf(username));
		Thread.sleep(3000);
		driver.findElement(By.className("loginPassword")).clear();
		driver.findElement(By.className("loginPassword")).sendKeys(String.valueOf(password));
		Thread.sleep(3000);
		driver.findElement(By.id("loginbutton")).click();
		driver.switchTo().alert().accept();
	}
	
	@DataProvider
	public Object[][] loginData() throws IOException {
		FileInputStream file = new FileInputStream("C:/Users/Admin/Downloads/TestData.xlsx");
		XSSFWorkbook testDataworkbook = new XSSFWorkbook(file);
		XSSFSheet testDataSheet = testDataworkbook.getSheetAt(0);
		XSSFRow row = testDataSheet.getRow(0);
		
		int rows = testDataSheet.getLastRowNum();
		int columns = row.getLastCellNum();
		Object[][] testData = new Object[rows][columns];
		
		for(int testDataRow=0;testDataRow<rows;testDataRow++){
			for(int testDataColumn=0;testDataColumn<columns;testDataColumn++){
				testData[testDataRow][testDataColumn]=testDataSheet.getRow(testDataRow+1).getCell(testDataColumn);
			}
		}
		
		for(int testDataRow=0;testDataRow<rows;testDataRow++){
			for(int testDataColumn=0;testDataColumn<columns;testDataColumn++){
				System.out.println(testData[testDataRow][testDataColumn]);
			}
		}
		return testData;
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
