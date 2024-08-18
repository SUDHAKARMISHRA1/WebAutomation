package com.WebAutomation.Objectsfiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WebAutomation.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h2[text()='Login']")
	WebElement loginTitle;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit' and @Value='Login']")
	WebElement loginButton;

	public String loginTitle() {
		String title = loginTitle.getText();
		return title;
	}

	public void userName(String name) {
		userName.sendKeys(name);
	}

	public void password(String pass) {
		password.sendKeys(pass);
	}

	public void loginButton() {
		loginButton.click();

	}

}
