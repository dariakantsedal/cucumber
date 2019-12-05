package org.cucumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import bdd.Person;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class EntrepotSteps {
	int quantity;
	List<Person> entreprise;
	int id_new_person = 4;

	@Given("^Lentrepot contient (?:.*) Personnes")
	public void lentrepot_contient_N_Personnes() {
		Person one = new Person(1);
		Person two = new Person(2);
		Person three = new Person(3);
		entreprise = new ArrayList<Person>();
		entreprise.add(one);
		entreprise.add(two);
		entreprise.add(three);
		quantity = entreprise.size();

	}

	@When("Je cree une Personne")
	public void je_cree_une_Personne() {
		Person four = new Person(id_new_person);
		entreprise.add(four);
	}

	@Then("Jobtiens lID de la Personne creee et lentrepot contient plus de N Personnes")
	public void jobtiens_lID_de_la_Personne_creee_et_lentrepot_contient_plus_de_N_Personnes() {
		Assert.assertEquals(id_new_person, entreprise.get(entreprise.size() - 1).id);
		Assert.assertEquals(quantity, entreprise.size() - 1);
	}

	@Given("Lentrepot contient la Personnes Anakin Skywalker")
	public void lentrepot_contient_la_Personnes_Anakin_Skywalker() {
		entreprise = new ArrayList<Person>();
		Person anakin = new Person("Anakin", "Skywalker");
		entreprise.add(anakin);
		quantity = entreprise.size();
	}

	@When("Je supprime la Personne {int}")
	public void je_supprime_la_Personne(Integer int1) {
		entreprise.remove(int1 - 1);
	}

	@Then("Lentrepôt contient moins de N Personnes")
	public void lentrepôt_contient_moins_de_N_Personnes() {
		Assert.assertEquals(quantity - 1, entreprise.size());
	}

	@When("Je recupere la Personne {int}")
	public void je_recupere_la_Personne(Integer int1) {

		int index;
		System.out.println("INDEX ID : " + int1);
		switch (int1) {
		case 1: {
			for (Person person : entreprise) {
				if (person.id == 1) {
					index = entreprise.indexOf(person);
					entreprise.get(index).age = "41.9 BBY";
					entreprise.get(index).name = "Anakin";
					entreprise.get(index).surname = "Skywalker";
					System.out.println("@WHEN je rajoutr anakin, index: " + index);
				}
			}
		}

		case 2: {
			for (Person person : entreprise) {
				if (person.id == 2) {

					index = entreprise.indexOf(person);
					entreprise.get(index).age = "19 BBY";
					entreprise.get(index).name = "Luke";
					entreprise.get(index).surname = "Skywalker";
					System.out.println("@WHEN je rajoutr luke, index: " + index);
				}
			}
		}
		case 3: {
			for (Person person : entreprise) {
				if (person.id == 3) {
					index = entreprise.indexOf(person);
					entreprise.get(index).age = "19 BBY";
					entreprise.get(index).name = "Leia";
					entreprise.get(index).surname = "Organa Solo";
					System.out.println("@WHEN je rajoutr Leia, index: " + index);
				}
			}
		}
		}

	}

	@Then("Jobtiens la Personne didentifiant {int} contenant les donnees {}, {}, {}")
	public void jobtiens_la_Personne_didentifiant_contenant_les_donnees(Integer id, String name, String surname,
			String age) {
		for (Person person : entreprise) {
			if (id == person.id) {
				Assert.assertEquals(age, person.age);
				Assert.assertEquals(name, person.name);
				Assert.assertEquals(surname, person.surname);

			}
		}
	}

	@Given("Lentrepot contient les Personnes suivantes")
	public void lentrepot_contient_les_Personnes_suivantes(DataTable dt) {
		// System.out.println(list.height());
		// System.out.println(list.toString());
		// entreprise.add(new Person(list.cell(0, column)))
		entreprise = new ArrayList<Person>();
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("id"));
			System.out.println(list.get(i).get("name"));
			System.out.println(list.get(i).get("surname"));
			System.out.println(list.get(i).get("age"));

			Person person = new Person(Integer.parseInt(list.get(i).get("id")), list.get(i).get("name"),
					list.get(i).get("surname"), list.get(i).get("age"));

			entreprise.add(person);
		}
	}

	@When("Je modifie la Personne {int} avec {}")
	public void je_modifie_la_Personne_avec_Organa_Solo_Skywalker(Integer id, String surname) {
		for (Person person : entreprise) {
			if (person.id == id) {
				person.surname = surname;

			}
		}
	}

}
