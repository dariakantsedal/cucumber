package org.cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProfilSteps {
	 WebDriver driver;
	  private ContextSteps contextSteps;

	   // PicoContainer injects class ContextSteps
	   public ProfilSteps (ContextSteps contextSteps) {
	      this.contextSteps = contextSteps;
	   }
		
	@Given("that I go to the page and log in")
	public void that_I_go_to_the_page_and_log_in() {
		driver = contextSteps.getDriver();
		
		
		//navigation
		driver.get("https://petstore.octoperf.com/");
		driver.findElement(By.xpath("//a[.='Enter the Store']")).click();
		driver.findElement(By.xpath("//a[.='Sign In']")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("username")).sendKeys("j2ee");
		driver.findElement(By.name("password")).sendKeys("j2ee");
		driver.findElement(By.name("signon")).click();
	}

	@When("I go to the page MyAccount")
	public void i_go_to_the_page_MyAccount() {
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
	}

	@When("I change Favourite Category to {}")
	public void i_change_Favourite_Category_to_FISH(String category) {
	    Select select = new Select(driver.findElement(By.name("account.favouriteCategoryId")));
	    select.selectByVisibleText(category);
	}

	@When("I save account information")
	public void i_save_account_information() {
	 driver.findElement(By.name("editAccount")).click();
	 
	}

	@Then("category is changed to {}")
	public void category_is_changed_to_FISH(String word) {
		Select select = new Select(driver.findElement(By.name("account.favouriteCategoryId")));
	    Assert.assertEquals("",word,select.getFirstSelectedOption().getText());
	}

	@When("I uncheck checkbox Enable MyBanner")
	public void i_uncheck_checkbox_Enable_MyBanner() {
	   driver.findElement(By.name("account.bannerOption")).click(); 
	}

	@Then("checkbox is unchecked")
	public void checkbox_is_unchecked() {
		Assert.assertFalse(driver.findElement(By.name("account.bannerOption")).isSelected()); 
	}
}
