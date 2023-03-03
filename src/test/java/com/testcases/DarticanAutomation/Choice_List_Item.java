package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Choice_List_Item {

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
		Thread.sleep(3000);
		
	}
	
	
	@Test(priority = 3)
	public void ChoicelistitemValidation() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Choice List Validation check");
		
		
		try 
		{
				WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
				String errorexpected  = "Dartican choice item is required";
				String error1expected = "Choice item is required";
				
				
					
			try
					{
						WebElement clickrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-choice-list']/tbody/tr")));
						clickrow.click();
						Thread.sleep(5000);
						Configuration.logger.log(LogStatus.INFO, "Single click choice list row");
					}
					catch(Exception e)
					{
						Configuration.logger.log(LogStatus.INFO, e);
					}
					
			try
					{
						WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-choice-item-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
						AddButton.click();
						Configuration.logger.log(LogStatus.INFO, "Add choice list item screen");
					
						Configuration.logger.log(LogStatus.INFO, "Click save button,'without entering data'");
						WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='modal-choice-item']/div/div/div[3]/div[2]/button[2]"))));
						savebtn.click();
						Thread.sleep(5000);
						
						
						String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-choice-item']/div/div/div[2]/form/div[4]/div[2]/span"))).getText();
						Assert.assertEquals(errorread, errorexpected);
						
						if(errorread.equals(errorexpected))
					{
						Configuration.logger.log(LogStatus.FAIL, errorexpected);
					}
					
					
					String error1read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-choice-item']/div/div/div[2]/form/div[5]/div[2]/span"))).getText();
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
			Configuration.logger.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 8)
	public void AddChoiceListItem() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Add choice list item");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		try
		{
			
		
			try 
			{
				WebElement choiceitem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-item']/div/div/div[2]/form/div[5]/div[2]/input")));
				choiceitem.sendKeys("1007");
				Configuration.logger.log(LogStatus.INFO,"Enter choice item");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			try 
			{
				WebElement trans1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-item']/div/div/div[2]/form/div[10]/div[2]/input")));
				trans1.sendKeys("1007 trans");
				Configuration.logger.log(LogStatus.INFO,"Enter translation 1");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try 
			{
				WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-item']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Thread.sleep(5000);
				
				Configuration.logger.log(LogStatus.INFO,"Click save button");
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
	
	
	@Test(priority = 8)
	public void EditChoiceListItem() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Edit choice list item");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			try
			{
				WebElement searchtxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-choice-item-wrapper']/div[2]/div[1]/input")));
				searchtxt.sendKeys("1007",Keys.ENTER);
				Thread.sleep(5000);
				Configuration.logger.log(LogStatus.INFO, "enter test item in search box");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				WebElement doubleclickrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-choice-item']/tbody/tr")));
				ac1.doubleClick(doubleclickrow).perform();
				Thread.sleep(5000);
				Configuration.logger.log(LogStatus.INFO, "Double click choice list item row");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try
			{
				WebElement choiceitem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-item']/div/div/div[2]/form/div[5]/div[2]/input")));
				choiceitem.clear();
				choiceitem.sendKeys("1008");
				Configuration.logger.log(LogStatus.INFO, "Edit Choice Item");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try 
			{
				WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-item']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Thread.sleep(5000);
				Configuration.logger.log(LogStatus.INFO,"Click save button");
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
	
	
	@Test(priority = 9)
	public void CopyChoiceListItem() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Copy choice list item");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{	
			
			
			try
			{
				WebElement searchtxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-choice-item-wrapper']/div[2]/div[1]/input")));
				searchtxt.clear();
				searchtxt.sendKeys("1008",Keys.ENTER);
				Thread.sleep(5000);
				Configuration.logger.log(LogStatus.INFO, "enter test item in search box");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				WebElement clickrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-choice-item']/tbody/tr[1]")));
				clickrow.click();
				Thread.sleep(5000);
				WebElement copylink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-choice-item']/tbody/tr[1]/td[2]/div/button")));
				ac1.moveToElement(copylink).perform();
				WebElement btncopy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[32]/a[2]/button")));
				ac1.moveToElement(btncopy).click().perform();
				Configuration.logger.log(LogStatus.INFO, "Click copy button choice list item");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try
			{
				WebElement choiceitem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-item']/div/div/div[2]/form/div[5]/div[2]/input")));
				choiceitem.clear();
				choiceitem.sendKeys("1009");
				Configuration.logger.log(LogStatus.INFO, "Edit Choice Item");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			try 
			{
				WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-choice-item']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Thread.sleep(5000);
				Configuration.logger.log(LogStatus.INFO,"Click save button");
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
	
	
	@Test(priority = 10)
	public void DeleteChoiceitem() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			Configuration.logger = Configuration.extent.startTest("Choice list item delete screen");
			
			try
			{
				Thread.sleep(25000);
				WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-choice-item']/tbody/tr[1]")));
				clickrow.click();
				WebElement choicelistitemrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-choice-item']/tbody/tr[1]/td[2]/div/button")));
				ac1.moveToElement(choicelistitemrow).perform();		
				WebElement choicelistitemdel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[32]/a[3]/button")));
				ac1.moveToElement(choicelistitemdel).click().perform();
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
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
	}	
}
