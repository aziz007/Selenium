package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Budget_Pools {
	
@Test (description = "enter credentials and hit enter button",priority = 1)
	
	public void login() {
	Configuration.logger = Configuration.extent.startTest("Valid login");
	Configuration.logger.log(LogStatus.INFO, "Entering username");
	Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
	Configuration.logger.log(LogStatus.INFO, "Entering password");
	Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
	
	try 
	{
		Configuration.logger.log(LogStatus.INFO, "Click submit button");
		Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(20000);
		
	} 
	catch (Exception e) {
		// TODO: handle exception
		Configuration.logger.log(LogStatus.FAIL, e);
	
}

}

@Test (description = "mouse over function",priority =2)
public void mouseover() throws InterruptedException 
{
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
	Actions ac = new Actions(Configuration.driver);
	
	//select cycle
	WebElement selectcycle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='selected-planning-cycle']/ul/li")));
	ac.moveToElement(selectcycle).perform();
	WebElement selectcycle1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='selected-planning-cycle']/ul/li/div/a[2]")));
	ac.moveToElement(selectcycle1).click().perform();
	
	//select specific page
	Configuration.logger = Configuration.extent.startTest("BudgetPool Page");
	Configuration.logger.log(LogStatus.INFO, "Mouse over function");
	WebElement conf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[3]/a[@data-menu-id='10']")));		
	ac.moveToElement(conf).perform();	
	Configuration.logger.log(LogStatus.INFO, "Click BudgetPool link");
	WebElement cycle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='55']")));
	ac.moveToElement(cycle).click().perform();
}


@Test(priority = 3)
public void ValidationErrorBP() throws Exception {
	
	Configuration.logger = Configuration.extent.startTest("BudgetPool Validation check");
	
	
	try 
	{
			WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
			String errorexpected = "Budget pool name is required";
			
			try
			{
				WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-budget-pool-wrapper']/div/div[1]/div/ul/li[1]")));
				AddButton.click();
				Configuration.logger.log(LogStatus.INFO, "Add budget pool screen");
			
				Configuration.logger.log(LogStatus.INFO, "Click save button,'without entering data'");
				WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='modal-budget-pool']/div/div/div[3]/div[2]/button[2]]"))));
				savebtn.click();
				Thread.sleep(5000);
			
				String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool']/div/div/div[2]/form/div[3]/div[2]/span"))).getText();
				Assert.assertEquals(errorread, errorexpected);
				
				if(errorread.equals(errorexpected))
				{
					Configuration.logger.log(LogStatus.FAIL, errorexpected);
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
public void AddBudgetPools() throws Exception {
	
	Configuration.logger = Configuration.extent.startTest("Add budget pool");
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
	//Actions ac1 = new Actions(Configuration.driver);
	
	try
	{		
			
			try 
			{
				WebElement BPName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: BudgetPoolName']")));
				BPName.sendKeys("test pool");
				BPName.sendKeys(Keys.TAB);
				BPName.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Enter budget pool name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement Percent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool']/div/div/div[2]/form/div[5]/div[2]/input")));
				Percent.sendKeys("10");
				Percent.sendKeys(Keys.TAB);
				Percent.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Enter percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement HoldbackPct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool']/div/div/div[2]/form/div[6]/div[2]/input")));
				HoldbackPct.sendKeys("10");
				HoldbackPct.sendKeys(Keys.TAB);
				HoldbackPct.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Enter Holdback percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement HoldbackApp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool']/div/div/div[2]/form/div[7]/div[2]/label/div")));
				HoldbackApp.click();
				Configuration.logger.log(LogStatus.INFO, "Enter holdback applied");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-budget-pool']/div/div/div[3]/div[2]/button[2]")));
				savebutton.click();
				Configuration.logger.log(LogStatus.INFO, "Click save button");
				
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
	}
	catch(Exception e)
	{
		throw(e);
	}
}


@Test(priority = 5)
public void EditBudgetPools() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
	Actions ac1 = new Actions(Configuration.driver);
	
	try
	{		
		Configuration.logger = Configuration.extent.startTest("BudgetPool edit screen");
		
			try 
			{
				WebElement searchBP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-budget-pool-wrapper']/div[2]/div[1]/input")));
				searchBP.sendKeys("test pool",Keys.ENTER);
				Thread.sleep(3000);
				Configuration.logger.log(LogStatus.INFO, "Search budget pool name to edit");
		    }
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
		
		
			try
			{
				WebElement doubleclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-budget-pool']/tbody/tr[1]")));
				ac1.doubleClick(doubleclick).perform();
				Configuration.logger.log(LogStatus.INFO, "Double click row");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement BPName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: BudgetPoolName']")));
				BPName.clear();
				BPName.sendKeys("test pool edit",Keys.TAB);
				BPName.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Edit budget pool name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement Percent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool']/div/div/div[2]/form/div[5]/div[2]/input")));
				Percent.clear();
				Percent.sendKeys("10",Keys.TAB);
				Percent.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Edit percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement HoldbackPct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool']/div/div/div[2]/form/div[6]/div[2]/input")));
				HoldbackPct.clear();
				HoldbackPct.sendKeys("10",Keys.TAB);
				HoldbackPct.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Edit Holdback percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			
			try
			{
				WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-budget-pool']/div/div/div[3]/div[2]/button[2]")));
				savebutton.click();	
				Configuration.logger.log(LogStatus.INFO, "Click save button");
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

@Test(priority = 6)
public void CopyBudgetPools() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
	Actions ac1 = new Actions(Configuration.driver);
	
	try
	{		
		Configuration.logger = Configuration.extent.startTest("BudgetPool copy screen");
			try
			{
				Thread.sleep(20000);
				WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-budget-pool']/tbody/tr[1]")));
				clickrow.click();
				WebElement copyrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-budget-pool']/tbody/tr/td[1]/div/button/i")));
				ac1.moveToElement(copyrow).perform();
				WebElement clickcopy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[50]/a[2]/button/i")));
				ac1.moveToElement(clickcopy).click().perform();
				Configuration.logger.log(LogStatus.INFO, "Copy row");
				Thread.sleep(3000);
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement BPName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: BudgetPoolName']")));
				BPName.clear();
				BPName.sendKeys("test pool copy",Keys.TAB);
				BPName.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Edit and copy budget pool name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement Percent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool']/div/div/div[2]/form/div[5]/div[2]/input")));
				Percent.clear();
				Percent.sendKeys("20",Keys.TAB);
				Percent.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Edit percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement HoldbackPct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool']/div/div/div[2]/form/div[6]/div[2]/input")));
				HoldbackPct.clear();
				HoldbackPct.sendKeys("10",Keys.TAB);
				HoldbackPct.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Edit Holdback percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement HoldbackApp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool']/div/div/div[2]/form/div[7]/div[2]/label/div")));
				HoldbackApp.click();
				Configuration.logger.log(LogStatus.INFO, "Edit holdback applied");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			
			try
			{
				WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-budget-pool']/div/div/div[3]/div[2]/button[2]")));
				savebutton.click();
				Thread.sleep(5000);
				Configuration.logger.log(LogStatus.INFO, "Click save button to copy data");
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


@Test(priority = 7)
public void DeleteBP() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
	Actions ac1 = new Actions(Configuration.driver);
	try
	{
		Configuration.logger = Configuration.extent.startTest("Budget Pool delete screen");
		
		try
		{
			Thread.sleep(25000);
			WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-budget-pool']/tbody/tr[2]")));
			clickrow.click();
			WebElement budgterow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-budget-pool']/tbody/tr[2]/td[1]/div/button")));
			ac1.moveToElement(budgterow).perform();		
			WebElement budgetdel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[50]/a[3]/button/i")));
			ac1.moveToElement(budgetdel).click().perform();	
			Configuration.logger.log(LogStatus.INFO, "Delete popup message");
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try 
		{
			WebElement delbudgetpool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
			delbudgetpool.click();
			Configuration.logger.log(LogStatus.INFO, "Delete button yes");
			Thread.sleep(7000);
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


@Test(priority = 8)
public void ValidationErrorBPD() throws Exception {
	
	Configuration.logger  = Configuration.extent.startTest("BudgetPoolDivision Validation check");
	String errorexpected  = "Division name is required";
	String error2expected = "Division percent is required";
	
	try 
	{
			WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
			
			try
			{
				WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-budget-pool-division-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
				AddButton.click();
				Configuration.logger.log(LogStatus.INFO, "Add budget pool division screen");
			
				Configuration.logger.log(LogStatus.INFO, "Click save button,'without entering data'");
				WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[3]/div[2]/button[2]"))));
				savebtn.click();
				Thread.sleep(5000);
			
				String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[2]/div[2]/span"))).getText();
				Assert.assertEquals(errorread, errorexpected);
				
				if(errorread.equals(errorexpected))
				{
					Configuration.logger.log(LogStatus.INFO, errorexpected);
				}
				
				
				String error2read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[3]/div[2]/span"))).getText();
				Assert.assertEquals(error2read, error2expected);
				
				if(error2read.equals(error2expected))
				{
					Configuration.logger.log(LogStatus.INFO, error2expected);
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

	@Test(priority = 9)
	public void AddBudgetPoolDivisions() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Budget pool divisions Page");
		try 
		{
				Thread.sleep(10000);
				
				
				try
				{
					WebElement PDName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: PoolDivisionName']")));
					PDName.sendKeys("test div");
					Configuration.logger.log(LogStatus.INFO, "Enter pool division name");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDpct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: PoolDivisionPercent']")));
					PDpct.sendKeys("10");
					Configuration.logger.log(LogStatus.INFO, "Enter pool division percent");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDM = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[5]/div/div[2]/label/div")));
					PDM.click();
					Configuration.logger.log(LogStatus.INFO,"Click pool division merit");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDMLs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[5]/div[2]/div[2]/label/div")));
					PDMLs.click();
					Configuration.logger.log(LogStatus.INFO,"Click pool division merit Ls");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDIE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[5]/div[3]/div[2]/label/div")));
					PDIE.click();
					Configuration.logger.log(LogStatus.INFO, "Click pool division internal equity");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Click pool division promotion");
					WebElement PDP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[5]/div[4]/div[2]/label/div")));
					PDP.click();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDMA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[5]/div[5]/div[2]/label/div")));
					PDMA.click();
					Configuration.logger.log(LogStatus.INFO, "Click pool division market adjustment");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDO = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[5]/div[6]/div[2]/label/div")));
					PDO.click();
					Configuration.logger.log(LogStatus.INFO, "Click pool division other");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDvar1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[5]/div[7]/div[2]/label/div")));
					PDvar1.click();
					Configuration.logger.log(LogStatus.INFO, "Click pool division variable 1");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDvar2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[2]/form/div[5]/div[8]/div[2]/label/div")));
					PDvar2.click();
					Configuration.logger.log(LogStatus.INFO, "Click pool division variable 2");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[3]/div[2]/button[2]")));
					savebutton.click();	
					Configuration.logger.log(LogStatus.INFO, "Click save button");
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
	
	
	@Test(priority = 10)
	public void EditBudgetPoolDivisions() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac2 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Budget pool divisions edit screen");
		
		try 
		{
			
			
				try 
				{
					WebElement searchBPD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-budget-pool-division-wrapper']/div[2]/div[1]/input")));
					searchBPD.sendKeys("test div",Keys.ENTER);
					Thread.sleep(3000);
					Configuration.logger.log(LogStatus.INFO, "Search budget pool division name to edit");
			    }
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
			
				Thread.sleep(25000);
				try
				{
					WebElement doubleclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-budget-pool-division']/tbody/tr")));
					ac2.doubleClick(doubleclick).click().perform();
					Configuration.logger.log(LogStatus.INFO, "Double click row");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: PoolDivisionName']")));
					PDName.clear();
					PDName.sendKeys("test div edit");
					Configuration.logger.log(LogStatus.INFO, "Enter pool division name");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDpct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: PoolDivisionPercent']")));
					PDpct.clear();
					PDpct.sendKeys("20");
					Configuration.logger.log(LogStatus.INFO, "Enter pool division percent");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}				
				
				try
				{
					WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[3]/div[2]/button[2]")));
					savebutton.click();	
					Configuration.logger.log(LogStatus.INFO, "Click save button");
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
	
	
	@Test(priority = 11)
	public void CopyBudgetPoolDivisions() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac2 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Budget pool divisions copy screen");
		
		try 
		{
				Thread.sleep(25000);
				try
				{
					WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-budget-pool-division']/tbody/tr[1]")));
					clickrow.click();
					WebElement copyrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-budget-pool-division']/tbody/tr/td[1]/div/button")));
					ac2.moveToElement(copyrow).perform();
					WebElement clickcopy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[48]/a[2]/button")));
					ac2.moveToElement(clickcopy).click().perform();			
					Configuration.logger.log(LogStatus.INFO, "Click copy button");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: PoolDivisionName']")));
					PDName.clear();
					PDName.sendKeys("test div copy");
					Configuration.logger.log(LogStatus.INFO, "Enter pool division name");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement PDpct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: PoolDivisionPercent']")));
					PDpct.clear();
					PDpct.sendKeys("10");
					Configuration.logger.log(LogStatus.INFO, "Enter pool division percent");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}				
				
				try
				{
					WebElement savenewbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[3]/div[2]/button[3]")));
					savenewbtn.click();
					Thread.sleep(5000);
					Configuration.logger.log(LogStatus.INFO, "Click save and new button");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				try
				{
					WebElement cancelbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-budget-pool-division']/div/div/div[3]/div[2]/button[1]")));
					cancelbtn.click();
					Thread.sleep(5000);
					Configuration.logger.log(LogStatus.INFO, "Click cancel button");
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
	
	@Test(priority = 12)
	public void DeleteBPD() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			Configuration.logger = Configuration.extent.startTest("Budget Pool division delete screen");
			
			try
			{
				Thread.sleep(25000);
				WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-budget-pool-division']/tbody/tr")));
				clickrow.click();
				WebElement pooldivrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-budget-pool-division']/tbody/tr")));
				ac1.moveToElement(pooldivrow).perform();		
				WebElement pooldivdel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[48]/a[3]/button")));
				ac1.moveToElement(pooldivdel).click().perform();
				Thread.sleep(3000);
				Configuration.logger.log(LogStatus.INFO, "Delete popup message");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement delbudgetpool = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
				delbudgetpool.click();
				Configuration.logger.log(LogStatus.INFO, "Delete button yes");
				Thread.sleep(7000);
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

	
	@Test(priority = 13)
	public void ViewOptions() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Open column options");
		
		WebElement options = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='view-opotions']/i")));
		options.click();
		
		WebElement columnoptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='view-options-menu']/ul/li[2]/label")));
		columnoptions.click();
		
		Configuration.logger.log(LogStatus.INFO, "select all options");
		WebElement All = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='columns']/div/div/div[2]/div/div/div[2]/label/div")));
		All.click();
		
		Configuration.logger.log(LogStatus.INFO, "Click save options button");
		WebElement savebuttonoptions = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-bind='visible:(SelectedTab()!==2 && !IsUpdateMaster()) , if: !IsReporting() ,click:ColumnOptionsChanged']")));
		savebuttonoptions.click();	
		
		
	}
	

}
