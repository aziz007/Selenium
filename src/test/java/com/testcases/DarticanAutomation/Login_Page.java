package com.testcases.DarticanAutomation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Months;
//import java.time.Duration;
//import java.text.SimpleDateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

//import freemarker.template.SimpleDate;



public class Login_Page {

	//public static WebDriver driver;
@Test (description = "enter credentials and hit enter button",priority =1)
	
	public void login() 
{
	Configuration.logger = Configuration.extent.startTest("Login – Positive test case");
	Configuration.logger.log(LogStatus.INFO, "Entering correct Username");
	Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
	Configuration.logger.log(LogStatus.INFO, "Entering correct Password");
	Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
	
	try {
		Configuration.logger.log(LogStatus.INFO, "Click submit button");
		Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(20000);
		
	} catch (Exception e) {
		// TODO: handle exception
		Configuration.logger.log(LogStatus.FAIL,e);
	
}

}
@Test (description = "mouse over function",priority =2)
public void mouseover() throws InterruptedException {
	Configuration.logger = Configuration.extent.startTest("Configuration => Cycle Creation");
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	WebElement conf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
	//conf.click();
	
	
	Actions ac = new Actions(Configuration.driver);
	ac.moveToElement(conf).perform();
	
	Configuration.logger.log(LogStatus.INFO, "Click cycle from the drop-down menu");
	WebElement cycle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-menu-id='83']")));
	//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
	
	ac.moveToElement(cycle).click().perform();


}

@Test(priority = 3)
public void AddCycle() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac1 = new Actions(Configuration.driver);
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Open Cycle Add screen ");
		WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-planning-cycle-wrapper']/div[2]/div[1]/div/ul/li[1]")));
		AddButton.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Enter cycle name");
		WebElement CycleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CycleName']")));
		CycleName.sendKeys("28 Feb A1");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Check Is Salary Planning");
		WebElement SalaryCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[2]/div[4]/label/div")));
		SalaryCheckbox.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO,"Select Cycle Status from the drop-down list");
		WebElement cyclestatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='CycleStatus']")));
		ac1.click(cyclestatus).perform();
		Thread.sleep(2000);
		Select dropdowncurrency = new Select (Configuration.driver.findElement(By.xpath("//select[@id='CycleStatus']")));
		dropdowncurrency.selectByVisibleText("Active");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e );
	}
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Salary Effective Date");
		
		WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[4]/div[2]/div/input")));
		calendar.click();
		
		String setdatestr = "03/16/2023";
		
		String currdatestr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[155]/div[1]/table/thead/tr[2]/th[2]"))).getText();
		System.out.println(currdatestr);
		
		
		Date setdate = new SimpleDateFormat("MM/dd/yyyy").parse(setdatestr);
		System.out.println(setdate);
		
		Date currdate = new SimpleDateFormat("MMMM yyyy").parse(currdatestr);
		System.out.println(currdate);
		
		
		int monthdiff = Months.monthsBetween(new DateTime(currdate).withDayOfMonth(1),new DateTime(setdate).withDayOfMonth(1)).getMonths();
		System.out.println(monthdiff);
		
		boolean isfuture = true;
		if(monthdiff<0) 
		{
			isfuture = false;
			monthdiff = -1 * monthdiff;
		}
		
		for(int i=0; i<monthdiff;i++)
		{
			if(isfuture)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[155]/div[1]/table/thead/tr[2]/th[3]"))).click();
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[155]/div[1]/table/thead/tr[2]/th[1]"))).click();
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[155]/div[1]/table/tbody/tr[3]/td[5]"))).click();
		
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Performance Ranking Type  from the drop-down list");
		WebElement currencyname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='PerformanceRankingType']")));	
		ac1.click(currencyname).perform();
		Thread.sleep(2000);
		Select dropdowncurrency = new Select (Configuration.driver.findElement(By.xpath("//select[@id='PerformanceRankingType']")));
		dropdowncurrency.selectByVisibleText("Performance Ratings");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Is Multi-Currency");
		WebElement currencyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[6]/div[2]/label/div")));
		currencyCheckbox.click();
	}
	catch(Exception e) 
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select US dollar");
		WebElement currencyname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[6]/div[4]/select")));	
		ac1.click(currencyname).perform();
		Thread.sleep(2000);
		Select dropdowncurrency = new Select (Configuration.driver.findElement(By.xpath("//select[@id='CurrencyName']")));
		dropdowncurrency.selectByVisibleText("US Dollar");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Is Job Table Active");
		WebElement jobCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[7]/div[2]/label/span[2]")));
		jobCheckbox.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Is Email Send To Log");
		WebElement emailCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[9]/div[2]/label/div")));
		emailCheckbox.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Is Personalization Allowed");
		WebElement personalizationCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[9]/div[4]/label/div")));
		personalizationCheckbox.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Eligible Hire Date");
		
		WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='eligible-hire-date']")));
		calendar.click();
		
		String setdatestr = "03/20/2023";
		
		String currdatestr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[155]/div[1]/table/thead/tr[2]/th[2]"))).getText();
		System.out.println(currdatestr);
		
		
		Date setdate = new SimpleDateFormat("MM/dd/yyyy").parse(setdatestr);
		System.out.println(setdate);
		
		Date currdate = new SimpleDateFormat("MMMM yyyy").parse(currdatestr);
		System.out.println(currdate);
		
		
		int monthdiff = Months.monthsBetween(new DateTime(currdate).withDayOfMonth(1),new DateTime(setdate).withDayOfMonth(1)).getMonths();
		System.out.println(monthdiff);
		
		boolean isfuture = true;
		if(monthdiff<0) 
		{
			isfuture = false;
			monthdiff = -1 * monthdiff;
		}
		
		for(int i=0; i<monthdiff;i++)
		{
			if(isfuture)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[155]/div[1]/table/thead/tr[2]/th[3]"))).click();
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[155]/div[1]/table/thead/tr[2]/th[1]"))).click();
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[155]/div[1]/table/tbody/tr[4]/td[2]"))).click();
		
		
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	try 
	{
		Configuration.logger.log(LogStatus.INFO, "Select Is Merit");
		WebElement meritCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[25]/div[2]/label/div")));
		meritCheckbox.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Is Lump Sum");
		WebElement lumpsumCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[25]/div[4]/label/div")));
		lumpsumCheckbox.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Use Salary Structure");
		WebElement strCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[33]/div[2]/label/div")));
		strCheckbox.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Is Import Salary Structure");
		WebElement impstrCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[34]/div[2]/label/div")));
		impstrCheckbox.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Use Structure Table");
		WebElement strtableCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[35]/div[3]/label/div")));
		strtableCheckbox.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Select Enforce Salary Minimum Type drop-down list");
		WebElement minstrCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[33]/div[4]/label/div")));
		ac1.click(minstrCheckbox).perform();
		Thread.sleep(2000);
		Select dropdowncurrency = new Select (Configuration.driver.findElement(By.xpath("//select[@id='EnforceSalaryMinimumType']")));
		dropdowncurrency.selectByVisibleText("Before");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	
	
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Click save button");
		WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-planning-cycle']/div/div/div[3]/div[2]/button[2]")));
		savebutton.click();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
}

@Test(priority = 4)
public void Templates() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac1 = new Actions(Configuration.driver);
	
	try
	{
		Configuration.logger = Configuration.extent.startTest("Administration => Templates");
		WebElement administration = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@id='header']/nav/ul/li[3]/a[@data-menu-id='10']")));
		ac1.moveToElement(administration).perform();		
		WebElement templates = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-menu-id='53']")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));		
		ac1.moveToElement(templates).click().perform();	
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
		
	try
	{
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='search']")));
		search.sendKeys("merit planning",Keys.ENTER);
		Configuration.logger.log(LogStatus.INFO, "Search Template Name in search box");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	try
	{
		WebElement merit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-template']/tbody/tr[1]/td")));
		merit.click();
		Configuration.logger.log(LogStatus.INFO, "Click merit planning row");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	
	try
	{
	
		WebElement jobsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		jobsearch.clear();
		jobsearch.sendKeys("Job",Keys.ENTER);
		Configuration.logger.log(LogStatus.INFO, "Enter a Job in the column title search bar");
		Thread.sleep(15000);
	
		List<WebElement> jobcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
	
	for(WebElement names : jobcolumns)
	{					
		if(names.getText().equals("job_title"))
		{							
			Configuration.logger.log(LogStatus.INFO, "job_title");			
		}
		
		if(names.getText().equals("job_code"))
		{							
			Configuration.logger.log(LogStatus.INFO, "job_code");			
		}
		
		if(names.getText().equals("job_function_code"))
		{
			Configuration.logger.log(LogStatus.INFO, "job_function_code");
		}	
		
		if(names.getText().equals("job_function_name"))
		{
			Configuration.logger.log(LogStatus.INFO, "job_function_name");
		}
		
		if(names.getText().equals("job_sub_function_name"))
		{
			Configuration.logger.log(LogStatus.INFO, "job_sub_function_name");
		}
		
	}
	
		Configuration.logger.log(LogStatus.INFO, "Search and verify Job Columns");
	}
	
	catch(Exception e)
	
	{
		System.out.println("Job rules are not correct");
	}
	
	
	
	try
	{
	
		WebElement meritsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		meritsearch.clear();
		meritsearch.sendKeys("merit_increase",Keys.ENTER);
		Configuration.logger.log(LogStatus.INFO, "Enter a merit increase in the column title search bar");
		Thread.sleep(10000);
	
		List<WebElement> meritcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
	
	for(WebElement names : meritcolumns)
	{					
		if(names.getText().equals("recommended_merit_increase_pct"))
		{							
			Configuration.logger.log(LogStatus.INFO, "recommended_merit_increase_pct");	
		}
		
		if(names.getText().equals("recommended_merit_increase_amt"))
		{
			Configuration.logger.log(LogStatus.INFO, "recommended_merit_increase_amt");
		}
		
	}
		
	Configuration.logger.log(LogStatus.INFO, "Search and verify Merit Columns");
	}
	
	catch(Exception e)
	
	{
		System.out.println("Merit rules are not correct");
	}
	
	
	try
	{
	
		WebElement lumpsumsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		lumpsumsearch.clear();
		lumpsumsearch.sendKeys("lump sum",Keys.ENTER);
		Configuration.logger.log(LogStatus.INFO, "Enter a lump sum in the column title search bar");
		Thread.sleep(10000);
	
		List<WebElement> lumpsumcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
	
	for(WebElement names : lumpsumcolumns)
	{					
		if(names.getText().equals("lump_sum_pct"))
		{							
			Configuration.logger.log(LogStatus.INFO, "lump_sum_pct");	
		}
		
		if(names.getText().equals("lump_sum_amt"))
		{
			Configuration.logger.log(LogStatus.INFO, "lump_sum_amt");
		}
		
		if(names.getText().equals("lump_sum_type"))
		{
			Configuration.logger.log(LogStatus.INFO, "lump_sum_type");
		}
				
	}	
	
	Configuration.logger.log(LogStatus.INFO, "Search and verify Lump Sum Columns");
	}
	
	catch(Exception e)
	
	{
		System.out.println("Lump Sum rules are not correct");
	}
	
	
	
	
	try
	{
	
			WebElement stritemsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			stritemsearch.clear();
			stritemsearch.sendKeys("structure item",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Enter a structure item in the column title search bar");
			Thread.sleep(10000);
		
			List<WebElement> stritemcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
		
			for(WebElement names : stritemcolumns)
			{					
				if(names.getText().equals("structure_item"))
				{							
					Configuration.logger.log(LogStatus.INFO, "structure_item");	
				}	
			}
	
	
	
	
	
			WebElement compasearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			compasearch.clear();
			compasearch.sendKeys("compa ratio",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Enter a compa ratio in the column title search bar");
			Thread.sleep(10000);
		
			List<WebElement> compacolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
		
			for(WebElement names : compacolumns)
			{					
				if(names.getText().equals("compa_ratio"))
				{							
					Configuration.logger.log(LogStatus.INFO, "compa_ratio");	
				}
				
				if(names.getText().equals("new_compa_ratio"))
				{							
					Configuration.logger.log(LogStatus.INFO, "new_compa_ratio");	
				}
			}
			
			
		
			WebElement rangesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			rangesearch.clear();
			rangesearch.sendKeys("range penetration percent",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Enter a range penetration percent in the column title search bar");
			Thread.sleep(10000);
		
			List<WebElement> rangecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
		
			for(WebElement names : rangecolumns)
			{					
				if(names.getText().equals("range_penetration_pct"))
				{							
					Configuration.logger.log(LogStatus.INFO, "range_penetration_pct");
				}
				
				if(names.getText().equals("new_range_penetration_pct"))
				{							
					Configuration.logger.log(LogStatus.INFO, "new_range_penetration_pct");	
				}
				
			}
			
			
		
			WebElement minimumsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			minimumsearch.clear();
			minimumsearch.sendKeys("minimum amt",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Enter a minimum amt in the column title search bar");
			Thread.sleep(10000);
		
			List<WebElement> minicolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
		
			for(WebElement names : minicolumns)
			{					
				if(names.getText().equals("minimum_amt"))
				{							
					Configuration.logger.log(LogStatus.INFO, "minimum_amt");
				}				
			}
	
	
	
		
			WebElement midpointsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			midpointsearch.clear();
			midpointsearch.sendKeys("midpoint amt",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Enter a midpoint amt in the column title search bar");
			Thread.sleep(10000);
		
			List<WebElement> midcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
		
			for(WebElement names : midcolumns)
			{					
				if(names.getText().equals("midpoint_amt"))
				{							
					Configuration.logger.log(LogStatus.INFO, "midpoint_amt");
				}			
			}
		
		
		
			WebElement maximumsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			maximumsearch.clear();
			maximumsearch.sendKeys("maximum amt",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Enter a maximum amt in the column title search bar");
			Thread.sleep(10000);
		
			List<WebElement> maxcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
		
			for(WebElement names : maxcolumns)
			{					
				if(names.getText().equals("maximum_amt"))
				{							
					Configuration.logger.log(LogStatus.INFO, "maximum_amt");
				}			
			}
		
		Configuration.logger.log(LogStatus.INFO, "Search and verify Salary Structure Columns");
	}
	
	catch(Exception e)
	
	{
		System.out.println("Salary Structure rules are not correct");
	}
		
		
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
/*
 * try { WebElement editcolumn =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//table[@id='grid-column']/tbody/tr[1]")));
 * ac1.doubleClick(editcolumn).perform();
 * 
 * Thread.sleep(5000); Select viewabletypeON = new Select
 * (Configuration.driver.findElement(By.xpath(
 * "//select[@id='column-viewable-option']")));
 * viewabletypeON.selectByVisibleText("On");
 * 
 * WebElement savebutton2 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
 * savebutton2.click(); Thread.sleep(5000);
 * Configuration.logger.log(LogStatus.INFO,
 * "Change job_title viewable type to ON"); } catch(Exception e) {
 * Configuration.logger.log(LogStatus.FAIL,e); }
 * 
 * try { WebElement editcolumn =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//table[@id='grid-column']/tbody/tr[2]")));
 * ac1.doubleClick(editcolumn).perform();
 * 
 * Select viewabletypeON = new Select
 * (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//select[@id='column-viewable-option']"))));
 * viewabletypeON.selectByVisibleText("On");
 * 
 * WebElement savebutton2 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
 * savebutton2.click(); Thread.sleep(5000);
 * Configuration.logger.log(LogStatus.INFO,
 * "Change job_code viewable type to ON"); } catch(Exception e) {
 * Configuration.logger.log(LogStatus.FAIL,e); }
 * 
 * try { WebElement editcolumn =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//table[@id='grid-column']/tbody/tr[3]")));
 * ac1.doubleClick(editcolumn).perform();
 * 
 * Thread.sleep(3000); Select viewabletypeON = new Select
 * (Configuration.driver.findElement(By.xpath(
 * "//select[@id='column-viewable-option']")));
 * viewabletypeON.selectByVisibleText("On");
 * 
 * WebElement savebutton2 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
 * savebutton2.click(); Configuration.logger.log(LogStatus.INFO,
 * "Change job_function_code viewable type to ON"); Thread.sleep(3000);
 * 
 * }
 * 
 * catch(Exception e) { Configuration.logger.log(LogStatus.FAIL,e); }
 * 
 * try { WebElement editcolumn =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//table[@id='grid-column']/tbody/tr[4]")));
 * ac1.doubleClick(editcolumn).perform();
 * 
 * Thread.sleep(3000); Select viewabletypeON = new Select
 * (Configuration.driver.findElement(By.xpath(
 * "//select[@id='column-viewable-option']")));
 * viewabletypeON.selectByVisibleText("On");
 * 
 * WebElement savebutton2 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
 * savebutton2.click(); Configuration.logger.log(LogStatus.INFO,
 * "Change job_function_name viewable type to ON"); Thread.sleep(3000); }
 * catch(Exception e) { Configuration.logger.log(LogStatus.FAIL,e); }
 * 
 * try { WebElement editcolumn =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//table[@id='grid-column']/tbody/tr[5]")));
 * ac1.doubleClick(editcolumn).perform();
 * 
 * Thread.sleep(3000); Select viewabletypeON = new Select
 * (Configuration.driver.findElement(By.xpath(
 * "//select[@id='column-viewable-option']")));
 * viewabletypeON.selectByVisibleText("On");
 * 
 * WebElement savebutton2 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
 * savebutton2.click(); Configuration.logger.log(LogStatus.INFO,
 * "Change job_sub_function_name viewable type to ON"); Thread.sleep(5000); }
 * catch(Exception e) { Configuration.logger.log(LogStatus.FAIL,e); }
 * 
 * try { try { WebElement jobtext2 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[2]/td[2]"))); String jobcode =
 * jobtext2.getText(); System.out.println(jobcode);
 * 
 * WebElement jobviewabletype =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[2]/td[7]"))); String Jobcodetype =
 * jobviewabletype.getText(); System.out.println(Jobcodetype);
 * Configuration.logger.log(LogStatus.INFO,"Read job_code viewable type"); }
 * catch(Exception e) { Configuration.logger.log(LogStatus.FAIL,e); }
 * 
 * try { WebElement jobtext1 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[1]/td[2]"))); String jobtitle =
 * jobtext1.getText(); System.out.println( jobtitle);
 * 
 * WebElement jobviewabletypetitle =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[1]/td[7]"))); String Jobtitletype =
 * jobviewabletypetitle.getText(); System.out.println(Jobtitletype);
 * Configuration.logger.log(LogStatus.INFO, "Read job_title viewable type"); }
 * catch(Exception e) { Configuration.logger.log(LogStatus.FAIL,e); }
 * 
 * try { WebElement jobtext3 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[3]/td[2]"))); String jobfunctioncode =
 * jobtext3.getText(); System.out.println( jobfunctioncode);
 * 
 * WebElement jobviewabletypefc =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[3]/td[7]"))); String Jobfunctioncodetype =
 * jobviewabletypefc.getText(); System.out.println(Jobfunctioncodetype);
 * Configuration.logger.log(LogStatus.INFO,
 * "Read job_function_code viewable type"); } catch(Exception e) {
 * Configuration.logger.log(LogStatus.FAIL,e); }
 * 
 * try { WebElement jobtext4 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[4]/td[2]"))); String jobfunctionname =
 * jobtext4.getText(); System.out.println( jobfunctionname);
 * 
 * WebElement jobviewabletypefn =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[4]/td[7]"))); String Jobfunctionnametype =
 * jobviewabletypefn.getText(); System.out.println(Jobfunctionnametype);
 * Configuration.logger.log(LogStatus.INFO,
 * "Read job_function_name viewable type"); } catch(Exception e) {
 * Configuration.logger.log(LogStatus.FAIL,e); }
 * 
 * try { WebElement jobtext5 =
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[5]/td[2]"))); String jobfunctionsubname =
 * jobtext5.getText(); System.out.println( jobfunctionsubname);
 * 
 * WebElement jobviewabletypefcn =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//*[@id='grid-column']/tbody/tr[5]/td[7]"))); String Jobsubfunctionnametype
 * = jobviewabletypefcn.getText(); System.out.println(Jobsubfunctionnametype);
 * Configuration.logger.log(LogStatus.INFO,
 * "Read job_sub_function_name viewable type"); } catch(Exception e) {
 * Configuration.logger.log(LogStatus.FAIL,e); } } catch(Exception e) {
 * Configuration.logger.log(LogStatus.FAIL,e); } }
 */

	
		
	
	public void rolescount() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
		Actions ac1 = new Actions(Configuration.driver);
		
		try
		{
			Configuration.logger = Configuration.extent.startTest("Viewable Access");
			WebElement administration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[3]/a[@data-menu-id='10']")));	
			ac1.moveToElement(administration).perform();
			WebElement templates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='53']")));
			//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));		
			ac1.moveToElement(templates).click().perform();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
	}
}

