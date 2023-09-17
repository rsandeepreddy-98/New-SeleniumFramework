package com.Demo.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Demo.pageObjects.LoginPage;
import com.Demo.utilities.BaseClass;

public class TC01_First extends BaseClass {
	public LoginPage loginPage;

	@Test
	public void loginCheck() {
		loginPage = new LoginPage(driver);
		loginPage.setUsername(readConfig.getUsername());
		loginPage.setPassword(readConfig.getPassword());
		loginPage.clickSubmitButton();
		loginPage.veriyTextPresent();
	}

}
