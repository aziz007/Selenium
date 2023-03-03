package com.testcases.DarticanAutomation;

//import java.util.List;

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

public class User_fields {

	
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
		srchbox.sendKeys("merit planning");
		Thread.sleep(10000);		
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Merit planning row click");
			WebElement meritplanning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr[1]")));
			meritplanning.click();
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement execlass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			execlass.sendKeys("employee user defined",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement emp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(emp1).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_1 viewable type to ON");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
			
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement emp2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(emp2).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_2 viewable type to ON");	
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement emp3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[3]")));
			ac1.doubleClick(emp3).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_3 viewable type to ON");	
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement emp4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[4]")));
			ac1.doubleClick(emp4).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_4 viewable type to ON");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement emp5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[5]")));
			ac1.doubleClick(emp5).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_5 viewable type to ON");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement empamt1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[6]")));
			ac1.doubleClick(empamt1).perform();
			Thread.sleep(8000);

			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_1_amt viewable type to ON");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement empamt2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[7]")));
			ac1.doubleClick(empamt2).perform();
			Thread.sleep(5000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change employee_user_defined_2_amt viewable type to ON");	
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement empamt3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[8]")));
			ac1.doubleClick(empamt3).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_3_amt viewable type to ON");	
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement empamt4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[9]")));
			ac1.doubleClick(empamt4).perform();
			Thread.sleep(5000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_4_amt viewable type to ON");	
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement empamt5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[10]")));
			ac1.doubleClick(empamt5).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_5_amt viewable type to ON");	
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement geo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			geo.clear();
			geo.sendKeys("geographic",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement geo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(geo1).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change geographic_region_1 viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement geo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(geo2).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change geographic_region_2 viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try 
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement geo3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[3]")));
			ac1.doubleClick(geo3).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change geogrpahic_region_3 viewable type to ON");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement execlass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			execlass.clear();
			execlass.sendKeys("executive",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement exe1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(exe1).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change executive_classification_1 viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement exe2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(exe2).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change executive_classification_2 viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement reporting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			reporting.clear();
			reporting.sendKeys("reporting",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement rollup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(rollup).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change reporting_rollup viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement pos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			pos.clear();
			pos.sendKeys("position",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement postitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(postitle).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change position_title viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement poscode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(poscode).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change position_code viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement comp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			comp.clear();
			comp.sendKeys("company_id",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement companyid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(companyid).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change company_id viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement org = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			org.clear();
			org.sendKeys("organization",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement org1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(org1).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change organization_level_1 viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement org2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(org2).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change organization_level_2 viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement org3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[3]")));
			ac1.doubleClick(org3).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change organization_level_3 viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement cost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			cost.clear();
			cost.sendKeys("cost",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement cost1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(cost1).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change cost_center_1 viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO,"Double click row to edit");
			WebElement cost2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(cost2).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select(Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change cost_center_2 viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement budget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			budget.clear();
			budget.sendKeys("budget",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement budget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(budget).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change budget_base_amt viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement last = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			last.clear();
			last.sendKeys("last salary",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement lastsal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(lastsal).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change last_salary_effective_date viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement perpay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			perpay.clear();
			perpay.sendKeys("per pay",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement payamt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(payamt).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change per_pay_amt viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement paytype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[3]")));
			ac1.doubleClick(paytype).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change per_pay_type viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement guide = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			guide.clear();
			guide.sendKeys("guideline_name",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement guideline = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(guideline).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change guideline_name viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement pool = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			pool.clear();
			pool.sendKeys("budget_pool_name",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement budgetpool = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(budgetpool).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change budget_pool_name viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement priorrating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			priorrating.clear();
			priorrating.sendKeys("rating",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement prior = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(prior).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change prior_rating_alpha viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement rating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(rating).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change rating_name viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement fte = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			fte.clear();
			fte.sendKeys("fte",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement fte = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(fte).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change fte viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement ethnicity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			ethnicity.clear();
			ethnicity.sendKeys("ethnicity",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement ethnicity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(ethnicity).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change ethnicity viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			gender.clear();
			gender.sendKeys("gender",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement gender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(gender).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change gender viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement dob = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			dob.clear();
			dob.sendKeys("date of birth",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement dob = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(dob).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change date_of_birth viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement payroll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			payroll.clear();
			payroll.sendKeys("payroll",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement iden = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(iden).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change payroll_identifier viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement freq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(freq).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change payroll_frequency viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement hours = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			hours.clear();
			hours.sendKeys("hours",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement perperiod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(perperiod).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change hours_per_pay_period viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement perweek = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]")));
			ac1.doubleClick(perweek).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change hours_per_week viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
			
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			email.clear();
			email.sendKeys("email",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(email).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO,"Change email_address viewable type to ON");
		}
		
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
	}
}
