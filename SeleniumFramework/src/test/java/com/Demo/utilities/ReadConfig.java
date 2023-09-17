package com.Demo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public Properties properties;

	public ReadConfig() {

		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("./Configuration/data.properties");
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getApplicationurl() {
		String url = properties.getProperty("url");
		return url;
	}
	
	public String getUsername() {
		String username = properties.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = properties.getProperty("password");
		return password;
	}
	
	public String getChromeBrowser() {
		String browser = properties.getProperty("cbrowser");
		return browser;
	}
	//fbrowser
	public String getFireFoxBrowser() {
		String fbrowser = properties.getProperty("fbrowser");
		return fbrowser;
	}
}
