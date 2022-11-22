package ds.graph;

import java.util.ArrayList;
import java.util.Objects;

public class Business {
    private String name;
    private ArrayList<Person> edges;

    public Business(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge(Business dest, Person route) {
        Person current=null;

        for (Person edge : edges) {
            if(edge.getBusiness().equals(dest)){
                current=edge;
            }
        }

        if(current==null){
            route.setBusiness(dest);
            edges.add(route);
        }else{
            if(current.getInfectiveness()<route.getInfectiveness()){
                removeEdge(dest);
                route.setBusiness(dest);
                edges.add(route);
            }
        }
    }

    public void removeEdge(Business dest) {
        edges.removeIf(edge -> edge.getBusiness().equals(dest));
    }

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
