package serenity;

import static org.assertj.core.api.Assertions.assertThat;

//import javax.naming.directory.SearchResult;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.navigation.NavigateTo;
import serenity.recherche.SearchFor;
import serenity.recherche.SearchResult;


public class RechercheSteps {
	
	@Steps
	NavigateTo navigateTo;
	@Steps
	SearchFor searchFor;
	@Steps
	SearchResult searchResult;
	
	
	@Given("Not logged in user is on the home page")
	
	public void not_logged_in_user_is_on_the_home_page() {
	    navigateTo.homePage();
	}

	@When("he searches for {string}")
	public void he_searches_for(String string) {
	    searchFor.search(string);
	}

	@Then("result page contains the word {string}")
	public void result_page_contains_the_word(String string) {
		assertThat(searchResult.title())
       .containsIgnoringCase(string);
	}


}
