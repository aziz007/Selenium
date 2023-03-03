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
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Merit_Planning {

	
	
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
	
	
	
	@Test(priority = 3)
	public void AddCycle() throws Exception  {
		
			WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
			Actions ac1 = new Actions(Configuration.driver);
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click Add button");
				WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-planning-cycle-wrapper']/div[2]/div[1]/div/ul/li[1]")));
				AddButton.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Enter cycle name");
				WebElement CycleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CycleName']")));
				CycleName.sendKeys("Automation Cycle141");
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO,"Click salary planning");
				WebElement SalaryCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[2]/div[4]/label/div")));
				SalaryCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select ranking type");
				WebElement rankingtype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='PerformanceRankingType']")));	
				ac1.doubleClick(rankingtype).perform();
				Select dropdownrating = new Select (Configuration.driver.findElement(By.xpath("//select[@id='PerformanceRankingType']")));
				dropdownrating.selectByVisibleText("Performance Ratings");
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try 
			{
				Configuration.logger.log(LogStatus.INFO, "Enter salary effective date");
				WebElement SalaryEffDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[5]/div[2]/div/input")));
				SalaryEffDate.sendKeys("09/19/2022");
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click target planning");
				WebElement targetCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[5]/div[4]/label/div")));
				targetCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click currency");
				WebElement currencyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[6]/div[2]/label/div")));
				currencyCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select currency name");
				WebElement currencyname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[6]/div[4]/select")));	
				ac1.doubleClick(currencyname).perform();			
				Select dropdowncurrency = new Select (Configuration.driver.findElement(By.xpath("//select[@id='CurrencyName']")));
				dropdowncurrency.selectByVisibleText("US Dollar");
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click email send to log");
				WebElement emailCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[9]/div[2]/label/div")));
				emailCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click personalization allowed");
				WebElement personalizationCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[9]/div[4]/label/div")));
				personalizationCheckbox.click();
			}
			catch(Exception e) 
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Enter eligible hire date");
				WebElement eligible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='eligible-hire-date']")));
				eligible.sendKeys("09/20/2022");
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click prorate");
				WebElement proratecheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[22]/div[2]/label/div")));
				proratecheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click merit");
				WebElement meritCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[25]/div[2]/label/div")));
				meritCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click lumpsum");
				WebElement lumpsumCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[25]/div[4]/label/div")));
				lumpsumCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click promotion");
				WebElement promotionCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[26]/div[2]/label/div")));
				promotionCheckbox.click();
				Configuration.logger.log(LogStatus.INFO, "Click market adjustment");
				WebElement marketcheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[26]/div[4]/label/div")));
				marketcheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click internal equity");
				WebElement equitycheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[27]/div[2]/label/div")));
				equitycheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click internal equity approval");
				WebElement equityapprovedcheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[27]/div[4]/label/div")));
				equityapprovedcheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click other");
				WebElement othercheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[28]/div[2]/label/div")));
				othercheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click variable 1");
				WebElement variable1Checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[30]/div[2]/label/div")));
				variable1Checkbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			//WebElement var1basis = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='Variable1Basis']")));	
			//ac1.doubleClick(var1basis).perform();	
			//Select dropdownvar1 = new Select (Configuration.driver.findElement(By.xpath("//select[@id='Variable1Basis']")));
			//dropdownvar1.selectByVisibleText("Individual");
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click variable 2");
				WebElement variable2Checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[30]/div[4]/label/div")));
				variable2Checkbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			//WebElement var2basis = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='Variable1Basis']")));	
			//ac1.doubleClick(var2basis).perform();		
			//Select dropdownvar2 = new Select (Configuration.driver.findElement(By.xpath("//select[@id='Variable2Basis']")));
			//dropdownvar2.selectByVisibleText("Individual");
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click salary structure");
				WebElement salarystrCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[33]/div[2]/label/div")));
				salarystrCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click import salary structure");
				WebElement impsalarystrCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[34]/div[2]/label/div")));
				impsalarystrCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click structure on employee");
				WebElement stronempCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[35]/div[2]/label")));
				stronempCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click enforce salary structure");
				WebElement enforcestrCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[33]/div[4]/label/div")));
				enforcestrCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Select enforce salary minimum");
				WebElement esmtype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='EnforceSalaryMinimumType']")));	
				ac1.doubleClick(esmtype).perform();		
				Select dropdownesm = new Select (Configuration.driver.findElement(By.xpath("//select[@id='EnforceSalaryMinimumType']")));
				dropdownesm.selectByVisibleText("Before");
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click merit guide line");
				WebElement meritguideCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[39]/div[2]/label/div")));
				meritguideCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click guide line on employee");
				WebElement guideempCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[40]/div[2]/label/div")));
				guideempCheckbox.click();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click save button");
				WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-planning-cycle']/div/div/div[3]/div[2]/button[2]")));
				savebutton.click();
				Thread.sleep(8000);
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger = Configuration.extent.startTest("Templates Page");
				WebElement administration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[3]/a[@data-menu-id='10']")));	
				ac1.moveToElement(administration).perform();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				WebElement templates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='53']")));	
				ac1.moveToElement(templates).click().perform();
			}
			catch(Exception e)
			{
				throw(e);
			}
			
			try
			{
				Configuration.logger.log(LogStatus.INFO, "Click merit planning");
				WebElement merit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr[1]/td")));
				merit.click();
				Thread.sleep(50000);
			}
			catch(Exception e)
			{
				throw(e);
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
			}
			
			for(WebElement names1 : ratingcolumns)
			{
						
				if(names1.getText().equals("rating_alpha"))
				{
					System.out.println("rating_alpha");		
					WebElement alphatype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[3]/td[7]")));
					System.out.println(alphatype.getText());
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
			
			WebElement currencysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			currencysearch.clear();
			currencysearch.sendKeys("Currency",Keys.ENTER);
			Thread.sleep(5000);
			
			List<WebElement> currencycolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : currencycolumns)
			{
				System.out.println(names.getText());
			}
				Configuration.logger.log(LogStatus.INFO, "Search and verify currency_code");
			}
			
			catch(Exception e)
			
			{
				System.out.println("Currency rules are not correct");
			}
			
			try
			{
			
			WebElement convertedsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			convertedsearch.clear();
			convertedsearch.sendKeys("Converted",Keys.ENTER);
			Thread.sleep(5000);
			
			List<WebElement> convertedcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : convertedcolumns)
			{
				System.out.println(names.getText());
			}
				Configuration.logger.log(LogStatus.INFO, "Search and verify converted salary");
			}
			
			catch(Exception e)
			
			{
				System.out.println("Converted Salary rules are not correct");
			}
			
			try
			{
			
			WebElement ratesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			ratesearch.clear();
			ratesearch.sendKeys("Exchange",Keys.ENTER);
			Thread.sleep(5000);
			
			List<WebElement> ratecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : ratecolumns)
			{
				System.out.println(names.getText());
			}
				Configuration.logger.log(LogStatus.INFO, "Search and verify exchange_rate");
			}
			
			catch(Exception e)
			
			{
				System.out.println("Exchange Rate rules are not correct");
			}
			
			
			try
			{
				
			WebElement meritsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			meritsearch.clear();
			meritsearch.sendKeys("recommended_merit_increase_pct",Keys.ENTER);
			Thread.sleep(10000);
			
			List<WebElement> meritcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : meritcolumns)
			{
				if(names.getText().equals("recommended_merit_increase_pct"))
				{
					System.out.println("recommended_merit_increase_pct");
				}
			}
				Configuration.logger.log(LogStatus.INFO, "Search and verify recommended_merit_increase_pct");
			}
			catch(Exception e)
			{
				System.out.println("Merit rules are not correct");
			}
			
			
			try
			{
				
			WebElement meritsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			meritsearch.clear();
			meritsearch.sendKeys("merit_increase_amt",Keys.ENTER);
			Thread.sleep(10000);
			
			List<WebElement> meritcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			
			for(WebElement names1 : meritcolumns)
			{
				if(names1.getText().equals("recommended_merit_increase_amt"))
				{
					System.out.println("recommended_merit_increase_amt");
				}
			}
				Configuration.logger.log(LogStatus.INFO, "Search and verify recommended_merit_increase_amt");
			}
			catch(Exception e)
			{
				System.out.println("Merit rules are not correct");
			}
			
			try
			{
			
			WebElement lumpsumsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			lumpsumsearch.clear();
			lumpsumsearch.sendKeys("Lump_sum",Keys.ENTER);
			Thread.sleep(10000);
			
			List<WebElement> lumpsumcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names : lumpsumcolumns)
			{
				System.out.println(names.getText());
			}
				Configuration.logger.log(LogStatus.INFO, "Search and verify lump_sum");
			}
			
			catch(Exception e)
			
			{
				System.out.println("Lumpsum rules are not correct");
			}
			
			try
			{
				WebElement promotionsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				promotionsearch.clear();
				promotionsearch.sendKeys("Promotion",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> promotioncolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : promotioncolumns)
				{
					System.out.println(names.getText());
				}			
				Configuration.logger.log(LogStatus.INFO, "Search and verify promotion columns");
			}
			catch(Exception e)
			{
				System.out.println("Promotion rules are not correct");
			}
			
			try
			{
				WebElement marketsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				marketsearch.clear();
				marketsearch.sendKeys("Market",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> marketcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
				
				for(WebElement names : marketcolumns)
				{						
								
					if(names.getText().equals("market_adjustment_pct"))
						{
							System.out.println("market_adjustment_pct");
						}			
				}
				
				for(WebElement names1 : marketcolumns)
				{						
								
					if(names1.getText().equals("market_adjustment_amt"))
						{
							System.out.println("market_adjustment_amt");
						}			
				}
					Configuration.logger.log(LogStatus.INFO, "Search and verify market adjustment columns");
			}
			catch(Exception e)
			{
				System.out.println("Market Adjustment rules are not correct");
			}
			
			
			try
			{
				WebElement internalsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				internalsearch.clear();
				internalsearch.sendKeys("internal_equity_increase",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> internalcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
				
				for(WebElement names : internalcolumns)
				{
					System.out.println(names.getText());
				}			
					Configuration.logger.log(LogStatus.INFO, "Search and verify internal equity columns");
			}
			catch(Exception e)
			{
				System.out.println("Internal Equity rules are not correct");
			}
			
			
			
			try
			{
				WebElement internalapprovedsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				internalapprovedsearch.clear();
				internalapprovedsearch.sendKeys("internal_equity_approved",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> internalapprovedcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
				
				for(WebElement names : internalapprovedcolumns)
				{
					System.out.println(names.getText());
				}			
				Configuration.logger.log(LogStatus.INFO, "Search and verify internal equity approval columns");
			}
			catch(Exception e)
			{
				System.out.println("Internal Equity Approved rules are not correct");
			}
			
			
			try
			{
				WebElement othersearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				othersearch.clear();
				othersearch.sendKeys("other",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> othercolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
				
				for(WebElement names: othercolumns)
				{
					System.out.println(names.getText());
				}			
				Configuration.logger.log(LogStatus.INFO, "Search and verify other columns");
			}
			catch(Exception e)
			{
				System.out.println("Other rules are not correct");
			}
			
			
			try
			{
				WebElement proratesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				proratesearch.clear();
				proratesearch.sendKeys("prorate_merit_percent",Keys.ENTER);
				Thread.sleep(10000);
				
				
				List<WebElement> proratecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
				
				for(WebElement names: proratecolumns)
				{
					if(names.getText().equals("prorate_merit_percent"))
					{
						System.out.println("prorate_merit_percent");
					}	
				}
				
				
				
				WebElement proposedpctsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				proposedpctsearch.clear();
				proposedpctsearch.sendKeys("merit_proposed_increase_pct",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> proposedpctcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
				
				for(WebElement names: proposedpctcolumns)
				{
					if(names.getText().equals("merit_proposed_increase_pct"))
					{
						System.out.println("merit_proposed_increase_pct");
					}	
				}
				
				
				WebElement proposedamtsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				proposedamtsearch.clear();
				proposedamtsearch.sendKeys("merit_proposed_increase_amt",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> proposedamtcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names: proposedamtcolumns)
				{
					if(names.getText().equals("merit_proposed_increase_amt"))
					{
						System.out.println("merit_proposed_increase_amt");
					}
				}	
				Configuration.logger.log(LogStatus.INFO, "Search and verify prorate columns");
			}
			catch(Exception e)
			{
				System.out.println("Prorate merit rules are not correct");
			}
			
			
			try
			{
						
				WebElement variable1search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				variable1search.clear();
				variable1search.sendKeys("Variable_1",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> variable1columns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
				
					for(WebElement names : variable1columns)
					{
						System.out.println(names.getText());
					}		
				Configuration.logger.log(LogStatus.INFO, "Search and verify variable_1 columns");
			}
			catch(Exception e)
			{
				System.out.println("Variable_1 rules are not correct");
			}
			
			
			try
			{
				WebElement variable2search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				variable2search.clear();
				variable2search.sendKeys("Variable_2",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> variable2columns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
					for(WebElement names1 : variable2columns)
					{
						System.out.println(names1.getText());
					}
				Configuration.logger.log(LogStatus.INFO, "Search and verify variable_2 columns");
			}
			catch(Exception e)
			{
				System.out.println("Variable_2 rules are not correct");
			}
			
			
			
			try 
			{
				String currentttcexpected = "current_ttc_amt";
				String newttcexpected = "new_ttc_amt";
				
				WebElement ttcsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				ttcsearch.clear();
				ttcsearch.sendKeys("current total target",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> ttccolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
				
					for(WebElement names : ttccolumns)
					{
						if(names.getText().equals("current_ttc_amt"))
						{
						String currentttc = "current_ttc_amt";
						Assert.assertEquals(currentttcexpected, currentttc);
						System.out.println("current_ttc_amt");
						}
					}
					
								
					WebElement newttcsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
					newttcsearch.clear();
					newttcsearch.sendKeys("new total target",Keys.ENTER);
					Thread.sleep(10000);
					
					List<WebElement> newttccolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
					
					for(WebElement names : newttccolumns)
					{
						if(names.getText().equals("new_ttc_amt"))
						{
						String newttc = "new_ttc_amt";
						Assert.assertEquals(newttcexpected, newttc);
						System.out.println("new_ttc_amt");
				
						}
					}
				Configuration.logger.log(LogStatus.INFO, "Search and verify current_ttc and new_ttc columns");
			}
			catch(AssertionError e)
			{
				System.out.println("Current_ttc_amt and New_ttc_amt rules are not correct");
			}
			
			
			
			
			
			try 
			{
				String currenttdcexpected = "current_tdc_amt";
				String newtdcexpected = "new_tdc_amt";
				
				WebElement tdcsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				tdcsearch.clear();
				tdcsearch.sendKeys("current total direct",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> tdccolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
				
					for(WebElement names : tdccolumns)
					{
						if(names.getText().equals("current_tdc_amt"))
						{
						String currenttdc = "current_tdc_amt";
						Assert.assertEquals(currenttdcexpected, currenttdc);
						System.out.println("current_tdc_amt");
						}
					}
				
					
					
					
					WebElement newtdcsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
					newtdcsearch.clear();
					newtdcsearch.sendKeys("new total direct",Keys.ENTER);
					Thread.sleep(10000);
					
					List<WebElement> newtdccolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
					
					for(WebElement names : newtdccolumns)
					{
						if(names.getText().equals("new_tdc_amt"))
						{
						String newtdc = "new_tdc_amt";
						Assert.assertEquals(newtdcexpected, newtdc);
						System.out.println("new_tdc_amt");
						}
					}
					Configuration.logger.log(LogStatus.INFO, "Search and verify current_tdc and new_tdc columns");
			}
			catch(AssertionError e)
			{
				System.out.println("Current_tdc_amt and New_tdc_amt rules are not correct");
			}
			
			
			try
			{
				WebElement salarysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				salarysearch.clear();
				salarysearch.sendKeys("structure_item",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> structurecolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : structurecolumns)
				{
					System.out.println(names.getText());
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify salary structrue columns");
			}
			catch(Exception e)
			{
				System.out.println("Salary Structure rules are not correct");
			}
			
			
			try
			{
				WebElement impsalarysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				impsalarysearch.clear();
				impsalarysearch.sendKeys("compa ratio",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> ratiocolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : ratiocolumns)
				{
					System.out.println(names.getText());
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify compa ratio columns");
			}
			catch(Exception e)
			{
				System.out.println("Import Salary Structure rules are not correct for compa ratio");
			}
			
			try
			{
				WebElement impsalarysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				impsalarysearch.clear();
				impsalarysearch.sendKeys("range penetration percent",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> rangecolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : rangecolumns)
				{
					System.out.println(names.getText());
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify range penetration columns");
			}
			catch(Exception e)
			{
				System.out.println("Import Salary Structure rules are not correct for range penetration");
			}
			
			try
			{
				WebElement impsalarysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				impsalarysearch.clear();
				impsalarysearch.sendKeys("minimum amt",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> minimumcolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : minimumcolumns)
				{
					//System.out.println(names.getText());
					
					//if(promotionCheckbox.isSelected());
					//{				
							if(names.getText().equals("new minimum amt"))
							{
								System.out.println("new_minimum_amt");
							}					
					//}				
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify minimum amt columns");
			}
			catch(Exception e)
			{
				System.out.println("Import Salary Structure rules are not correct for minimum amt");
			}
			
			
			try
			{
				WebElement impsalarysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				impsalarysearch.clear();
				impsalarysearch.sendKeys("midpoint amt",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> midpointcolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : midpointcolumns)
				{
					System.out.println(names.getText());
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify midpoint amt columns");
			}
			catch(Exception e)
			{
				System.out.println("Import Salary Structure rules are not correct for midpoint amt");
			}
			
			try
			{
				WebElement impsalarysearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				impsalarysearch.clear();
				impsalarysearch.sendKeys("maximum amt",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> maxcolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : maxcolumns)
				{
					System.out.println(names.getText());
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify maximum amt columns");
			}
			catch(Exception e)
			{
				System.out.println("Import Salary Structure rules are not correct for maximum amt");
			}
			
			
			try
			{
			WebElement strtablesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			strtablesearch.clear();
			strtablesearch.sendKeys("structure",Keys.ENTER);
			Thread.sleep(10000);
			
			List<WebElement> strtablecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
			
			for(WebElement names: strtablecolumns)
			{
				if(names.getText().equals("structure_region"))
				{
					System.out.println("structure_region");
				}
			}	
			
			for(WebElement names: strtablecolumns)
			{
				if(names.getText().equals("structure_name"))
				{
					System.out.println("structure_name");
				}
			}	
			Configuration.logger.log(LogStatus.INFO, "Search and verify structure_on_employee columns");
		}
		catch(Exception e)
		{
			System.out.println("structure_on_employee rules are not correct");
		}
			
			try
			{
				WebElement messagesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				messagesearch.clear();
				Thread.sleep(5000);
				
				List<WebElement> messagecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
				
				for(WebElement names: messagecolumns)
				{
					if(names.getText().equals("message_text"))
					{
						System.out.println("message_text");
					}
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify enforced_salary_structure columns");
			}
			catch(Exception e)
			{
				System.out.println("Enforced salary structure rules are not correct");
			}
			
			try
			{
				WebElement esmsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				esmsearch.clear();
				esmsearch.sendKeys("range adjustment",Keys.ENTER);			
				Thread.sleep(10000);
				
				List<WebElement> esmcolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : esmcolumns)
				{
					System.out.println(names.getText());
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify enforce_salary_minimum_type columns");
			}
			catch(Exception e)
			{
				System.out.println("Enforce Salary Minimum Type rules are not correct");
			}
			
							
			try
			{
				WebElement guidelineempsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				guidelineempsearch.clear();
				guidelineempsearch.sendKeys("guideline",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> guidelineempcolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : guidelineempcolumns)
				{
					System.out.println(names.getText());
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify guideline_on_employee columns");
			}
			catch(Exception e)
			{
				System.out.println("Guideline on employee rules are not correct");
			}
			
			
			try
			{
				WebElement guidelineempsearch1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
				guidelineempsearch1.clear();
				guidelineempsearch1.sendKeys("range penetration",Keys.ENTER);
				Thread.sleep(10000);
				
				List<WebElement> guidelineempcolumns1 = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
				
				for(WebElement names : guidelineempcolumns1)
				{
					System.out.println(names.getText());
				}
				Configuration.logger.log(LogStatus.INFO, "Search and verify range penetration columns");
			}
			catch(Exception e)
			{
				System.out.println("Guideline on employee rules are not correct");
			}				
					
		
	}
	
	}
