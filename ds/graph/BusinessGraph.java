package ds.graph;

import ds.graph.exceptions.VertexAlreadyExist;
import ds.graph.exceptions.VertexDoesNotExist;

import java.util.*;

/**
 * The business graph class, BusinessGraph, should store the vertices in
 * an ArrayList<Business>, called vertices.
 */
public class BusinessGraph {
    private ArrayList<Business> vertices;

    /**
     * Default constructor
     */
    public BusinessGraph() {
        vertices = new ArrayList<>();
    }

    /**
     * Add a Business in the graph
     *
     * @param bus Business
     * @throws VertexAlreadyExist if the Business already in the graph
     */
    public void addVertex(Business bus) throws VertexAlreadyExist {
        if (vertices.contains(bus)) {
            throw new VertexAlreadyExist("Vertex Already Exist");
        }
        vertices.add(bus);
    }

    /**
     * Remove a Business in the graph
     *
     * @param bus Business
     * @throws VertexDoesNotExist if the Business not in the graph
     */
    public void removeVertex(Business bus) throws VertexDoesNotExist {
        if (!vertices.contains(bus)) {
            throw new VertexDoesNotExist("Vertex Does Not Exist");
        }
        for (Business vertex : vertices) {
            vertex.removeEdge(bus);
        }
        vertices.remove(bus);
    }

    /**
     * This method find the total number of Persons infected
     *
     * @param start starting business
     * @return total number of persons infected
     * @throws VertexDoesNotExist if the starting business not in the graph
     */
    public int totalPersonsInfected(Business start) throws VertexDoesNotExist {
        if (!vertices.contains(start)) {
            throw new VertexDoesNotExist("Vertex Does Not Exist");
        }

        HashSet<Business> visited = new HashSet<>();

        Queue<Business> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Business u = queue.poll();

            for (Person edge : u.getEdges()) {
                Business v = edge.getBusiness();
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }

        return visited.size();
    }

    /**
     * This method find the minimum number of steps required for an infection to reach the
     * destination Business, from the Starting Business.
     *
     * @param start current Business
     * @param dest  destination Business
     * @return minimum number of steps require
     * @throws VertexDoesNotExist if given vertex does not exist
     */
    public int minStepsToDestFromStart(Business start, Business dest) throws VertexDoesNotExist {
        int count = Integer.MAX_VALUE;
        if (vertices.contains(start) && vertices.contains(dest)) {
            HashSet<Business> visited = new HashSet<>();
            HashMap<Business, Integer> level = new HashMap<>();

            Stack<Business> stack = new Stack<>();
            stack.push(start);
            visited.add(start);
            level.put(start, 0);

            while (!stack.isEmpty()) {
                Business u = stack.pop();

                ArrayList<Person> edges = u.getEdges();
                for (int i = edges.size() - 1; i >= 0; i--) {
                    Business v = edges.get(i).getBusiness();
                    if (!visited.contains(v)) {
                        visited.add(v);
                        stack.push(v);
                        level.put(v, level.get(u) + 1);
                    }
                    if (v.equals(dest)) {
                        count = Math.min(count, level.get(u) + 1);
                    }
                }
            }

            return count;

        } else {
            throw new VertexDoesNotExist("Vertex Does Not Exist");
        }
    }

    /**
     * This method determine if the graph node is strongly connected or not
     *
     * @param start node
     * @return true if strongly connected otherwise false
     * @throws VertexDoesNotExist if given vertex does not exist
     */
    public boolean isStronglyConnected(Business start) throws VertexDoesNotExist {
        if (!vertices.contains(start)) {
            throw new VertexDoesNotExist("Vertex Does Not Exist");
        }

        return totalPersonsInfected(start) == vertices.size();
    }
}
