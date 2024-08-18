package com.WebAutomation.Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.WebAutomation.AbstractComponents.AbstractComponent;

public class Utils extends AbstractComponent{

	WebDriver driver;

	public Utils(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
