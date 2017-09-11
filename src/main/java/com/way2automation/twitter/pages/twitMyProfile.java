package com.way2automation.twitter.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.way2automation.twitter.config.Configuration;

public class twitMyProfile {
	
	
	
	
	WebDriver driver;
	
	public twitMyProfile(WebDriver driver) throws IOException{
		
		this.driver = driver;
		
		
	}

	
	@FindBy(xpath=Configuration.editbutton)
	public WebElement editbutton;
	
	public twitEditProfile editProfile() throws InterruptedException {
		
		//System.out.println("Senthil_Profile");
		
		Thread.sleep(6000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[7]/div/button")));
		
		editbutton.click();
		
		//Thread.sleep(6000);
		
		return PageFactory.initElements(driver, twitEditProfile.class);
		
		
	}
	
}
