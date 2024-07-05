package com.sampleprogram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdown 
{
	WebElement tes;
	static WebDriver driver;
	StaticDropdown()
	{
		
		driver=new ChromeDriver();
		// to use implictwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	public void geturl() throws InterruptedException 
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Documents\\chromedriver.exe" );
		    //ChromeOptions options = new ChromeOptions();
			//options.setBinary("C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Desktop\\Automation\\chrome-win64\\chrome-win64\\chrome.exe");
			//WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
	}
	public void selectDropdown()
	{
		//dropdown with select tag
		WebElement staticdropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown= new Select(staticdropdown);
		//to select the options by providing index on dropdown and print
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//to select the options by providing text on dropdown and print
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//to select the options by providing value on dropdown and print
		dropdown.selectByVisibleText("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}
	public void selectAdvancedDropdown() throws InterruptedException
	{
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		//to select values multiple time by While loop
		int i=1;
//		while(i<5)
//		{
//			driver.findElement(By.id("hrefIncAdt")).click();
//			i++;
//		}
//		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//same process to selectt multiple times using For loop
		for(i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		//Assertions used
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
	}
	
	

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		StaticDropdown  sd=new StaticDropdown();
		sd.geturl();
		//sd.selectDropdown();
		//sd.selectAdvancedDropdown();
		
		
		
	}

}
