package org.cucumber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class RechercheSteps {
	static By SEARCH_FIELD = By.xpath("//*[@id=\"SearchContent\"]/form/input[1]");
	static By SEARCH_BUTTON = By.xpath("//*[@id=\"SearchContent\"]/form/input[2]");
	static By RESULT_TITLES = By.xpath("//td[3]");
	//@After
	public void doSomethingAfter() {
			driver.close();
	}	
	
	WebDriver driver;
@Given("Not logged in user is on the home page.")
public void not_logged_in_user_is_on_the_home_page() {
	//System.setProperty("webdriver.gecko.driver", "src/test/resources/squash/geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//navigation
	driver.get("https://petstore.octoperf.com/");
	driver.findElement(By.xpath("//a[.='Enter the Store']")).click();
}

@When("he searches for {}")
public void he_searches_for_bulldog(String word) {
	driver.findElement(SEARCH_FIELD).clear();
	driver.findElement(SEARCH_FIELD).sendKeys(word);
	driver.findElement(SEARCH_BUTTON).click();
}

@Then("result page contains the word {}")
public void result_page_contains_the_word_bulldog(String word) {
	List<WebElement> results = driver.findElements(RESULT_TITLES);
	for (WebElement element : results) {
		Assert.assertTrue("there is not the "+word,element.getText().toLowerCase().contains(word));
	}
    
}


@Then("there is an empty table")
public void there_is_an_empty_table() {
    System.out.println("empty table");
}



}
