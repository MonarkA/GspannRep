package com.maven.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jetty.websocket.client.masks.RandomMasker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JuniperExcel {
	WebDriver driver;
	JavascriptExecutor jsx;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		jsx = (JavascriptExecutor) driver;
	}

	@Test
	public void myTest() throws FileNotFoundException, IOException, InterruptedException {
		driver.get("http://www.juniper.net/");
		ArrayList<String> links = new ArrayList<String>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		for(WebElement element :elements){
			links.add(element.getText());
		}
		writeLinks(links);

		for(int i=0;i<5;i++){
			String randomLink = getRandomUrl(links);
			if(!randomLink.isEmpty()){
				jsx.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='"+randomLink+"']")));
				Thread.sleep(5000);
			}
			else
				System.out.println("Link not exist!!!");
		}
	}

	@AfterTest
	public void quit(){
		driver.quit();
	}

	public String getRandomUrl(ArrayList<String> links) throws IOException{
		XSSFWorkbook testDataworkbook = new XSSFWorkbook("JuniperExcelTest.xlsx");
		XSSFSheet testDataSheet = testDataworkbook.getSheetAt(0);
		XSSFRow row = testDataSheet.getRow(new Random().nextInt(links.size()));
		return row.getCell(0).getStringCellValue();
	}

	public void writeLinks(ArrayList<String> links) throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("JuniperTestSheet");

		int rowCount = 0;
		for (String link : links) {
			Row row = sheet.createRow(rowCount++);
			Cell cell = row.createCell(0);
			cell.setCellValue(link);
		}

		workbook.write(new FileOutputStream("JuniperExcelTest.xlsx"));

	}

}
