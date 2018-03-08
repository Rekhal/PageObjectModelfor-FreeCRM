package com.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.testbaseclasses.Testbaseclass;

public class WebDriverListener extends Testbaseclass implements WebDriverEventListener{

	
	//this class is used for generating the error logs so that user can understand the events that are fired
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating url is:"+url);
		
	}

	
	public void afterNavigateTo(String url, WebDriver driver) {
		
		System.out.println("After navigating url is:"+url);
	}

	
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		
	}

	
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After Navigated to previous page ");
		
	}

	
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before Navigating  to next page ");
		
	}

	
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("After Navigated  to next page ");
		
	}

	
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find webElement by:"+by.toString());
		
	}

	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element by:"+by.toString());
		
	}


	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to clickonElement:"+element.toString());
		
	}

	
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(" clicked on the Element:"+element.toString());
		
	}

	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Before the changes are made value of element is:"+element.toString());
		
	}

	
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("After the changes are made value of element is:"+element.toString());
		
	}

	
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	
	public void onException(Throwable error, WebDriver driver){
		
		System.out.println("Exception occured at:"+error);
		try{
			TestUtil.takescreenshot();//need to generate getscreenshotclass in TestUtil.java 
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	
	
}
