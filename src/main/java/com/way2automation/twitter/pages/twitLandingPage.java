package com.way2automation.twitter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.way2automation.twitter.config.Configuration;

public class twitLandingPage {
	
	
	WebDriver driver;
	
	public twitLandingPage(WebDriver driver){
		
		this.driver = driver;
		
	}
	
		
	@FindBy(xpath=Configuration.profile)
	public WebElement profile;
	@FindBy(xpath=Configuration.tweets)
	public WebElement tweets;
	@FindBy(xpath=Configuration.following)
	public WebElement following;
	@FindBy(xpath=Configuration.followers)
	public WebElement followers;
	
//	public twitLandingPage gotoSearch(){
//		search.sendKeys("Senthil");
//		return PageFactory.initElements(driver, twitLandingPage.class);
//	}
	
	public twitMyProfile gotoProfile() throws InterruptedException {
		
		//System.out.println("Senthil");
		
		//new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(profile));
		//Thread.sleep(60000);
		Thread.sleep(6000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-container']/div[1]/div[1]/div/div[1]/div/a")));
		
		
		
		profile.click();
		
		System.out.println("Senthil Completed");
		//Thread.sleep(6000);
		
		return PageFactory.initElements(driver, twitMyProfile.class);
	}
	
	public twitMyProfile gotoTweets() {
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-container']/div[1]/div[1]/div/div[2]/ul/li[1]/a/span[1]")));
		
		tweets.click();
		
		//Thread.sleep(6000);
		
		return PageFactory.initElements(driver, twitMyProfile.class);
	}
	
	public void gotoFollowing(){
		
		following.click();
		
	}
	
	public void gotoFollowers(){
		
		followers.click();
	}

}
