package org.cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.assertEquals;

public class CalculationSteps {
	WebDriver driver;
	@FindBy (xpath = "//*[@id='Cart']/form/table/tbody/tr[2]/td[6]")
	static WebElement list_price;
	static double prix;
	
	@Given("I add to cart a Large Angelfish")
	public void i_add_to_cart_a_Large_Angelfish() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/squash/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//navigation
		driver.get("https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01");
		driver.findElement(By.xpath("(//a[@class='Button'])[1]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dollar = driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[2]/td[6]")).getText();
		dollar = dollar.replace("$", "");
		prix = Double.parseDouble(dollar);
		
	}

	@When("I select {int}")
	public void i_select(Integer quantity) {
	    driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[2]/td[5]/input")).clear();
	    driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[2]/td[5]/input")).sendKeys(quantity.toString());
	    driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[3]/td[1]/input")).click();
	}

	@Then("for each {int} its {double} is a proper one")
	public void for_each_its_is_a_proper_one(Integer quantity, Double double1) {
	  Assert.assertEquals("prices are not the same", quantity*prix, double1, 0.1);
	 driver.close();
	}



}
