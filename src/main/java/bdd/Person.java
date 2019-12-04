package bdd;

public class Person {
	public int id;
	public String name;
	public String surname;
	public String age;

	public Person(int id, String name, String surname, String age) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public Person(int id) {

		this.id = id;
	}

	public Person() {

	}
	public Person( String name, String surname) {

		
		this.name = name;
		this.surname = surname;
		
	}

}
