package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails 
{
	// Create object of webdriver
		WebDriver ldriver;
		
		//Constructor
		public accountCreationDetails (WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		//identify web elements
		@FindBy(id = "id_gender1")
		WebElement titleMr;
		
		@FindBy(id="customer_firstname")
		WebElement custfirstName;
		
		@FindBy(id = "customer_lastname")
		WebElement custlastName;
		
		@FindBy(id = "passwd")
		WebElement password;
		
		@FindBy(id="firstname")
		WebElement addfirstname;
		
		@FindBy(id = "lastname")
		WebElement addLastname;
		
		@FindBy(id = "address1")
		WebElement address1;
		
		@FindBy(id = "city")
		WebElement city;
		
		@FindBy(id = "id_state")
		WebElement state;
		
		@FindBy(id = "postcode")
		WebElement postcode;
		
		@FindBy(id = "id_country")
		WebElement country;
		
		@FindBy(id = "phone_mobile")
		WebElement phone_mobile;
		
		@FindBy(id = "alias")
		WebElement alias;
		
		@FindBy(id = "submitAccount")
		WebElement register;
		
		
		//identify action on webelement
		public void selectTitleMr()
		{
			titleMr.click();
		}
		
		
		public void enterCustomerFirstName(String fname)
		{
			custfirstName.sendKeys(fname);
		}
		
		public void enterCustomerLastName(String lname)
		{
			custlastName.sendKeys(lname);
		}
		 public void enterPassword(String pwd)
		 {
			 password.sendKeys(pwd);
		 }
		public void enterAddressFirstName(String fname)
		{
			addfirstname.clear();
			addfirstname.sendKeys(fname);
		}
		
		public void enterAddressLastName(String lname)
		{
			addLastname.clear();
			addLastname.sendKeys(lname);
		}
		
		public void enterAddress(String address)
		{
			address1.sendKeys(address);
		}
		
		public void enterCity(String cityName)
		{
			city.sendKeys(cityName);
		}
		public void enterState(String text )
		{
			Select obj = new Select(state);
			obj.selectByVisibleText(text);			
		}
		public void enterPostCode(String postcodeData)
		{
			postcode.sendKeys(postcodeData);
		}
		
		public void enterCountry(String text )
		{
			Select obj = new Select(country);
			obj.selectByVisibleText(text);			
		}
		
		public void enterMobilePhone(String mobile)
		{
			phone_mobile.sendKeys(mobile);
		}
		public void enterAlias(String text)
		{
			alias.clear();
			alias.sendKeys(text);
		}
		public void clickOnRegister()
		{
			register.click();
		}
		
		
		
}

