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

public class testngAnnotationTest2 {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite2");
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test2");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("after Test2");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before class2");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("After class2");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Before Method2");
	}
	
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method2");
	}
	
	@Test
	public void test1(){
		System.out.println("Test 1 in 2");
	}
	
	@Test
	public void test2(){
		System.out.println("Test 2 in 2");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("after suite2");
	}
}
