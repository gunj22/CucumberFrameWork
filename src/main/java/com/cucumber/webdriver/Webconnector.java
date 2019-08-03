package com.cucumber.webdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webconnector {

	WebDriver driver;
	Properties prop;

	public Webconnector() throws IOException {
		if (prop == null) {
			prop = new Properties();
			FileInputStream fs;
			try {
				fs = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\cucumber\\propertiesfiles\\project.properties");
				prop.load(fs);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

	}

	public void openBrowser(String browserName) {
		if (browserName.equals("Mozilla"))
			driver = new FirefoxDriver();
		else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\com\\cucumber\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

	}

	public void navigate(String urlKey) {
		driver.get(prop.getProperty(urlKey));
	}

	public void clickOnElement(String elementKey) {

		driver.findElement(By.xpath(prop.getProperty(elementKey))).click();

	}

	public void type(String data, String elementKey) {

		driver.findElement(By.xpath(prop.getProperty("email_address"))).sendKeys(data);
	}

}
