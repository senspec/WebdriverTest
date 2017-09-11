package com.way2automation.twitter.core;

import java.awt.LayoutManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.way2automation.twitter.utils.excel_reader;

public class testCore {
	
	public static Properties config = new Properties();
	
	public static Properties object = new Properties();
	
	public static WebDriver driver = null;
	
	public static excel_reader excel = null;
	
	public static Logger sel_logs = LogManager.getLogger();
	public static Logger app_logs =	LogManager.getLogger("devpinoyLogger");
	
	
	//public static Logger app_logs = LogManager.getLogger(testCore.class.getName());
			//Manager.
	
	//public static monitoringMail mail = new monitoringMail();
	
	@BeforeSuite
	public static void init() throws IOException{
		
		if(driver == null){
			
		
			
			//Load the Config Properties file
			//Logger sel_logs =	LogManager.getLogger();
			//Logger app_logs =	LogManager.getLogger("devpinoyLogger");
			
			//Logger app_logs = LogManager.getLogger("devpinoyLogger");
			//PropertyConfigurator.configure("Log4j.properties");
			
			System.out.println("Senthil Start");
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\way2automation\\twitter\\config\\config.properties");
			config.load(fis);
			app_logs.debug("Config property file loaded");
		
			//Load the Object Properties file
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\way2automation\\twitter\\config\\OR.properties");
			object.load(fis);
			app_logs.debug("Object property file loaded");
			
	
			//load the Excel file
			excel = new excel_reader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\way2automation\\twitter\\testdata\\testdata.xlsx");
			System.out.println("Excel Path:" + excel);
			app_logs.debug("Excel file loaded");
			//Initialize the WebDriver
			if(config.getProperty("browser").equals("firefox")){
			
				ProfilesIni prof = new ProfilesIni();
				FirefoxProfile ffProfile= prof.getProfile ("Senthil");
				ffProfile.setAcceptUntrustedCertificates(true);
				ffProfile.setAssumeUntrustedCertificateIssuer(false);
				System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.14.0-win64\\geckodriver.exe");
			//driver = new FirefoxDriver(ffProfile);
			driver = new FirefoxDriver(ffProfile);
			//driver = new FirefoxDriver()
			app_logs.debug("Firefox driver initialized");
			}else if(config.getProperty("browser").equals("ie")){
				
				
				System.setProperty("webdriver.ie.driver", "C:\\Softwares\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}else if(config.getProperty("browser").equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			driver.get(config.getProperty("testsite"));
			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
			
			
		}
		
		
		
		
	}
	
	
	@AfterSuite
	public static void testQuitDriver() {
		
		//code for sending mails
		//testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
		//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, "Test Report", "Please find the attached report", TestConfig.reportPath, "Reports.zip");
		
		//driver.quit();
		
		System.out.println("Test End");
		
	}
	

}
