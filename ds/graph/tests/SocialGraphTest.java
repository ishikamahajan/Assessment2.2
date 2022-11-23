package ds.graph.tests;

import static org.junit.jupiter.api.Assertions.*;

import ds.graph.exceptions.PersonDoesNotExist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ds.graph.Person;
import ds.graph.SocialGraph;

import java.util.ArrayList;

class SocialGraphTest {

    SocialGraph sg = new SocialGraph();

    Person a1, a2, a3, a4, a5, b1, b2, b3, b4, b5, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    @BeforeEach
    void setUp() throws Exception {

        // Create Persons to insert into the social graph.
        a1 = new Person("A1", 20, .2f);
        a2 = new Person("A2", 30, .43f);
        a3 = new Person("A3", 40, .13f);
        a4 = new Person("A4", 50, .79f);
        a5 = new Person("A5", 60, .98f);

        sg.addVertex(a1);
        sg.addVertex(a2);
        sg.addVertex(a3);
        sg.addVertex(a4);
        sg.addVertex(a5);

        sg.addEdge(a1, a2);
        sg.addEdge(a1, a3);
        sg.addEdge(a1, a4);

        sg.addEdge(a2, a4);
        sg.addEdge(a2, a5);


        b1 = new Person("B1", 35, .78f);
        b2 = new Person("B2", 55, .86f);
        b3 = new Person("B3", 85, .27f);
        b4 = new Person("B4", 95, .82f);
        b5 = new Person("B5", 5, .01f);

        sg.addVertex(b1);
        sg.addVertex(b2);
        sg.addVertex(b3);
        sg.addVertex(b4);
        sg.addVertex(b5);

        sg.addEdge(b1, b2);
        sg.addEdge(b2, b3);
        sg.addEdge(b3, b4);
        sg.addEdge(b4, b5);

        sg.addEdge(b1, a2);
        sg.addEdge(b5, a3);


        c1 = new Person("C1", 36, .78f);
        c2 = new Person("C2", 37, .78f);
        c3 = new Person("C3", 42, .78f);
        c4 = new Person("C4", 45, .78f);
        c5 = new Person("C5", 21, .78f);
        c6 = new Person("C6", 16, .78f);
        c7 = new Person("C7", 63, .78f);
        c8 = new Person("C8", 92, .78f);
        c9 = new Person("C9", 27, .78f);
        c10 = new Person("C10", 23, .78f);

        sg.addVertex(c1);
        sg.addVertex(c2);
        sg.addVertex(c3);
        sg.addVertex(c4);
        sg.addVertex(c5);
        sg.addVertex(c6);
        sg.addVertex(c7);
        sg.addVertex(c8);
        sg.addVertex(c9);
        sg.addVertex(c10);

        sg.addEdge(a1, c1);
        sg.addEdge(c2, c3);
        sg.addEdge(c4, c5);
        sg.addEdge(c6, c1);

        sg.addEdge(b1, c3);
        sg.addEdge(b4, c4);

        sg.addEdge(a5, c7);
        sg.addEdge(c8, c9);
        sg.addEdge(b3, c10);
        sg.addEdge(c10, c8);

        sg.addEdge(c8, c1);
    }

    /**
     * searchBFSTest1: Check searchBFS method work the way it should work.
     * For the undirected graph which is initiated in setUp, I run searchBFS for a1 to b2 and get the path.
     * Then compare it with the actual path, here I get the actual path using pen and paper which is [A2, B1, B2].
     */
    @Test
    void searchBFSTest1() throws Exception {
        ArrayList<Person> list = sg.searchBFS(a1, b2);
        ArrayList<String> path = new ArrayList<>();
        for (Person person : list) {
            path.add(person.getName());
        }
        assertEquals(path.toString(), "[A2, B1, B2]");
    }

    /**
     * searchBFSTest2: Check searchBFS method throws PersonDoesNotExist when it should be.
     * For the undirected graph which is initiated in setUp, I run searchBFS for two new person c98 and c99, which doesn't exist in the graph,
     * for that this method must throw PersonDoesNotExist exception.
     */
    @Test
    void searchBFSTest2() {
        assertThrows(PersonDoesNotExist.class, () -> {
            Person c98 = new Person("C98", 23, .78f);
            Person c99 = new Person("C99", 23, .78f);
            ArrayList<Person> list = sg.searchBFS(c98, c99);
        });
    }


    /**
     * searchDFSTest1: Check searchDFS method work the way it should work.
     * For the undirected graph which is initiated in setUp, I run searchDFS for a1 to c8 and get the path.
     * Then compare it with the actual path, here I get the actual path using pen and paper which is [A2, B1, B2, B3, C10, C8].
     */
    @Test
    void searchDFSTest1() throws Exception {
        ArrayList<Person> list = sg.searchDFS(a1, c8);
        ArrayList<String> path = new ArrayList<>();
        for (Person person : list) {
            path.add(person.getName());
        }
        assertEquals(path.toString(), "[A2, B1, B2, B3, C10, C8]");
    }


    /**
     * searchDFSTest2: Check searchDFS method throws PersonDoesNotExist when it should be.
     * For the undirected graph which is initiated in setUp, I run searchDFS for two new person c98 and c99, which doesn't exist in the graph,
     * for that this method must throw PersonDoesNotExist exception.
     */
    @Test
    void searchDFSTest2() {
        assertThrows(PersonDoesNotExist.class, () -> {
            Person c98 = new Person("C98", 23, .78f);
            Person c99 = new Person("C99", 23, .78f);
            ArrayList<Person> list = sg.searchDFS(c98, c99);
        });
    }


    /**
     * searchWeightedBFSTest1: Check searchWeightedBFS method work the way it should work.
     * For the undirected graph which is initiated in setUp, I run searchWeightedBFS for a1 to c8 and get the path.
     * Then compare it with the actual path, here I get the actual path using pen and paper which is [A2, B1, B2, B3, B4].
     */
    @Test
    void searchWeightedBFSTest1() throws Exception {
        ArrayList<Person> list = sg.searchWeightedBFS(a1, b4);
        ArrayList<String> path = new ArrayList<>();
        for (Person person : list) {
            path.add(person.getName());
        }
        assertEquals(path.toString(), "[A2, B1, B2, B3, B4]");
    }

    /**
     * searchWeightedBFSTest2: Check searchWeightedBFS method throws PersonDoesNotExist when it should be.
     * For the undirected graph which is initiated in setUp, I run searchWeightedBFS for two new person c98 and c99, which doesn't exist in the graph,
     * for that this method must throw PersonDoesNotExist exception.
     */
    @Test
    void searchWeightedBFSTest2() {
        assertThrows(PersonDoesNotExist.class, () -> {
            Person c98 = new Person("C98", 23, .78f);
            Person c99 = new Person("C99", 23, .78f);
            ArrayList<Person> list = sg.searchWeightedBFS(c98, c99);
        });
    }


    /**
     * searchWeightedDFSTest1: Check searchWeightedDFS method work the way it should work.
     * For the undirected graph which is initiated in setUp, I run searchWeightedDFS for a1 to c8 and get the path.
     * Then compare it with the actual path, here I get the actual path using pen and paper which is [C1, C8, C10, B3, B4].
     */
    @Test
    void searchWeightedDFSTest1() throws Exception {
        ArrayList<Person> list = sg.searchWeightedDFS(a1, b4);
        ArrayList<String> path = new ArrayList<>();
        for (Person person : list) {
            path.add(person.getName());
        }
        assertEquals(path.toString(), "[C1, C8, C10, B3, B4]");
    }


    /**
     * searchWeightedDFSTest2: Check searchWeightedDFS method throws PersonDoesNotExist when it should be.
     * For the undirected graph which is initiated in setUp, I run searchWeightedDFS for two new person c98 and c99, which doesn't exist in the graph,
     * for that this method must throw PersonDoesNotExist exception.
     */
    @Test
    void searchWeightedDFSTest2() {
        assertThrows(PersonDoesNotExist.class, () -> {
            Person c98 = new Person("C98", 23, .78f);
            Person c99 = new Person("C99", 23, .78f);
            ArrayList<Person> list = sg.searchWeightedDFS(c98, c99);
        });
    }


    /**
     * countContactsTest1: Check countContacts method work the way it should work.
     * For the undirected graph which is initiated in setUp, I run countContacts for a1 and
     * compare it with the actual path, here I get the actual path using pen and paper which is 7.
     */
    @Test
    void countContactsTest1() throws Exception {
        assertEquals(sg.countContacts(a1), 7);
    }


    /**
     * countContactsTest2: Check countContacts method throws PersonDoesNotExist when it should be.
     * For the undirected graph which is initiated in setUp, I run countContacts for new person c99, which doesn't exist in the graph,
     * for that this method must throw PersonDoesNotExist exception.
     */
    @Test
    void countContactsTest2() {
        assertThrows(PersonDoesNotExist.class, () -> {
            Person c99 = new Person("C99", 23, .78f);
            sg.countContacts(c99);
        });
    }

}
