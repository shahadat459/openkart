package com.qa.vaaree.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// 1. constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 2. private by locators
	private By emailId = By.id("CustomerEmail");
	private By password = By.id("CustomerPassword");
	private By signInBtn = By.xpath("//button[text()='Sign In']");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	private By login = By.xpath("//a[@class='t4s-pr']");
	By footerLinks = By.xpath("//footer//a");

	// 3. public page actions/methods
	public AccountsPage doLogin(String email, String pwd) {
		driver.findElement(login).click();
		driver.findElement(emailId).sendKeys(email);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		// returns the next landing page -- AccountsPage ---page chaining model
		return new AccountsPage(driver);

	}

	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("login page title : " + title);
		return title;
	}

	public String getLoginPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("login page url : " + url);
		return url;
	}

	public boolean isForgotPwdExist() {

		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public List<String> getFooterLinksList() {
		
		  List<WebElement> footerLinksList = driver.findElements(footerLinks);
		List<String> footerTextList = new ArrayList<String>();
		
		
		for(WebElement e :footerLinksList ) {
			String text = e.getText();
			footerTextList.add(text);
			
		}
		
		return footerTextList;
	}
}
