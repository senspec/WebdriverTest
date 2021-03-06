package com.way2automation.twitter.testcases;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import ErrorCollectors.ErrorCollector;

import com.way2automation.twitter.config.Configuration;
import com.way2automation.twitter.core.testCore;
import com.way2automation.twitter.pages.twitEditProfile;
import com.way2automation.twitter.pages.twitLandingPage;
import com.way2automation.twitter.pages.twitLoginPage;
import com.way2automation.twitter.pages.twitMyProfile;
import com.way2automation.twitter.utils.Utility;
import com.way2automation.twitter.utils.excel_reader;

public class LoginTest extends testCore {
	
	//excel_reader xls;
	
	@BeforeTest
	//@Parameters({ "test-name" })
	public void checkRunMode(){
		
	//xls = new excel_reader(System.getProperty("user.dir")+"\\src\\com\\way2automation\\twitter\\testdata\\testdata.xlsx");
		
		System.out.println("Before Test Execution");
		if(!Utility.isExecutable("LoginTest", excel))
			throw new SkipException("Skipping the test");
		
	}
	
	@Test(dataProvider="getData")
	public void sampleTest(String username, String password) throws InterruptedException{
		
		System.out.println("Username from Sheet:" + username);
		
		/*WebDriver driver = new FirefoxDriver();
		driver.get(Configuration.testsite);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		*/
		twitLoginPage lp = PageFactory.initElements(driver, twitLoginPage.class);
		//lp.doLogin(username, password);
		try{
		Assert.assertEquals(driver.getTitle(), "yahoo.com");
		}catch(Throwable t){
			
			ErrorCollector.addVerificationFailure(t);
			//System.out.println("Error occurred");
		}
		
		//twitLandingPage landingpage = lp.doLogin(username, password);
		twitLandingPage landingpage = lp.doLogin(username, password);
		System.out.println("End of Login Page");
		//Thread.sleep(30000);
		//twitLandingPage search = landingpage.gotoSearch();
		twitMyProfile profile = landingpage.gotoProfile();
		twitEditProfile editprofile = profile.editProfile();
		editprofile.changePic();
		
		
		
	}

	@DataProvider
	public Object [][] getData(){
		
		System.out.println("Username from Sheet is:");
		//return test data from the sheetname provided
		
		return Utility.getData("LoginTest",excel);
	}
	

}
