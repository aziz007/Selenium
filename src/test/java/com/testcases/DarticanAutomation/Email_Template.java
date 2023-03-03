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

public class Email_Template {
	
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
		Configuration.logger = Configuration.extent.startTest("Email Template Page");
		Configuration.logger.log(LogStatus.INFO, "Mouse over function");
		WebElement conf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
		//conf.click();
		
		
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(conf).perform();
		
		Configuration.logger.log(LogStatus.INFO, "Click email template link");
		WebElement cycle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-menu-id='90']")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
		ac.moveToElement(cycle).click().perform();


	}
	
	
	@Test(priority = 3)
	public void ValidationErrorEmailT() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Email Template Validation check");
		
		
		try 
		{
				WebDriverWait wait    = new WebDriverWait(Configuration.driver, 40);
				String errorexpected  = "Language is required";
				String error1expected = "Template name is required";
				String error2expected = "Email subject is required";
			 
				
				try
				{
					WebElement AddButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-email-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
					AddButton.click();
					Configuration.logger.log(LogStatus.INFO, "Add email template screen");
				
					Configuration.logger.log(LogStatus.INFO, "Click save button,'without entering data'");
					WebElement savebtn = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@id='modal-email']/div/div/div[3]/div[2]/button[2]"))));
					savebtn.click();
					
				
					String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='template']/form/div[1]/div[2]/span"))).getText();
					Assert.assertEquals(errorread, errorexpected);
					
					if(errorread.equals(errorexpected))
					{
						Configuration.logger.log(LogStatus.INFO, errorexpected);
					}
					
					String error1read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='template']/form/div[3]/div[2]/span"))).getText();
					Assert.assertEquals(error1read, error1expected);
					
					if(error1read.equals(error1expected))
					{
						Configuration.logger.log(LogStatus.INFO, error1expected);
					}
					

					String error2read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='template']/form/div[7]/div[2]/span"))).getText();
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
				
				Configuration.logger.log(LogStatus.INFO, "Click cancel button");
				WebElement cancelbtn = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@id='modal-email']/div/div/div[3]/div[2]/button[1]"))));
				cancelbtn.click();
				
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
	}
	
	
	@Test(priority = 4)
	public void Emailtemplate() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
		Actions ac = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Add Email Template");
		
		try
		{
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click add button");
				WebElement addbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-email-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
				addbutton.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select Language");
				WebElement Language = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='LanguageName']")));	
				ac.doubleClick(Language).perform();		
				Select dropdownlanguage = new Select (Configuration.driver.findElement(By.xpath("//select[@id='LanguageName']")));
				dropdownlanguage.selectByVisibleText("English");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select Email template group");
				WebElement tempgrp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='template']/form/div[2]/div[2]/select")));	
				ac.doubleClick(tempgrp).perform();		
				Select ddtempgrp = new Select (Configuration.driver.findElement(By.xpath("//div[@id='template']/form/div[2]/div[2]/select")));
				ddtempgrp.selectByVisibleText("Recipient Emails");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
						
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Enter email template name");
				WebElement tempname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='template']/form/div[3]/div[2]/input")));
				tempname.sendKeys("email test");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select from group");
				WebElement fromgrp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='FromGroup']")));	
				ac.doubleClick(fromgrp).perform();		
				Select ddfromgrp = new Select (Configuration.driver.findElement(By.xpath("//select[@id='FromGroup']")));
				ddfromgrp.selectByVisibleText("Area Representative");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Enter email subject");
				WebElement emailsub = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='template']/form/div[7]/div[2]/textarea")));
				emailsub.sendKeys("Testing");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Is Active");
				WebElement isactive = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='template']/form/div[8]/div[2]/label/div")));
				isactive.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Is Include Standard Header");
				WebElement isstdhdr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='template']/form/div[9]/div[2]/label/div")));
				isstdhdr.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Is Include Standard Footer");
				WebElement isstdftr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='template']/form/div[10]/div[2]/label/div")));
				isstdftr.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select license type");
				WebElement lic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Restrict']")));	
				ac.doubleClick(lic).perform();		
				Select ddlic = new Select (Configuration.driver.findElement(By.xpath("//select[@id='Restrict']")));
				ddlic.selectByVisibleText("Salary Planning");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select cycle name");
				WebElement cycle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='CycleName']")));	
				ac.doubleClick(cycle).perform();	
				Select ddlic = new Select (Configuration.driver.findElement(By.xpath("//select[@id='CycleName']")));
				ddlic.selectByVisibleText("Az space");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Attachments");
				WebElement attachments = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='template']/form/div[13]/div[2]/button")));
				attachments.click();
				
				Configuration.logger.log(LogStatus.INFO,"Select documents");
				WebElement tabdoc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='tab-documents']")));
				tabdoc.click();
				
				WebElement docselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='files-documents']/ul/li[1]/i[2]")));
				ac.doubleClick(docselect).perform();			
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Text tab");
				WebElement texttab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='text-tab']")));
				texttab.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select placeholder");
				WebElement placeholder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Placeholder']")));	
				ac.doubleClick(placeholder).perform();
				Select ddplaceholder = new Select (Configuration.driver.findElement(By.xpath("//select[@id='Placeholder']")));
				ddplaceholder.selectByVisibleText("Template Sender");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
					
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Save button");
				WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-email']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Thread.sleep(10000);
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
	
	
	
	@Test(priority = 5)
	public void EmailtemplateEdit() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
		Actions ac = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Edit Email Template");
		
		try
		{
			
			try
			{
				Thread.sleep(15000);
				Configuration.logger.log(LogStatus.INFO, "Enter text to search email template");
				WebElement srchtemp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-email-wrapper']/div[2]/div[1]/input")));
				srchtemp.click();
				srchtemp.sendKeys("test",Keys.ENTER);
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			
			try
			{
				Thread.sleep(15000);
				Configuration.logger.log(LogStatus.INFO, "Double click row");
				WebElement temprow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-email']/tbody/tr")));
				ac.doubleClick(temprow).perform();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select from group");
				WebElement fromgrp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='FromGroup']")));
				ac.doubleClick(fromgrp).perform();
				Select ddfromgrp = new Select (Configuration.driver.findElement(By.xpath("//select[@id='FromGroup']")));
				ddfromgrp.selectByVisibleText("HR Representative");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Enter email subject");
				WebElement emailsub = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='template']/form/div[7]/div[2]/textarea")));
				emailsub.clear();
				emailsub.sendKeys("Testing HR");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select license type");
				WebElement lic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Restrict']")));
				ac.doubleClick(lic).perform();
				Select ddlic = new Select (Configuration.driver.findElement(By.xpath("//select[@id='Restrict']")));
				ddlic.selectByVisibleText("Bonus Planning");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Save button,edit data");
				WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-email']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
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
	public void EmailtemplateCopy() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
		Actions ac = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Copy Email Template");
		
		try
		{
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click email template row");
				WebElement rowclick= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-email']/tbody/tr")));
				rowclick.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click row edit button");
				WebElement rowcopy= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-email']/tbody/tr[1]/td[1]/div/button")));
				ac.moveToElement(rowcopy).perform();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click copy button");
				WebElement btncopy= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[32]/a[2]/button")));
				ac.moveToElement(btncopy).click().perform();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Copy email template name");
				WebElement tempname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='template']/form/div[3]/div[2]/input")));
				tempname.clear();
				tempname.sendKeys("email test copy");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Save button,copy data");
				WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-email']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
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
	public void Emailtemplatedel() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
		Actions ac = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Delete Email Template");
		
		try
		{
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click email template row");
				WebElement rowclick= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-email']/tbody/tr")));
				rowclick.click();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click row edit button");
				WebElement rowcopy= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-email']/tbody/tr[1]/td[1]/div/button")));
				ac.moveToElement(rowcopy).perform();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click delete button");
				WebElement btncopy= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[32]/a[3]/button")));
				ac.moveToElement(btncopy).click().perform();
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement delemailtemp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
				delemailtemp.click();
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