package com.testcases.DarticanAutomation.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class LoginPage {

	    private WebDriver driver;

	    //@FindBy(id = "email")
	    By uName = By.xpath("//input[@type='text']");
	    private WebElement emailField;

	    //@FindBy(id = "password")
	    By pswd = By.id("//input[@type='password']");
	    private WebElement passwordField;

	    //@FindBy(xpath = "//button[contains(text(),'Login')]")
	    By loginBtn = By.id("//button[@type='submit']");
	    private WebElement loginButton;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterEmail(String uName) {
	        emailField.sendKeys(uName);
	    }

	    public void enterPassword(String pswd) {
	        passwordField.sendKeys(pswd);
	    }

	    public void clickLoginButton() {
	        loginButton.click();
	    }
	}
