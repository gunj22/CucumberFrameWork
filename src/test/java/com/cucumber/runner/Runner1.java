package com.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class Runner1 {
	
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			dryRun=false,
			strict=true,
			monochrome=true,
			features={"src/test/resources/"},
			glue={"com.cucumber.runner"},
					plugin={"pretty",
							"html:target/site/cucumber-html",
							"json:target/cucumber1.json"}
			
			)
	
	public class Runner {

	}
	

}
