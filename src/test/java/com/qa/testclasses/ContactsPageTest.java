// Author Rekha


package com.qa.testclasses;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;
import com.qa.testbaseclasses.Testbaseclass;
import com.qa.util.TestUtil;

public class ContactsPageTest extends Testbaseclass{

	static ContactsPage contactpage=new ContactsPage();
	static Loginpage loginpage;
	static HomePage homepage=new HomePage();
	static TestUtil testutil=new TestUtil();
	static String sheetname="NewContacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		
		initialize();
		loginpage=new Loginpage();
		homepage=loginpage.loginbtnclickverification(prop.getProperty("username"),prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		testutil.switchtoframe();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	
	
	@Test(priority=1)
	public void readcontactinfotextTest(){
		
		//testutil.switchtoframe();
		
		contactpage=homepage.validateclickoncontactslink();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag=contactpage.readcontactinfotext();
		Assert.assertTrue(flag);
	}
	
	
	@DataProvider
	public Object[][] readNewcontactTestdata(){
		
		Object[][] data=testutil.testdata(sheetname);
		return data;
		
	}
	@Test(priority=2,dataProvider="readNewcontactTestdata")
	public void createnewcontacttest(String tit,String fn,String ln,String suf,String comp){
		
		contactpage=homepage.clickonnewcontactpage();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//contactpage.createnewcontact("Mrs.","Rak","su","Sr.","Microsoft"); //we are hardcoding to read just single data
		contactpage.createnewcontact(tit, fn, ln, suf, comp);
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
		
	}







}

