package serenity.recherche;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class SearchFor extends UIInteractionSteps{
@Step("he searches for {string}")
public void search (String string) {
	System.out.println("Clear");
	$(SearchForm.SEARCH_FIELD).clear();
	System.out.println("Type");
    $(SearchForm.SEARCH_FIELD).type(string);
    System.out.println("Click");
    $(SearchForm.SEARCH_BUTTON).click();
}
}
