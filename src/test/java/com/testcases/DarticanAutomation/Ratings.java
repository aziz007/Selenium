package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Ratings {
	
@Test (description = "enter credentials and hit enter button",priority = 1)
	
	public void login() {
	Configuration.logger = Configuration.extent.startTest("Valid login");
	Configuration.logger.log(LogStatus.INFO, "Entering username");
	Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
	Configuration.logger.log(LogStatus.INFO, "Entering password");
	Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
	
	try {
		Configuration.logger.log(LogStatus.INFO, "Click submit button");
		Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(20000);
		
		} catch (Exception e) {
		// TODO: handle exception
		Configuration.logger.log(LogStatus.FAIL, e);
	
	}
	
}

@Test (description = "mouse over function",priority =2)
public void mouseover() throws InterruptedException {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
	Actions ac = new Actions(Configuration.driver);
	Configuration.logger = Configuration.extent.startTest("Ratings Page");
	
	try 
	{
		Configuration.logger.log(LogStatus.INFO,"Select cycle");
		WebElement selectcycle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='selected-planning-cycle']/ul/li")));
		ac.moveToElement(selectcycle).perform();
		WebElement selectcycle1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='selected-planning-cycle']/ul/li/div/a[2]")));
		ac.moveToElement(selectcycle1).click().perform();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO,e);
	}
	//select specific page
	try
	{
		Configuration.logger.log(LogStatus.INFO, "Mouse over function");
		WebElement conf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[3]/a[@data-menu-id='10']")));		
		ac.moveToElement(conf).perform();
		Configuration.logger.log(LogStatus.INFO, "Click Ratings link");
		WebElement cycle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='56']")));
		ac.moveToElement(cycle).click().perform();
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO,e);
	}

}


@Test(priority = 3)
public void RatingValidation() throws Exception {
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	
	try
	{
		
		String errorexpected = "Rating name is required";
		try
		{
			WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-wrapper']/div/div[1]/div/ul/li[1]")));
			AddButton.click();
			Configuration.logger.log(LogStatus.INFO, "Click ratings add button");
			Thread.sleep(3000);
			
			WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating']/div/div/div[3]/div[2]/button[2]")));
			savebtn.click();
			
			String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating']/div/div/div[2]/form/div[3]/div[2]/span"))).getText();
			Assert.assertEquals(errorread, errorexpected);
			
			if(errorread.equals(errorexpected))
			{
				Configuration.logger.log(LogStatus.INFO, errorexpected);
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
public void AddRatings() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	
	try
	{
					
			try 
			{
				WebElement ratingname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating']/div/div/div[2]/form/div[3]/div[2]/input")));
				ratingname.sendKeys("rt101");
				Configuration.logger.log(LogStatus.INFO, "Enter rating name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			

			try 
			{
				WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Configuration.logger.log(LogStatus.INFO, "Click save button");
				Thread.sleep(5000);
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
public void EditRatings() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac1 = new Actions(Configuration.driver);
	try
	{
		
			try 
			{
				WebElement searchrating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-wrapper']/div[2]/div[1]/input")));
				searchrating.sendKeys("rt101",Keys.ENTER);
				Configuration.logger.log(LogStatus.INFO, "Search rating");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
		
			try 
			{
				Thread.sleep(3000);
				WebElement doubleclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating']/tbody/tr[1]")));
				ac1.doubleClick(doubleclick).click();
				Configuration.logger.log(LogStatus.INFO, "Double click row");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement ratingname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating']/div/div/div[2]/form/div[3]/div[2]/input")));
				ratingname.clear();
				ratingname.sendKeys("rt202");
				Configuration.logger.log(LogStatus.INFO, "Edit rating name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement ratinggroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating']/div/div/div[2]/form/div[4]/div[2]/label/div")));
				ratinggroup.click();
				Configuration.logger.log(LogStatus.INFO, "select rating groups");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}

			try 
			{
				WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Configuration.logger.log(LogStatus.INFO, "Click save button");
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


@Test(priority = 6)
public void CopyRatings() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac1 = new Actions(Configuration.driver);
	try
	{
		try 
		{
			WebElement searchrating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-wrapper']/div[2]/div[1]/input")));
			searchrating.clear();
			searchrating.sendKeys("rt202",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Search rating");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
		try 
		{
			WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating']/tbody/tr[1]")));
			ac1.click(clickrow).perform();
			Configuration.logger.log(LogStatus.INFO, "Click row");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		
			try 
			{
				WebElement copylink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating']/tbody/tr[2]/td[1]/div/button")));
				ac1.moveToElement(copylink).perform();
				WebElement copyclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[14]/a[2]/button/i")));
				ac1.moveToElement(copyclick).click().perform();
				Configuration.logger.log(LogStatus.INFO,"Click copy link");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement ratingname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating']/div/div/div[2]/form/div[3]/div[2]/input")));
				ratingname.clear();
				ratingname.sendKeys("rt303");
				Configuration.logger.log(LogStatus.INFO, "Edit rating name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			

			try 
			{
				WebElement btnsaveandnew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating']/div/div/div[3]/div[2]/button[2]")));
				btnsaveandnew.click();
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



@Test(priority = 7)
public void RatingGroupValidation() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	
	try
	{
		String errorexpected = "Distribution percent is required";
			try 
			{
				WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-group-wrapper']/div[1]/div[1]/div/ul/li[1]")));
				AddButton.click();
				Configuration.logger.log(LogStatus.INFO, "Click rating group add button");
				Thread.sleep(3000);
				
				WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[3]/div[2]/button[2]")));
				savebtn.click();
				Configuration.logger.log(LogStatus.INFO,"click save button without entering data");
				Thread.sleep(2000);
				
				String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[2]/form/div[4]/div[2]/span"))).getText();
				Assert.assertEquals(errorread, errorexpected);
				
				if(errorread.equals(errorexpected));
				{
					Configuration.logger.log(LogStatus.INFO, errorexpected);
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
public void AddRatingGroup() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver,40);
	
	
			
			
			try 
			{
				WebElement ratinggroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[2]/form/div[3]/div[2]/input")));
				ratinggroup.sendKeys("1");
				Configuration.logger.log(LogStatus.INFO, "Enter consolidated rating alpha");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement dispct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[2]/form/div[4]/div[2]/input")));
				dispct.sendKeys("10");
				Configuration.logger.log(LogStatus.INFO, "Enter distribution percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement itemseq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[2]/form/div[4]/div[2]/input")));
				itemseq.sendKeys("1");
				Configuration.logger.log(LogStatus.INFO, "Enter item sequence");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
				Configuration.logger.log(LogStatus.INFO, "Click save button");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
}

@Test(priority = 9)
public void EditRatingGroup() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac = new Actions(Configuration.driver);
	try
	{
			try 
			{
				WebElement searchrating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-group-wrapper']/div[2]/div[1]/input")));
				searchrating.sendKeys("1",Keys.ENTER);
				Configuration.logger.log(LogStatus.INFO, "Search rating group");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
		
	
			try 
			{
				WebElement doubleclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating-group']/tbody/tr[1]")));
				ac.doubleClick(doubleclick).click().perform();
				Configuration.logger.log(LogStatus.INFO, "Double click rating group row");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement ratinggroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[2]/form/div[3]/div[2]/input")));
				ratinggroup.clear();
				ratinggroup.sendKeys("4");
				Configuration.logger.log(LogStatus.INFO, "Enter consolidated rating alpha");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement dispct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[2]/form/div[4]/div[2]/input")));
				dispct.clear();
				dispct.sendKeys("40");
				Configuration.logger.log(LogStatus.INFO, "Enter distribution percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement itemseq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[2]/form/div[4]/div[2]/input")));
				itemseq.clear();
				itemseq.sendKeys("4");
				Configuration.logger.log(LogStatus.INFO, "Enter item sequence");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			try 
			{
				WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-group']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
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
public void RatingitemsValidation() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	
	try
	{
		String errorexpected  = "Rating Alpha is required";
		String error1expected = "Rating Group is required";
		String error2expected = "Distribution Percent is required";
			try 
			{
				WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-item-wrapper']/div[1]/div[1]/div")));
				AddButton.click();
				Configuration.logger.log(LogStatus.INFO, "Click rating items add button");
				Thread.sleep(3000);
				
				WebElement savebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[3]/div[2]/button[2]")));
				savebtn.click();
				Configuration.logger.log(LogStatus.INFO,"click save button without entering data");
				Thread.sleep(2000);
				
				String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[3]/div[2]/span"))).getText();
				Assert.assertEquals(errorread, errorexpected);
				
				if(errorread.equals(errorexpected));
				{
					Configuration.logger.log(LogStatus.INFO, errorexpected);
				}
				
				
				String error1read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[4]/div[2]/span"))).getText();
				Assert.assertEquals(error1read, error1expected);
				
				if(error1read.equals(error1expected));
				{
					Configuration.logger.log(LogStatus.INFO, error1expected);
				}
				
				
				String error2read = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[5]/div[2]/span"))).getText();
				Assert.assertEquals(error2read, error2expected);
				
				if(error2read.equals(error2expected));
				{
					Configuration.logger.log(LogStatus.INFO, error2expected);
				}
			
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
}
@Test(priority = 11)
public void AddRatingItems() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac1 = new Actions(Configuration.driver);
	
	try
	{		
			
			try 
			{
				WebElement ratingalpha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[3]/div[2]/input")));
				ratingalpha.sendKeys("1");
				Configuration.logger.log(LogStatus.INFO, "Enter consolidated rating alpha");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement ratingroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[3]/div[2]/input")));
				ac1.click(ratingroup).perform();
				Select groupdropdown = new Select (Configuration.driver.findElement(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[4]/div[2]/select")));
				groupdropdown.selectByVisibleText("4");	
				Configuration.logger.log(LogStatus.INFO, "Select rating group");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement dispct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[5]/div[2]/input")));
				dispct.sendKeys("10");
				Configuration.logger.log(LogStatus.INFO, "Enter distribution percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement itemseq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[6]/div[2]/input")));
				itemseq.sendKeys("1");
				Configuration.logger.log(LogStatus.INFO, "Enter item sequence");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
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

@Test(priority = 12)
public void EditRatingItems() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac1 = new Actions(Configuration.driver);
	
	try
	{
		
			try 
			{
				WebElement searchrating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-item-wrapper']/div[2]/div[1]/input")));
				searchrating.sendKeys("1",Keys.ENTER);
				Configuration.logger.log(LogStatus.INFO, "Search rating items");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement doubleclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating-item']/tbody/tr")));
				ac1.doubleClick(doubleclick).perform();
				Configuration.logger.log(LogStatus.INFO, "Double click rating items");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement ratingalpha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[3]/div[2]/input")));
				ratingalpha.clear();
				ratingalpha.sendKeys("2");
				Configuration.logger.log(LogStatus.INFO, "Enter consolidated rating alpha");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement ratingroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[3]/div[2]/input")));
				ac1.click(ratingroup).perform();
				Select groupdropdown = new Select (Configuration.driver.findElement(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[4]/div[2]/select")));
				groupdropdown.selectByVisibleText("4");	
				Configuration.logger.log(LogStatus.INFO, "Select rating group");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement dispct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[5]/div[2]/input")));
				dispct.clear();
				dispct.sendKeys("20");
				Configuration.logger.log(LogStatus.INFO, "Enter distribution percent");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			try
			{
				WebElement itemseq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[2]/form/div[6]/div[2]/input")));
				itemseq.clear();
				itemseq.sendKeys("2");
				Configuration.logger.log(LogStatus.INFO, "Enter item sequence");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			try 
			{
				WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-rating-item']/div/div/div[3]/div[2]/button[2]")));
				btnsave.click();
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


@Test(priority = 13)
public void DelRatingItems() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac1 = new Actions(Configuration.driver);
	
	try
	{
			try 
			{
				WebElement searchrating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-items-wrapper']/div[2]/div[1]/input")));
				searchrating.sendKeys("2",Keys.ENTER);
				Configuration.logger.log(LogStatus.INFO, "Search rating items");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
		
		
			try 
			{
				WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating-item']/tbody/tr")));
				clickrow.click();
				WebElement rowbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating-item']/tbody/tr/td[2]/div/button")));
				ac1.moveToElement(rowbtn).perform();
				WebElement btndel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[12]/a[2]/button")));
				ac1.moveToElement(btndel).click().perform();
				Configuration.logger.log(LogStatus.INFO, "Deleting rating items");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement btnyes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
				btnyes.click();
				Configuration.logger.log(LogStatus.INFO, "Click yes to confirm deletion");
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


@Test(priority = 14)
public void DelRatingGroup() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac1 = new Actions(Configuration.driver);
	
	try
	{
		try 
		{
			WebElement searchrating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-group-wrapper']/div[2]/div[1]/input")));
			searchrating.sendKeys("4",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Search rating group");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
		try 
			{
				WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating-group']/tbody/tr[1]")));
				clickrow.click();
				WebElement rowbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating-group']/tbody/tr[1]/td[1]/div/button")));
				ac1.moveToElement(rowbtn).perform();
				WebElement btndel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[12]/a[2]/button")));
				ac1.moveToElement(btndel).click().perform();
				Configuration.logger.log(LogStatus.INFO, "Deleting rating groups");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement btnyes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
				btnyes.click();
				Configuration.logger.log(LogStatus.INFO, "Click yes to confirm deletion");
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


@Test(priority = 15)
public void DelRating() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 40);
	Actions ac1 = new Actions(Configuration.driver);
	
	try
	{
		try 
		{
			WebElement searchrating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-rating-wrapper']/div[2]/div[1]/input")));
			searchrating.sendKeys("rt303",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Search rating");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL, e);
		}
		
			try 
			{
				WebElement clickrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating']/tbody/tr[1]")));
				clickrow.click();
				WebElement rowbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-rating']/tbody/tr[1]/td[1]/div/button")));
				ac1.moveToElement(rowbtn).perform();
				WebElement btndel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[12]/a[3]/button")));
				ac1.moveToElement(btndel).click().perform();
				Configuration.logger.log(LogStatus.INFO, "Deleting rating");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try 
			{
				WebElement btnyes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
				btnyes.click();
				Configuration.logger.log(LogStatus.INFO, "Click yes to confirm deletion");
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
