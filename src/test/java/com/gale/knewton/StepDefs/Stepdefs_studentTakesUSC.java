package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

import cucumber.api.java.en.Then;

public class Stepdefs_studentTakesUSC extends BaseWebComponent {
	
	private UscActivityPage uscActivitypage;
	
	@Then("^I am on Unit Study Center page$")
	public void i_am_on_Unit_Study_Center_page() {
		uscActivitypage = new UscActivityPage();
	}

}
