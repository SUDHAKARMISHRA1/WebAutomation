package com.WebAutomation.TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.WebAutomation.Objectsfiles.HomePage;
import com.WebAutomation.Objectsfiles.LoginPage;
import com.WebAutomation.Resources.DataProviderMethod;
import com.WebAutomation.TestComponents.BaseFile;

public class LoginWithMultipleTestData  extends BaseFile{

	
	@Test(dataProvider = "setLoginData", dataProviderClass = DataProviderMethod.class)
	public void validateLoginTest(String userName, String password) {
		HomePage home = new HomePage(driver);
		home.MyAccount();
		LoginPage login = new LoginPage(driver);
		String text = login.loginTitle();
		login.userName(userName);
		login.password(password);
		
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(text, "CheckTitle");
		login.loginButton();
		asserts.assertAll();
	// new comments
	}
}
