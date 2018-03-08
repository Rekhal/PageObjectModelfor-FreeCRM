package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.testbaseclasses.Testbaseclass;

public class TestUtil extends Testbaseclass{

	public static  long IMPLICIT_WAIT=40;
	public  static  long PAGE_LOAD_TIMEOUT=40;
	
	static Workbook book;
	static Sheet sheet;
	public static String fullpath="C:\\javatests\\freeCRMTest\\src\\test\\java\\com\\qa\\testdata\\FreecrmNewcontactdata.xls";
	
	
	public void switchtoframe(){
		driver.switchTo().frame("mainpanel");
		
	}
	
	public Object[][] testdata(String sheetname){
		
		FileInputStream file=null;
		
		
		
		try {
			 file=new FileInputStream(fullpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetname);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
		for(int i=0;i<sheet.getLastRowNum();i++){   //row loop
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){   //column loop
				
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
		
		
		
		
	}
	
	
	
	public static void takescreenshot() throws IOException{
		
		File sourcefile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcefile, new File("C:\\Takescreenshot\\getscreenshot.jpeg"));
	}
}
