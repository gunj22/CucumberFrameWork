package com.cucumber.steps;

import com.cucumber.webdriver.Webconnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;





@SuppressWarnings("deprecation")
public class GenericSteps {

	Webconnector connect;

	public GenericSteps(Webconnector connect) {
		this.connect = connect;
	}

	
	
	@Given("^I Open (.*) Browser$")
	public void I_Open_Browser(String browserName) {
		connect.openBrowser(browserName);
	}

	@And("^I navigate to (.*)$")
	public void I_navigate(String url) {

		connect.navigate(url);
	}

	@And("^I type (.*) in username field$")
	public void I_Type_Username(String data,String locatorKey) {
		System.out.println("Typing in " + locatorKey + ". Data " +data);
		connect.type(data, locatorKey);
	}

	@And("^I Click on (.*)$")
	public void I_Click(String locatorKey) {
		connect.clickOnElement(locatorKey);

	}

}
