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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LTI_Planning {
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
			System.out.println("Login successfully");
			System.out.println("--------------------------");
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println("button not clicked");
		
	}

	}
	
		@Test (description = "mouse over function",priority =2)
		public void mouseover() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(Configuration.driver,20);
			Configuration.logger = Configuration.extent.startTest("Cycle Page");
			Configuration.logger.log(LogStatus.INFO, "Mouse over function");
			WebElement conf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
			//conf.click();
		
		
			Actions ac = new Actions(Configuration.driver);
			ac.moveToElement(conf).perform();
		
			Configuration.logger.log(LogStatus.INFO, "Click cycle link");
			WebElement cycle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='82']")));
			//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
			ac.moveToElement(cycle).click().perform();
			System.out.println("Cycle Page");
			System.out.println("--------------------------");

	}

	@Test(description = "Create Cycle",priority =3)
	public void AddCycle() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		try {
		Configuration.logger.log(LogStatus.INFO, "Click Add button");
		WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-planning-cycle-wrapper']/div[2]/div[1]/div/ul/li[1]")));
		AddButton.click();

		Configuration.logger.log(LogStatus.INFO, "Enter cycle name");
		WebElement CycleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CycleName']")));
		CycleName.sendKeys("Automation Cycle130");
					
		Configuration.logger.log(LogStatus.INFO, "Click lti planning ");
		WebElement LtiCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[4]/div[4]/label/div")));
		LtiCheckbox.click();
		
		Configuration.logger.log(LogStatus.INFO, "Select ranking type");
		WebElement rankingtype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='PerformanceRankingType']")));	
		ac1.doubleClick(rankingtype).perform();
		Select dropdownrating = new Select (Configuration.driver.findElement(By.xpath("//select[@id='PerformanceRankingType']")));
		dropdownrating.selectByVisibleText("Performance Ratings");
		
		Configuration.logger.log(LogStatus.INFO, "Enter salary effective date");
		WebElement SalaryEffDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[5]/div[2]/div/input")));
		SalaryEffDate.sendKeys("30/11/2022");
		
		Configuration.logger.log(LogStatus.INFO, "Click currency");
		WebElement currencyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[6]/div[2]/label/div")));
		currencyCheckbox.click();
		
		Configuration.logger.log(LogStatus.INFO, "Select currency name");
		WebElement currencyname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[6]/div[4]/select")));	
		ac1.doubleClick(currencyname).perform();			
		Select dropdowncurrency = new Select (Configuration.driver.findElement(By.xpath("//select[@id='CurrencyName']")));
		dropdowncurrency.selectByVisibleText("US Dollar");
		
		Configuration.logger.log(LogStatus.INFO, "Click import lti history");
		WebElement impltihisCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[44]/div[4]/label/div")));
		impltihisCheckbox.click();
		
		Configuration.logger.log(LogStatus.INFO, "Click prorate incentive");
		WebElement prorateincentiveCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[45]/div[4]/label/div")));
		prorateincentiveCheckbox.click();
		
		Configuration.logger.log(LogStatus.INFO, "Select percent based");
		WebElement percentbased = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='PercentBasedOn']")));	
		ac1.click(percentbased).perform();			
		Select dropdownpercent = new Select (Configuration.driver.findElement(By.xpath("//select[@id='PercentBasedOn']")));
		dropdownpercent.selectByVisibleText("Earnings");
		
		Configuration.logger.log(LogStatus.INFO, "Click save button");
		WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-planning-cycle']/div/div/div[3]/div[2]/button[2]")));
		savebutton.click();
		System.out.println("Automation Cycle130 Created");
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test (description = "Add Incentives",priority =4)
	public void Incentives() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Incentive Page");
		try {
			
		Thread.sleep(20000);
		Configuration.logger.log(LogStatus.INFO, "Click add button");
		WebElement AddButton1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-bonusplan-setting-wrapper']/div[1]/div[1]/div/ul/li[1]")));
		AddButton1.click();
		
		Configuration.logger.log(LogStatus.INFO, "Enter incentive name");
		WebElement incentivename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[2]/div[2]/input")));
		incentivename.sendKeys("L1");
		
		Configuration.logger.log(LogStatus.INFO, "Select incentive group");
		WebElement incentivegroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='IncentiveGroup']")));
		ac1.click(incentivegroup).perform();
		Select dropdowngroup = new Select (Configuration.driver.findElement(By.xpath("//select[@id='IncentiveGroup']")));
		dropdowngroup.selectByVisibleText("Staff Plan");
		
		Configuration.logger.log(LogStatus.INFO, "Click share price");
		WebElement shareprice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[3]/div[4]/label/div")));
		shareprice.click();	
		
		Configuration.logger.log(LogStatus.INFO, "Enter payout date");
		WebElement payoutdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[4]/div[2]/div/input")));
		payoutdate.sendKeys("30/09/2022",Keys.TAB);
		
		Configuration.logger.log(LogStatus.INFO, "Enter start date");
		WebElement Incstartdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[5]/div[2]/div/input")));
		Incstartdate.sendKeys("30/09/2022",Keys.TAB);
		
		Configuration.logger.log(LogStatus.INFO, "Enter end date");
		WebElement Incenddate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[6]/div[2]/div/input")));
		Incenddate.sendKeys("10/10/2022",Keys.TAB);
		
		Configuration.logger.log(LogStatus.INFO, "Click metric plan");
		WebElement metricplan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[8]/div[2]/label/div")));
		metricplan.click();			
		
		Configuration.logger.log(LogStatus.INFO, "Click amount");
		WebElement amt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[10]/div[2]/label/div")));
		amt.click();
		
		Configuration.logger.log(LogStatus.INFO, "Click save button");
		WebElement saveinc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[3]/div[2]/button[2]")));
		saveinc.click();
		System.out.println("LTI Incentive Added");
		}
		catch(Exception e)
		{
			Configuration.logger = Configuration.extent.startTest("Incentives not added");
			//Configuration.logger.log(LogStatus.INFO, "Click save button");
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
		
		WebElement templates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='52']")));		
		ac1.moveToElement(templates).click().perform();
		
		Configuration.logger.log(LogStatus.INFO, "Click lti planning");
		WebElement ltiplanning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr")));
		ltiplanning.click();
		Thread.sleep(30000);		
		
		
		try
		{
		
		WebElement currencysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		currencysearch.clear();
		currencysearch.sendKeys("Currency",Keys.ENTER);
		Thread.sleep(5000);
		
		
		List<WebElement> currencycolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : currencycolumns)
		{
			System.out.println("-------Planning Template------");
			if(names.getText().equals("currency_code"))
			{
				System.out.println("currency_code");								
			}
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column for currency");
			}
		}
			Configuration.logger.log(LogStatus.INFO, "Search and verify currency_code");
		}
		
		catch(Exception e)
		
		{
			System.out.println("Currency rules are not correct");
		}
		
		try
		{
		
		WebElement exchangesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		exchangesearch.clear();
		exchangesearch.sendKeys("exchange",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> exchangecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : exchangecolumns)
		{
			if(names.getText().equals("exchange_rate"))
			{
				System.out.println("exchange_rate");
			}
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column for exchange_rate");
			}
		}
			Configuration.logger.log(LogStatus.INFO, "Search and verify exchange_rate");
		}
		
		catch(Exception e)
		
		{
			System.out.println("Exchange Rate rules are not correct");
		}
		
		try
		{
		
		WebElement ratingsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		ratingsearch.clear();
		ratingsearch.sendKeys("Rating",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> ratingcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : ratingcolumns)
		{					
			if(names.getText().equals("rating_name"))
			{				
				System.out.println("rating_name");		
				WebElement ratingtype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[2]/td[7]")));				
				System.out.println(ratingtype.getText());						
			}
			
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column for rating_name");
			}
		}
		
		for(WebElement names1 : ratingcolumns)
		{
					
			if(names1.getText().equals("rating_alpha"))
			{
				System.out.println("rating_alpha");		
				WebElement alphatype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[3]/td[7]")));
				System.out.println(alphatype.getText());
			}
			if(names1.getText().isEmpty())
			{
				System.out.println("There is no column for rating_alpha");
			}
		}
			Configuration.logger.log(LogStatus.INFO, "Search and verify rating name and rating alpha");
		}
		
		catch(Exception e)
		
		{
			System.out.println("Rating rules are not correct");
		}
		
		try
		{
		
		WebElement proratedsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		proratedsearch.clear();
		proratedsearch.sendKeys("prorated",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> proratedcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : proratedcolumns)
		{
			if(names.getText().equals("prorated_lti_multiplier_pct"))
			{
				System.out.println("prorated_lti_multiplier_pct");
			}
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column for prorated_lti_multiplier_pct");
			}
		}
			Configuration.logger.log(LogStatus.INFO, "Search and verify prorated_lti_multiplier_pct");
		}
		
		catch(Exception e)
		
		{
			System.out.println("Prorated LTI Multiplier Pct rules are not correct");
		}
		
		
		try
		{
		
		WebElement sharesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		sharesearch.clear();
		sharesearch.sendKeys("share",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> sharecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : sharecolumns)
		{
					
			if(names.getText().equals("share_price"))
			{				
				System.out.println("share_price");							
			}
			
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column for share_price");
			}
		}
		
		for(WebElement names1 : sharecolumns)
		{
					
			if(names1.getText().equals("recommended_number_of_shares"))
			{
				System.out.println("recommended_number_of_shares");		
			}
			if(names1.getText().isEmpty())
			{
				System.out.println("There is no column for recommended_number_of_shares");
			}
		}
		Configuration.logger.log(LogStatus.INFO, "Search and verify share price and recommended_number_of_shares");
	}
		catch(Exception e)
		
		{
			System.out.println("share_based rules are not correct");
		}
					
	}
	
	@Test(description = "Import Templates(verify templates column)",priority =6)
	public void Importbonustemplate() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Configuration.logger = Configuration.extent.startTest("Import Templates");
		
		WebElement importtemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-5088-container']")));
		importtemplate.click();
		WebElement enterkey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='body']/span/span/span[1]/input")));
		enterkey.sendKeys("Import",Keys.ENTER);
		Thread.sleep(15000);
		
		
		WebElement importsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
		importsearch.sendKeys("employee lti plans",Keys.ENTER);
		Thread.sleep(15000);
		
		Configuration.logger.log(LogStatus.INFO, "Click Employee LTI plans");
		WebElement ltiplans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr")));
		ltiplans.click();
		Thread.sleep(15000);	
		
		try
		{
		
		WebElement currencysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		currencysearch.clear();
		currencysearch.sendKeys("Currency",Keys.ENTER);
		Thread.sleep(5000);
		
		
		List<WebElement> currencycolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : currencycolumns)
		{
			System.out.println("-------Import Template------");
			if(names.getText().equals("currency_code"))
			{
				System.out.println("currency_code");
			}
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column for currency_code");
			}
		}
			Configuration.logger.log(LogStatus.INFO, "Search and verify currency_code");
		}
		
		catch(Exception e)
		
		{
			System.out.println("Currency rules are not correct");
		}
		
		try
		{
		
		WebElement proratedsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		proratedsearch.clear();
		proratedsearch.sendKeys("prorated",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> proratedcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : proratedcolumns)
		{
			
			if(names.getText().equals("prorated_lti_multiplier_pct"))
			{
				System.out.println("prorated_lti_multiplier_pct");
			}
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column for prorated_lti_multiplier_pct");
			}
		}
			Configuration.logger.log(LogStatus.INFO, "Search and verify prorated_lti_multiplier_pct");
		}
		
		catch(Exception e)
		
		{
			System.out.println("Prorated LTI Multiplier Pct rules are not correct");
		}
		
		try
		{
		
		WebElement targetsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		targetsearch.clear();
		targetsearch.sendKeys("target",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> targetcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : targetcolumns)
		{
					
			if(names.getText().equals("target_opportunity_amt"))
			{				
				System.out.println("target_opportunity_amt");						
			}
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column against is_incentive_amount");
			}
		}
			Configuration.logger.log(LogStatus.INFO, "Search and verify target_opportunity_amt");
		}
					
		catch(Exception e)
		
		{
			System.out.println("Incentive percent rules are not correct");
		}
		
		
		
		try
		{
		
		WebElement pctsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		pctsearch.clear();
		pctsearch.sendKeys("target_opportunity_pct",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> pctcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : pctcolumns)
		{
					
			if(names.getText().equals("target_opportunity_pct"))
			{				
				System.out.println("target_opportunity_pct");						
			}
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column against is_incentive_percentage");
			}
		}
			Configuration.logger.log(LogStatus.INFO, "Search and verify target_opportunity_pct");
		}
					
		catch(Exception e)
		
		{
			System.out.println("Incentive percent rules are not correct");
		}
		
		try
		{
		
		WebElement financialsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		financialsearch.clear();
		financialsearch.sendKeys("financial",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> financialcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : financialcolumns)
		{
			System.out.println(names.getText());
			
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column against is_metric_plan");
			}
				
		}
		Configuration.logger.log(LogStatus.INFO, "Search and verify corporate and individual financial mpr");
	}
		
		catch(Exception e)
		
		{
			System.out.println("is_metric_plan rules are not correct");
		}							
	}
	
	@Test(description = "Templates(verify templates)",priority =7)
	public void ltitemplate() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		
		try
		{
			WebElement importsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
			importsearch.clear();
			importsearch.sendKeys("employee lti history",Keys.ENTER);				
			Thread.sleep(5000);
			
			List<WebElement> ltihistorycolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-template']/tbody/tr/td[1]"));	
			
			for(WebElement names : ltihistorycolumns)
			{
				System.out.println("----------Employee LTI History Import Template----------");
				System.out.println(names.getText());
			}
			Configuration.logger.log(LogStatus.INFO, "Search and verify Employee LTI History import template");							
		}
			catch(Exception e)
		{
			System.out.println("Employee lti history template is missing");
		}
		
		
		WebElement importtemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-5088-container']")));
		importtemplate.click();
		WebElement enterkey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='body']/span/span/span[1]/input")));
		enterkey.sendKeys("Display",Keys.ENTER);
		Thread.sleep(5000);
		
		try
		{
			WebElement displaysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
			displaysearch.clear();
			displaysearch.sendKeys("lti history display",Keys.ENTER);				
			Thread.sleep(5000);
			
			List<WebElement> ltihistorydiscolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-template']/tbody/tr/td[1]"));	
			
			for(WebElement names : ltihistorydiscolumns)
			{
				System.out.println("----------LTI History Display Template----------");
				System.out.println(names.getText());
			}
			Configuration.logger.log(LogStatus.INFO, "Search and verify LTI History Display template");								
		}
			catch(Exception e)
		{
			System.out.println("LTI history display template is missing");
		}		
	}	
	
		@AfterMethod
		public void columnname(ITestResult result)
		{
			long a = result.getEndMillis()-result.getStartMillis();
			System.out.println("Time taken to run test is : "+a+" milliseconds");
		}
}