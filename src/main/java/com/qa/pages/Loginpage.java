package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.testbaseclasses.Testbaseclass;



public class Loginpage extends Testbaseclass {

	//ObjectRepository or webEements(Page factory)
	
	
	@FindBy(css=".form-control[name='username']")
	static WebElement username;
	
	@FindBy(css=".form-control[name='password']")
	static WebElement password;
	
	@FindBy(css=".btn.btn-small")
	static WebElement submitbtn;
	
	@FindBy(css="#navbar-collapse")
	static WebElement header;
	//next step is to initialize the webelements
	public Loginpage(){	//creating constructor to initialize webElements using PageFactory class By calling the driver object from baseclass
		
		
		PageFactory.initElements(driver, this);
	}
	//Actions in login page are verify the loginpage title and it navigates to homepage,verifyheader portion and after user submits on login he should get homepage object
	public static String loginpagetitle(){
		return driver.getTitle();
		
	}
	
	public static boolean loginbtnenabled(){
		
		return submitbtn.isEnabled();
	}
	
	public static boolean headerverification(){
		return header.isDisplayed();
	}
	public static HomePage loginbtnclickverification(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitbtn.click();
		
		return new HomePage();
		
	}
}
