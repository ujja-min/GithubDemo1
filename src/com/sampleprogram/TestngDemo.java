package com.sampleprogram;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestngDemo 
{
		WebElement tes;
		static WebDriver driver;
		TestngDemo()
		{
			driver=new ChromeDriver();
			// to use implictwait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
  @BeforeTest
  public void geturl() throws InterruptedException 
	{
		 
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Documents\\chromedriver.exe" );
		  System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver-win64\\chromedriver.exe" );
		 driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
			driver.manage().window().maximize();
			Thread.sleep(2000);		
	}
  
  
  
  

}
