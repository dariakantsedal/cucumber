package serenity.recherche;

import java.util.List;
import java.util.stream.Collectors;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class SearchResult extends UIInteractionSteps {
	public List<String> titles() {
		return findAll(SearchResultLists.RESULT_TITLES).stream()
                .map(WebElementFacade::getTextContent)
                .filter(text -> !text.equalsIgnoreCase("Ad"))
                .collect(Collectors.toList());
	}
	public String title()
	{
		
		return find(SearchResultLists.RESULT_TITLES).getText();
		
	}
	
	
}