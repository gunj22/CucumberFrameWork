$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com/cucumber/featuresFiles/Login.feature");
formatter.feature({
  "name": "Logging in Rediffmail Money",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "name": "Loging into Rediff Money",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Login"
    }
  ]
});
formatter.step({
  "name": "I Open Chrome Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.I_Open_Browser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to siteUrl",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.I_navigate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter ashishthakur1983 in emailAddress field",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.I_Type_Username(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Click on continue_button",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.I_Click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I type pass@1234 in password field",
  "keyword": "Then "
});
formatter.match({
  "location": "GenericSteps.I_Type_Password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "After that i click on loginButton",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.I_again_click_On_ContinueButton(String)"
});
formatter.result({
  "status": "passed"
});
});