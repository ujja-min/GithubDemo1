package com.sampleprogram;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@SuppressWarnings("unused")
public class AssessmentTest 
{
	WebElement tes;
	static WebDriver driver;
	AssessmentTest()
	{
		driver=new ChromeDriver();
		// to use implictwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
		public void geturl() throws InterruptedException 
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Documents\\chromedriver.exe" );
		driver.navigate().to("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		
	}
		public void searchText() throws InterruptedException
		{
			
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("deepikaujja10@gmail.com",Keys.TAB);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("helloworld",Keys.TAB);
		driver.findElement(By.name("company")).sendKeys("Capgemini Technology Service",Keys.TAB);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/section[2]/div/div[1]/div/div[1]/div/div/div[1]/div/div/div/input[2]")).sendKeys("9876543235",Keys.TAB);
		driver.findElement(By.cssSelector("input[id='inp_val']")).sendKeys("testing 1");
		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.cssSelector("input[type='email']")).getText());
//		System.out.println(driver.findElement(By.cssSelector("input[type='password']")).getText());
//		System.out.println(driver.findElement(By.name("company")).getText());
//		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/section[2]/div/div[1]/div/div[1]/div/div/div[1]/div/div/div/input[2]")).getText());
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/section[2]/div/div[1]/div/div[1]/div/div/button")).click();
//		Thread.sleep(2000);
		driver.close();
		}
	
}
