package com.testcases.DarticanAutomation.TestCases;



	
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class LoginTest {

	    private WebDriver driver;
	    private LoginPage loginPage;

	    @BeforeMethod
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://stagev6.dartican.com/");
	        loginPage = new LoginPage(driver);
	    }

	    @Test
	    public void testLogin() {
	        loginPage.enterEmail("mgerthe");
	        loginPage.enterPassword("mgerthe");
	        loginPage.clickLoginButton();
	        // Perform verification steps
	    }

	    @AfterMethod
	    public void teardown() {
	        driver.quit();
	    }
	}

