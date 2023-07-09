package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;


public class TC_MyAccountPageTest extends BaseClass
{
	@Test
	public void verifyRegistrationAndLogin()
	{
		
		
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("clicked on sign in link");
		
		myAccount myAcpg = new myAccount(driver);
		myAcpg.enterCreateEmailAddress("sagardarekar80@gmail.com");
		logger.info("Email adress entered in create account section");
		
		myAcpg.clickSubmitCreate();
		logger.info("clicked on create an account button");
		
		accountCreationDetails accCreationPg = new accountCreationDetails(driver);
		accCreationPg.selectTitleMr();
		accCreationPg.enterCustomerFirstName("Sagar");
		accCreationPg.enterCustomerLastName("Darekar");
		accCreationPg.enterPassword("Darekar@123");
		accCreationPg.enterAddressFirstName("Sagar");
		accCreationPg.enterAddressLastName("Darekar");
		accCreationPg.enterAddress("Latur");
		accCreationPg.enterCity("Killari");
		accCreationPg.enterState("Alabama");
		accCreationPg.enterPostCode("413516");
		accCreationPg.enterCountry("United States");
		accCreationPg.enterMobilePhone("9764773655");
		accCreationPg.enterAlias("Home");
		logger.info("entered use details an account creation page");
		accCreationPg.clickOnRegister();
		logger.info("Clicked on registred button");
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();
		
		Assert.assertEquals("Sagar Darekar", userName);
	}
	
	@Test
	public void VerifyLogin() throws IOException
	{
		logger.info("verifyLogin test case execution started...");
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("clicked on sign in link");
		
		myAccount myAcpg = new myAccount(driver);
		myAcpg.enterEmailAddress("sagardarekar80@gmail.com");
		logger.info("Entered email address");
		myAcpg.enterPassword("Darekar@123");
		logger.info("Entered password");
		myAcpg.clickSubmit();
		logger.info("Clicked on submit button");
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();
		
		if(userName.equals("Sagar Darekar"))
		{
			logger.info("verify login - passed");
			
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("verify login - Failed");
			captureScreenshot(driver,"VerifyLogin");
			Assert.assertTrue(true);
			
		}
	}
	
	
}
