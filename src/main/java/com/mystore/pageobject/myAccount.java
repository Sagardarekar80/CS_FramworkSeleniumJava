package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount 
{
	// Create object of webdriver
	WebDriver ldriver;
	
	//Constructor
	public myAccount (WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//identify web elements
	//create new account
	@FindBy(id = "email_create")
	WebElement createEmailId;
	
	@FindBy(id = "SubmitCreate")
	WebElement SubmitCreate;
	
	//Already registered users
	@FindBy(id = "email")
	WebElement RegistredUsersEmail;
	
	@FindBy(id = "passwd")
	WebElement RegistredUsersPwd;
	
	@FindBy(id = "SubmitLoginn")
	WebElement submitLogin;
	
	//identify action on webelement
	public void enterCreateEmailAddress(String emailAdd)
	{
		createEmailId.sendKeys(emailAdd);
	}
	public void clickSubmitCreate()
	{
		SubmitCreate.click();
	}
	
	//Actions methods for already registered users
	
	public void enterEmailAddress(String emailAdd)
	{
		RegistredUsersEmail.sendKeys(emailAdd);
	}
	public void enterPassword(String pwd)
	{
		RegistredUsersPwd.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		submitLogin.click();
	}	
}