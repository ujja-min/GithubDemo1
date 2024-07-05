package PageobjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AstractComponents.AbstractComponents;

public class LoginlandingPage 
{
	WebDriver driver;
	
	////creating live driver from Standalone.java program code and below cod eis executed first always
	
	public LoginlandingPage(WebDriver driver)
	{
		//initialising the driver to locate elements
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//// code executed alwarys first end
	
	////page factory start to locate elements wthout any actions
	@FindBy(id="userEmai")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordElement;
	
	@FindBy(id="login")
	WebElement login;

		//// page factory start to locate elements wthout any actionsend
	
	////actions on elements are done by passing value from the testcase or StandAlone code.POM will nnt use hardcoded data
	////POM just tarnverse the data provided in test script without keeping data
	public void LoginUrl()
	{
		 driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void LoginPageActions(String email,String password)
	{
		userEmail.sendKeys(email);//passing email
		passwordElement.sendKeys(password);//passing password
		login.click();//clicking on login button action
	}
}

	
	
	
	

