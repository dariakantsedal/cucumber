package serenity.recherche;

import org.openqa.selenium.By;

public class SearchForm {
	static By SEARCH_FIELD = By.xpath("//*[@id=\"SearchContent\"]/form/input[1]");
	static By SEARCH_BUTTON = By.xpath("//*[@id=\"SearchContent\"]/form/input[2]");
}
