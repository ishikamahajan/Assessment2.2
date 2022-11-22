package ds.graph;

import java.util.ArrayList;

public class SocialGraph {
	
	public SocialGraph() {
		
	}
	
	/**
	 * Add the given person to the graph. The person needs to be added to the list of vertices.
	 * 
	 * @param p
	 * @throws PersonAlreadyExists If the person is already present in the graph, 
	 *  		this method should throw a PersonAlreadyPresent exception. 
	 */
	public void addVertex(Person p) {
		
	}
	
	
	/**
	 * Remove the given Person from the graph. Any edges to this person should also be removed. 
	 * 
	 * @throws PersonDoesNotExist If the given person is not found inside the graph. 
	 * @param p
	 */
	public void removeVertex(Person p) {
		
	}
	
	/**
	 * Add an edge between the two people (vertices) in the graph. The graph is undirected, so 
	 * both People will need to list the other, in their list of contacts. 
	 * 
	 * If the edge already exists, this method should return true. 
	 *
	 * @param a
	 * @param b
	 * 
	 * @throws PersonDoesNotExist	If the person is not found within the graph. 
	 */
	public void addEdge(Person a, Person b) {
		
	}
	
	/**
	 * Remove the edge between the given People from the graph. 
	 * If no edge existed between these people, this method should throw an EdgeDoesNotExist exception. 
	 * 
	 * @throws EdgeDoesNotExist
	 * @param a
	 * @param b
	 */
	public void removeEdge(Person a, Person b) {
		
	}
	
	/**
	 * Implement a breadth-first search, from Person start to target. 
	 * This method should consider the graph unweighted: the order that the Persons are stored inside the contacts list will
	 * determine the order that the BFS operates. 
	 * 
	 * @throws PersonDoesNotExist if either start or target are not in the graph. 
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchBFS(Person start, Person target) {
		return null;
	}
	
	/**
	 * Implement a breadth-first search, from Person start to target.
	 * The weights associated with each edge should determine the order that the BFS operates. 
	 * Higher weights are preferred over lower weights. The weight is found by calling getInfectiveness() on the Person. 
	 * 
	 * @throws PersonDoesNotExist if either start or target are not in the graph. 
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchWeightedBFS(Person start, Person target) {
		return null;
	}
	
		
	/**
	 * Implement a depth-first search, from Person start to target.  
	 * This method should consider the graph unweighted: the order that the Persons are stored inside the contacts list will
	 * determine the order that the DFS operates. 
 	 * @throws PersonDoesNotExist if either start or target are not in the graph. 	
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchDFS(Person start, Person target) {
		return null;
	}
	
	/**
	 * Implement a depth-first search, from Person start to target.  
	 * The weights associated with each edge should determine the order that the DFS operates. 
	 * Higher weights are preferred over lower weights. The weight is found by calling getInfectiveness() on the Person. 
	 * 
 	 * @throws PersonDoesNotExist if either start or target are not in the graph. 	
	 * @param start
	 * @param target
	 * @return A list of nodes that must be traversed to get to target, from start. 
	 */
	public ArrayList<Person> searchWeightedDFS(Person start, Person target) {
		return null;
	}
	
	/**
	 * This method should return an int value showing the total number of contacts-of-contacts of the start person. 
	 * This is the equivalent to doing a BFS around the start person, and 
	 * counting the vertices 2 steps away from the start node.  
	 * 
	 * @throws PersonDoesNotExist if either start or target are not in the graph. 	
	 * @param start
	 * @return
	 */
	public int countContacts(Person start) {
		return 0;
	}
}
