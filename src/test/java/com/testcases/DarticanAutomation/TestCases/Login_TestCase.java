package com.testcases.DarticanAutomation.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.testcases.DarticanAutomation.Pages.Dashboard;
import com.testcases.DarticanAutomation.Pages.LoginPage;

public class Login_TestCase {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
		
			//Creating object of Login page
			LoginPage login = new LoginPage(driver);
			
			//Creating object of Dashboard
			Dashboard dashboard = new Dashboard(driver);
			
			
			//Enter username & password
			login.enterUsername("mgerthe");
			login.enterPassword("mgerthe");
			
			//Click on login button
			login.clickLogin();
			Thread.sleep(3000);
			
			
			//Capture the page heading and print on console
			System.out.println("The current cycle is --- " +dashboard.getHeading());
			
			//Click on Logout button
			dashboard.clickLogout();

	               //Close browser instance
	               driver.quit();
		}
	
}
