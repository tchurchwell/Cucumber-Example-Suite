package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

public class MindTapDashboardPage extends BaseWebComponent{
	private String lbl_dashboard_xpath = "//h3[contains(.,'Dashboard')]";
	private String lnk_UserMenu_css = ".user-menu-link.tb_item";
	private String lnk_CourseSetting_css = "#manage_users";
	private String chk_ToggleDashboard_css = "input[name='dashboardCheckbox']";
	private String btn_Save_id = "dashboard-settings-save-btn";
	
	public boolean isMindtapDashboardDisplayed(){
	return findElementByXpath(lbl_dashboard_xpath).isDisplayed();	
	}

	public void disableDashboard(){
		findElementByCssPath(lnk_UserMenu_css).click();
		findElementByCssPath(lnk_CourseSetting_css).click();
		findElementByCssPath(chk_ToggleDashboard_css).click();
		findElementById(btn_Save_id).click();
		findElementById(btn_Save_id).click();
		logPassMessage("Dashboard disabled successfully");
	}
}
