package ds.graph;

import java.util.ArrayList;
import java.util.Objects;

public class Person {

	private float socialHygine;
	private int age;
	private String name;
	private ArrayList<Person> contacts;
	private Business business;

	public Person(String name, int age, float socialHygine) {
		this.name=name;
		this.age=age;
		this.socialHygine=socialHygine;
		contacts=new ArrayList<>();
		business=null;
	}

	public Float getInfectiveness(){
		return (float) ((socialHygine*(age/100.00))-(age/100.00));
	}

	public float getSocialHygine() {
		return socialHygine;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Person> getContacts() {
		return contacts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person)) return false;
		Person person = (Person) o;
		return Objects.equals(name, person.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "Person:" +
				name + "," +
				age + "  " +
				"Business: " + (business==null?"[No Business Set]":business)+" "+
				"Contacts: " + contacts.size();
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business bus) {
		this.business = bus;
	}
}
