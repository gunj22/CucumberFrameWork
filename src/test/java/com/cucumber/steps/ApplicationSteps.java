package com.cucumber.steps;

import java.util.Map;

import com.cucumber.webdriver.Webconnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ApplicationSteps {
	Webconnector connect;

	public ApplicationSteps(Webconnector connect) {
		this.connect = connect;
	}

	@And("^I login into application$")
	public void login_into_Application(Map<String, String> data) {
		/*
		 * System.out.println(data.get("UserName"));
		 * System.out.println(data.get("Password"));
		 */

		connect.login(data.get("UserName"), data.get("Password"));

	}

	@Then("^login should be (.*)$")
	public void login_should_be(String expectedResult) {
		connect.validateLogin(expectedResult);

	}

}
