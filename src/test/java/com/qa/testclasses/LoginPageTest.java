package com.qa.testclasses;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;
import com.qa.testbaseclasses.Testbaseclass;

public class LoginPageTest extends Testbaseclass{
    static Loginpage loginpage;
	static HomePage homepage;
	
	public LoginPageTest(){//created constructor to access base class method
		super();
		
	}
	@BeforeMethod(alwaysRun=true)
	public void getbrowser(){
		initialize();
		new Loginpage();
	}

@Test(priority=1)
public static void loginpagetitleTest(){
		String title=Loginpage.loginpagetitle();                                               
	Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software",title);
		
}
@Test(priority=2)                                 
public static void loginbtnenabledTest(){
	
	boolean flag=Loginpage.loginbtnenabled();
	Assert.assertTrue(flag);
	
}

@Test(priority=3)
public static void headerverification(){
	boolean flag=Loginpage.headerverification();
	Assert.assertTrue(flag);
}
@Test(priority=4)
public static void loginbtnclickverificationTest(){
	//since it is returning homepage object need to create homepageobject
			homepage=Loginpage.loginbtnclickverification(prop.getProperty("username"), prop.getProperty("password"));//created multiple usernames 1)rekhal,Tavish123  2)Test1981,Test1981
	
	
}

@AfterMethod(alwaysRun=true)
 public void closebrowser(){
	driver.quit();
}
}


