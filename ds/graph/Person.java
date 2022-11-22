package ds.graph;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The Person class represents one individual within the Social Graph.
 * It holds a name, a float representing the individuals social hygiene
 * value (a percentage, stored as a number between 0 and 1).
 */
public class Person {

    private float socialHygine;
    private int age;
    private String name;
    private ArrayList<Person> contacts;
    private Business business;

    /**
     * Constructor to make a person object using name, age and socialHygine
     *
     * @param name         name of the person
     * @param age          age of the person
     * @param socialHygine socialHygine of the person
     */
    public Person(String name, int age, float socialHygine) {
        this.name = name;
        this.age = age;
        this.socialHygine = socialHygine;
        contacts = new ArrayList<>();
        business = null;
    }

    /**
     * Calculate the person's infectiveness
     *
     * @return person's infectiveness
     */
    public Float getInfectiveness() {
        return (float) ((socialHygine * (age / 100.00)) - (age / 100.00));
    }

    /**
     * Getter for socialHygine
     *
     * @return socialHygine
     */
    public float getSocialHygine() {
        return socialHygine;
    }

    /**
     * Getter for age
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for contacts
     *
     * @return list of contacts
     */
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    /**
     * Getter method for business
     *
     * @return business
     */
    public Business getBusiness() {
        return business;
    }

    /**
     * Setter method for business
     *
     * @param bus business
     */
    public void setBusiness(Business bus) {
        this.business = bus;
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
                "Business: " + (business == null ? "[No Business Set]" : business) + " " +
                "Contacts: " + contacts.size();
    }
}
