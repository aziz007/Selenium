package com.testcases.DarticanAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Cycles_Page {
	
	
	public static WebDriver driver;
	
@Test(description = "mouse over function")

public void mouseover()
{
	try
	{
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.id("83"));
		actions.moveToElement(target).perform();
		System.out.println("Done mouse over");
	}
	catch(Error e) {
		System.out.println("Not Done mouse over");
	}
	
	
}


}
