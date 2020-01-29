package org.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ContextSteps {
	private static boolean initialized = false;

	   private WebDriver driver;

	   @Before
	   public void setUp() throws Exception {
	      if (!initialized) {
	         // initialize the driver
	    	 
	    	//  System.setProperty("webdriver.gecko.driver", "src/test/resources/squash/geckodriver.exe");
	         driver = new FirefoxDriver();
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         initialized = false;
	      }
	   }

	   public WebDriver getDriver() {
	      return driver;
	   }
	   @After
	   public void tearDown()
	   {
		   driver.close();
		   
	   }

}
