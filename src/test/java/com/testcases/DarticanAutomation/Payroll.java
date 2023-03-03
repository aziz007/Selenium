package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
 
public class Payroll {
	
	public static WebDriver driver;
	@Test (description = "enter credentials and hit enter button",priority =1)
		
		public void login() {
		Configuration.logger = Configuration.extent.startTest("Valid login");
		Configuration.logger.log(LogStatus.INFO, "Entering username");
		Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
		Configuration.logger.log(LogStatus.INFO, "Entering password");
		Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
		
		try {
			Configuration.logger.log(LogStatus.INFO, "Click submit button");
			Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println("button not clicked");
	}

	}

	@Test (description = "mouse over function",priority =2)
	public void mouseover() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Configuration.driver,20);
		Configuration.logger = Configuration.extent.startTest("Payroll Page");
		Configuration.logger.log(LogStatus.INFO, "Mouse over function");
		WebElement conf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
		//conf.click();
		
		
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(conf).perform();
		
		Configuration.logger.log(LogStatus.INFO, "Click Payroll link");
		WebElement cycle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-menu-id='92']")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
		ac.moveToElement(cycle).click().perform();


	}
	
	
	@Test(priority = 3)
	public void ValidationErrorpayroll() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Payroll Validation check");
		
		
		try 
		{
				WebDriverWait wait    = new WebDriverWait(Configuration.driver, 20);
				String errorexpected  = "Payroll identifier is required";
				String error1expected = "Payroll name is required";
				
				try
				{
					WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-payroll-identifier-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
					AddButton.click();
					Configuration.logger.log(LogStatus.INFO, "Add payroll screen");
				
					Configuration.logger.log(LogStatus.INFO, "Click save button,'without entering data'");
					WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[3]/div[2]/button[2]"))));
					savebtn.click();
					
				
					String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[2]/form/div[2]/div[2]/span"))).getText();
					Assert.assertEquals(errorread, errorexpected);
					
					if(errorread.equals(errorexpected))
					{
						Configuration.logger.log(LogStatus.FAIL, errorexpected);
					}
					
					String error1read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[2]/form/div[3]/div[2]/span"))).getText();
					Assert.assertEquals(error1read, error1expected);
					
					if(error1read.equals(error1expected))
					{
						Configuration.logger.log(LogStatus.FAIL, error1expected);
					}
				}
				catch(Exception e)
				{
						Configuration.logger.log(LogStatus.FAIL,e);
				}		
				
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
	}
	@Test(priority = 4)
	public void Payrollidentifier() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		try
		{
			try
			{
				Configuration.logger.log(LogStatus.INFO, "click add button");
				WebElement addbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-payroll-identifier-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
				addbutton.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Enter payroll identifier");
				WebElement payrollidentifier = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[2]/form/div[2]/div[2]/input")));
				payrollidentifier.sendKeys("1001");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Enter payroll name");
				WebElement payrollname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[2]/form/div[3]/div[2]/input")));
				payrollname.sendKeys("Test1001");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click payroll name");
				WebElement payrollsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[3]/div[2]/button[2]")));
				payrollsave.click();
				payrollsave.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
	}
		catch(Exception e)
		{
			throw(e);
		}
		
}
	
	@Test(priority = 5)
	public void EditPI() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			Configuration.logger = Configuration.extent.startTest("Payroll Identifier edit screen");
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Edit screen");
				WebElement payrollrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-payroll-identifier']/tbody/tr")));
				ac1.doubleClick(payrollrow).perform();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Edit Payroll identifier");
				WebElement editpayrollide = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[2]/form/div[2]/div[2]/input")));
				editpayrollide.clear();
				editpayrollide.sendKeys("1002");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Edit Payroll name");
				WebElement editpayrollname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[2]/form/div[3]/div[2]/input")));
				editpayrollname.clear();
				editpayrollname.sendKeys("test1002");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Edit data saved");
				WebElement editpayroll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[3]/div[2]/button[2]")));
				editpayroll.click();
				editpayroll.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
		}
		
		catch(Exception e)
		{
			throw(e);
		}
	}
	
	@Test(priority = 6)
	public void CopyPI() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			Configuration.logger = Configuration.extent.startTest("Payroll identifier copy screen");
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click row");
				WebElement payrollrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-payroll-identifier']/tbody/tr[1]")));
				payrollrow.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Copy row");
				WebElement payrollbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-payroll-identifier']/tbody/tr[1]/td[1]/div/button")));
				ac1.moveToElement(payrollbtn).perform();
				WebElement payrollcopy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[14]/a[2]/button")));
				ac1.moveToElement(payrollcopy).click().perform();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Copy Payroll identifier");
				WebElement copypayrollide = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[2]/form/div[2]/div[2]/input")));
				copypayrollide.clear();
				copypayrollide.sendKeys("1003");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Copy Payroll name");
				WebElement copypayrollname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[2]/form/div[3]/div[2]/input")));
				copypayrollname.clear();
				copypayrollname.sendKeys("test1003");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Copy data saved");
				WebElement copysavepayroll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-identifier']/div/div/div[3]/div[2]/button[2]")));
				copysavepayroll.click();
				copysavepayroll.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
	}
	
	@Test(priority = 11)
	public void DeletePI() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			Configuration.logger = Configuration.extent.startTest("Payroll Identifier delete screen");
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Delete popup message");
				WebElement payrollrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-payroll-identifier']/tbody/tr/td[1]/div/button")));
				ac1.moveToElement(payrollrow).perform();
				
				WebElement payrollcopy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[12]/a[3]/button")));
				ac1.moveToElement(payrollcopy).click().perform();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Delete button yes");
				WebElement delpayrollide = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
				delpayrollide.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}			
			
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
	}
	
	
	@Test(priority = 7)
	public void ValidationErrorfrequency() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Payroll Frequency Validation check");
		
		
		try 
		{
				WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
				String errorexpected  = "Payroll frequency is required";
				String error1expected = "Pay periods per year is required";
				String error2expected = "Weeks per year is required";
				String error3expected = "Hours is required";
				
				try
				{
					WebElement AddButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-payroll-frequency-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
					AddButton.click();
					Configuration.logger.log(LogStatus.INFO, "Add payroll frequency screen");
				
					Configuration.logger.log(LogStatus.INFO, "Click save button,'without entering data'");
					WebElement savebtn = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[3]/div[2]/button[2]"))));
					savebtn.click();
				
					String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[2]/div[2]/span"))).getText();
					Assert.assertEquals(errorread, errorexpected);
					
					if(errorread.equals(errorexpected))
					{
						Configuration.logger.log(LogStatus.FAIL, errorexpected);
					}
					
					
					String error1read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[3]/div[2]/span"))).getText();
					Assert.assertEquals(error1read, error1expected);
					
					if(error1read.equals(error1expected))
					{
						Configuration.logger.log(LogStatus.FAIL, error1expected);
					}
					
					
					String error2read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[4]/div[2]/span"))).getText();
					Assert.assertEquals(error2read, error2expected);
				
					if(error2read.equals(error2expected));
					{
						Configuration.logger.log(LogStatus.FAIL, error2expected);
					}
					
					String error3read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[5]/div[2]/span"))).getText();
					Assert.assertEquals(error3read, error3expected);
					
					if(error3read.equals(error3expected));
					{
						Configuration.logger.log(LogStatus.FAIL, error3expected);
					}
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
	}
				
	
	@Test(priority = 8)
	public void Payrollfrequency() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
						
			Configuration.logger = Configuration.extent.startTest("Payroll Frequency screen");
			
			//try
			//{
				//Configuration.logger.log(LogStatus.INFO, "click payroll identifier row");
				//WebElement PIrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-payroll-identifier']/tbody/tr")));
				//PIrow.click();
				//Thread.sleep(3000);
			//}
			//catch(Exception e)
			//{
				//throw(e);
			//}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "click add button");
				WebElement addbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-payroll-frequency-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
				addbutton.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select payroll frequency");
				WebElement payrollfrequency = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='PayrollFrequency']")));	
				ac1.doubleClick(payrollfrequency).perform();		
				Select dropdownpayroll = new Select (Configuration.driver.findElement(By.xpath("//select[@id='PayrollFrequency']")));
				dropdownpayroll.selectByVisibleText("Annual");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Enter Pay periods per year");
				WebElement periodspereyear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[3]/div[2]/input")));
				periodspereyear.sendKeys("12");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Enter Weeks per year");
				WebElement weeksperyear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[4]/div[2]/input")));
				weeksperyear.sendKeys("48");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Enter Hours per pay period");
				WebElement hoursperperiod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[5]/div[2]/input")));
				hoursperperiod.sendKeys("250");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
			
				Configuration.logger.log(LogStatus.INFO, "Hours per year");
				WebElement hoursperyear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[6]/div[2]/input")));
				hoursperyear.sendKeys("1001");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select hourly rounding method");
				WebElement roundingmethod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='HourlyRoundingMethod']")));	
				ac1.doubleClick(roundingmethod).perform();		
				Select dropdownrounding = new Select (Configuration.driver.findElement(By.xpath("//select[@id='HourlyRoundingMethod']")));
				dropdownrounding.selectByVisibleText("Currency");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Click isactive");
				WebElement isactive = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[8]/div[2]/label/div")));
				isactive.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click Use Fte factor");
				WebElement fte = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[9]/div[2]/label/div")));
				fte.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click Final based on hourly");
				WebElement basedonhourly = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[11]/div[2]/label/div")));
				basedonhourly.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click Final based on pay period");
				WebElement basedonperiod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[12]/div[2]/label/div")));
				basedonperiod.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click save button");
				WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[3]/div[2]/button[2]")));
				savebutton.click();
				savebutton.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
		}
		
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
  }
	
	@Test(priority = 9)
	public void EditPF() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			Configuration.logger = Configuration.extent.startTest("Edit Payroll Frequency screen");	
			try
			{
				Configuration.logger.log(LogStatus.INFO, "double click row");
				WebElement rowclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-payroll-frequency']/tbody/tr[1]")));
				ac1.doubleClick(rowclick).click().perform();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select payroll frequency");
				WebElement payrollfrequency = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='PayrollFrequency']")));	
				ac1.doubleClick(payrollfrequency).perform();		
				Select dropdownpayroll = new Select (Configuration.driver.findElement(By.xpath("//select[@id='PayrollFrequency']")));
				dropdownpayroll.selectByVisibleText("Monthly");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Edit Pay periods per year");
				WebElement periodsperyear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[3]/div[2]/input")));
				periodsperyear.clear();
				periodsperyear.sendKeys("121");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Edit Weeks per year");
				WebElement weeksperyear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[4]/div[2]/input")));
				weeksperyear.clear();
				weeksperyear.sendKeys("481");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Edit Hours per pay period");
				WebElement hoursperperiod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[5]/div[2]/input")));
				hoursperperiod.clear();
				hoursperperiod.sendKeys("2501");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{			
				Configuration.logger.log(LogStatus.INFO, "Edit Hours per year");
				WebElement hoursperyear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[6]/div[2]/input")));
				hoursperyear.clear();
				hoursperyear.sendKeys("10011");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Edit hourly rounding method");
				WebElement roundingmethod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='HourlyRoundingMethod']")));	
				ac1.doubleClick(roundingmethod).perform();		
				Select dropdownrounding = new Select (Configuration.driver.findElement(By.xpath("//select[@id='HourlyRoundingMethod']")));
				dropdownrounding.selectByVisibleText("Currency");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Click isactive");
				WebElement isactive = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[8]/div[2]/label/div")));
				isactive.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click Use Fte factor");
				WebElement fte = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[9]/div[2]/label/div")));
				fte.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click Final based on hourly");
				WebElement basedonhourly = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[10]/div[2]/label/div")));
				basedonhourly.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click Final based on pay period");
				WebElement basedonperiod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[2]/form/div[12]/div[2]/label/div")));
				basedonperiod.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Edit data saved");
				WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-payroll-frequency']/div/div/div[3]/div[2]/button[2]")));
				savebutton.click();
				savebutton.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
		}
		
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
  }

	
	@Test(priority = 10)
	public void DeletePF() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			Configuration.logger = Configuration.extent.startTest("Payroll frequency delete screen");
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Delete Payroll frequency row");
				WebElement payrollfrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-payroll-frequency']/tbody/tr")));
				payrollfrow.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Delete popup message");
				WebElement payrollrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-payroll-frequency']/tbody/tr/td[1]/div/button")));
				ac1.moveToElement(payrollrow).perform();
				
				WebElement payrollcopy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[14]/a[2]/button")));
				ac1.moveToElement(payrollcopy).click().perform();			
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Delete button yes");
				WebElement delpayrollide = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
				delpayrollide.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}			
			
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
	}
	
	
}