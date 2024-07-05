package com.sampleprogram;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class AlertsTest 
{

	WebElement tes;
	static WebDriver driver;
	AlertsTest()
	{
		driver=new ChromeDriver();
		// to use implictwait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void geturl() throws InterruptedException 
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\DNUJJA\\OneDrive - Capgemini\\Documents\\chromedriver.exe" );
		 driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			Thread.sleep(2000);		
	}
	
	//to get the alert displayed
	public void getAlert() throws InterruptedException
	{
		//to accept alert pop up without having any button except OK button
		String text="Jeeps";
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		//to accept alert pop up having OK or CANCEL buttons on it
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		//to accept alert
		driver.switchTo().alert().accept();
		// to click on cancel buyyon on alert
		driver.switchTo().alert().dismiss();
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		AlertsTest at =new AlertsTest();
		at.geturl();
		at.getAlert();

	}

}
