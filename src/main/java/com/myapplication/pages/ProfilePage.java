package com.myapplication.pages;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;

import com.myapplication.qa.base.TestBase;

	public class ProfilePage extends TestBase {
		
		//an alternate way to find elements using @FindBy annotation /page object repositories
		//defining page libraries
//		@FindBy(xpath="//*[@id=\"mount_0_0_Ez\"]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div/div/div[3]/div/div[1]/div/div/div/div/div[2]/div/div[1]/span")
//		WebElement Rememberme;
//	
		
		//@FindBy(xpath="//input[@type='submit']") //This xpath works also
		@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div/div/div[3]/div/div[1]/div/div/div/div/div[2]/div/div[1]/span")
		private WebElement Remember;
	
		//LoginPage constructor will initialize LoginPage objects/variables above using WebDriver
		public ProfilePage() {
			PageFactory.initElements(driver, this);
		}
		 
		//returns title of the page
		public String validateLoginPageTitle() {
			return driver.getTitle();	
		}
		
		public String getRememberText() {
			return Remember.getText();
	}	
}
