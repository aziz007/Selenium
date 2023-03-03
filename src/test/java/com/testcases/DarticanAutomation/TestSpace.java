package com.testcases.DarticanAutomation;

import org.joda.time.DateTime;
import org.joda.time.Months;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;


//import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSpace {
	
	public static WebDriver driver;
	
	
	//public static WebDriver driver;
	@Test (description = "enter credentials and hit enter button",priority =1)
		
		public void login() {
		
		Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
		Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
		
		try {
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
		WebElement conf = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[3]/a[@data-menu-id='10']")));
		//conf.click();
		
		
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(conf).perform();
		
		
		WebElement cycle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-menu-id='54']")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
		ac.moveToElement(cycle).click().perform();
		System.out.println("Cycle Page");
		System.out.println("--------------------------");

	}
	
	
	@Test(priority = 3)
	public void datepicker() throws InterruptedException, ParseException
	{
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		
		WebElement addbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-currency-wrapper']/div[1]/div[1]/div/ul/li[1]/a")));
		addbutton.click();
		Thread.sleep(5000);
		
		WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-currency']/div/div/div[2]/form/div[8]/div[2]/div/input")));
		calendar.click();
		Thread.sleep(3000);
		
		String setdatestr = "12/25/2022";
		
		String currdatestr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[25]/div[1]/table/thead/tr[2]/th[2]"))).getText();
		System.out.println(currdatestr);
		
		Date setdate = new SimpleDateFormat("MM/dd/yyyy").parse(setdatestr);
		System.out.println(setdate);
		
		Date currdate = new SimpleDateFormat("MMMM yyyy").parse(currdatestr);
		System.out.println(currdate);
		
		int monthdiff = Months.monthsBetween(new DateTime(currdate).withDayOfMonth(1),new DateTime(setdate).withDayOfMonth(1)).getMonths();
		System.out.println(monthdiff);
		
		boolean isfuture = true;
		
		if(monthdiff<0) 
		{
			isfuture = false;
			monthdiff = -1 * monthdiff;
		}
		
		for(int i=0;i<monthdiff;i++)
		{
			if(isfuture)
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[25]/div[1]/table/thead/tr[2]/th[3]"))).click();
			else
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[25]/div[1]/table/thead/tr[2]/th[1]"))).click();
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/div[25]/div[1]/table/tbody/tr[5]/td[1]"))).click();
		
	}

	
	//@Test(priority = 3)
	public void TestSpace2() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(Configuration.driver,20);
		Actions ac = new Actions(Configuration.driver);
		Configuration.logger = Configuration.extent.startTest("Templates Page");
		
		try
		{
			WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='search']")));
			search.sendKeys("merit planning",Keys.ENTER);
			Thread.sleep(10000);
			Configuration.logger.log(LogStatus.INFO, "Entering merit planning into templates search box");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		
		try
		{
			WebElement merit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr[1]")));
			ac.click(merit).perform();
			Thread.sleep(8000);
			Configuration.logger.log(LogStatus.INFO, "Click merit");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		
		try
		{
			WebElement usersearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			usersearch.sendKeys("user defined",Keys.ENTER);
			Configuration.logger.log(LogStatus.INFO, "Entering job to templates column search box");
			Thread.sleep(10000);	
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		
		try
		{
			Configuration.logger.log(LogStatus.INFO, "Double click row to edit");
			WebElement user1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]")));
			ac.doubleClick(user1).perform();
			Thread.sleep(8000);
		
			Select viewabletypeON = new Select (Configuration.driver.findElement(By.xpath("//select[@id='column-viewable-option']")));
			viewabletypeON.selectByVisibleText("On");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			WebElement view = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-column']/div/div/div[2]/form/div[27]/div[1]/div/h6/a")));
			ac.doubleClick(view).perform();
			
			WebElement da = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-column']/div/div/div[2]/form/div[28]/div[1]/div[3]/label/div")));
			da.click();
			Configuration.logger.log(LogStatus.INFO, "Set role access less than 3 roles");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			WebElement btnsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-column']/div/div/div[3]/div[2]/button[2]")));
			btnsave.click();
			Configuration.logger.log(LogStatus.INFO, "Change employee_user_defined_1 viewable type to ON");
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			
			WebElement planning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[2]/span/span[1]/span")));
			planning.click();
			Thread.sleep(2000);
			
			WebElement importtmep = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='body']/span/span/span[1]/input")));
			importtmep.sendKeys("import",Keys.ENTER);
			Thread.sleep(8000);
			Configuration.logger.log(LogStatus.INFO, "Move to import(employee information) templates");
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			WebElement tempsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
			tempsearch.clear();
			tempsearch.sendKeys("employee information",Keys.ENTER);
			Thread.sleep(8000);
			
			WebElement empclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr")));
			empclick.click();
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		try
		{
			WebElement colsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			colsearch.clear();
			colsearch.sendKeys("employee_user_defined_1",Keys.ENTER);
			Thread.sleep(4000);
			
			WebElement colname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]/td[2]")));
			colname.getText();
			
			WebElement viewabletype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-column']/tbody/tr[1]/td[7]")));
			viewabletype.getText();
			Configuration.logger.log(LogStatus.INFO, "Read column name and viewable type");		
		}
		catch(Exception e)
		{
			Configuration.logger.log(LogStatus.INFO, e);
		}
		
		
		
		
	}
	
	
	public void TestSpace1() throws InterruptedException {
		
		//WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.ignoring(NoSuchElementException.class);
		
		Actions ac1 = new Actions(Configuration.driver);
	try
	{
		WebElement AddButton =	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='grid-planning-cycle-wrapper']/div[2]/div[1]/div/ul/li[1]")));
		AddButton.click();
		Configuration.logger.log(LogStatus.INFO, "Click Add button");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try {
		WebElement CycleName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-bind='value: CycleName']")));
		CycleName.sendKeys("Automation Cycle151");
		Configuration.logger.log(LogStatus.INFO, "Enter cycle name");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		WebElement BonusCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='general']/form/div[3]/div[4]/label/div")));
		BonusCheckbox.click();
		Configuration.logger.log(LogStatus.INFO, "Check bonus planning");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		WebElement rankingtype = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='PerformanceRankingType']")));	
		ac1.doubleClick(rankingtype).perform();		
		Select dropdownrating = new Select (Configuration.driver.findElement(By.xpath("//select[@id='PerformanceRankingType']")));
		dropdownrating.selectByVisibleText("Performance Ratings");
		Configuration.logger.log(LogStatus.INFO, "Select performance rating");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try 
	{
		WebElement SalaryEffDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='general']/form/div[5]/div[2]/div/input")));
		SalaryEffDate.sendKeys("09/28/2022");
		Configuration.logger.log(LogStatus.INFO, "Enter salary effective date");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
	
	try
	{
		WebElement savebutton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-planning-cycle']/div/div/div[3]/div[2]/button[2]")));
		savebutton.click();
		Thread.sleep(20000);
		Configuration.logger.log(LogStatus.INFO, "Click save button, Automation Cycle151 Created");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
	try
	{
		ac1.sendKeys(Keys.PAGE_DOWN).perform();
		WebElement AddButton1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='grid-bonusplan-setting-wrapper']/div[1]/div[1]/div/ul/li[1]")));
		AddButton1.click();
		Thread.sleep(5000);
		Configuration.logger.log(LogStatus.INFO, "Click incentive add button");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO,e);
	}
	
	try
	{
		WebElement incentivename = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[2]/div[2]/input")));
		incentivename.sendKeys("B1");
		Thread.sleep(3000);
		Configuration.logger.log(LogStatus.INFO, "Enter incentive name");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		WebElement incentivegroup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='IncentiveGroup']")));
		ac1.click(incentivegroup).perform();
		Select dropdowngroup = new Select (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='IncentiveGroup']"))));
		dropdowngroup.selectByVisibleText("Staff Plan");
		Thread.sleep(3000);
		Configuration.logger.log(LogStatus.INFO, "Select staff plan");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		WebElement payoutdate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[4]/div[2]/div/input")));
		payoutdate.sendKeys("09/30/2022");
		payoutdate.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		Configuration.logger.log(LogStatus.INFO, "Select payout date");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		WebElement Incstartdate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[5]/div[2]/div/input")));
		Incstartdate.sendKeys("09/30/2022");
		Incstartdate.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		Configuration.logger.log(LogStatus.INFO, "Select incentive start date");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		WebElement Incenddate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[6]/div[2]/div/input")));
		Incenddate.sendKeys("10/01/2022");
		Incenddate.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		Configuration.logger.log(LogStatus.INFO, "Select incentive end date");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		WebElement metricplan = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[8]/div[2]/label/div")));
		metricplan.click();
		Thread.sleep(3000);
		Configuration.logger.log(LogStatus.INFO, "Select merit plan");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		//WebElement amt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[2]/form/div[10]/div[2]/label/div")));
		//amt.click();
		
		WebElement pct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"modal-bonusplan-setting\"]/div/div/div[2]/form/div[10]/div[1]/label/div")));
		pct.click();
		//boolean checkbox1 = amt.isSelected();
		Configuration.logger.log(LogStatus.INFO, "Select incentive percent");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
	try
	{
		WebElement saveinc = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-bonusplan-setting']/div/div/div[3]/div[2]/button[2]")));
		saveinc.click();
		System.out.println("Bonus Incentive Added");
		Thread.sleep(5000);
		Configuration.logger.log(LogStatus.INFO, "Click save incentive");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
	try
	{
		WebElement administration = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[3]/a[@data-menu-id='10']")));	
		ac1.moveToElement(administration).perform();	
		WebElement templates = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-menu-id='52']")));		
		ac1.moveToElement(templates).click().perform();
		Configuration.logger = Configuration.extent.startTest("Move to Templates");
	}	
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		WebElement importtemplate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='select2-5088-container']")));
		importtemplate.click();
		WebElement enterkey = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='body']/span/span/span[1]/input")));
		enterkey.sendKeys("Import");
		enterkey.sendKeys(Keys.ENTER);
		Thread.sleep(15000);
		Configuration.logger.log(LogStatus.INFO, "Move to import templates");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
	
	try
	{
		WebElement importsearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
		importsearch.sendKeys("employee bonus plans");
		importsearch.sendKeys(Keys.ENTER);
		Thread.sleep(15000);
		Configuration.logger.log(LogStatus.INFO, "Search employee bonus plans");
	}
	catch(Exception e)
	{
		Configuration.logger.log(LogStatus.INFO, e);
	}
		
		WebElement bonusplans = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr")));
		bonusplans.click();
		Thread.sleep(15000);	
		
		
		
		//if(checkbox1 = true)
		//{
		try
		{
		
		WebElement targetsearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		targetsearch.clear();
		targetsearch.sendKeys("target",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> targetcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));
		
		for(WebElement names : targetcolumns)
		{
					
			if(names.getText().equals("target_opportunity_amt"))
			{				
				System.out.println("target_opportunity_amt");			
				break;
			}
			else
			{
				System.out.println("There is no column against is_incentive_amount");
				break;
			}
		}
		
		}
					
		catch(Exception e)
		
		{
			System.out.println("Incentive amount rules are not correct");
		}
		
		//}
		
		//if(checkbox1 = false)
		//{
		
		try
		{
		
		WebElement pctsearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		pctsearch.clear();
		pctsearch.sendKeys("target opportunity",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> pctcolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : pctcolumns)
		{
					
			if(names.getText().equals("target_opportunity_pct"))
			{				
				System.out.println("target_opportunity_pct");	
				break;
			}
			if(names.getText().isEmpty())
			{
				System.out.println("There is no column against is_incentive_percentage");
				break;
			}
		}
		
		}
					
		catch(Exception e)
		
		{
			System.out.println("Incentive percent rules are not correct");
		}
	}
}
	
//}
