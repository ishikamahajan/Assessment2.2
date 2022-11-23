package ds.graph.tests;

import ds.graph.Business;
import ds.graph.BusinessGraph;
import ds.graph.Person;
import ds.graph.exceptions.VertexDoesNotExist;
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

    /**
     * removeVertex1: Test removeVertex method. If n3 vertex is removed successfully then total 2 persons is infected.
     */
    @Test
    void removeVertex1() throws Exception {
        graph.removeVertex(n3);
        assertEquals(graph.totalPersonsInfected(n1), 2);
    }

    /**
     * removeVertex2: Test removeVertex method. In the initiated graph in setUp,
     * there is no n99 node added, so calling removeVertex(n99) must throw an exception.
     */
    @Test
    void removeVertex2() {
        assertThrows(VertexDoesNotExist.class, () -> {
            Business n99 = new Business("N99");
            graph.removeVertex(n99);
        });
    }

    /**
     * addVertex: Test addVertex method. In the initiated graph in setUp,
     * I added a node n5 that has an edge from n5 to n1 , If vertex is added successfully then minStepsToDestFromStart(n5, n1) must return 1.
     */
    @Test
    void addVertex() throws Exception {
        Business n5 = new Business("N5");
        n5.addEdge(n1, a5);
        graph.addVertex(n5);
        assertEquals(graph.minStepsToDestFromStart(n5, n1), 1);
    }

    /**
     * totalPersonsInfected1: Test totalPersonsInfected method. In the initiated graph in setUp,
     * I compare graph.totalPersonsInfected(n1) with actual value 4 which I get using pen and paper.
     */
    @Test
    void totalPersonsInfected1() throws Exception {
        assertEquals(graph.totalPersonsInfected(n1), 4);
    }

    /**
     * totalPersonsInfected2: Test totalPersonsInfected method. In the initiated graph in setUp,
     * After removing node n4, I compare graph.totalPersonsInfected(n1) with actual value 3 which I get using pen and paper.
     */
    @Test
    void totalPersonsInfected2() throws Exception {
        graph.removeVertex(n4);
        assertEquals(graph.totalPersonsInfected(n1), 3);
    }

    /**
     * minStepsToDestFromStart1: Test minStepsToDestFromStart method. In the initiated graph in setUp,
     * using pen and paper we can get minimum distance for n1 to n4 is 3. I compare it with minStepsToDestFromStart(n1, n4)
     */
    @Test
    void minStepsToDestFromStart1() throws Exception {
        int step = graph.minStepsToDestFromStart(n1, n4);
        assertEquals(step, 3);
    }

    /**
     * minStepsToDestFromStart2: Test minStepsToDestFromStart method. In the initiated graph in setUp,
     * After adding an edge between n1 to n4,
     * using pen and paper we can get minimum distance for n1 to n4 is 1. I compare it with minStepsToDestFromStart(n1, n4)
     */
    @Test
    void minStepsToDestFromStart2() throws Exception {
        n1.addEdge(n4, a4);
        int step = graph.minStepsToDestFromStart(n1, n4);
        assertEquals(step, 1);
    }

    /**
     * minStepsToDestFromStart3: Test minStepsToDestFromStart method. In the initiated graph in setUp,
     * There is no vertex n99, calling minStepsToDestFromStart(n1, n99) must throw an exception.
     */
    @Test
    void minStepsToDestFromStart3() {
        assertThrows(VertexDoesNotExist.class, () -> {
            Business n99 = new Business("N99");
            int step = graph.minStepsToDestFromStart(n1, n99);
            assertEquals(step, 1);
        });
    }

    /**
     * isStronglyConnected1: Test isStronglyConnected method work perfectly.
     * For the initiated graph in setUp we can go any other node from n1 node. So the node is Strongly Connected.
     */
    @Test
    void isStronglyConnected1() throws Exception {
        boolean result = graph.isStronglyConnected(n1);
        assertTrue(result);
    }

    /**
     * isStronglyConnected2: Test isStronglyConnected method work perfectly.
     * For the initiated graph in setUp we cannot go all other nodes from n2 node. So the node is not Strongly Connected.
     */
    @Test
    void isStronglyConnected2() throws Exception {
        boolean result = graph.isStronglyConnected(n2);
        assertFalse(result);
    }

    /**
     * isStronglyConnected3: Test isStronglyConnected method work perfectly.
     * For the initiated graph in setUp we cannot go all other nodes from n3 node. So the node is not Strongly Connected.
     */
    @Test
    void isStronglyConnected3() throws Exception {
        boolean result = graph.isStronglyConnected(n3);
        assertFalse(result);
    }

    /**
     * isStronglyConnected4: Test isStronglyConnected method work perfectly.
     * The initiated graph in setUp doesn't have a node N99, so if we call graph.isStronglyConnected(n99) then there must be an exception.
     */
    @Test
    void isStronglyConnected4() {
        assertThrows(VertexDoesNotExist.class, () -> {
            Business n99 = new Business("N99");
            boolean result = graph.isStronglyConnected(n99);
        });
    }
}