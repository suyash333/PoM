package com.myapplication.testcases;
import com.myapplication.pages.*;
import com.myapplication.qa.base.TestBase;
import com.myapplication.utils.RetryFailedTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginPageTests extends TestBase {


	LoginPage LP ;
	ProfilePage PP;
	RetryFailedTestCases RFT;
	//constructor calls TestBase method
	public LoginPageTests() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		//sets driver, manages windows, and timeouts
		initialization();
		LP = new LoginPage();
		PP = new ProfilePage();
		RFT = new RetryFailedTestCases();
	}

	//@BeforeMethod
	//public void setup() {

	//LP = PageFactory.initElements(initialization(), LoginPage.class);
	//PP = PageFactory.initElements(initialization(), ProfilePage.class);
	//}


	@Test(priority =1, retryAnalyzer = com.myapplication.utils.RetryFailedTestCases.class,  description = "test to check if test filed testNg will retry or not")

	public void Test1_RTRY()
	{

		Assert.assertEquals(false, true);
	}


	@Test(priority =12, retryAnalyzer = com.myapplication.utils.RetryFailedTestCases.class)

	public void getTitleTest() {

		String title = LP.validateLoginPageTitle();

		if( RFT.getcurrRetryCount() == 0) {
			System.out.println("Retry count fetched= "+ RFT.getcurrRetryCount());
			Assert.assertEquals(title, "Facebook");
		} else 
			if( RFT.getcurrRetryCount() == 1) {
				System.out.println("Retry count fetched= "+ RFT.getcurrRetryCount());
				Assert.assertEquals(title, "Facebook - लॉग इन या साइन अप करें");


			}

	}

	@Test(priority =3, retryAnalyzer = com.myapplication.utils.RetryFailedTestCases.class)
	public void verifyValidLogin() {
		LP.LogintoFacebook("cryptocoins333@gmail.com", "eqqe");
		//driver.quit();
	}

	@Test(priority =3)
	public void verifyInvalidLogin() throws InterruptedException {
		Thread.sleep(1000);
		LP.EnterUsername("cryptocoins333@gmail.com").EnterPassword("1111@123");
		LP.ClickLoginButton();
		Thread.sleep(10000);
		System.out.println(PP.getRememberText());
		//driver.quit(); 

	}

	@AfterMethod
	public void Clsbrowser() {
		tearDown();
	}
}


