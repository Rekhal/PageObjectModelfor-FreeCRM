package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.pages.Loginpage;

import com.qa.testbaseclasses.Testbaseclass;
import com.qa.util.TestUtil;


public class HomePage extends Testbaseclass{
     
	
	//OR or WebElements
	@FindBy(css=".topnavlink[href='https://www.freecrm.com/index.cfm?logout=1']")
	static WebElement logoutlnk;
	
	@FindBy(css=".select[value='Quick Search']")
	static WebElement quicksearchtextbox;
	
	@FindBy(css=".noprint>input[type='image']")
	static WebElement searchbutton;
	
	@FindBy(xpath="//td[contains(text(),'User: rekha sharma')]")
	static WebElement username;
	
	@FindBy(css=".mlddm")
	static WebElement homepageheader;
	
	@FindBy(xpath="//td[contains(text(),'Companies')]")
	static WebElement readcompaniestext;
	
	@FindBy(css="html>body>table>tbody>tr>td>table>tbody>tr>td>table")
	static WebElement table;
	
	@FindBy(css=".mlddm>li>ul>li>a[title='New Contact']")
	static WebElement newcontactspage;
	
	@FindBy(xpath="//legend[contains(text(),'Contact Information')]")
	static WebElement readcontactinformationtext;
	
	@FindBy(css=".mlddm>li>a[title='Contacts']")
	static WebElement clickoncontactslink;
	
	
	
	
	
	@FindBy(css=".datatitle>input")
	static WebElement selectcheckbox;
	
	@FindBy(xpath="//a[contains(text(),'rekha sharma')]")
	static WebElement clickonname;
	
	@FindBy(css=".datacardtitle[onclick='showExtendedSearch();']")
	static WebElement readnameafterclickoncontacts;
	
	
	static Loginpage loginpage=new Loginpage();
	static TestUtil testutil=new TestUtil();
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions in homepage
	
	public String verifyhomepagetitle(){
		return driver.getTitle();
		
	}
	public Loginpage checkusercanlogout(){
	    //driver.switchTo().frame("mainpanel");
		testutil.switchtoframe();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logoutlnk.click();
		driver.manage().deleteAllCookies();
		return new Loginpage();		
		
	}
	
	public String quicksearchtext(String textname){
	
	testutil.switchtoframe();
	//driver.switchTo().frame("mainpanel");	
	quicksearchtextbox.sendKeys(textname);
	searchbutton.click();
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//driver.navigate().equals(table);
	table.click();
	String readtext=readcompaniestext.getText();
			
	return readtext;	
	}
	
	public boolean verifyHomepageheader(){
		
		testutil.switchtoframe();
		//driver.switchTo().frame("mainpanel");
		return homepageheader.isDisplayed();
			
	}
	
	public boolean verifyusernameisdisplayed(){
		
		testutil.switchtoframe();
		//driver.switchTo().frame("mainpanel");
		return username.isDisplayed();
			
	}
	
	
	public ContactsPage validateclickoncontactslink(){
		
		clickoncontactslink.click();
		return new ContactsPage();
	}	
	
	
	
	public ContactsPage clickonnewcontactpage(){
		
		
		Actions action=new Actions(driver);   //need to use action class for mouse move over or keyboardcontrols
		action.moveToElement(clickoncontactslink).build().perform();
		action.moveToElement(newcontactspage).build().perform();;
		newcontactspage.click();
		return new ContactsPage();
		
		
		/*testutil.switchtoframe();
		
		
		Actions action=new Actions(driver);   //need to use action class for mouse move over or keyboardcontrols
		action.moveToElement(clickoncontactslink).build().perform();
		action.moveToElement(newcontactspage).build().perform();;
		newcontactspage.click();
		//WebDriverWait wait=new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.visibilityOf(readcontactinformationtext)).isDisplayed();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ContactsPage();
	}*/
}
}