//Author Rekha


package com.qa.testclasses;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;
import com.qa.pages.SearchPage;
import com.qa.testbaseclasses.Testbaseclass;
import com.qa.util.TestUtil;



public class HomePageTest extends Testbaseclass{


	static Loginpage loginpage;
	static HomePage homepage;
	static SearchPage searchpage;
	static TestUtil testutil;
	static ContactsPage contactpage;
	
	public HomePageTest(){
		super();
		
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public static void getbrowserandloginsetup(){
		initialize();
		testutil=new TestUtil();
		loginpage=new Loginpage();
		homepage=loginpage.loginbtnclickverification(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public  static void verifyhomepagetitleTest(){
		
		String title=homepage.verifyhomepagetitle();
		Assert.assertEquals("CRMPRO", title);
	}
	
	@Test(priority=2)
	public static void checkuserlogoutTest(){
		
	homepage.checkusercanlogout();
	//driver.navigate().equals(loginpage);
	//HomePage homepage=new HomePage();
	//driver.navigate().equals(homepage);
	//String url=driver.getCurrentUrl();
	//System.out.println("current url is:"+url);
	String title= loginpage.loginpagetitle();
	Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software","Title didnot match");
	
	// Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", title);
		//Assert.assertTrue(true, "you returned to loginpage");
		//Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software",title,"Page Title didnot Match" );
	}  
	
	@Test(priority=3)
	public static void quicksearchtextTest(){
		String text=homepage.quicksearchtext(prop.getProperty("quicksearch"));
		Assert.assertEquals("Companies",text);
		
	}
	
	@Test(priority=4)
	public static void verifyHomepageheaderTest(){
		boolean flag=homepage.verifyHomepageheader();
		Assert.assertTrue(flag);
			
	}
	@Test(priority=5)
	public static void verifyusernameisdisplayedTest(){
		
		boolean flag=homepage.verifyusernameisdisplayed();
		Assert.assertTrue(flag);
		
		
	}   
	
		
	@AfterMethod
	public void closebrowser(){
	driver.quit();
	
	}
	








}

