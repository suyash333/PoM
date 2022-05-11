package com.myapplication.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myapplication.qa.base.TestBase;



public class LoginPage extends TestBase{
	


	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email")
	private WebElement Username;

	@FindBy(name="email")
	 private WebElement Username_Byname;

	@FindBy(name="pass")
	private WebElement Password;

	@FindBy(name="login")
	private WebElement LoginButton;

	//public LoginPage(WebDriver driver) {
	//	// TODO Auto-generated constructor stub
	//	
	//	this.driver=driver;
	//	
	//}




	//public WebDriver setup(String BaseUrl) {
	//	
	//	System.setProperty("webdriver.gecko.driver", "D:\\Suyash\\Automation\\new_Workspace\\automation-pom\\drivers\\geckodriver.exe");
	//	driver = new FirefoxDriver();
	//	driver.manage().window().maximize();
	//	driver.get(BaseUrl);
	//	return driver;
	//	
	//}



	public void LogintoFacebook(String uname, String Pass) {
		
		try {
			if(Username.isDisplayed()==true) {
				Username.sendKeys(uname);
			}	
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Given element is not found by primary locator hence trying with secondry locator");
			Username_Byname.sendKeys(uname);
		}

		WebDriverWait wait = new WebDriverWait(driver, 10);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));
		Password.sendKeys(Pass);
		LoginButton.click();
	}

	public LoginPage EnterUsername(String uname) {
		try {
			if(Username.isDisplayed()==true) {
				Username.sendKeys(uname);
			}	
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Given element is not found by primary locator hence trying with secondry locator");
			Username_Byname.sendKeys(uname);
		}
			
		return this;
	}

	public LoginPage EnterPassword(String Pass) {
		Password.sendKeys(Pass);
		return this;
	}

	public void ClickLoginButton() 
	{
		LoginButton.click();
	}

	//returns title of the page
	public String validateLoginPageTitle() {
		return driver.getTitle();	
	}



}
