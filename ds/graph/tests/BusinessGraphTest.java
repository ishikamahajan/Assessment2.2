package ds.graph.tests;

import ds.graph.Business;
import ds.graph.BusinessGraph;
import ds.graph.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessGraphTest {

    BusinessGraph graph;
    Person a1, a2, a3, a4, a5;
    Business n1, n2, n3, n4;

    @BeforeEach
    void setUp() throws Exception {

        graph = new BusinessGraph();

        a1 = new Person("A1", 20, .2f);
        a2 = new Person("A2", 30, .43f);
        a3 = new Person("A3", 40, .13f);
        a4 = new Person("A4", 50, .79f);
        a5 = new Person("A5", 60, .98f);


        n1 = new Business("N1");
        n2 = new Business("N2");
        n3 = new Business("N3");
        n4 = new Business("N4");

        graph.addVertex(n1);
        graph.addVertex(n2);
        graph.addVertex(n3);
        graph.addVertex(n4);

        n1.addEdge(n2, a1);
        n2.addEdge(n3, a2);
        n3.addEdge(n4, a3);
    }

    @Test
    void totalPersonsInfected() throws Exception {
        assertEquals(graph.totalPersonsInfected(n1),4);
    }

    @Test
    void minStepsToDestFromStart() throws Exception {
        n1.addEdge(n4, a4);
        int step = graph.minStepsToDestFromStart(n1, n4);
        assertEquals(step, 1);
    }

    @Test
    void isStronglyConnected() throws Exception {
        boolean result = graph.isStronglyConnected(n1);
        assertTrue(result);
    }
}