package com.testcases.DarticanAutomation;

import java.io.File;
//import java.util.concurrent.TimeUnit;

//import java.awt.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class Configuration {
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
@Test
public void Browser() {
	
	extent = new ExtentReports (System.getProperty("user.dir") +"/reporting/index.html",true);
	
	extent.addSystemInfo("Reporter", "Aziz");
	extent.addSystemInfo("Sprint", "11");
	extent.addSystemInfo("Module", "Compensation Planning");
	
	Configuration.logger = Configuration.extent.startTest("Open Stagev6");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	Configuration.logger.log(LogStatus.INFO,"Open Chrome browser");
	
	driver.manage().window().maximize();
	Configuration.logger.log(LogStatus.INFO,"Maximize Chrome browser");
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://stagev6.dartican.com/");	
	Configuration.logger.log(LogStatus.INFO,"stagev6.dartican.com");
	
	//extent = new ExtentReports (System.getProperty("user.dir") +"/reporting/index.html",true);
	
	//extent.addSystemInfo("Reporter", "Aziz");
	//extent.addSystemInfo("Sprint", "11");
	//extent.addSystemInfo("Module", "Compensation Plan");
	
    extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-report.xml"));
	
}
	@AfterSuite
	public void endReport(){
			extent.endTest(logger);
	        extent.flush();
	        //extent.close();
}
}
