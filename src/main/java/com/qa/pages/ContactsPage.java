package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testbaseclasses.Testbaseclass;

public class ContactsPage extends Testbaseclass {


	
		
	@FindBy(css=".datacardtitle[onclick='showExtendedSearch();']")
	static WebElement advancedsearchtext;
	
	@FindBy(xpath="//legend[contains(text(),'Contact Information')]")
	static WebElement readcontactinfotextinnewcontactpage;
	
	@FindBy(css=".mlddm>li>a[title='Contacts']")
	static WebElement clickoncontactslink;
	
	@FindBy(css=".mlddm>li>ul>li>a[title='New Contact']")
	static WebElement newcontactspage;
	
	@FindBy(css="#first_name")
	static WebElement Fname;
	
	@FindBy(css="#surname")
	static WebElement Lname;
	
	@FindBy(css=".select[name='title']")
	static WebElement Titl;
	
	//@FindBy(xpath="//strong[contains(text(),'Title')]")
	//static WebElement readTitletext;
	
	@FindBy(css=".select[name='suffix']")  
	static WebElement sufix;
	
	@FindBy(css="input[name='client_lookup']")
	static WebElement company;
	
	@FindBy(css="input[value='Save']")
	static WebElement savebtn;
	
	@FindBy(css=".datatitle>input")
	static WebElement selectcheckbox;
	
	@FindBy(xpath="//a[contains(text(),'rekha sharma')]")
	static WebElement clickonname;
	
	@FindBy(css=".tabs_header[align='left']")
	static WebElement readheaderrekha;
	
	
	
	static HomePage homepage=new HomePage();
	
	
	
	public ContactsPage(){
		
		PageFactory.initElements(driver, this);  //creating constructor to initialize webelements
	}
	
	
	
	//Actions
	
	public boolean readcontactinfotext(){
		
		selectcheckbox.click();
		clickonname.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return readheaderrekha.isDisplayed();
		
		
	}


	public void createnewcontact(String tit,String fn,String ln,String suf,String comp){
		
		
		/*Actions action=new Actions(driver);   //need to use action class for mouse move over or keyboardcontrols
		action.moveToElement(clickoncontactslink).build().perform();
		action.moveToElement(newcontactspage).build().perform();;
		newcontactspage.click();*/
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(readcontactinfotextinnewcontactpage)).isDisplayed();
		//WebDriverWait wait=new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOf(Titl)).isDisplayed();
		
		//System.out.println("The Title text is:"+readTitletext.getText());
		Select dropdown=new Select(Titl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dropdown.selectByVisibleText(tit);
		Fname.sendKeys(fn);
		Lname.sendKeys(ln);
		Select sufixdropdown=new Select(sufix);
		sufixdropdown.selectByVisibleText(suf);
		company.sendKeys(comp);
		savebtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
