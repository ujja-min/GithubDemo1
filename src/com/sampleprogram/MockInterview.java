package com.sampleprogram;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MockInterview 
{
	WebElement tes;
	static WebDriver driver;
	MockInterview()
	{
		driver=new ChromeDriver();
		// to use implictwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void geturl() throws InterruptedException 
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Documents\\chromedriver.exe" );
		 driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
			driver.manage().window().maximize();
			Thread.sleep(2000);		
	}
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		MockInterview mi =new MockInterview();
		mi.geturl();

	}

}
