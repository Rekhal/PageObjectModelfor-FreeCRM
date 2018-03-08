package com.qa.testbaseclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.qa.util.TestUtil;
import com.qa.util.WebDriverListener;

public class Testbaseclass {

	public static WebDriver driver;//both webdriver object,properties object should be accessed globally hence use public static 
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;
	public static WebDriverListener eventlistener;
	
	
	public Testbaseclass() {
		try {
		prop=new Properties();
		
		FileInputStream fs = new FileInputStream("C:\\javatests\\freeCRMTest\\src\\main\\java\\com\\qa\\environmentvariables\\config.properties");//using fileinputstream we are accessing the .properties file
			
		prop.load(fs);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}
		
		
	}
	
	
	public static void initialize(){
	//using properties class object we are getting the values of .properties file(key value pair based)
	
	String geturl=prop.getProperty("URL");
	
	String browsername=prop.getProperty("Browser");	
	
	if(browsername.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkat\\Downloads\\chromedriver\\chromedriver.exe");
	    driver=new ChromeDriver();
	}else if(browsername.equals("Firefox")){
	    	driver=new FirefoxDriver();
	    }
	//for firing the webdriverevents we are calling the WebDriverListener.java by instantiating
	 e_driver=new EventFiringWebDriver(driver);
	 eventlistener=new WebDriverListener();
	 e_driver.register(eventlistener);
	 driver=e_driver;
	
	driver.get(geturl);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
	}
	
		
	}
	
	
	
