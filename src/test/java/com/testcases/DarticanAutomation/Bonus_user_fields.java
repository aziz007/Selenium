package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Bonus_user_fields {

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
		srchbox.sendKeys("bonus planning",Keys.ENTER);
		Thread.sleep(10000);		
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Bonus planning row click");
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
			WebElement prepaid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			prepaid.sendKeys("prepaid",Keys.ENTER);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement prepaid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac1.doubleClick(prepaid).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement view = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-column']/div/div/div[2]/form/div[36]/div[1]/div/h6/a")));
			ac1.doubleClick(view).perform();
			
			WebElement da = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-column']/div/div/div[2]/form/div[37]/div[1]/div[3]/label/div")));
			da.click();
			
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change amount_prepaid viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
			
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter value in template column search box");
			WebElement bonususer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			bonususer.clear();
			bonususer.sendKeys("bonus user defined",Keys.ENTER);
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
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_1 viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
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
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_2 viewable type to ON");
			Thread.sleep(5000);
			
			btnsave.sendKeys(Keys.PAGE_DOWN);
			btnsave.sendKeys(Keys.PAGE_DOWN);
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
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_3 viewable type to ON");
			Thread.sleep(5000);
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
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_4 viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
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
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_5 viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement amt1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[6]")));
			ac1.doubleClick(amt1).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_1_amt viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement amt2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[7]")));
			ac1.doubleClick(amt2).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_2_amt viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement amt3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[8]")));
			ac1.doubleClick(amt3).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_3_amt viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement amt4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[9]")));
			ac1.doubleClick(amt4).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
				
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_4_amt viewable type to ON");
			Thread.sleep(5000);
			
			btnsave.sendKeys(Keys.PAGE_DOWN);
			btnsave.sendKeys(Keys.PAGE_DOWN);
			btnsave.sendKeys(Keys.PAGE_DOWN);
			
			 //JavascriptExecutor js = (JavascriptExecutor) driver;
			 
		       //get the height of the webpage and scroll to the end
		      // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			
			JavascriptExecutor js = (JavascriptExecutor) driver;		
			js.executeScript("window.scrollBy(0,3000)");
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement amt5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[10]")));
			ac1.doubleClick(amt5).perform();
			Thread.sleep(8000);
			
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
			
			WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change bonus_user_defined_5_amt viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
	}
}
