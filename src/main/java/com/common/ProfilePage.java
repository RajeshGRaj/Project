package com.common;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class ProfilePage extends Base_Class{
	
	public By L_username_menu = By.xpath("//div[@class='user__name']");
	public void clickUsernameDropdown() {
		try {
			click(L_username_menu);
			ExtentTestManager.getTest().log(Status.PASS, "Username Menu Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Username Menu Not Clicked");
		}
	}
	
	
	public By L_profile = By.xpath("//button[normalize-space()='Profile']");
	public void clickProfileOption() {
		try {
			click(L_profile);
			ExtentTestManager.getTest().log(Status.PASS, "Profile Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Profile Not Clicked");
		}
	}
	
	public By L_logout = By.xpath("//button[normalize-space()='Logout']");
	public void clickLogout() {
		try {
			click(L_logout);
			ExtentTestManager.getTest().log(Status.PASS, "Logout Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Logout Not Clicked");
		}
	}
	
	public By L_change_password = By.xpath("//button[normalize-space()='Change Password']");
	public void clickChangePassword() {
		try {
			click(L_change_password);
			ExtentTestManager.getTest().log(Status.PASS, "Change Password Clicked");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Change Password Not Clicked");
		}
	}

}
