package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage 
{
	// Create object of webdriver
	WebDriver ldriver;
	
	//Constructor
	public indexPage (WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//identify web elements
	@FindBy(linkText = "Sign In")
	WebElement signIn;
	
	//identify action on webelement
	public void clickOnSignIn()
	{
		signIn.click();
	}
}
