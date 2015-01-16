package com.gale.knewton.StepDefs;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.gale.knewton.StepDefs.Stepdefs_baseTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/gale/knewton/features",
tags={"@LoginLaunch, @InstLaunchESC"},
format = {"pretty","html:target/cucumber","json:target/cucumber.json"})

/* Cucumber tags
 * Instructor: @LogincreateLaunch, @LoginLaunch
 * Student: @LoginEnrollAndAcceptEula, @StudentLoginAndLaunchCourse
 * GDA: @AccessGDAAndlinkSimpleAssessment, @LaunchSubmitSA, @StuLaunchSubmitDistnct
 * GIA: @StuLaunchSubmitInline, @LaunchSubmitInlineSA, @AccessinlineSAAndlinkToEBook
 * ESC: @AccessESCandLinkToLPN, @InstLaunchESC, @StudLaunchESC, @StuVerifyESC, @StuClosesESC
 */

public class Test_SpecificFeature {
	@BeforeClass
	public static void classSetup() {
		Stepdefs_baseTest.setUp();
	}

	/*@AfterClass
	public static void classTeardown() {
		Stepdefs_baseTest.tearDown();
	}*/
}	