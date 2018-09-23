package com.qa.test.runner.pge;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				 features="pge/com/qa/test/feature/pge",
				 glue={"helpers","com.qa.test.stepdefinition.pge"},
				 format={"pretty","html:html-result/html-test-out","json:json-result/json-test-out.json","junit:xml-result/xml-rest-out.xml"},
				 monochrome=true,
				 strict=true,
				 dryRun=false
		)
public class PgeTestRunner {

}
