package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;


import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		switch(browser.toLowerCase())
		{
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
				
		case "msedge" :
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;	
			
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;	
		
		default:
			driver = null;
			break;				
		}
		//impilicit wait of 10 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for logging
		logger = LogManager.getLogger("MyStoreV1");
		
		//Open Url
		driver.get(url);
		logger.info("url opened");
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
	//Capture screenshot
	public void captureScreenshot(WebDriver driver, String testName) throws IOException
	{
		//Step1: convert webdriver object to TakeScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver); 
		
		//Step:2 call getScreenshotAs method to create image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
		//Step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}
	
	
}
