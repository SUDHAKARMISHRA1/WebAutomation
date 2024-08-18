package com.WebAutomation.Resources;

import org.testng.annotations.DataProvider;

public class DataProviderMethod {
	@DataProvider(name = "setLoginData")
	public Object[][] loginPositiveDataProvider() {
		Object[][] poscred = new Object[2][2];
		poscred[0][0]= "jhon@mailinator.com";
		poscred[0][1]= "123456";
		
		poscred[1][0]= "jhon@mailinator.com";
		poscred[1][1]= "123456";

		return poscred;
	}

}
