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

public class DocumentsNLinks {

	
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
		Configuration.logger = Configuration.extent.startTest("Documents&Links Page");
		Configuration.logger.log(LogStatus.INFO, "Mouse over function");
		WebElement conf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
		//conf.click();
		
		
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(conf).perform();
		
		Configuration.logger.log(LogStatus.INFO, "Click Documents&Links link");
		WebElement choicelist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[2]/div/ul/li[11]/a")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
		ac.moveToElement(choicelist).click().perform();
		Thread.sleep(3000);


	}
	
	
	
	@Test (priority = 3)
	public  void DocumentsValidation() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Documents&Links Validation check");
		
		
		try 
		{
				WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
				String errorexpected  = "Link type is required";
				String error1expected = "Link section is required";
				String error2expected = "This field is required";
				
				try
				{
					WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-document-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
					AddButton.click();
					Configuration.logger.log(LogStatus.INFO, "Click Add Button");
				
					Configuration.logger.log(LogStatus.INFO, "Click save button,'without entering data'");
					WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='modal-document']/div/div/div[3]/div[2]/button[2]"))));
					savebtn.click();
					Thread.sleep(5000);
				
					
					String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-document']/div/div/div[2]/form/div[2]/div[2]/span"))).getText();
					Assert.assertEquals(errorread, errorexpected);
					
					if(errorread.equals(errorexpected))
					{
						Configuration.logger.log(LogStatus.INFO, errorexpected);
					}
					
					
					String error1read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-document']/div/div/div[2]/form/div[3]/div[2]/span"))).getText();
					Assert.assertEquals(error1read, error1expected);
					
					if(error1read.equals(error1expected))
					{
						Configuration.logger.log(LogStatus.INFO, error1read);
					}
					
					
					String error2read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-document']/div/div/div[2]/form/div[8]/div[2]/span"))).getText();
					Assert.assertEquals(error2read, error2expected);
					
					if(error2read.equals(error2expected))
					{
						Configuration.logger.log(LogStatus.INFO, error2read);
					}
				}
				
					catch(Exception e)
					{
						Configuration.logger.log(LogStatus.FAIL, e);
					}
					
					Configuration.logger.log(LogStatus.INFO, "Click cancel button");
					WebElement cancelbtn = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@id='modal-document']/div/div/div[3]/div[2]/button[1]"))));
					cancelbtn.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
	
	}
	
	@Test(priority = 4)
	public void AddDocs() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Add Documents and Links");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
				try
				{
					WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-document-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
					AddButton.click();
					Configuration.logger.log(LogStatus.INFO, "Click Add Button");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				
				try
				{
					WebElement linktype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='LinkType']")));
					ac1.moveToElement(linktype).perform();
					Select linkdropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='LinkType']")));
					linkdropdown.selectByVisibleText("Menus");
					Configuration.logger.log(LogStatus.INFO,"Select Link Type");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				
				try
				{
					WebElement linksection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='LinkSection']")));
					ac1.moveToElement(linksection).perform();
					Select groupdropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='LinkSection']")));
					groupdropdown.selectByVisibleText("Startup Materials");
					Configuration.logger.log(LogStatus.INFO,"Select Link Section");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				
				try
				{
					WebElement menuitem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='Menu']")));
					ac1.moveToElement(menuitem).perform();
					Select menudropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='Menu']")));
					menudropdown.selectByVisibleText("Cycles");
					Configuration.logger.log(LogStatus.INFO,"Select menu item name");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
			
				
				try
				{
					WebElement linkname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-document']/div/div/div[2]/form/div[11]/div[2]/input")));
					linkname.sendKeys("1");
					Configuration.logger.log(LogStatus.INFO, "Enter List Sequence");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
			
				
				try
				{
					WebElement newwindow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-document']/div/div/div[2]/form/div[12]/div[2]/label/div")));
					newwindow.click();
					Configuration.logger.log(LogStatus.INFO, "Select link in new window");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try 
				{
					Configuration.logger.log(LogStatus.INFO, "Click save button");
					WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='modal-document']/div/div/div[3]/div[2]/button[2]"))));
					savebtn.click();
					Thread.sleep(15000);
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
	
	
	@Test(priority = 5)
	public void Editdocs() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Edit Documents and Links");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			try
			{
				WebElement searchtxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grid-document-wrapper']/div[2]/div[1]/input")));
				searchtxt.sendKeys("cycles",Keys.ENTER);
				Thread.sleep(30000);
				Configuration.logger.log(LogStatus.INFO, "enter cycles in search box");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
	
			try
			{
				WebElement doubleclickrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
				ac1.doubleClick(doubleclickrow).perform();
				Thread.sleep(5000);
				Configuration.logger.log(LogStatus.INFO, "double row click to edit");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			
			try
			{
				WebElement linktype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='LinkType']")));
				ac1.moveToElement(linktype).perform();
				Select linkdropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='LinkType']")));
				linkdropdown.selectByVisibleText("URL");
				Configuration.logger.log(LogStatus.INFO,"Select Link Type");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				WebElement linksection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='LinkSection']")));
				ac1.moveToElement(linksection).perform();
				Select groupdropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='LinkSection']")));
				groupdropdown.selectByVisibleText("Training Materials");
				Configuration.logger.log(LogStatus.INFO,"Select Link Section");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Click save button,'edit data'");
				WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='modal-document']/div/div/div[3]/div[2]/button[2]"))));
				savebtn.click();
				Thread.sleep(5000);
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
	
	
	
	
	@Test(priority = 6)
	public void CopyDocs() throws Exception {
		
		Configuration.logger = Configuration.extent.startTest("Copy Documents and Links");
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{		
			try
			{
				WebElement clickrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-document']/tbody/tr[1]")));
				ac1.click(clickrow).perform();
				Thread.sleep(3000);
				WebElement copylink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-document']/tbody/tr[1]/td[1]/div/button")));
				ac1.moveToElement(copylink).perform();
				WebElement btncopy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[36]/a[2]/button")));
				ac1.moveToElement(btncopy).click().perform();
				Configuration.logger.log(LogStatus.INFO, "Click copy button choice list");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
		
			try
			{
				WebElement linktype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='LinkType']")));
				ac1.moveToElement(linktype).perform();
				Select linkdropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='LinkType']")));
				linkdropdown.selectByVisibleText("Quick Links");
				Configuration.logger.log(LogStatus.INFO,"Select Link Type");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			try
			{
				WebElement linksection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='LinkSection']")));
				ac1.moveToElement(linksection).perform();
				Select groupdropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='LinkSection']")));
				groupdropdown.selectByVisibleText("Startup Materials");
				Configuration.logger.log(LogStatus.INFO,"Select Link Section");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click save button,'copy data'");
				WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='modal-document']/div/div/div[3]/div[2]/button[2]"))));
				savebtn.click();
				Thread.sleep(5000);
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
	
	
	@Test(priority = 7)
	public void Deletedocs() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try
		{
			Configuration.logger = Configuration.extent.startTest("Documents and Links delete screen");
			
			try
			{
				Thread.sleep(25000);
				WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-document']/tbody/tr[1]")));
				clickrow.click();
				WebElement docsrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='grid-document']/tbody/tr[1]/td[1]/div/button")));
				ac1.moveToElement(docsrow).perform();		
				WebElement docsdel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[@id='body']/div[36]/a[3]/button")));
				ac1.moveToElement(docsdel).click().perform();
				Thread.sleep(3000);
				Configuration.logger.log(LogStatus.INFO, "Delete popup message");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement deldocs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
				deldocs.click();
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