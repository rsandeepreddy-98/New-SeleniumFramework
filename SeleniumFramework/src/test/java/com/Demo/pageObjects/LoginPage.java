package com.Demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//form/div/div/input")
	private WebElement username;

	public void setUsername(String UserName) {
		username.sendKeys(UserName);
	}

	@FindBy(id = "password")
	private WebElement password;

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	public void clickSubmitButton() {
		submitButton.click();
	}
	
	@FindBy(xpath = "//h4[@class='subheader']")
	private WebElement successLoginText;
	
	public void veriyTextPresent() {
		String expectedText = successLoginText.getText();
		Assert.assertEquals("Welcome to the Secure Area. When you are done click logout below.", expectedText);
	}

}
