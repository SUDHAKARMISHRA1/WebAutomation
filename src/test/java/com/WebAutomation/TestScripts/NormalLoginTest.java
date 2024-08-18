package com.WebAutomation.TestScripts;

import org.testng.annotations.Test;

import com.WebAutomation.Objectsfiles.HomePage;
import com.WebAutomation.Objectsfiles.LoginPage;
import com.WebAutomation.TestComponents.BaseFile;

public class NormalLoginTest extends BaseFile{

	
	@Test
	public void loginTest() {
		HomePage home = new HomePage(driver);
		home.MyAccount();
		LoginPage login = new LoginPage(driver);
		login.userName("rohan");
		login.password("pass");
		login.loginButton();
		
	}
	
}
