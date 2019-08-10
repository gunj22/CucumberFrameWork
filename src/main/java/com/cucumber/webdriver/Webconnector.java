package com.cucumber.webdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cucumber.Reports.ExtentManager;

public class Webconnector {

	WebDriver driver;
	public Properties prop;
	public ExtentReports rep;
	public ExtentTest test;

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
			infoLog("Opening Browser ===> " + browserName);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "\\src\\main\\resources\\com\\cucumber\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public WebElement geElement(String locatorKey) {
		WebElement element = null;
		WebDriverWait wait;
		try {

			if (locatorKey.endsWith("_xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				// wait = new WebDriverWait(driver, 15);
				// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(locatorKey))));
			} else if (locatorKey.endsWith("_id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				/*
				 * wait = new WebDriverWait(driver, 15);
				 * wait.until(ExpectedConditions.
				 * visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(
				 * locatorKey))));
				 */
			} else if (locatorKey.endsWith("_name")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				/*
				 * wait = new WebDriverWait(driver, 15);
				 * wait.until(ExpectedConditions.
				 * visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(
				 * locatorKey))));
				 */
			} else if (locatorKey.endsWith("_css")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				/*
				 * wait = new WebDriverWait(driver, 15);
				 * wait.until(ExpectedConditions.
				 * visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(
				 * locatorKey))));
				 */
			}

		} catch (Exception ex) {
			// Report the failure report
		}

		return element;
	}

	public void navigate(String urlKey) {
		infoLog("Navigating to Url ===> " + urlKey);
		driver.get(prop.getProperty(urlKey));
	}

	public void clickOnElement(String elementKey) {
		geElement(elementKey).click();

	}

	public void type(String elementKey, String data) {
		infoLog("Enter ===> " + data + " into ==> " + elementKey);

		geElement(elementKey).sendKeys(data);
	}

	public void validateLogin(String expectedResult) {

		boolean result = isElementPresent("portfolioDropDown_id");
		String actualResult = "";
		if (result == true) {
			actualResult = "sucess";
		} else {
			actualResult = "Failure";
		}
		infoLog("Expected Result is === > " + expectedResult);
		infoLog("Got Actual Result is === > " + actualResult);
		if (!actualResult.equalsIgnoreCase(expectedResult)) {
			// Report a failure
			failureLog("Login not sucessfull..");
			System.out.println("Failiure in Login the application");
		}

	}

	public boolean isElementPresent(String elementKey) {
		List<WebElement> element = null;
		if (elementKey.endsWith("_xpath")) {
			element = driver.findElements(By.xpath(prop.getProperty(elementKey)));
		} else if (elementKey.endsWith("_id")) {
			element = driver.findElements(By.id(prop.getProperty(elementKey)));
		} else if (elementKey.endsWith("_name")) {
			element = driver.findElements(By.xpath(prop.getProperty(elementKey)));
		} else if (elementKey.endsWith("_css")) {
			element = driver.findElements(By.cssSelector(prop.getProperty(elementKey)));
		}
		if (element.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void login(String userName, String password) {
		type("emailAddress_id", userName);
		clickOnElement("continue_button_id");
		type("password_id", password);
		clickOnElement("loginButton_id");

	}

	/**
	 * Methods for Logging
	 */

	public void infoLog(String infoMsg) {
		test.log(Status.INFO, infoMsg);
	}

	public void failureLog(String failMsg) {
		test.log(Status.FAIL, failMsg);
	}

	/**
	 * Method for Initialize and flush the report to print on the reports section
	 */
	public void initReports(String testName) {
		rep = ExtentManager.getInstance(prop.getProperty("reportPath"));
		test = rep.createTest(testName);
		test.log(Status.INFO, "Starting " + testName);
	}

	public void quit() {
		if (rep != null) {
			rep.flush();
		}
	}

}
