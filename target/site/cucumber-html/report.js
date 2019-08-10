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
formatter.scenarioOutline({
  "name": "Loging into Rediff Money",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.step({
  "name": "I Open \u003cBrowser\u003e Browser",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to siteUrl",
  "keyword": "And "
});
formatter.step({
  "name": "I login into application",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "UserName",
        "ashishthakur1983"
      ]
    },
    {
      "cells": [
        "Password",
        "pass@1234"
      ]
    }
  ]
});
formatter.step({
  "name": "login should be \u003cResult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Browser",
        "Result"
      ]
    },
    {
      "cells": [
        "Chrome",
        "Sucess"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Loging into Rediff Money",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Login"
    }
  ]
});
formatter.before({
  "status": "passed"
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
  "name": "I login into application",
  "rows": [
    {
      "cells": [
        "UserName",
        "ashishthakur1983"
      ]
    },
    {
      "cells": [
        "Password",
        "pass@1234"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.login_into_Application(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login should be Sucess",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.login_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});