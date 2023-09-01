package com.qa.vaaree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {
	private WebDriver driver;

	// 1. constructor of the page class
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	// 2. private by locators
	private By logOutLink = By.id("CustomerEmail");

}
