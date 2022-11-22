package ds.graph.tests;

import ds.graph.Business;
import ds.graph.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BusinessTest {

    Person a1, a2, a3, a4;
    Business n1, n2, n3, n4;

    @BeforeEach
    void setUp() throws Exception {

        a1 = new Person("A1", 20, .2f);
        a2 = new Person("A2", 30, .43f);
        a3 = new Person("A3", 40, .13f);
        a4 = new Person("A4", 50, .79f);


        n1 = new Business("N1");
        n2 = new Business("N2");
        n3 = new Business("N3");
        n4 = new Business("N4");

    }

    @Test
    void getEdges() {
        Business business=new Business("A");
        business.addEdge(n1,a1);
        ArrayList<Person> edges=business.getEdges();
        assertEquals(edges.size(),1);
    }

    @Test
    void addEdge() {
        Business business=new Business("B");
        business.addEdge(n1,a1);
        business.addEdge(n1,a2);
        business.addEdge(n1,a3);
        business.addEdge(n1,a4);

        ArrayList<Person> edges=business.getEdges();
        assertEquals(edges.size(),1);

    }

    @Test
    void removeEdge() {

        Business business=new Business("C");
        business.addEdge(n1,a1);
        business.addEdge(n2,a2);
        business.addEdge(n3,a3);
        business.addEdge(n4,a4);

        business.removeEdge(n1);
        business.removeEdge(n2);
        business.removeEdge(n3);
        business.removeEdge(n4);

        ArrayList<Person> edges=business.getEdges();
        assertEquals(edges.size(),0);
    }
}