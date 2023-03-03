package com.testcases.DarticanAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Choice_List {

	 
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
			Thread.sleep(10000);			
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println("button not clicked");
		
	}

	}
	
	
	@Test (description = "mouse over function",priority =2)
	public void mouseover() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Choice list Page");
		Configuration.logger.log(LogStatus.INFO, "Mouse over function");
		WebElement conf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
		//conf.click();
		
		
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(conf).perform();
		
		Configuration.logger.log(LogStatus.INFO, "Click Choice List link");
		WebElement choicelist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='84']")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
		ac.moveToElement(choicelist).click().perform();
		//Thread.sleep(3000);
		
	}
	
	
	@Test (priority = 3)
	public void ChoiceListValidation() throws Exception {
		
		WebDriverWait wait 	  = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Choice List Validation check");
	
		
		
		try
		{			
				String errorexpected  = "Dartican choice name is required";
				String error1expected = "Choice name is required";
				String error2expected = "Choice group is required";
				
				try
				{
					System.out.println("i am here");
					WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-choice-list-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
					AddButton.click();
					Configuration.logger.log(LogStatus.INFO, "Add choice list screen");
					
					Configuration.logger.log(LogStatus.INFO, "Click save button,'without entering data'");
					WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='modal-choice-list']/div/div/div[3]/div[2]/button[2]"))));
					savebtn.click();
					Thread.sleep(5000);
					
						
					String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-choice-list']/div/div/div[2]/form/div[2]/div[2]/span"))).getText();
					Assert.assertEquals(errorread, errorexpected);
					
					if(errorread.equals(errorexpected))
					{
						Configuration.logger.log(LogStatus.FAIL, errorexpected);
					}
					
					
					String error1read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-choice-list']/div/div/div[2]/form/div[3]/div[2]/span"))).getText();
					Assert.assertEquals(error1read, error1expected);
					
					if(error1read.equals(error1expected))
					{
						Configuration.logger.log(LogStatus.FAIL, error1read);
					}
					
					
					String error2read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-choice-list']/div/div/div[2]/form/div[4]/div[2]/span"))).getText();
					Assert.assertEquals(error2read, error2expected);
					
					if(error2read.equals(error2expected))
					{
						Configuration.logger.log(LogStatus.FAIL, error2read);
					}
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

	@Test(priority = 4)
	public void AddChoiceList() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Add choice list");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
				
			try
			{
				WebElement choicename = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-list']/div/div/div[2]/form/div[3]/div[2]/input")));
				choicename.sendKeys("Test Status");
				Configuration.logger.log(LogStatus.INFO, "Enter Choice Name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try
			{
				WebElement choicegroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ChoiceGroup']")));
				ac1.moveToElement(choicegroup).perform();
				Select groupdropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='ChoiceGroup']")));
				groupdropdown.selectByVisibleText("Setup");
				Configuration.logger.log(LogStatus.INFO,"Select choice group");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement isnumeric = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-list']/div/div/div[2]/form/div[5]/div[2]/label/div")));
				isnumeric.click();
				Configuration.logger.log(LogStatus.INFO,"Select IsNumeric");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement ishastranslation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-list']/div/div/div[2]/form/div[6]/div[2]/label/div")));
				ishastranslation.click();
				Configuration.logger.log(LogStatus.INFO,"Select IsHasTranslation");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement istranslation1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-list']/div/div/div[2]/form/div[7]/div[2]/label/div")));
				istranslation1.click();
				Configuration.logger.log(LogStatus.INFO, "Select IsDisplayTranslation1");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try
			{
				WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-list']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Configuration.logger.log(LogStatus.INFO, "Click save button");
				Thread.sleep(15000);
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
	
	
	@Test(priority = 5)
	public void EditChoiceList() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Edit choice list");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			try
			{
				WebElement searchtxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-choice-list-wrapper']/div[2]/div[1]/input")));
				searchtxt.sendKeys("test status",Keys.ENTER);
				Thread.sleep(3000);
				Configuration.logger.log(LogStatus.INFO, "enter test status in search box");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			try
			{
				WebElement doubleclickrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-choice-list']/tbody/tr")));
				ac1.doubleClick(doubleclickrow).perform();
				Thread.sleep(5000);
				Configuration.logger.log(LogStatus.INFO, "Double click choice list row");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			try
			{
				WebElement choicename = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-list']/div/div/div[2]/form/div[3]/div[2]/input")));
				choicename.clear();
				choicename.sendKeys("Test Status 1");
				Configuration.logger.log(LogStatus.INFO, "Edit Choice Name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try
			{
				WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-list']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Configuration.logger.log(LogStatus.INFO, "Save edited data");
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
	public void CopyChoiceList() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Copy choice list");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{		
			try
			{
				WebElement clickrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-choice-list']/tbody/tr[1]")));
				ac1.click(clickrow).perform();
				Thread.sleep(3000);
				WebElement copylink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-choice-list']/tbody/tr/td[1]/div/button")));
				ac1.moveToElement(copylink).perform();
				WebElement btncopy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[32]/a[2]/button")));
				ac1.moveToElement(btncopy).click().perform();
				Configuration.logger.log(LogStatus.INFO, "Click copy button choice list");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try
			{
				WebElement choicename = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-list']/div/div/div[2]/form/div[3]/div[2]/input")));
				choicename.clear();
				choicename.sendKeys("Test Status 2");
				Configuration.logger.log(LogStatus.INFO, "Copy Choice Name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try
			{
				WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-list']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Configuration.logger.log(LogStatus.INFO, "Save copied data");
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
	public void DeleteChoicelist() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			Configuration.logger = Configuration.extent.startTest("Choice list delete screen");
			
			try
			{
				Thread.sleep(25000);
				WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-choice-list']/tbody/tr[1]")));
				clickrow.click();
				WebElement choicelistrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-choice-list']/tbody/tr[1]/td[1]/div/button")));
				ac1.moveToElement(choicelistrow).perform();		
				WebElement choicelistdel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[32]/a[3]/button")));
				ac1.moveToElement(choicelistdel).click().perform();
				Thread.sleep(3000);
				Configuration.logger.log(LogStatus.INFO, "Delete popup message");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement delchoicelist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
				delchoicelist.click();
				Configuration.logger.log(LogStatus.INFO, "Delete button yes");
				Thread.sleep(7000);
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
}
