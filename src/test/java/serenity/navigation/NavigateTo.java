package serenity.navigation;

import net.thucydides.core.annotations.Step;

public class NavigateTo {
Homepage homepage;
@Step("Not logged in user is on the home page")
public void homePage() {
	System.out.println("Try to open");
	homepage.open();
	System.out.println("opened");
}
}
