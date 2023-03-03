package com.Excel;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Excel_Practice {
	
	//public static FileOutputStream fos;
	public static FileInputStream fis;
	public static WebDriver driver;
	

	
@Test
public void ReadData() throws IOException {
	
	
	fis = new FileInputStream(System.getProperty("user.dir")+"/Excel.xlsx");
	XSSFWorkbook wk = new XSSFWorkbook(fis);
	XSSFSheet sheet  = wk.getSheet("Sheet1");
	XSSFRow row = sheet.getRow(1);
	XSSFCell cell = row.getCell(0);
	System.out.println("Getting data from excel = " + cell.getStringCellValue());

	
}



}
