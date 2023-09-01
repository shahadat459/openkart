package com.qa.vaaree.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.vaaree.pages.AccountsPage;
import com.qa.vaaree.pages.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	LoginPage loginPage;
	AccountsPage accountsPage;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://vaaree.com/");
		loginPage = new LoginPage(driver);
	}

	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}

	@Test
	public void loginPageUrlTest() {
		String actURL = loginPage.getLoginPageUrl();
		Assert.assertTrue(actURL.contains("route=account/login"));

	}

	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdExist());
	}

	@Test
	public void loginTest() {
		accountsPage = loginPage.doLogin("shahadat.khan@launchventures.co", "S#aan2023");
	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}
}