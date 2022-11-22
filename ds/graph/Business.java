package ds.graph;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The Business class will represent a vertex in the Business graph.
 * Each Business has a name and a list of edges, stored as an ArrayList<Person>, called edges.
 */
public class Business {
    private String name;
    private ArrayList<Person> edges;

    /**
     * Constructor to create a Business object using giving a name
     *
     * @param name Business name
     */
    public Business(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    /**
     * This method will create an edge from one Business to another, via a Person.
     * The person's infectiveness value is the weight for the edge.
     * The Person will be stored in the starting Business’ edges list.
     * The destination vertex does not store the edge.
     * <p>
     * When adding an edge to the Business, this method should check if there is already an edge to that destination.
     * If there is, the highest weighted edge is used – the original edge is replaced if the new edge’s weight is greater than the originals.
     *
     * @param dest  destination vertex
     * @param route via Person
     */
    public void addEdge(Business dest, Person route) {
        Person current = null;

        for (Person edge : edges) {
            if (edge.getBusiness().equals(dest)) {
                current = edge;
            }
        }

        if (current == null) {
            route.setBusiness(dest);
            edges.add(route);
        } else {
            if (current.getInfectiveness() < route.getInfectiveness()) {
                removeEdge(dest);
                route.setBusiness(dest);
                edges.add(route);
            }
        }
    }

    /**
     * This method remove an edge with specified destination
     *
     * @param dest specified destination
     */
    public void removeEdge(Business dest) {
        edges.removeIf(edge -> edge.getBusiness().equals(dest));
    }

    /**
     * Getter method for all edges
     *
     * @return list of edges
     */
    public ArrayList<Person> getEdges() {
        return edges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Business)) return false;
        Business business = (Business) o;
        return Objects.equals(name, business.name) && Objects.equals(edges, business.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
