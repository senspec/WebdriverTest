package com.way2automation.twitter.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

public class LandingPageTest extends testCore {
	
	//excel_reader xls;

	@BeforeTest
	public void checkRunMode(){
		
		//xls = new excel_reader(System.getProperty("user.dir")+"\\POMwithFactory\\src\\com\\way2automation\\twitter\\testdata\\testdata.xlsx");
		
		if(!Utility.isExecutable("LandingPageTest", excel))
			throw new SkipException("Skipping the test");
		
	}
	
	@Test(dataProvider="getData")
	public void sampleTest(String username, String password) throws Throwable{
		
//		WebDriver driver = new FirefoxDriver();
//		driver.get(Configuration.testsite);
//		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
//		
		twitLoginPage lp = PageFactory.initElements(driver, twitLoginPage.class);
		try{
		Assert.assertEquals(driver.getTitle(), "yahoo.com");
		}catch(Throwable t){
			
			
			ErrorCollector.addVerificationFailure(t);
			//System.out.println("Error occurred");
		}
		
		twitLandingPage landingpage = lp.doLogin(username, password);
		//twitLandingPage landingpage = lp.doLogin("MohanSenthil228", "Nehasenthil2208");
		twitMyProfile profile = landingpage.gotoTweets();
		twitEditProfile editprofile = profile.editProfile();
		editprofile.changePic();
		
		
		
	}
	
	

	@DataProvider
	public Object [][] getData(){
		
		//return test data from the sheetname provided
		
		return Utility.getData("LoginTest",excel);
	}
	

}
