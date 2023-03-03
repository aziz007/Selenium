package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Settings {
	
	
	public static WebDriver driver;
	
	
	
	@Test (description = "enter credentials and hit enter button",priority =1)
		
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
			Thread.sleep(10000);			
			
		}
		catch (Exception e) {
			// TODO: handle the exception
		System.out.println("button not clicked");
		
	}

	}

	@Test (description = "mouse over function",priority =2)
	public void mouseover() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Settings Screen");
		Configuration.logger.log(LogStatus.INFO, "Mouse over to Configuration menu");
		WebElement conf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
		//conf.click();
		
		
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(conf).perform();
		
		Configuration.logger.log(LogStatus.INFO, "Click Settings link");
		WebElement cycle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[2]/div/ul/li[1]/a")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
		ac.moveToElement(cycle).click().perform();
		Thread.sleep(3000);


	}
	
	@Test(priority = 3)
	public void SetSettings() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 60);
		Actions ac1 = new Actions(Configuration.driver);

		//WebElement Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"application\"]/div/div[1]/div[2]/input")));
		//Title.clear();
		//Title.sendKeys("Compensation Planning");
		Configuration.logger = Configuration.extent.startTest("Application Tab");
		
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter application title");
					WebElement applicationtitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='application']/div/div[1]/div[2]/input")));
					applicationtitle.clear();
					applicationtitle.sendKeys("Compensation Planning");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Select Always show home page image");
					WebElement homeimage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='application']/div/div[6]/div[2]/label/span[2]")));
					ac1.doubleClick(homeimage).perform();				
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Open Skin Name drop-down list");
					WebElement Skinname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='SkinName']")));
					ac1.click(Skinname).perform();
					Configuration.logger.log(LogStatus.INFO, "Select Default");
					Select dropdownskin = new Select (Configuration.driver.findElement(By.xpath("//select[@id='SkinName']")));
					dropdownskin.selectByVisibleText("Default");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Open Client Time Zone drop-down list");
					WebElement timezone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='GuidelineEnforcement']")));
					ac1.click(timezone).perform();
					Configuration.logger.log(LogStatus.INFO, "Select North America Central");
					Select dropdownskin = new Select (Configuration.driver.findElement(By.xpath("//select[@id='GuidelineEnforcement']")));
					dropdownskin.selectByVisibleText("North America Central");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Select Is Localization Enabled");
					WebElement localization = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='application']/div/div[12]/div[2]/label/span[2]")));
					ac1.doubleClick(localization).perform();			
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Select Audit Logins");
					WebElement audit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='application']/div/div[13]/div[2]/label/span[2]")));
					ac1.doubleClick(audit).perform();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
				
							
				
				
				try
				{
					Configuration.logger = Configuration.extent.startTest("Compensation Tab");
					WebElement compensation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='compsetting-tab']")));
					compensation.click();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL, e);
				}
							
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Check submission email");
					WebElement submissionemail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='compsetting']/div/div[2]/div[2]/label/span[3]")));
					submissionemail.click();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "check use submit tracking ");
					WebElement tracking = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='compsetting']/div/div[3]/div[2]/label/span[3]")));
					tracking.click();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Click job code");
					WebElement jobcode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='compsetting']/div/div[5]/div[3]/label/div")));
					jobcode.click();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter default submit text");
					WebElement defaulttext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='compsetting']/div/div[9]/div[2]/textarea")));
					defaulttext.clear();
					defaulttext.sendKeys("Sample Submit Text");
				}
				catch(Exception e)
				{
					throw(e);
				}
				
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Check Allow export to excel");
					WebElement export = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='compsetting']/div/div[11]/div[2]/label/span[3]")));
					ac1.doubleClick(export).perform();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Check Show Corporate currency option");
					WebElement corporate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='compsetting']/div/div[12]/div[2]/label/span[3]")));
					ac1.doubleClick(corporate).perform();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Check show hourly plan option");
					WebElement hourly = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='compsetting']/div/div[13]/div[2]/label/span[3]")));
					ac1.doubleClick(hourly).perform();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Check show monthly plan option");
					WebElement hourly = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='compsetting']/div/div[14]/div[2]/label/span[3]")));
					ac1.doubleClick(hourly).perform();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Check target based bonus calc");
					WebElement hourly = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='compsetting']/div/div[17]/div[2]/label/span[3]")));
					ac1.doubleClick(hourly).perform();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				
				
				try
				{
					Configuration.logger = Configuration.extent.startTest("Access Tab");
					WebElement access = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='pasword-tab']")));
					access.click();
					access.sendKeys(Keys.ARROW_UP);
					access.sendKeys(Keys.ARROW_UP);
					
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}			
			
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter minimum length");
					WebElement minimumlength = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div[13]/div[2]/div[2]/input")));
					minimumlength.clear();
					minimumlength.sendKeys("0",Keys.TAB);
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter unique passwords");
					WebElement requniqpass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div[13]/div[3]/div[2]/input")));
					requniqpass.clear();
					requniqpass.sendKeys("0",Keys.TAB);
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter minimum uppercase characters");
					WebElement uppercase = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div[13]/div[4]/div[2]/input")));
					uppercase.clear();
					uppercase.sendKeys("0",Keys.TAB);
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter minimum lowercase characters");
					WebElement lowercase = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div[13]/div[5]/div[2]/input")));
					lowercase.clear();
					lowercase.sendKeys("0",Keys.TAB);
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter minimum special characters");
					WebElement specialchar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div[13]/div[6]/div[2]/input")));
					specialchar.clear();
					specialchar.sendKeys("0",Keys.TAB);
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter minimum numeric characters");
					WebElement numericchar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div[13]/div[7]/div[2]/input")));
					numericchar.clear();
					numericchar.sendKeys("0",Keys.TAB);
					numericchar.sendKeys(Keys.TAB);
					numericchar.sendKeys(Keys.ARROW_DOWN);
					numericchar.sendKeys(Keys.ARROW_DOWN);
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Unlock grid");
					WebElement unlock = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div[14]/div[1]/div/span[2]")));
					unlock.click();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Select employee id padding drop down list");
					WebElement padding = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='EmployeeIdPadDefinition']")));	
					ac1.click(padding).perform();			
					Thread.sleep(5000);
					Select dropdownpadding = new Select (Configuration.driver.findElement(By.xpath("//*[@id='EmployeeIdPadDefinition']")));
					dropdownpadding.selectByVisibleText("Left");
					Configuration.logger.log(LogStatus.INFO, "Select Left");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter employee id size");
					WebElement idsize = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div[16]/div[2]/input")));
					idsize.clear();
					idsize.sendKeys("1");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Enter pad character");
					WebElement padchar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='password']/div/div[17]/div[2]/input")));
					padchar.clear();
					padchar.sendKeys("@");
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
				
				
				
				try
				{
					Configuration.logger.log(LogStatus.INFO, "Click save button");
					WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='settings-view']/div/div/div/div/div[1]/div/button[3]")));
					save.click();
				}
				catch(Exception e)
				{
					Configuration.logger.log(LogStatus.FAIL,e);
				}
	}
}
