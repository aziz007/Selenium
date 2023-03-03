package com.testcases.DarticanAutomation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Bonus_Plannning {
		
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
				
			} catch (Exception e) {
				// TODO: handle exception
			System.out.println("button not clicked");
			
		}

		}
		
		
		@Test (description = "mouse over function",priority =2)
		public void mouseover() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
			Configuration.logger = Configuration.extent.startTest("Cycle Page");
			Configuration.logger.log(LogStatus.INFO, "Mouse over function");
			WebElement conf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
			//conf.click();
			
			
			Actions ac = new Actions(Configuration.driver);
			ac.moveToElement(conf).perform();
			
			Configuration.logger.log(LogStatus.INFO, "Click cycle link");
			WebElement cycle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='83']")));
			//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
			
			ac.moveToElement(cycle).click().perform();
			

		}

		@Test(description = "Create Cycle",priority =3)
		public void AddCycle() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
			Actions ac1 = new Actions(Configuration.driver);
		try
		{	
			WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-planning-cycle-wrapper']/div[2]/div[1]/div/ul/li[1]")));
			AddButton.click();
			Configuration.logger.log(LogStatus.INFO, "Click Add button");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			
			WebElement CycleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CycleName']")));
			CycleName.sendKeys("Automation Cycle151");
			Configuration.logger.log(LogStatus.INFO, "Entering Cycle name");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			WebElement BonusCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[3]/div[4]/label/div")));
			BonusCheckbox.click();
			Configuration.logger.log(LogStatus.INFO, "Click Bonus planning");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			WebElement rankingtype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='PerformanceRankingType']")));	
			ac1.doubleClick(rankingtype).perform();
			Select dropdownrating = new Select (Configuration.driver.findElement(By.xpath("//select[@id='PerformanceRankingType']")));
			dropdownrating.selectByVisibleText("Performance Ratings");
			Configuration.logger.log(LogStatus.INFO, "Select Ranking type");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{	
			WebElement SalaryEffDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[5]/div[2]/div/input")));
			SalaryEffDate.sendKeys("26/11/2022");
			Configuration.logger.log(LogStatus.INFO, "Select salary effective date");
		}
		catch(Exception e) 
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			WebElement currencyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[6]/div[2]/label/div")));
			currencyCheckbox.click();
			Configuration.logger.log(LogStatus.INFO, "Click Currency");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			WebElement currencyname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[6]/div[4]/select")));
			ac1.doubleClick(currencyname).perform();			
			Select dropdowncurrency = new Select (Configuration.driver.findElement(By.xpath("//select[@id='CurrencyName']")));
			dropdowncurrency.selectByVisibleText("US Dollar");
			Configuration.logger.log(LogStatus.INFO, "Select currency name");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			WebElement impbonushisCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[43]/div[4]/label/div")));
			impbonushisCheckbox.click();
			Configuration.logger.log(LogStatus.INFO, "Click import bonus history");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		try
		{
			WebElement prorateincentiveCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[45]/div[4]/label/div")));
			prorateincentiveCheckbox.click();
			Configuration.logger.log(LogStatus.INFO, "Click prorate incentive");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			WebElement prepaidtype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='BonusPrepaidType']")));	
			ac1.doubleClick(prepaidtype).perform();
			Select dropdownprepaid = new Select (Configuration.driver.findElement(By.xpath("//select[@id='BonusPrepaidType']")));
			dropdownprepaid.selectByVisibleText("Add Prepaid");
			Configuration.logger.log(LogStatus.INFO, "Select prepaid type");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO,e);
		}
		
		try
		{
			WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-planning-cycle']/div/div/div[3]/div[2]/button[2]")));
			savebutton.click();
			//Thread.sleep(30000, 100000);
			Configuration.logger.log(LogStatus.INFO, "Click Save Button");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
	}
		
		@Test (description = "Add Incentives",priority =4)
		public void Incentives() throws InterruptedException
		{		
			WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
			Actions ac1 = new Actions(Configuration.driver);
			Configuration.logger = Configuration.extent.startTest("Incentives Page");
			
		try 
			{
				//Thread.sleep(20000);
			try 
			{
				WebElement AddButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-bonusplan-setting-wrapper']/div[1]/div[1]/div/ul/li[1]")));
				AddButton1.click();
				Configuration.logger.log(LogStatus.INFO, "Click Add button");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			try
			{
				WebElement incentivename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[2]/div[2]/input")));
				incentivename.sendKeys("B1");
				Configuration.logger.log(LogStatus.INFO, "Enter incentive name");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			try
			{
				WebElement incentivegroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='IncentiveGroup']")));
				ac1.click(incentivegroup).perform();
				Select dropdowngroup = new Select (Configuration.driver.findElement(By.xpath("//select[@id='IncentiveGroup']")));
				dropdowngroup.selectByVisibleText("Staff Plan");
				Configuration.logger.log(LogStatus.INFO, "Select incentive group");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, e);
			}
			
			try
			{
				WebElement payoutdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[4]/div[2]/div/input")));
				payoutdate.sendKeys("09/28/2022");
				payoutdate.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Enter payout date");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			try
			{	
				WebElement Incstartdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[5]/div[2]/div/input")));
				Incstartdate.sendKeys("09/28/2022");
				Incstartdate.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Enter start date");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			try
			{	
				WebElement Incenddate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[6]/div[2]/div/input")));
				Incenddate.sendKeys("09/30/2022");
				Incenddate.sendKeys(Keys.TAB);
				Configuration.logger.log(LogStatus.INFO, "Enter end date");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			try
			{
				WebElement metricplan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[8]/div[2]/label/div")));
				metricplan.click();		
				Configuration.logger.log(LogStatus.INFO, "Click matric plan");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			try
			{	
				WebElement amt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[10]/div[2]/label/div")));
				amt.click();
				Configuration.logger.log(LogStatus.INFO, "Click amount");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO,e);
			}
			
			try
			{
				WebElement saveinc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[3]/div[2]/button[2]")));
				saveinc.click();
				Configuration.logger.log(LogStatus.INFO, "Click save button");
			}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.INFO, "Bonus incentive not added");
			}
		}
			catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
		}
		
		@Test(description = "Templates Page(verify templates columns)",priority =5)
		public void Templates() throws InterruptedException
		{			
			WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
			Actions ac1 = new Actions(Configuration.driver);
			Configuration.logger = Configuration.extent.startTest("Templates Page");
			
			
			WebElement administration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[3]/a[@data-menu-id='10']")));	
			ac1.moveToElement(administration).perform();
			Configuration.logger.log(LogStatus.INFO, "Mouse over administration");
			
			
			WebElement templates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='53']")));		
			ac1.moveToElement(templates).click().perform();
			Configuration.logger.log(LogStatus.INFO, "Click templates");
			
			
			WebElement bonusplanning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr")));
			bonusplanning.click();
			//Thread.sleep(30000);
			//Thread.sleep(50000, 100000);
			Configuration.logger.log(LogStatus.INFO, "Click bonus planning template name");
			
			
			try
			{
			
			WebElement currencysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			currencysearch.clear();
			currencysearch.sendKeys("Currency",Keys.ENTER);
			//Thread.sleep(2000);
			
			
			List<WebElement> currencycolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : currencycolumns)
			{
				if(names.getText().equals("currency_code"))
				{
					Configuration.logger.log(LogStatus.INFO, "Search and verify currency_code in templates column");							
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for currency");
				}
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
				
			WebElement exchangesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			exchangesearch.clear();
			exchangesearch.sendKeys("exchange",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> exchangecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : exchangecolumns)
			{
				if(names.getText().equals("exchange_rate"))
				{
					Configuration.logger.log(LogStatus.INFO, "Search and verify exchange_rate in templates column");
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for exchange_rate");
				}
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			
			try
			{
			
			WebElement ratingsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			ratingsearch.clear();
			ratingsearch.sendKeys("Rating",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> ratingcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : ratingcolumns)
			{
						
				if(names.getText().equals("rating_name"))
				{				
					WebElement ratingtype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]/td[7]")));				
					Configuration.logger.log(LogStatus.INFO, "rating_name");
					Configuration.logger.log(LogStatus.INFO, ratingtype.getText());
				}
				
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for rating_name");
				}
			}
			
			for(WebElement names1 : ratingcolumns)
			{
						
				if(names1.getText().equals("rating_alpha"))
				{
					WebElement alphatype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[3]/td[7]")));
					Configuration.logger.log(LogStatus.INFO, "rating_alpha");
					Configuration.logger.log(LogStatus.INFO,alphatype.getText());
				}
				if(names1.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for rating_alpha");
				}
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
			
			WebElement proratedsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			proratedsearch.clear();
			proratedsearch.sendKeys("prorated",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> proratedcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : proratedcolumns)
			{
				if(names.getText().equals("prorated_multiplier_pct"))
				{
					Configuration.logger.log(LogStatus.INFO, "Search and verify prorated_multiplier_pct in templates column");
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for prorated_multiplier_pct");
				}
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
			
			WebElement prepaidsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			prepaidsearch.clear();
			prepaidsearch.sendKeys("prepaid",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> prepaidcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : prepaidcolumns)
			{
				if(names.getText().equals("amount_prepaid"))
				{
					Configuration.logger.log(LogStatus.INFO, "Search and verify amount_prepaid in templates column");
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for amount_prepaid");
				}
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			try
			{
			
			WebElement ytdsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			ytdsearch.clear();
			ytdsearch.sendKeys("ytd",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> ytdcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : ytdcolumns)
			{
				if(names.getText().equals("ytd_result"))
				{
					Configuration.logger.log(LogStatus.INFO, "Search and verify ytd_result in templates column");
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for ytd_result");
				}
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
		}
		

		@Test(description = "Import Templates(verify templates column)",priority =6)
		public void Importbonustemplate() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
			Configuration.logger = Configuration.extent.startTest("Import Templates");
			
			
			WebElement importtemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-5091-container']")));
			importtemplate.click();
			WebElement enterkey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='body']/span/span/span[1]/input")));
			enterkey.sendKeys("Import",Keys.ENTER);
			//Thread.sleep(15000);
			
			
			WebElement importsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
			importsearch.sendKeys("employee bonus plans",Keys.ENTER);
			//Thread.sleep(15000);
			
			
			WebElement bonusplans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr")));
			bonusplans.click();
			//Thread.sleep(15000);	
			Configuration.logger.log(LogStatus.INFO, "Click bonus plans template name");
			
			try
			{
			
			WebElement currencysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			currencysearch.clear();
			currencysearch.sendKeys("Currency",Keys.ENTER);
			//Thread.sleep(5000);
			
			
			List<WebElement> currencycolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : currencycolumns)
			{
				if(names.getText().equals("currency_code"))
				{
					Configuration.logger.log(LogStatus.INFO, "Search and verify currency_code in templates column");
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for currency_code");
				}
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			try
			{
			WebElement proratedsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			proratedsearch.clear();
			proratedsearch.sendKeys("prorated",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> proratedcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : proratedcolumns)
			{
				
				if(names.getText().equals("prorated_multiplier_pct"))
				{
					Configuration.logger.log(LogStatus.INFO, "Search and verify prorated_multiplier_pct in templates column");
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for prorated_multiplier_pct");
				}
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			try
			{
			
			WebElement prepaidsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			prepaidsearch.clear();
			prepaidsearch.sendKeys("prepaid",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> prepaidcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : prepaidcolumns)
			{
				if(names.getText().equals("amount_prepaid"))
				{
					Configuration.logger.log(LogStatus.INFO, "Search and verify amount_prepaid in templates column");
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column for amount_prepaid");
				}
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			try
			{
			
			WebElement targetsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			targetsearch.clear();
			targetsearch.sendKeys("target",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> targetcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : targetcolumns)
			{
						
				if(names.getText().equals("target_opportunity_amt"))
				{				
					Configuration.logger.log(LogStatus.INFO, "Search and verify target_opportunity_amt in templates column");		
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column against target");
				}
			}
				
			}
						
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			
			try
			{
					
			WebElement pctsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			pctsearch.clear();
			pctsearch.sendKeys("target_opportunity_pct",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> pctcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : pctcolumns)
			{
						
				if(names.getText().equals("target_opportunity_pct"))
				{				
					Configuration.logger.log(LogStatus.INFO, "Search and verify target_opportunity_pct in templates column");			
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO,"There is no column against target_opportunity_pct");
				}
			}
				
			}
						
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			
			try
			{
			
			WebElement financialsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			financialsearch.clear();
			financialsearch.sendKeys("financial",Keys.ENTER);
			//Thread.sleep(2000);
			
			List<WebElement> financialcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : financialcolumns)
			{
				if(names.getText().equals("target_opportunity_pct"))
				{	
					Configuration.logger.log(LogStatus.INFO, "Search and verify corporate and individual financial mpr in templates column");
				}
				if(names.getText().isEmpty())
				{
					Configuration.logger.log(LogStatus.INFO, "There is no column against is_metric_plan");
				}
					
			}
				
			}
			
			catch(Exception e)
			
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
						
		}
						
		
		
		
		@Test(description = "Display Templates(verify templates)",priority =7)
		public void displaybonustemplate() throws InterruptedException {
			
			WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
			
			try
			{
				
				WebElement importsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
				importsearch.clear();
				importsearch.sendKeys("employee bonus history",Keys.ENTER);
				//Thread.sleep(2000);
				
				List<WebElement> bonushistorycolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-template']/tbody/tr/td[1]"));	
				
				for(WebElement names : bonushistorycolumns)
				{
					Configuration.logger.log(LogStatus.INFO,names.getText());
				}
				
											
			}
				catch(Exception e)
			{
				Configuration.logger.log(LogStatus.FAIL, e);
			}
			
			
			WebElement importtemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-5091-container']")));
			importtemplate.click();
			WebElement enterkey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='body']/span/span/span[1]/input")));
			enterkey.sendKeys("Display",Keys.ENTER);
			//Thread.sleep(2000);
			
			try
			{
				
				WebElement displaysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
				displaysearch.clear();
				displaysearch.sendKeys("bonus history display",Keys.ENTER);	
				//Thread.sleep(2000);
				
				List<WebElement> bonushistorydiscolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-template']/tbody/tr/td[1]"));	
				
				for(WebElement names : bonushistorydiscolumns)
				{
					Configuration.logger.log(LogStatus.INFO,names.getText());
				}				
										
			}
				catch(Exception e)
			{
					Configuration.logger.log(LogStatus.FAIL, e);
			}
			
		}								
}