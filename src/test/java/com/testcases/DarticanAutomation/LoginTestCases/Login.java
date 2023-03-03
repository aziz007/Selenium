package com.testcases.DarticanAutomation.LoginTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.testcases.DarticanAutomation.Configuration;

public class Login {

public static WebDriver driver;
	

	
	@Test (description = "Enter Valid credentials and hit enter button",priority = 4)
		
		public void Validlogin() 
			{
	
				
		
				try 
				{
					
						String titleexpected = "Compensation Plannings";
					
						WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
						Configuration.logger = Configuration.extent.startTest("Login - Positive test case");
						
						String titleread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/p[1]"))).getText();
						Assert.assertEquals(titleread, titleexpected);
						
						if(titleread.equals(titleexpected))
						{
							Configuration.logger.log(LogStatus.INFO, titleexpected);
						}
						else 
						{
							Configuration.logger.log(LogStatus.INFO, "Page Title does'nt match");
						}
				}
				catch(Exception e)
				{
						Configuration.logger.log(LogStatus.FAIL,e);
				}
		
				
				try 
				{
						Configuration.logger.log(LogStatus.INFO, "Entering correct username");
						Configuration.driver.findElement(By.xpath("//input[@type='text']")).clear();
						Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
						Configuration.logger.log(LogStatus.INFO, "Entering correct password");
						Configuration.driver.findElement(By.xpath("//input[@type='password']")).clear();
						Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
						
						Configuration.logger.log(LogStatus.INFO, "Hit Login button");
						Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
						Thread.sleep(1000);	
						Configuration.logger.log(LogStatus.INFO, "Login Successfully");
				} 
				catch (Exception e) 
				{
						// TODO: handle the exception
						Configuration.logger.log(LogStatus.FAIL,e);
					
				}
	}
	
	
	
	@Test (description = "Enter InValid credentials and hit enter button",priority = 1)
	
	public void InValidlogin() 
	{

		
	
		try 
		{
				String titleexpected = "Compensation Plannings";
			
				WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
				Configuration.logger = Configuration.extent.startTest("Login - Negative test case");
				
				String titleread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/p[1]"))).getText();
				Assert.assertEquals(titleread, titleexpected);
								
					if(titleread.equals(titleexpected))
					{
						Configuration.logger.log(LogStatus.INFO, titleexpected);
					}										
		}
		catch(Exception e)
		{
				Configuration.logger.log(LogStatus.FAIL,e);
		}

		
		try 
		{
				Configuration.logger.log(LogStatus.INFO, "Entering wrong username");
				Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerth");
				Configuration.logger.log(LogStatus.INFO, "Entering wrong password");
				Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerth");
				
				Configuration.logger.log(LogStatus.INFO, "Click Login button");
				Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(1000);
				Configuration.logger.log(LogStatus.FAIL,"Login Failed");
		} 
		catch (Exception e)
		{
				// TODO: handle the exception
				Configuration.logger.log(LogStatus.FAIL,e);
		}
		
		
		String errorexpected = "Invalid login attempt.";
		
		try 
		{
				WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
				
				String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/form/div[1]"))).getText();
				Assert.assertEquals(errorread, errorexpected);
				
				if(errorread.equals(errorexpected))
				{
					Configuration.logger.log(LogStatus.INFO, errorexpected);
				}
				else
				{
					Configuration.logger.log(LogStatus.INFO, "Error does'nt match");
				}			
		}
		catch(Exception e)
		{
				Configuration.logger.log(LogStatus.FAIL,e);
		}
		
	}
	
	
	@Test (description = "Enter credentials and hit enter button",priority = 2)
	
	public void Wrong_Password_login() 
		{
	
			
		
			try 
			{
					String titleexpected = "Compensation Plannings";
				
					WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
					Configuration.logger = Configuration.extent.startTest("Negative - Wrong Password Attempt");
					
					String titleread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/p[1]"))).getText();
					Assert.assertEquals(titleread, titleexpected);
					
					if(titleread.equals(titleexpected))
					{
						Configuration.logger.log(LogStatus.INFO, titleexpected);
					}
					else 
					{
						Configuration.logger.log(LogStatus.INFO, "Page Title does'nt match");
					}
			}
			catch(Exception e)
			{
					Configuration.logger.log(LogStatus.FAIL,e);
			}
	
			
			try 
			{
					Configuration.logger.log(LogStatus.INFO, "Entering Username");
					Configuration.driver.findElement(By.xpath("//input[@type='text']")).clear();
					Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mgerthe");
					Configuration.logger.log(LogStatus.INFO, "Enter wrong password");
					Configuration.driver.findElement(By.xpath("//input[@type='password']")).clear();
					Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mger");
					
					Configuration.logger.log(LogStatus.INFO, "Click Login button");
					Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
					Thread.sleep(1000);
					Configuration.logger.log(LogStatus.FAIL, "Login Failed , Wrong Password");
			} 
			catch (Exception e)
			{
					// TODO: handle the exception
					Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			String errorexpected = "Incorrect Password";
			
			try 
			{
					WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
					
					String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/form/div[1]/ul/li"))).getText();
					Assert.assertEquals(errorread, errorexpected);
					try
					{
							if(errorread.equals(errorexpected))
							{
								Configuration.logger.log(LogStatus.FAIL, errorexpected);
							}
							else
							{
								Configuration.logger.log(LogStatus.INFO, "Error does not match");
							}
					}
					catch(Exception e)
					{
						Configuration.logger.log(LogStatus.INFO, "Error does'nt match");
					}
			}
			catch(Exception e)
			{
					Configuration.logger.log(LogStatus.FAIL,e);
			}
			
		}
	
	
	@Test (description = "Enter credentials and hit enter button",priority = 3)
	
	public void Wrong_Username_login() 
		{
	
			
		
			try 
			{
				
					String titleexpected = "Compensation Plannings";
				
					WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
					Configuration.logger = Configuration.extent.startTest("Negative - Wrong Username Attempt");
					
					String titleread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/p[1]"))).getText();
					Assert.assertEquals(titleread, titleexpected);
					
					if(titleread.equals(titleexpected))
					{
						Configuration.logger.log(LogStatus.INFO, titleexpected);
					}
					else 
					{
						Configuration.logger.log(LogStatus.INFO, "Page Title does'nt match");
					}
			}
			catch(Exception e)
			{
					Configuration.logger.log(LogStatus.FAIL,e);
			}
	
			
			try 
			{
					Configuration.logger.log(LogStatus.INFO, "Enter Wrong Username");
					Configuration.driver.findElement(By.xpath("//input[@type='text']")).clear();
					Configuration.driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mger");
					Configuration.logger.log(LogStatus.INFO, "Entering password");
					Configuration.driver.findElement(By.xpath("//input[@type='password']")).clear();
					Configuration.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mgerthe");
					
					Configuration.logger.log(LogStatus.INFO, "Click Login button");
					Configuration.driver.findElement(By.xpath("//button[@type='submit']")).click();
					Thread.sleep(1000);
					Configuration.logger.log(LogStatus.FAIL, "Login Failed , Wrong Username");
			} 
			catch (Exception e)
			{
					// TODO: handle the exception
					Configuration.logger.log(LogStatus.FAIL,e);
			}
			
			
			String errorexpected = "Invalid Username";
			
			try 
			{
					WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
					
					String errorread = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/form/div[1]/ul/li"))).getText();
					Assert.assertEquals(errorread, errorexpected);
					
					if(errorread.equals(errorexpected))
					{
						Configuration.logger.log(LogStatus.INFO, errorexpected);
					}
					else
					{
						Configuration.logger.log(LogStatus.INFO, "Error does'nt match");
					}
			}
			catch(Exception e)
			{
					Configuration.logger.log(LogStatus.FAIL,e);
			}
			
		}
	
	
}
