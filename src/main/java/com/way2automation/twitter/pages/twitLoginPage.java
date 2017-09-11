package com.way2automation.twitter.pages;

import org.openqa.selenium.By;

//import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.way2automation.twitter.config.Configuration;

public class twitLoginPage {
	
	
	WebDriver driver;
	
	public twitLoginPage(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	@FindBy(xpath=Configuration.username)
	public WebElement username;
	
	@FindBy(how = How.XPATH, using = Configuration.password)
	public WebElement password;
	
	@FindBy(xpath=Configuration.signin)
	public WebElement signin;
	
	//Business Login
	public twitLandingPage doLogin(String myusername, String mypassword) throws InterruptedException {
		
		System.out.println("Senthil Start Login");
		username.sendKeys(myusername);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-container']/div/div[1]/form/fieldset/div[2]/input")));
		password.sendKeys(mypassword);
		//Thread.sleep(6000);
	
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-container']/div/div[1]/form/div[2]/button")));
		//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='page-container']/div/div[1]/form/div[2]/button")));
		signin.submit();
		Thread.sleep(6000);
		
		return PageFactory.initElements(driver, twitLandingPage.class); 
		//Initialise Pagefactory for landing page
	}

}
