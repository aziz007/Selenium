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

public class Lti_user_fields {
						
	
	public static WebDriver driver;
	@Test (description = "enter credentials and hit enter button",priority =1)
		
		public void login() {
		Configuration.logger = Configuration.extent.startTest("Valid login");
		//Put this line after every step to track them.(for reporting)
		Configuration.logger.log(LogStatus.INFO, "Entering username");
		Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
		Configuration.logger.log(LogStatus.INFO, "Entering password");
		Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
		
		try {
			Configuration.logger.log(LogStatus.INFO, "Click submit button");
			Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
			System.out.println("Login successfully");
			System.out.println("--------------------------");
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println("button not clicked");
		
	}

	}
		
	@Test (description = "mouse over function",priority =2)
	public void mouseover() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Templates Page");
		Configuration.logger.log(LogStatus.INFO, "Mouse over function");
		WebElement conf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='10']")));
		//conf.click();
		
		
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(conf).perform();
		
		Configuration.logger.log(LogStatus.INFO, "Click template link");
		WebElement cycle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='53']")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
		ac.moveToElement(cycle).click().perform();
		System.out.println("Templates Page");
		System.out.println("--------------------------");

	}
	
	
	@Test(description = "Templates Page(verify templates columns)",priority =5)
	public void Templates() throws InterruptedException
	{			
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Enter in template search box");
		WebElement srchbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
		srchbox.sendKeys("lti planning",Keys.ENTER);
		Thread.sleep(10000);		
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "LTI planning row click");
			WebElement ltiplanning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr[1]")));
			ltiplanning.click();
			Thread.sleep(2000);
			ltiplanning.sendKeys(Keys.PAGE_DOWN);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement prior = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			prior.sendKeys("prior_grant",Keys.ENTER);
			Thread.sleep(5000);
			prior.sendKeys(Keys.PAGE_DOWN);
			prior.sendKeys(Keys.PAGE_DOWN);
			prior.sendKeys(Keys.PAGE_DOWN);
			prior.sendKeys(Keys.PAGE_DOWN);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement shares = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(shares).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change prior_grant_shares viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			
			WebElement value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(value).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change prior_grant_value viewable type to ON");
			Thread.sleep(5000);
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement equity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			equity.clear();
			equity.sendKeys("unvested_equity_value",Keys.ENTER);
			Thread.sleep(5000);
			equity.sendKeys(Keys.PAGE_DOWN);
			
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement unvested = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(unvested).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change unvested_equity_value viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement stock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			stock.clear();
			stock.sendKeys("stock",Keys.ENTER);
			Thread.sleep(5000);
			stock.sendKeys(Keys.PAGE_DOWN);
			stock.sendKeys(Keys.PAGE_DOWN);
			stock.sendKeys(Keys.PAGE_DOWN);
			stock.sendKeys(Keys.PAGE_DOWN);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement stlocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(stlocation).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change stock_location_group viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement stgroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(stgroup).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change stock_group viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement stitem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[3]")));
			ac1.doubleClick(stitem).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change stock_group_item viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement stguideline = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[4]")));
			ac1.doubleClick(stguideline).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change stock_guideline viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement lti = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			lti.clear();
			lti.sendKeys("lti user",Keys.ENTER);
			Thread.sleep(5000);
			lti.sendKeys(Keys.PAGE_DOWN);
			lti.sendKeys(Keys.PAGE_DOWN);
			lti.sendKeys(Keys.PAGE_DOWN);
			lti.sendKeys(Keys.PAGE_DOWN);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(user1).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change lti_user_defined_1 viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(user2).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change lti_user_defined_2 viewable type to ON");
			Thread.sleep(8000);			
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[3]")));
			ac1.doubleClick(user3).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change lti_user_defined_3 viewable type to ON");
			Thread.sleep(8000);		
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[4]")));
			ac1.doubleClick(user4).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change lti_user_defined_4 viewable type to ON");
			Thread.sleep(8000);		
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[5]")));
			ac1.doubleClick(user5).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change lti_user_defined_5 viewable type to ON");
			Thread.sleep(8000);		
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user1amt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[6]")));
			ac1.doubleClick(user1amt).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change lti_user_defined_1_amt viewable type to ON");
			Thread.sleep(8000);		
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user2amt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[7]")));
			ac1.doubleClick(user2amt).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change lti_user_defined_2_amt viewable type to ON");
			Thread.sleep(8000);		
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user3amt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[8]")));
			ac1.doubleClick(user3amt).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change lti_user_defined_3_amt viewable type to ON");
			Thread.sleep(8000);		
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user4amt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[9]")));
			ac1.doubleClick(user4amt).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change lti_user_defined_4_amt viewable type to ON");
			Thread.sleep(8000);		
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO,"Double click row to edit");
			WebElement user5amt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[10]")));
			ac1.doubleClick(user5amt).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change lti_user_defined_5_amt viewable type to ON");
			Thread.sleep(8000);		
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		
	}
}
