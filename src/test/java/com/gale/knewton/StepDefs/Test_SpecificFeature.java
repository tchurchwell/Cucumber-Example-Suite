package com.gale.knewton.StepDefs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.gale.knewton.StepDefs.Stepdefs_baseTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/gale/knewton/features",
tags={"@StudentLoginAndLaunchCourse, @StuLaunchesProgressApp"},

format = {"pretty","html:target/cucumber","json:target/cucumber.json"})

/* 
 * Cucumber tags
 * Instructor: @LogincreateLaunch, @LoginLaunch
 * Student: @LoginEnrollAndAcceptEula, @StudentLoginAndLaunchCourse
 * Assessment: @AccessAssessmentSA, @LaunchSubmitSA, @StuLaunchSubmitDistnct
 * Inline Assessment: @StuLaunchSubmitInline, @LaunchSubmitInlineSA, @AccessinlineSAAndlinkToEBook
 * ESC: @AccessESCandLinkToLPN, @InstLaunchESC, @StudLaunchESC, @StuVerifyESC, @StuClosesESC
 * SAA: @AccessAssessmentSA, @InstLaunchSubmitSAA, @StuLaunchSubmitSAA 
 */

public class Test_SpecificFeature {
	@BeforeClass
	public static void classSetup() {
		Stepdefs_baseTest.setUp();
	}

	@AfterClass
	public static void classTeardown() {
		Stepdefs_baseTest.tearDown();
	}
}	