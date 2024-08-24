package com.WebAutomation.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseFile {

	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		// properties class added
		
				WebDriverManager.chromedriver().setup();
				WebDriverManager.edgedriver().setup();
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
						+ "//src//main//java//com//WebAutomation//Resources//GlobalData.properties");
				prop.load(fis);

				String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
						: prop.getProperty("browser");

				if (browserName.contains("chrome")) {
					ChromeOptions options = new ChromeOptions();
					options.addArguments("start-maximized");
					WebDriverManager.chromedriver().setup();
					if (browserName.contains("headless")) {
						options.addArguments("headless");
					}
					driver = new ChromeDriver(options);

				} 
						
				else if (browserName.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", "./exefile//geckodriver");
					driver = new FirefoxDriver();
					// Firefox
				} else if (browserName.equalsIgnoreCase("edge")) {
					// Edge
					System.setProperty("webdriver.edge.driver", "C://Users//sudhakar mishra//Downloads//msedgedriver.exe");
					driver = new EdgeDriver();
					
				}

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				return driver;
		
	}
	
	/* Code to Capture Screenshots as per Requirements */
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		System.out.println("Check 3");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"//reports//" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(dest));
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	
	/*This is new comment*/
	@BeforeMethod(alwaysRun = true)
	public WebDriver launchApplication() throws IOException {
		driver = initializeDriver();
//		driver.manage().deleteAllCookies();
		driver.get("http://practice.automationtesting.in/");
		return driver;
	}
	
	//Code to Close all the Open Browser Tabs for automation
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
