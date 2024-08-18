package com.WebAutomation.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));

	}

	//Method to validate weather the uploaded image is displayed or not.
	public String isImageDisplayed(WebElement image) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)
				driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth "
						+ "!= \"undefined\" && arguments[0].naturalWidth > 0", image);
		String isDisplayedImg = "";
		if(ImagePresent == null) {
			isDisplayedImg = "no";
		}else {
			isDisplayedImg = "yes";
		}
		return isDisplayedImg;
	}
	
	/*Code to manage windows scrolling*/
	public void onScroll(int width, int height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy("+width+","+height+")");
	}
}
