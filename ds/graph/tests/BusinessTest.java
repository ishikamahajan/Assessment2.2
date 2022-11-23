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
    void setUp() {

        a1 = new Person("A1", 20, .2f);
        a2 = new Person("A2", 30, .43f);
        a3 = new Person("A3", 40, .13f);
        a4 = new Person("A4", 50, .79f);


        n1 = new Business("N1");
        n2 = new Business("N2");
        n3 = new Business("N3");
        n4 = new Business("N4");

    }

    /**
     * getEdgesTest: Here I test that getEdges method work perfectly. I created a business object
     * and add an edge to it after that I get the edge list using business.getEdges() then check the edge list size, and it must be 1.
     */
    @Test
    void getEdgesTest() {
        Business business=new Business("A");
        business.addEdge(n1,a1);
        ArrayList<Person> edges=business.getEdges();
        assertEquals(edges.size(),1);
    }


    /**
     * addEdgeTest1: Test that addEdge method add edge considering infectiveness. That is, when adding an edge to the Business, this method should check if there is already an edge to that destination.
     *   If there is, the highest weighted edge is used – the original edge is replaced if the new edge’s weight is greater than the originals.
     */
    @Test
    void addEdgeTest1() {
        Business business=new Business("B");
        business.addEdge(n1,a1);
        business.addEdge(n1,a2);
        business.addEdge(n1,a3);
        business.addEdge(n1,a4);

        ArrayList<Person> edges=business.getEdges();
        assertEquals(edges.size(),1);

    }

    /**
     * addEdgeTest2: Check addEdge method more thoroughly.
     * It checks the addEdgeTest1 condition is okay by adding edges to two different nodes.
     */
    @Test
    void addEdgeTest2() {
        Business business=new Business("B");
        business.addEdge(n1,a1);
        business.addEdge(n1,a2);
        business.addEdge(n1,a3);
        business.addEdge(n1,a4);

        business.addEdge(n2,a1);
        business.addEdge(n2,a2);
        business.addEdge(n2,a3);
        business.addEdge(n2,a4);

        ArrayList<Person> edges=business.getEdges();
        assertEquals(edges.size(),2);

    }

    /**
     * toStringTest: Test the toString work perfectly and return actual value, here n1.toString() should return
     * a string with perfect format:
     *
     * N1
     */
    @Test
    void toStringTest() {
        assertEquals(n1.toString(),"N1");
    }

    /**
     * removeEdgeTest: Test the removeEdgeTest work perfectly. Here first I added some edge and
     * then remove all the added edge, so there should be no edge after it.
     */
    @Test
    void removeEdgeTest() {

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


    /**
     * equalsTest1: Test the equals() work perfectly. Two business object with the same name must be equal.
     */
    @Test
    void equalTest1() {
        assertEquals(n1,n1);
    }

    /**
     * equalsTest2: Test the equals() work perfectly. Two business object with different names must not be equal.
     */
    @Test
    void equalTest2() {
        assertNotEquals(n1,n2);
    }

}