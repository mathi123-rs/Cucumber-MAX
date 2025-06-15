package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.devtools.v130.network.model.ReportingApiEndpoint;

import com.omrbranch.report.ReportingJvm;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@response",stepNotifications=false,snippets=SnippetType.CAMELCASE,dryRun=true,publish=true,monochrome=true,plugin={"pretty","json:target\\output.json"},glue="com.omrbranch.stepdefinition",features=("src\\test\\resources\\features"))
public class TestRunner {
	
@AfterClass
public static  void afterClass() {
	
	ReportingJvm.generateJvumReport("C:\\Users\\mathi\\eclipse-workspace-Selenium\\CucumberClass-Mathiyazhagan\\target\\output.json");

}

}
