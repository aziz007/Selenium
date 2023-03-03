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
import org.testng.annotations.Test;

public class Employee_Information {
	
	public static WebDriver driver;
	@Test (description = "enter credentials and hit enter button",priority =1)
		
		public void login() {
		
		Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
		Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
		
		try {
			Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();		
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println("button not clicked");
		
	}

	}
	
	
	@Test (description = "mouse over function",priority =2)
	public void mouseover() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		WebElement conf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[2]/a[@data-menu-id='9']")));
		//conf.click();
		
		
		Actions ac = new Actions(Configuration.driver);
		ac.moveToElement(conf).perform();
		
		
		WebElement cycle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='82']")));
		//WebElement cycle = Configuration.driver.findElement(By.xpath("//a[@data-menu-id='82']"));
		
		ac.moveToElement(cycle).click().perform();


	}
	
	
	@Test(priority = 3)
	public void AddCycle() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
		Actions ac1 = new Actions(Configuration.driver);
		
		WebElement AddButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-planning-cycle-wrapper']/div[2]/div[1]/div/ul/li[1]")));
		AddButton.click();
		
		WebElement CycleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-bind='value: CycleName']")));
		CycleName.sendKeys("Automation Cycle80");
		
		WebElement SalaryCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[2]/div[4]/label/div")));
		SalaryCheckbox.click();
		
		WebElement rankingtype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='PerformanceRankingType']")));	
		ac1.doubleClick(rankingtype).perform();		
		Select dropdownrating = new Select (Configuration.driver.findElement(By.xpath("//select[@id='PerformanceRankingType']")));
		dropdownrating.selectByVisibleText("Performance Ratings");
		
		WebElement SalaryEffDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[5]/div[2]/div/input")));
		SalaryEffDate.sendKeys("09/19/2022");
		
		WebElement targetCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[5]/div[4]/label/div")));
		targetCheckbox.click();
		
		WebElement currencyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[6]/div[2]/label/div")));
		currencyCheckbox.click();
		
		WebElement currencyname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='general']/form/div[6]/div[4]/select")));	
		ac1.doubleClick(currencyname).perform();			
		Select dropdowncurrency = new Select (Configuration.driver.findElement(By.xpath("//select[@id='CurrencyName']")));
		dropdowncurrency.selectByVisibleText("US Dollar");
				
		WebElement impempratingCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[14]/div[2]/label/div")));
		impempratingCheckbox.click();
		
		WebElement eligible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='eligible-hire-date']")));
		eligible.sendKeys("09/20/2022");
		
		WebElement proratecheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[22]/div[2]/label/div")));
		proratecheckbox.click();
		
		WebElement meritCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[25]/div[2]/label/div")));
		meritCheckbox.click();
		
		WebElement lumpsumCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cycle-setting-content']/div/form/div[25]/div[4]/label/div")));
		lumpsumCheckbox.click();
		
		WebElement promotionCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[26]/div[2]/label/div")));
		promotionCheckbox.click();
		
		WebElement marketcheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[26]/div[4]/label/div")));
		marketcheckbox.click();
		
		WebElement equitycheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[27]/div[2]/label/div")));
		equitycheckbox.click();
		
		WebElement equityapprovedcheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[27]/div[4]/label/div")));
		equityapprovedcheckbox.click();
		
		WebElement othercheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[28]/div[2]/label/div")));
		othercheckbox.click();
		
		WebElement variable1Checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[30]/div[2]/label/div")));
		variable1Checkbox.click();
		
		WebElement var1basis = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='Variable1Basis']")));	
		ac1.doubleClick(var1basis).perform();		
		Select dropdownvar1 = new Select (Configuration.driver.findElement(By.xpath("//select[@id='Variable1Basis']")));
		dropdownvar1.selectByVisibleText("Individual");
		
		WebElement variable2Checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[30]/div[4]/label/div")));
		variable2Checkbox.click();
		
		WebElement var2basis = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='Variable1Basis']")));	
		ac1.doubleClick(var2basis).perform();		
		Select dropdownvar2 = new Select (Configuration.driver.findElement(By.xpath("//select[@id='Variable2Basis']")));
		dropdownvar2.selectByVisibleText("Individual");
				
		WebElement salarystrCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[33]/div[2]/label/div")));
		salarystrCheckbox.click();
		
		WebElement impsalarystrCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[34]/div[2]/label/div")));
		impsalarystrCheckbox.click();
		
		WebElement stronempCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[35]/div[2]/label")));
		stronempCheckbox.click();
		
		WebElement enforcestrCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[33]/div[4]/label/div")));
		enforcestrCheckbox.click();
		
		WebElement esmtype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='EnforceSalaryMinimumType']")));	
		ac1.doubleClick(esmtype).perform();	
		Select dropdownesm = new Select (Configuration.driver.findElement(By.xpath("//select[@id='EnforceSalaryMinimumType']")));
		dropdownesm.selectByVisibleText("Before");
		
		WebElement meritguideCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[39]/div[2]/label/div")));
		meritguideCheckbox.click();
		
		WebElement guideempCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='general']/form/div[40]/div[2]/label/div")));
		guideempCheckbox.click();
		
		WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-planning-cycle']/div/div/div[3]/div[2]/button[2]")));
		savebutton.click();
		
		WebElement administration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header[@id='header']/nav/ul/li[3]/a[@data-menu-id='10']")));	
		ac1.moveToElement(administration).perform();
		
		WebElement templates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-menu-id='52']")));		
		ac1.moveToElement(templates).click().perform();
		
		WebElement importtemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-5088-container']")));
		importtemplate.click();
		WebElement enterkey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='body']/span/span/span[1]/input")));
		enterkey.sendKeys("Import");
		enterkey.sendKeys(Keys.ENTER);
		Thread.sleep(15000);
		
		
		WebElement importsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-template-wrapper']/div[3]/div[1]/input")));
		importsearch.sendKeys("Employee Information");
		importsearch.sendKeys(Keys.ENTER);
		Thread.sleep(15000);
		
		WebElement employeeinfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='grid-template']/tbody/tr")));
		employeeinfo.click();
		Thread.sleep(40000);
		
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
		
		}
		
		catch(Exception e)
		
		{
			System.out.println("Currency rules are not correct");
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
			else
			{
				System.out.println("Rating Name is missing");
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
			else
			{
				System.out.println("Rating Alpha is missing");
			}
		}
		
		}
		
		catch(Exception e)
		
		{
			System.out.println("Rating rules are not correct");
		}
		
		
		try
		{
		
		WebElement currentvar1search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		currentvar1search.clear();
		currentvar1search.sendKeys("current_variable_1",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> currentvar1columns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : currentvar1columns)
		{
			System.out.println(names.getText());
		}
		
		}
		
		catch(Exception e)
		
		{
			System.out.println("Current Variable 1 rules are not correct");
		}
		
		
		
		try
		{
		
		WebElement var1search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		var1search.clear();
		var1search.sendKeys("variable_1_basis",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> var1columns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : var1columns)
		{
			System.out.println(names.getText());
		}
		
		}
		
		catch(Exception e)
		
		{
			System.out.println("Variable 1 Basis rules are not correct");
		}
		
		
		try
		{
		
		WebElement var2search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		var2search.clear();
		var2search.sendKeys("variable_2_basis",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> var2columns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : var2columns)
		{
			System.out.println(names.getText());
		}
		
		}
		
		catch(Exception e)
		
		{
			System.out.println("Variable 2 Basis rules are not correct");
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
				if(names.getText().equals("structure_item"))
				{
					System.out.println("structure_item");
				}
				else
				{
					System.out.println("Structure item is missing");
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Salary Structure rules are not correct");
		}
		
		
		try
		{
			if(stronempCheckbox.isEnabled())
			{
			WebElement minamtsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			minamtsearch.clear();
			minamtsearch.sendKeys("minimum amt",Keys.ENTER);
			Thread.sleep(10000);
			
			List<WebElement> minamtcolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
		
			
			for(WebElement names : minamtcolumns)
			{
				if(names.getText().equals("minimum_amt"))
				{
					System.out.println("minimum_amt");
				}
				else
				{
					System.out.println("Minimum amt column is missing");
				}
			}
			
			}
			
			else 
			{
				System.out.println("Structure on employee is not selected");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Structrue on employee rules are not correct");
		}
		
		
		try
		{
			if(stronempCheckbox.isSelected())
			{
			WebElement minamtsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			minamtsearch.clear();
			minamtsearch.sendKeys("midpoint amt",Keys.ENTER);
			Thread.sleep(10000);
			
			List<WebElement> minamtcolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
		
			
			for(WebElement names : minamtcolumns)
			{
				if(names.getText().equals("midpoint_amt"))
				{
					System.out.println("midpoint_amt");
				}
				else
				{
					System.out.println("Midpoint amt column is missing");
				}
			}
			
			}
			
			else 
			{
				System.out.println("Structure on employee is not selected");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Structrue on employee rules are not correct");
		}
		
		
		try
		{
			if(stronempCheckbox.isSelected())
			{
			WebElement minamtsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
			minamtsearch.clear();
			minamtsearch.sendKeys("maximum amt",Keys.ENTER);
			Thread.sleep(10000);
			
			List<WebElement> minamtcolumns = Configuration.driver.findElements(By.xpath("//div[@id='grid-column']/tbody/tr/td[2]"));
		
			
			for(WebElement names : minamtcolumns)
			{
				if(names.getText().equals("maximum_amt"))
				{
					System.out.println("maximum_amt");
				}
				else
				{
					System.out.println("Maximum amt column is missing");
				}
			}
			
			}
			
			else 
			{
				System.out.println("Structure on employee is not selected");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Structrue on employee rules are not correct");
		}
		
		
		
		try
		{
		WebElement guidelinesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		guidelinesearch.clear();
		guidelinesearch.sendKeys("Guideline",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> guidelinecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : guidelinecolumns)
		{
					
			if(names.getText().equals("guideline_name"))
			{				
				System.out.println("guideline_name");		
			}
			else
			{
				System.out.println("Guideline Name is missing");
			}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Guide line rules are not correct");
		}
		
		try
		{
		WebElement rangesearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid-column-wrapper']/div[2]/div[1]/input")));
		rangesearch.clear();
		rangesearch.sendKeys("Range",Keys.ENTER);
		Thread.sleep(5000);
		
		List<WebElement> rangecolumns = Configuration.driver.findElements(By.xpath("//table[@id='grid-column']/tbody/tr/td[2]"));	
		
		for(WebElement names : rangecolumns)
		{
					
			if(names.getText().equals("range_penetration_label"))
			{				
				System.out.println("range_penetration_label");		
			}
			else
			{
				System.out.println("Range Penetration Label is missing");
			}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Range Penetration label rules are not correct");
		}
		
	}
}
