package com.testcases.DarticanAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Dashboard {

WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public Dashboard(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators for the page title and the logout button
	By heading = By.xpath("//form[@id='selected-planning-cycle']/ul/li/a/h1");
	By logoutBtn = By.xpath("//a[@href='/Logout']");
	
	//Method to capture the page heading
	public String getHeading() {
		String head = driver.findElement(heading).getText();
		return head;
	}
	
	//Method to click on Logout button
	public void clickLogout() {
		driver.findElement(logoutBtn).click();
	}
	
}
