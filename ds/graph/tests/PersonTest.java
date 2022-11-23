package ds.graph.tests;

import static org.junit.jupiter.api.Assertions.*;

import ds.graph.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

	private Person person1;
	private Person person2;

	@BeforeEach
	void setUp() {
		person1=new Person("Jhon",24,0.60f);
		person2=new Person("Jhon",24,0.60f);
	}

	/**
	 * infectivenessTest: Test the infectiveness of person1 by comparing person1.getInfectiveness() value
	 * wth manually calculated value.
	 */
	@Test
	void infectivenessTest(){
		float infectiveness= (float) ((person1.getSocialHygine()*(person1.getAge()/100.00))-(person1.getAge()/100.00));
		assertEquals(person1.getInfectiveness(),infectiveness);
	}


	/**
	 * getAgeTest: Test the getAge work perfectly and return actual value, here person1.getAge() should return 24 as
	 * person1 initiated with 24 age value.
	 */
	@Test
	void getAgeTest() {
		assertEquals(person1.getAge(),24);
	}


	/**
	 * getNameTest: Test the getName work perfectly and return actual value, here person1.getName() should return 'Jhon' as
	 * person1 initiated with 'Jhon' name value.
	 */
	@Test
	void getNameTest() {
		assertEquals(person1.getName(),"Jhon");
	}

	/**
	 * toStringTest: Test the toString work perfectly and return actual value, here person1.toString() should return
	 * a string with perfect format:
	 *
	 * Person:Jhon,24  Business: [No Business Set] Contacts: 0
	 */
	@Test
	void toStringTest() {
		assertEquals(person1.toString(),"Person:Jhon,24  Business: [No Business Set] Contacts: 0");
	}


	/**
	 * equalsTest: Test the equals() work perfectly. Two person's object with the same name must be equal.
	 */
	@Test
	void equalsTest(){
		assertEquals(person1,person2);
	}


	/**
	 * getBusinessTest: Test the getBusiness work perfectly and return actual value, here person1.getName() should return null as
	 * 	 person1 initiated with no business value yet.
	 */
	@Test
	void getBusinessTest(){
		assertNull(person1.getBusiness());
	}


}
