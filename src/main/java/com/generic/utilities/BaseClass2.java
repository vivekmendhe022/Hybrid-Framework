package com.generic.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.object.repository.HomePage;
import com.object.repository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 {

	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public PropertiesFileUtility putil = new PropertiesFileUtility();

	public WebDriver d = null;

	@BeforeSuite
	public void BSConfig() {
		System.out.println("***** Open the dabase connection *****");
	}

	/**
	 * This method perform browser launch & maximizing the web screen also contains
	 * main URL, Implicit wait
	 * 
	 * @throws IOException
	 */
	@BeforeClass
	public void BCConfig() throws IOException {

		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("bard_url");

		if (BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
			System.out.println("***** " + BROWSER + " is launched.");
		} else if (BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
			System.out.println("***** " + BROWSER + " is launched.");
		} else if (BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			d = new EdgeDriver();
			System.out.println("***** " + BROWSER + " is launched.");
		} else {
			System.out.println("***** Invalid Browser Name: enter 'chrome' 'firefox' 'edge' ");
		}

		// Maximizing web page
		wutil.maximizeWebPage(d);
		// Wait for 30 seconds to page load
		wutil.waitForPageLoad(d);
		// Launch the web URL
		d.get(URL);
	}

	
	@AfterClass
	public void ACConfig() {
		d.quit();
	}

	@AfterSuite
	public void ASConfig() {
		System.out.println("***** Close the dabase connection *****");
	}

}
