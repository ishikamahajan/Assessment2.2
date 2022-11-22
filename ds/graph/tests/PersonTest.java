package ds.graph.tests;

import static org.junit.jupiter.api.Assertions.*;

import ds.graph.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

	private Person person1;
	private Person person2;

	@BeforeEach
	void setUp() throws Exception {
		person1=new Person("Jhon",24,0.60f);
		person2=new Person("Jhon",24,0.60f);
	}

	@Test
	void test() {
		assertEquals(person1,person2);

		float infectiveness= (float) ((person1.getSocialHygine()*(person1.getAge()/100.00))-(person1.getAge()/100.00));

		assertEquals(person1.getInfectiveness(),infectiveness);

		assertEquals(person1.toString(),"Person:Jhon,24  Business: [No Business Set] Contacts: 0");
	}

}
