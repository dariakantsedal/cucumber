package org.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.cucumber.java.fr.Alors;
//import io.cucumber.java.fr.Etantdonnéque;
//import io.cucumber.java.fr.Quand;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Etantdonnéque;
import cucumber.api.java.fr.Quand;

public class ConnexionSteps {
	static String login;
	static String password;
	WebDriver driver;
	
	@Etantdonnéque("je suis un utilisateur de Jpetstore")
	public void je_suis_un_utilisateur_de_Jpetstore() {
	   login = "j2ee";
	   password = "j2ee";
	}

	@Quand("je me connecte")
	public void je_me_connecte() {
		//System.setProperty("webdriver.gecko.driver", "src/test/resources/squash/geckodriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//navigation
		driver.get("https://petstore.octoperf.com/");
		driver.findElement(By.xpath("//a[.='Enter the Store']")).click();
		driver.findElement(By.xpath("//a[.='Sign In']")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("username")).sendKeys(login);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("signon")).click();
		
	}

	@Alors("je vois la page welcome")
	public void je_vois_la_page() {
		WebElement welcome = driver.findElement(By.id("WelcomeContent"));
		assertEquals(welcome.getText(),"Welcome ABC!");
		driver.close();
	}
	
}
