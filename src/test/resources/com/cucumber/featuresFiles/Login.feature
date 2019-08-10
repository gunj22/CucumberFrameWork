#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Login 
Feature: Logging in Rediffmail Money
  

  @Login
  Scenario Outline: Loging into Rediff Money
    #Given I Open Chrome Browser
    #And I navigate to siteUrl
    #And I enter ashishthakur1983 in emailAddress field
    #And I Click on continue_button
    #Then I type pass@1234 in password field
    #And After that i click on loginButton
    
    Given I Open <Browser> Browser
    And I navigate to siteUrl
    And I login into application
    |UserName	| ashishthakur1983	|
    |Password	| pass@1234			|
    Then login should be <Result>
    
    Examples: 
    |Browser	|Result	|
    |Chrome		|Sucess	| 	
    
    
    