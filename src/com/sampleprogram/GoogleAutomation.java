package com.sampleprogram;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleAutomation 
{
	WebElement tes;
	static WebDriver driver;
	GoogleAutomation()
	{
		driver=new ChromeDriver();
		// to use implictwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	//@SuppressWarnings("deprecation")
	public void geturl() throws InterruptedException 
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Documents\\chromedriver.exe" );
		    //ChromeOptions options = new ChromeOptions();
			//options.setBinary("C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Desktop\\Automation\\chrome-win64\\chrome-win64\\chrome.exe");
			//WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		
	}
	
		public void searchText() throws InterruptedException
	{
		
	driver.findElement(By.id("inputUsername")).sendKeys("rahul",Keys.TAB);
	driver.findElement(By.name("inputPassword")).sendKeys("helloworld");
	driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/button")).click();
	//css selector invoke to get error message dispayed on page
	
	System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	//to use linktext
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(2000);
	}
		public void enterData() throws InterruptedException
		{
			
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul",Keys.TAB);
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rahul@gmail.com",Keys.TAB);
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("98765432130");
			//driver..findElement(By.xpath("//div[@class='forgot-pwd-btn-container']/button[1]")).click();
			driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
			Thread.sleep(3000);
			driver.navigate().refresh();
//			// reset button
//			driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
			
		}
//		//to get passowrd
//		public String getPassword()
//		{
//			String passwordText= driver.findElement(By.cssSelector("form p")).getText();
//			String[] passwordArray =passwordText.split("'");
//			String password = passwordArray[1].split("'")[0];
//			return password;
			
			
			//driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-container']/button[1]")).click();
			
			
		
								
public void loginPage() throws InterruptedException
{
				//print new values
				driver.findElement(By.id("inputUsername")).sendKeys("rahul",Keys.TAB);
				Thread.sleep(3000);
				System.out.println(driver.findElement(By.id("inputUsername")).getText());
				driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
				Thread.sleep(3000);
				System.out.println(driver.findElement(By.name("inputPassword")).getText());
				driver.findElement(By.id("chkboxOne")).click();			
				driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
				driver.getTitle();
				System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/p")).getText());					
				
			}
			
				
		public void logoutPage()
		{
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button")).click();
			//driver.close();
		}
	//to get list of all links,tags on page
	public void searchAnchorTag()
	{
		List<WebElement>list=driver.findElements(By.tagName("a"));
		Iterator<WebElement>it=list.iterator();
		while(it.hasNext())
		{
				System.out.println(it.next().getText());
				
		}
	}
	//to switch within frames in page http://demo.guru99.com/selenium/deprecated.html
		public static  void switchFrame()
		{
			driver.switchTo().frame("classFrame");
			driver.findElement(By.linkText("Deprecated")).click();
			System.out.println(driver.getTitle());
		}
//		public void Frameswitching()
//		{
//			//ChromeDriver driver= new ChromeDriver();
//		}
//		//switch to windows(new tab)
	
		public void openSectionTab()
		{
			
			driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"));	
					((WebElement) driver).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
			
		}
		// to click and get the text from alert box
		public void clickButton() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/div/div[2]/div[2]/button")).click();
			Thread.sleep(500);
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			
		}
		
	
}
	

