package com.reporting;

import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReporting {
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void startReport(){
		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://getshipboardsaas.com/login");
		
		extent = new ExtentReports (System.getProperty("user.dir") +"/reporting/index.html",true);
		
		extent.addSystemInfo("Reporter", "Aziz");
		extent.addSystemInfo("Sprint", "11");
		extent.addSystemInfo("Module", "Compensation Plan");
		extent.addSystemInfo("Title","login");
        extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-report.xml"));
               // return extent;
	}
	
	@Test
	public void invalidlogin() {
		logger = extent.startTest("Invalid login");
		logger.log(LogStatus.INFO, "Entering username");
		logger.log(LogStatus.INFO, "Entering password");
		logger.log(LogStatus.INFO, "Hit login button");				
	}
	
	@AfterTest
	public void endReport(){
			extent.endTest(logger);
            extent.flush();
            //extent.close();
    }
}
