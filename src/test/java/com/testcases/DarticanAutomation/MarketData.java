package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class MarketData {
	
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
		this.notify();
		Thread.sleep(20000);
		
	} catch (Exception e) {
		// TODO: handle exception
	System.out.println("button not clicked");
	
}

}

@Test (description = "mouse over function",priority =2)
public void mouseover() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
	Configuration.logger = Configuration.extent.startTest("Market Data Page");
	Configuration.logger.log(LogStatus.INFO, "Mouse over function");
	try
	{
		WebElement config = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));			
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(config).perform();
		
		Configuration.logger.log(LogStatus.INFO, "Click Market data link");
		WebElement marketdata = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='89']")));
		ac.moveToElement(marketdata).click().perform();
		Thread.sleep(5000);
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL, e);
	}
}

@Test(priority = 3)
public void ValidationErrors() throws Exception {
	
	
	String mdsourceerrorexpected = "External source is required";
	String effdateexpectederror = "Effective date is required";
		
	try 
	{
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Check Form Validation Errors");
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click add button");
			WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-market-source-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
			AddButton.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}

		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click save button without entering data");
			WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try 
		{
			String mdsourceerror = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[2]/div[2]/span"))).getText();
			Assert.assertEquals(mdsourceerror, mdsourceerrorexpected);
			
			if(mdsourceerror.equals(mdsourceerrorexpected))
			{
				Configuration.logger.log(LogStatus.INFO, mdsourceerrorexpected);
			}
			
		} catch (AssertionError e) 
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			String effdateerror = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[3]/div[2]/div[2]"))).getText();
			Assert.assertEquals(effdateerror, effdateexpectederror);
			
			if(effdateerror.equals(effdateexpectederror))
			{
				Configuration.logger.log(LogStatus.INFO, effdateexpectederror);
			}
			
		} catch (AssertionError e) 
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click cancel button");
			WebElement btncancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[3]/div[2]/button[1]")));
			btncancel.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL, e);
	}
}

@Test(priority = 4)
public void AddMarketdata() throws Exception {
	
	try
	{
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Add Market Data");
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click add button");
			WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-market-source-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
			AddButton.click();
			this.notify();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}

		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter market data source" );
			WebElement MDsource = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[2]/div[2]/input")));
			MDsource.sendKeys("md test");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter effective date");
			WebElement Effdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[3]/div[2]/div[1]/input")));
			Effdate.sendKeys("10/13/2022");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter plan year");
			WebElement planyear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[4]/div[2]/input")));
			planyear.sendKeys("2022");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO,"Click save button");
			WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL, e);
	}
}


@Test(priority = 5)
public void EditMarketdata() throws Exception {
	
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Edit Market Data");
	try
	{			
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double row click");
			WebElement doubleclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-market-source']/tbody/tr")));
			ac1.doubleClick(doubleclick).perform();
			this.notify();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}

		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit market data source");
			WebElement MDsource = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[2]/div[2]/input")));
			MDsource.clear();
			MDsource.sendKeys("edit md test");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit effective date");
			WebElement Effdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[3]/div[2]/div[1]/input")));
			Effdate.clear();
			Effdate.sendKeys("10/15/2022");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit plan year");
			WebElement planyear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[4]/div[2]/input")));
			planyear.clear();
			planyear.sendKeys("2021");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO,"Click save&new button");
			WebElement btnnew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[3]/div[2]/button[3]")));
			btnnew.click();
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		Configuration.logger = Configuration.extent.startTest("Add new Market Data");
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter market data source" );
			WebElement MDsource = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[2]/div[2]/input")));
			MDsource.clear();
			MDsource.sendKeys("md test new");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter effective date");
			WebElement Effdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[3]/div[2]/div[1]/input")));
			Effdate.clear();
			Effdate.sendKeys("10/13/2022");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter plan year");
			WebElement planyear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[2]/form/div[4]/div[2]/input")));
			planyear.sendKeys("2021");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO,"Click save button");
			WebElement btnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-source']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
}


@Test(priority = 9)
public void DeleteMarketdata() throws Exception {
	
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Delete Market Data");
	try 
	{	
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Move to delete button");
			WebElement btndel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-market-source']/tbody/tr/td[1]/div/button")));
			ac1.moveToElement(btndel).perform();
			Configuration.logger.log(LogStatus.INFO, "Click delete button");
			WebElement delclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[16]/a[2]/button")));
			ac1.moveToElement(delclick).click().perform();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click yes button");
			WebElement btnyes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
			btnyes.click();
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
public void AddMarketdataadmin() throws Exception {
	
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Add Market Data Administration");
	try
	{
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click add button");
			WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-data-detail-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
			AddButton.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter Identifier");
			WebElement identifier = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[3]/div[2]/input")));
			identifier.sendKeys("IDE");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter Identifier Description");
			WebElement identifierdes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[4]/div[2]/input")));
			identifierdes.sendKeys("IDE description");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter DataPoint");
			WebElement datapoint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[5]/div[2]/input")));
			datapoint.sendKeys("DP12");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click IsActive");
			WebElement isactive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[6]/div[2]/label/div")));
			isactive.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Select Currency Code");
			WebElement currencycode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='CurrencyCode']")));
			ac1.doubleClick(currencycode).perform();
			Select currencydropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='CurrencyCode']")));
			currencydropdown.selectByVisibleText("US Dollar");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter MarketBaseAmt");
			WebElement marketbaseamt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[8]/div[2]/input")));
			marketbaseamt.sendKeys("100");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter MarketBonusValue");
			WebElement marketbonusvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[9]/div[2]/input")));
			marketbonusvalue.sendKeys("1000");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter MarketBonusPct");
			WebElement marketbonuspct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[10]/div[2]/input")));
			marketbonuspct.sendKeys("1");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter MarketLtiValue");
			WebElement marketltivalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[11]/div[2]/input")));
			marketltivalue.sendKeys("1000");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter MarketLtiPct");
			WebElement marketltipct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[12]/div[2]/input")));
			marketltipct.sendKeys("1");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter MarketTtc");
			WebElement marketTtc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[13]/div[2]/input")));
			marketTtc.sendKeys("1");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Enter MarketTdc");
			WebElement marketTdc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[14]/div[2]/input")));
			marketTdc.sendKeys("1");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click Save");
			WebElement clicksave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[3]/div[2]/button[2]")));
			clicksave.click();
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.FAIL,e);
	}
}
@Test(priority = 7)
public void EditMarketdataadmin() throws Exception {
	
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Edit Market Data Administration");
	try
	{
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row");
			WebElement doubleclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-data-detail']/tbody/tr")));
			ac1.doubleClick(doubleclick).perform();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit Identifier ");
			WebElement identifier = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[3]/div[2]/input")));
			identifier.clear();
			identifier.sendKeys("IDE");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit Identifier Description");
			WebElement identifierdes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[4]/div[2]/input")));
			identifierdes.clear();
			identifierdes.sendKeys("IDE description");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit DataPoint");
			WebElement datapoint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[5]/div[2]/input")));
			datapoint.clear();
			datapoint.sendKeys("DP12");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click IsActive");
			WebElement isactive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[6]/div[2]/label/div")));
			isactive.click();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Select Currency Code");
			WebElement currencycode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='CurrencyCode']")));
			ac1.doubleClick(currencycode).perform();
			Select currencydropdown = new Select (Configuration.driver.findElement(By.xpath("//select[@id='CurrencyCode']")));
			currencydropdown.selectByVisibleText("US Dollar");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit MarketBaseAmt");
			WebElement marketbaseamt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[8]/div[2]/input")));
			marketbaseamt.clear();
			marketbaseamt.sendKeys("100");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit MarketBonusValue");
			WebElement marketbonusvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[9]/div[2]/input")));
			marketbonusvalue.clear();
			marketbonusvalue.sendKeys("1000");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit MarketBonusPct");
			WebElement marketbonuspct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[10]/div[2]/input")));
			marketbonuspct.clear();
			marketbonuspct.sendKeys("1");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit MarketLtiValue");
			WebElement marketltivalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[11]/div[2]/input")));
			marketltivalue.clear();
			marketltivalue.sendKeys("1000");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit MarketLtiPct");
			WebElement marketltipct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[12]/div[2]/input")));
			marketltipct.clear();
			marketltipct.sendKeys("1");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit MarketTtc");
			WebElement marketTtc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[13]/div[2]/input")));
			marketTtc.clear();
			marketTtc.sendKeys("1");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Edit MarketTdc");
			WebElement marketTdc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[2]/form/div[14]/div[2]/input")));
			marketTdc.clear();
			marketTdc.sendKeys("1");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click save&new button");
			WebElement clicksave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[3]/div[2]/button[3]")));
			clicksave.click();
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click cancel button");
			WebElement btncancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-data-detail']/div/div/div[3]/div[2]/button[1]")));
			btncancel.click();
			Thread.sleep(3000);
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
public void DeleteMarketdataadmin() throws Exception {
	
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Delete Market Data Administration");
	try 
	{		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Move to delete button");
			WebElement btndel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-data-detail']/tbody/tr/td[1]/div/button")));
			ac1.moveToElement(btndel).perform();
			Configuration.logger.log(LogStatus.INFO, "Click delete button");
			WebElement delclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[16]/a[2]/button")));
			ac1.moveToElement(delclick).click().perform();
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Click yes button");
			WebElement btnyes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='confirm-delete']/div/div/div[3]/button[1]")));
			btnyes.click();
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
}