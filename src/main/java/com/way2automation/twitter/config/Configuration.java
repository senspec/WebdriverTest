package com.way2automation.twitter.config;

public class Configuration {
	
	public static String testsite="http://twitter.com/login";
	//twitLoginPage
	public static final String username=".//*[@id='page-container']/div/div[1]/form/fieldset/div[1]/input";
	public static final String password=".//*[@id='page-container']/div/div[1]/form/fieldset/div[2]/input";
	public static final String signin=".//*[@id='page-container']/div/div[1]/form/div[2]/button";

	//twitLandingPage
	//public static final String search = ".//*[@id='search-query']";
	//public static final String profile="//a[@href='//MohanSenthil228']";
	public static final String profile=".//*[@id='page-container']/div[1]/div[1]/div/div[1]/div/a";
	public static final String tweets=".//*[@id='page-container']/div[1]/div[1]/div/div[2]/ul/li[1]/a/span[1]";
	//                                   .//*[@id='page-container']/div[1]/div[1]/div/div[2]/ul/li[1]/a/span[1]
	public static final String following="//*[@id='page-container']/div[1]/div[1]/div[2]/ul/li[2]/a";
	public static final String followers="//*[@id='page-container']/div[1]/div[1]/div[2]/ul/li[3]/a";


	//twitMyProfile
	public static final String editbutton=".//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[7]/div/button";
										   

	//twitEditProfile
	public static final String inlineediticon=".//*[@id='page-container']/div[3]/div/div[1]/div[4]/div[1]/div[2]/div[5]/button";
	public static final String uploadPhoto=".//*[@id='photo-choose-existing']/div/div/label/input";
	public static final String cancel=".//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[7]/div/div/button[1]";
	public static final String cancelmenu=".//*[@id='choose-photo']/div/div/ul/li[5]/button";
	
	

}
