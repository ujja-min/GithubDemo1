package com.sampleprogram;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class PractiseTest 
{
	WebElement tes;
	static WebDriver driver;
	
	PractiseTest()
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
		
		public void selectRadiobutton()
		{
			System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			
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
		
		public void getDropdown() throws InterruptedException
		{
			 // dynamic dropdown select with parent child traverse(without index)
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
			driver.findElement(By.xpath("//a[@value='BLR']")).click();
			Thread.sleep(2000);
			//index not used
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
				
		}
		
		public void selectCalendar()
		{
			driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']")).click();
		}
		
		public void selectAdvancedDropdown() throws InterruptedException
		{
			driver.findElement(By.id("divpaxinfo")).click();
			Thread.sleep(3000);
			//to select values multiple time by While loop
			int i=1;
//			
			//same process to selectt multiple times using For loop
			for(i=1;i<5;i++)
			{
				driver.findElement(By.id("hrefIncAdt")).click();
				
			}
			driver.findElement(By.id("btnclosepaxoption")).click();
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			//Assertions used
			Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		}
		
		
		public void selectDropdown()
		{
			//dropdown with select tag
			WebElement staticdropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			Select dropdown= new Select(staticdropdown);
			//to select the options by providing index on dropdown and print
			dropdown.selectByIndex(3);
			//System.out.println(dropdown.getFirstSelectedOption().getText());
			
			//to select the options by providing text on dropdown and print
//			dropdown.selectByVisibleText("AED");
//			System.out.println(dropdown.getFirstSelectedOption().getText());
			
			//to select the options by providing value on dropdown and print
			dropdown.selectByVisibleText("INR");
			System.out.println(dropdown.getFirstSelectedOption().getText());
		}
		
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
		PractiseTest ps =new PractiseTest();
		ps.geturl();
		ps.autoSuggestive();
		//ps.selectRadiobutton();
		ps.getDropdown();
		ps.selectCalendar();
		ps.selectAdvancedDropdown();
		ps.selectDropdown();
		ps.selectCheckbox();
		//to click on search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
//
		
	
	}

}
