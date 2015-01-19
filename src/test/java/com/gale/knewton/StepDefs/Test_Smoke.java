package com.gale.knewton.StepDefs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.gale.knewton.StepDefs.Stepdefs_baseTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/gale/knewton/features",
tags={"@SmokeGulati"},
format = {"pretty","html:target/cucumber","json:target/cucumber.json"})


public class Test_Smoke {
	@BeforeClass
	public static void classSetup() {
		Stepdefs_baseTest.setUp();
	}

	@AfterClass
	public static void classTeardown() {
		Stepdefs_baseTest.tearDown();
	}
}	