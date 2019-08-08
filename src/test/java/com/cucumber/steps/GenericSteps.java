package com.cucumber.steps;

import com.cucumber.webdriver.Webconnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

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

	@And("^I enter (.*) in (.*) field$")
	public void I_Type_Username(String data,String locatorKey) {
		System.out.println("Typing in " + locatorKey + ". Data " +data);
		connect.type(data, locatorKey);
	}

	@And("^I Click on (.*)$")
	public void I_Click(String locatorKey) throws InterruptedException {
		connect.clickOnElement(locatorKey);
		Thread.sleep(1000);

	}
	
	@Then("^I type (.*) in (.*) field$")
	public void I_Type_Password(String data,String password){
		//connect.clickOnElement(password);
		connect.type(data,password);
	}
	
	@And("^After that i click on (.*)$")
	public void I_again_click_On_ContinueButton(String continu_Button){
		connect.clickOnElement(continu_Button);
	}
	
	
	
	
	
	
	

}
