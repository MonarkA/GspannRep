package com.maven.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngAnnotationTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite1");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test1");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("after Test1");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before class1");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("After class1");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before Method1");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method1");
	}
	
	@Test
	public void test1(){
		System.out.println("Test 1 in 1");
	}
	
	@Test
	public void test2(){
		System.out.println("Test 2 in 1");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("after suite1");
	}
}
