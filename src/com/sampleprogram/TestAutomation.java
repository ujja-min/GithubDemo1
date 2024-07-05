package com.sampleprogram;

public class TestAutomation
{

	public static void main(String[] args) throws InterruptedException 
	{
		 //TODO Auto-generated method stub
		GoogleAutomation ga=new GoogleAutomation();
		ga.geturl();
		ga.searchText();
		ga.enterData();
		
		//ga.getPassword();
		ga.loginPage();
		//ga.logoutPage();
		ga.searchAnchorTag();
//		//ga.Frameswitching();
//		ga.openSectionTab();
//		ga.clickButton();
//		ActionClass as=new ActionClass();
//		as.loadUrl();
//		as.openSectionTab();	
		
	}

	
}
