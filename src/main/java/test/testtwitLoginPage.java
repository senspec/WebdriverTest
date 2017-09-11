package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.way2automation.twitter.config.Configuration;
import com.way2automation.twitter.pages.twitEditProfile;
import com.way2automation.twitter.pages.twitLandingPage;
import com.way2automation.twitter.pages.twitLoginPage;
import com.way2automation.twitter.pages.twitMyProfile;

public class testtwitLoginPage {
	
	public static Properties config = new Properties();
	
	
	
	public static void main(String[] args) throws IOException{
		/*
		FileInputStream fis = new FileInputStream("C:\\selenium\\POMusingPageFactory\\POMwithFactory\\src\\com\\way2automation\\twitter\\config\\OR.properties");
		config.load(fis);
		*/
		
		WebDriver driver = new FirefoxDriver();
		driver.get(Configuration.testsite);
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		twitLoginPage lp = PageFactory.initElements(driver, twitLoginPage.class);
		twitLandingPage landingpage = lp.doLogin("seleniumcoaching@gmail.com", "Selenium1234");
		twitMyProfile profile = landingpage.gotoProfile();
		twitEditProfile editprofile = profile.editProfile();
		editprofile.changePic();
		
	}

}
