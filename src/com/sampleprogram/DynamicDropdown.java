package com.sampleprogram;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicDropdown 
{

	WebElement tes;
	static WebDriver driver;
	DynamicDropdown()
	
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
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
	}
	
	public void getDropdown() throws InterruptedException
	{
		 //dynamic dropdown with index
		/*driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
	driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
	//index used
	driver.findElement(By.xpath("(//a[@value='GWL'])[2]")).click();
	*/
	
		
		// dynamic dropdown select with parent child traverse(without index)
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		//index not used
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
			
	}
	
	
	//to handle dropdown which takes inputs from user
	public void autoSuggestive() throws InterruptedException
	{
		
	driver.findElement(By.id("autosuggest")).sendKeys("ind");
	Thread.sleep(2000);
	// used findelemets 
	List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	for(WebElement option: options)
	{
		if(option.getText().equalsIgnoreCase("India"))
				{
					option.click();
					break;	
				}
		
	}
			
	} 
	
	//to select calendar
		public void selectCalendar()
		{
			//to select current date from calendar with unique classname as highlight-active
			//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']")).click();
		}
		
		//to select radiobutton
		public void selectRadiobutton()
		{
			//to check fields are enabled or disabled
			//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		
		//to check fields enabled or disbaled based on style valu not only wrt UI color change
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Is Enabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		}
	
	// to have multiple checkbox selection
	public void selectCheckbox() throws InterruptedException
	{
	
		
		List<WebElement> checkboxs =driver.findElements(By.cssSelector("input[type='checkbox']"));;
		for(int i=0;i<checkboxs.size();i++)
		{
			if(checkboxs.get(i).isDisplayed()&& checkboxs.get(i).isDisplayed())
			{
					Thread.sleep(2000);
					 System.out.println("Checkbox is displayed at index : " + i + " Clicking on it now");
					 
					checkboxs.get(i).click();
					
				
			}
		}
		//deselect the checkbox on index 1 from the list of checkboxes selected above
				System.out.println("de-selecting checkbox with index 1");
				int i=1;
				checkboxs.get(i).click();
				if(checkboxs.get(i).isSelected())
				{
					System.out.println("Checkbox is still selected");
				}
				else
				{
					System.out.println("Checkbox is deselected successfully");
				}
			
		
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		DynamicDropdown  sd=new DynamicDropdown();
		sd.geturl();
		sd.getDropdown();
		sd.selectCalendar();
		//sd.selectRadiobutton();
		sd.autoSuggestive();
		sd.selectCheckbox();
		
	}

}
