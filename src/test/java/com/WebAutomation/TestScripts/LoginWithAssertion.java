package com.WebAutomation.TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.WebAutomation.Objectsfiles.HomePage;
import com.WebAutomation.Objectsfiles.LoginPage;
import com.WebAutomation.TestComponents.BaseFile;

public class LoginWithAssertion extends BaseFile{

	@Test
	public void validateLoginTest() {
		HomePage home = new HomePage(driver);
		home.MyAccount();
		LoginPage login = new LoginPage(driver);
		String text = login.loginTitle();
		login.userName("rohan");
		login.password("pass");
		
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(text, "CheckTitle");
		login.loginButton();
		asserts.assertAll();
	
	}
}
