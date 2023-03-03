package com.testcases.DarticanAutomation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Currency { 

	
@BeforeClass (description = "enter credentials and hit enter button")
	
	public void login() { 
	Configuration.logger = Configuration.extent.startTest("Valid login");
	Configuration.logger.log(LogStatus.INFO, "Entering username");
	Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
	Configuration.logger.log(LogStatus.INFO, "Entering password");
	Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
	
	try {
		Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
		this.notify();
		Configuration.logger.log(LogStatus.INFO, "Click submit button");
		Thread.sleep(20000);
		
	} catch (Exception e) {
		// TODO: handle exception
		Configuration.logger.log(LogStatus.FAIL, e);
	
}

}

@Test (description = "mouse over function")
public void mouseover() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
	Configuration.logger = Configuration.extent.startTest("Currency Page");
	Configuration.logger.log(LogStatus.INFO, "Mouse over function");
	
	try
	{
		WebElement admin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='10']")));			
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(admin).perform();
		
		WebElement currency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='54']")));
		ac.moveToElement(currency).click().perform();
		Configuration.logger.log(LogStatus.INFO, "Click Currency link");
		Thread.sleep(5000);
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
	
	

}

@Test(priority = 1)
public void ValidationErrors() throws Exception {
	
	
	String CCerrorexpected = "Currency code is required";
	String CNexpectederror = "Currency name is required";
		
	try
	{
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Check Form Validation Errors");
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click add button");
			WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-sm col mr-1 text-muted tooltipstered']")));
			AddButton.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}

		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click save button without entering data");
			WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-save btn-sm mr-1']")));
			btnsave.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try 
		{
			String CCerror = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='bg-danger text-light p-1']"))).getText();
			Assert.assertEquals(CCerror, CCerrorexpected);
			
			if(CCerror.equals(CCerrorexpected))
			{
				Configuration.logger.log(LogStatus.INFO, CCerrorexpected);
			}
			
		} catch (AssertionError e) 
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			String CNerror = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[3]/div[2]/span"))).getText();
			Assert.assertEquals(CNerror, CNexpectederror);
			
			if(CNerror.equals(CNexpectederror))
			{
				Configuration.logger.log(LogStatus.INFO, CNexpectederror);
			}
			
		} catch (AssertionError e) 
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click cancel button");
			WebElement btncancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-currency']/div/div/div[3]/div[2]/button[1]")));
			btncancel.click();
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL, e);
	}
}

@Test(priority = 2)
public void AddCurrency() throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Add Currency");
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click add button");
			WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-sm col mr-1 text-muted tooltipstered']")));
			AddButton.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		
		
		try
		{		
			WebElement CurrencyCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CurrencyCode']")));
			CurrencyCode.sendKeys("PKR");
			Configuration.logger.log(LogStatus.INFO,"Enter currency code");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try 
		{			
			WebElement CurrencyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CurrencyName']")));
			CurrencyName.sendKeys("Pakistani Ruppees");
			Configuration.logger.log(LogStatus.INFO, "Enter currency name");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try
		{			
			WebElement CurrencyFormat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CurrencyFormat']")));
			CurrencyFormat.sendKeys("test");
			Configuration.logger.log(LogStatus.INFO, "Enter currency format");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try 
		{
			WebElement RoundingMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[5]/div[2]/select")));	
			ac1.click(RoundingMethod).perform();
			Select Roundingdropdown = new Select (Configuration.driver.findElement(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[5]/div[2]/select")));
			Roundingdropdown.selectByVisibleText("Currency");
			Configuration.logger.log(LogStatus.INFO, "Select rounding method");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try
		{		
			WebElement ExchangeCurrencyCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[6]/div[2]/select")));	
			ac1.doubleClick(ExchangeCurrencyCode).perform();
			Thread.sleep(3000);
			Select Exchangedropdown = new Select (Configuration.driver.findElement(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[6]/div[2]/select")));
			Exchangedropdown.selectByVisibleText("US Dollar");
			Configuration.logger.log(LogStatus.INFO, "Select exchange currency code");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try
		{	
			WebElement ExchangeEffDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: ExchangeRate']")));
			ExchangeEffDate.sendKeys("225");
			Configuration.logger.log(LogStatus.INFO, "Enter exchange rate");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try
		{
			WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[8]/div[2]/div/input")));
			calendar.click();
			Thread.sleep(2000);
			
			String setdatestr = "11/25/2022";
			
			String currdatestr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[25]/div[1]/table/thead/tr[2]/th[2]"))).getText();
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
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[25]/div[1]/table/thead/tr[2]/th[3]"))).click();
				else
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[25]/div[1]/table/thead/tr[2]/th[1]"))).click();
			}
			
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[25]/div[1]/table/tbody/tr[4]/td[6]"))).click();
			Configuration.logger.log(LogStatus.INFO, "Select exchange effective date");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		
		try 
		{
			
			WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-currency']/div/div/div[3]/div[2]/button[2]")));
			savebutton.click();	
			Thread.sleep(5000);
			Configuration.logger.log(LogStatus.INFO, "Click save button");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
	}

@Test(priority = 3)
public void EditCurrency() throws InterruptedException {
	
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Edit Currency");
		Thread.sleep(10000);
		try
		{			
			WebElement Rowclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-currency']/tbody/tr[1]")));
			ac1.doubleClick(Rowclick).perform();
			Configuration.logger.log(LogStatus.INFO, "Double click row");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try
		{
			WebElement CurrencyCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CurrencyCode']")));
			CurrencyCode.clear();
			CurrencyCode.sendKeys("US");
			Configuration.logger.log(LogStatus.INFO, "Edit currency code");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try 
		{			
			WebElement CurrencyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CurrencyName']")));
			CurrencyName.clear();
			CurrencyName.sendKeys("US Dollar");
			Configuration.logger.log(LogStatus.INFO, "Edit currency name");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try
		{		
			WebElement CurrencyFormat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CurrencyFormat']")));
			CurrencyFormat.clear();
			CurrencyFormat.sendKeys("testus");
			Configuration.logger.log(LogStatus.INFO, "Edit currency format");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try 
		{		
			WebElement RoundingMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[5]/div[2]/select")));	
			ac1.click(RoundingMethod).perform();
			Select Roundingdropdown = new Select (Configuration.driver.findElement(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[5]/div[2]/select")));
			Roundingdropdown.selectByVisibleText("Currency");
			Configuration.logger.log(LogStatus.INFO, "Select rounding method");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try
		{		
			WebElement ExchangeCurrencyCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[6]/div[2]/select")));	
			ac1.click(ExchangeCurrencyCode).perform();
			Thread.sleep(3000);
			Select Exchangedropdown = new Select (Configuration.driver.findElement(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[6]/div[2]/select")));
			Exchangedropdown.selectByVisibleText("US Dollar");
			Configuration.logger.log(LogStatus.INFO, "Select exchange currency code");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try
		{			
			WebElement ExchangeRate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: ExchangeRate']")));
			ExchangeRate.clear();
			ExchangeRate.sendKeys("224");
			Configuration.logger.log(LogStatus.INFO, "Edit exchange rate");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try 
		{			
			WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-currency']/div/div/div[3]/div[2]/button[2]")));
			savebutton.click();
			Thread.sleep(3000);
			Configuration.logger.log(LogStatus.INFO, "Click save button");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
	}

@Test(priority = 4)
public void Deletecurrency() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
	Actions ac1 = new Actions(Configuration.driver);
	Thread.sleep(10000);
	try
	{
		Configuration.logger = Configuration.extent.startTest("Currency delete screen");
		try
		{
			WebElement currencyrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-currency']/tbody/tr[1]")));
			currencyrow.click();
			Configuration.logger.log(LogStatus.INFO, "Delete currency row");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try
		{		
			WebElement currencyrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-currency']/tbody/tr[1]/td[1]/div/button")));
			ac1.moveToElement(currencyrow).perform();			
			WebElement currencydelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[24]/a[2]/button")));
			ac1.moveToElement(currencydelete).click().perform();	
			Configuration.logger.log(LogStatus.INFO, "Delete popup message");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try 
		{		
			WebElement delcurrency = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
			delcurrency.click();
			Configuration.logger.log(LogStatus.INFO, "Delete button yes");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}			
	}
	
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL, e);
	}
}



		@AfterClass
		public void columnname(ITestResult result)
		{
			System.out.println("in aftermethod of NewTestgnClass");
			long a = result.getEndMillis()-result.getStartMillis();
			System.out.println("Time taken to run test is : "+a+" milliseconds");
		}			
}