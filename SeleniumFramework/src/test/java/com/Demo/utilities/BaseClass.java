package com.Demo.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public ReadConfig readConfig = new ReadConfig();

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {

		if (browser.equalsIgnoreCase(readConfig.getChromeBrowser())) {
			driver = new ChromeDriver();
			driver.get(readConfig.getApplicationurl());
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase(readConfig.getFireFoxBrowser())) {
			driver = new EdgeDriver();
			driver.get(readConfig.getApplicationurl());
			driver.manage().window().maximize();
		}
		else {
			System.out.println("No browser associated it with");
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public static String takeScreenshot(String testcasename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"./Screenshots//"+testcasename+".png";
		FileUtils.copyFile(srcFile, new File(path));
		return path;
	}
	
}
