package org.cucumber;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Etantdonnéque;
import cucumber.api.java.fr.Quand;

public class AnnotationSteps {
	@Etantdonnéque("je suis un utilisateur de Jpetstore")
	public void je_suis_un_utilisateur_de_Jpetstore() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Etantdonnéque("je me connecte sur")
	public void je_me_connecte_sur() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Quand("je me connecte")
	public void je_me_connecte() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Alors("je vois la page {string}")
	public void je_vois_la_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
}