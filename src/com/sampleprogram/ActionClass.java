package com.sampleprogram;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.SearchContext;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

public class ActionClass 
{
	WebElement mens;
	WebDriver driver;
	Actions action;
	ActionClass()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Documents\\chromedriver.exe" );
		driver=new ChromeDriver();
		action =new Actions(driver);
		
	}
	
	public void loadUrl() 
	{
		 //System.setProperty("webdriver.chrome.driver","C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Documents\\chromedriver.exe" );
		driver.navigate().to("https://www.myntra.com/");
		driver.manage().window().maximize();	
			
	}
	public void openSectionTab()
	{
		
		mens=driver.findElement(By.xpath("//a[contains(text(),'Mens')]"));	
		action.moveToElement(mens).build().perform();
	}

}
