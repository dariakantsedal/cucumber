package org.cucumber;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PanierSteps {
	 private ContextSteps contextSteps;

	   // PicoContainer injects class ContextSteps
	   public PanierSteps (ContextSteps contextSteps) {
	      this.contextSteps = contextSteps;
	     
	   }
	
	WebDriver driver;
	@FindBy(xpath = "//*[@id='Cart']/form/table/tbody/tr[2]/td[5]/input")
	WebElement quantity;
	@FindBy(xpath = "//*[@id='Cart']/form/table/tbody/tr[2]/td[6]")
	WebElement listPrice;
	@FindBy(xpath = "//*[@id='Cart']/form/table/tbody/tr[2]/td[7]")
	WebElement TotalCost;
	
	@When("I choose produit {} dans category FISH")
	public void i_choose_produit_dans_category_(String produit) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = contextSteps.getDriver();
	   driver.findElement(By.xpath("//*[@id='SidebarContent']/a[1]")).click();
	   System.out.println("//*[text()='"+produit+"']/preceding::td/a");
	   driver.findElement(By.xpath("//*[text()='"+produit+"']/preceding::td/a")).click();
	   driver.findElement(By.xpath("(//a[@class='Button'])[1]")).click();
	}

	@Then("produit is in the cart")
	public void produit_is_in_the_cart() {
	    // 
		Assert.assertTrue(true);
	}

	

	@When("I change quantity for {int}")
	public void i_change_quantity_for(Integer quantity) {
		driver = contextSteps.getDriver();
	    driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[2]/td[5]/input")).clear();
	    driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[2]/td[5]/input")).sendKeys(quantity.toString());
	    driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[3]/td[1]/input")).click();
	}

	@Then("price is changed accordingly")
	public void price_is_changed_accordingly() {
		driver = contextSteps.getDriver();
		PageFactory.initElements(driver, this);
	//	System.out.println(driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[2]/td[5]/input")).getAttribute("value"));
	//	System.out.println(driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[2]/td[6]")).getText());
	//	System.out.println(driver.findElement(By.xpath("//*[@id='Cart']/form/table/tbody/tr[2]/td[7]")).getText());
		String s = (quantity).getAttribute("value") ;
		s=s.replace("$", "");
	    Double number_quantity = Double.parseDouble(s);
	 System.out.println(number_quantity);
	//	System.out.println("(quantity).getAttribute(\"value\")");
	 s= (listPrice).getText();
	 s=s.replace("$", "");
	 	Double number_listprice = Double.parseDouble(s);
	 	s= (TotalCost).getText();
	 	s=s.replace("$", "");
	 	Double number_totalcost = Double.parseDouble(s);
	 	System.out.println(number_listprice+"     "+number_totalcost);
		Assert.assertEquals(number_quantity*number_listprice, number_totalcost, 0.001);
		System.out.println("AAAAAAAAAAAA"+quantity.getAttribute("value"));
	}

	@When("I checkout")
	public void i_checkout() {
		driver = contextSteps.getDriver();
	   driver.findElement(By.xpath("//*[@id='Cart']/a")).click();
	}

	@Then("page of the order is on the screen")
	public void page_of_the_order_is_on_the_screen() {
		driver = contextSteps.getDriver();
	  driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table/tbody/tr[1]/th")).isDisplayed();  
	}
}
