package ds.graph;

import ds.graph.exceptions.EdgeDoesNotExist;
import ds.graph.exceptions.PersonAlreadyExists;
import ds.graph.exceptions.PersonDoesNotExist;

import java.util.*;

public class SocialGraph {

	private ArrayList<Person> vertices;
	
	public SocialGraph() {
		vertices=new ArrayList<>();
	}
	
	/**
	 * Add the given person to the graph. The person needs to be added to the list of vertices.
	 * 
	 * @param p
	 * @throws PersonAlreadyExists If the person is already present in the graph,
	 *  		this method should throw a PersonAlreadyPresent exception. 
	 */
	public void addVertex(Person p) throws PersonAlreadyExists {
		if(vertices.contains(p)){
			throw new PersonAlreadyExists("Person Already Exists");
		}
		vertices.add(p);
	}
	
	
	/**
	 * Remove the given Person from the graph. Any edges to this person should also be removed. 
	 * 
	 * @throws PersonDoesNotExist If the given person is not found inside the graph.
	 * @param p
	 */
	public void removeVertex(Person p) throws PersonDoesNotExist {
		if(!vertices.contains(p)){
			throw new PersonDoesNotExist("Person Does Not Exist");
		}

		for (Person contact : p.getContacts()) {
			contact.getContacts().remove(p);
		}

		vertices.remove(p);
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
	 * @throws PersonDoesNotExist If the person is not found within the graph.
	 */
	public void addEdge(Person a, Person b) throws PersonDoesNotExist {
		if(vertices.contains(a) && vertices.contains(b)){
			a.getContacts().add(b);
			b.getContacts().add(a);
		}else{
			throw new PersonDoesNotExist("Person Does Not Exist");
		}
	}
	
	/**
	 * Remove the edge between the given People from the graph. 
	 * If no edge existed between these people, this method should throw an EdgeDoesNotExist exception. 
	 * 
	 * @throws EdgeDoesNotExist
	 * @param a
	 * @param b
	 */
	public void removeEdge(Person a, Person b) throws EdgeDoesNotExist {
		if(a.getContacts().contains(b) && b.getContacts().contains(a)){
			a.getContacts().remove(b);
			b.getContacts().remove(a);
		}else{
			throw new EdgeDoesNotExist("Edge Does Not Exist");
		}
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
	public ArrayList<Person> searchBFS(Person start, Person target) throws PersonDoesNotExist {
		if(vertices.contains(start) && vertices.contains(target)){
			HashSet<Person> visited=new HashSet<>();
			HashMap<Person,Person> parent=new HashMap<>();

			Queue<Person> queue=new LinkedList<>();
			queue.add(start);
			visited.add(start);
			parent.put(start,start);

			while (!queue.isEmpty()){
				Person u= queue.poll();

				if(u.equals(target)){
					ArrayList<Person> path=new ArrayList<>();
					while (!u.equals(start)){
						path.add(u);
						u=parent.get(u);
					}
					Collections.reverse(path);
					return path;
				}

				for (Person contact : u.getContacts()) {
					if(!visited.contains(contact)){
						visited.add(contact);
						queue.add(contact);
						parent.put(contact,u);
					}
				}
			}

			return null;

		}else{
			throw new PersonDoesNotExist("Person Does Not Exist");
		}
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
	public ArrayList<Person> searchWeightedBFS(Person start, Person target) throws PersonDoesNotExist {
		if(vertices.contains(start) && vertices.contains(target)){
			HashSet<Person> visited=new HashSet<>();
			HashMap<Person,Person> parent=new HashMap<>();

			PriorityQueue<Person> queue=new PriorityQueue<>(Comparator.comparing(Person::getInfectiveness));
			queue.add(start);
			visited.add(start);
			parent.put(start,start);

			while (!queue.isEmpty()){
				Person u= queue.poll();

				if(u.equals(target)){
					ArrayList<Person> path=new ArrayList<>();
					while (!u.equals(start)){
						path.add(u);
						u=parent.get(u);
					}
					Collections.reverse(path);
					return path;
				}

				for (Person contact : u.getContacts()) {
					if(!visited.contains(contact)){
						visited.add(contact);
						queue.add(contact);
						parent.put(contact,u);
					}
				}
			}

			return null;

		}else{
			throw new PersonDoesNotExist("Person Does Not Exist");
		}
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
	public ArrayList<Person> searchDFS(Person start, Person target) throws PersonDoesNotExist {
		if(vertices.contains(start) && vertices.contains(target)){
			HashSet<Person> visited=new HashSet<>();
			HashMap<Person,Person> parent=new HashMap<>();

			Stack<Person> stack=new Stack<>();
			stack.push(start);
			visited.add(start);
			parent.put(start,start);

			while (!stack.isEmpty()){
				Person u= stack.pop();

				if(u.equals(target)){
					ArrayList<Person> path=new ArrayList<>();
					while (!u.equals(start)){
						path.add(u);
						u=parent.get(u);
					}
					Collections.reverse(path);
					return path;
				}


				ArrayList<Person> contacts = u.getContacts();
				for (int i = contacts.size()-1; i >= 0; i--) {
					Person contact = contacts.get(i);
					if (!visited.contains(contact)) {
						visited.add(contact);
						stack.push(contact);
						parent.put(contact, u);
					}
				}
			}

			return null;

		}else{
			throw new PersonDoesNotExist("Person Does Not Exist");
		}
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
	public ArrayList<Person> searchWeightedDFS(Person start, Person target) throws PersonDoesNotExist {
		if(vertices.contains(start) && vertices.contains(target)){
			HashSet<Person> visited=new HashSet<>();
			HashMap<Person,Person> parent=new HashMap<>();

			Stack<Person> stack=new Stack<>();
			stack.push(start);
			visited.add(start);
			parent.put(start,start);

			while (!stack.isEmpty()){
				Person u= stack.pop();

				if(u.equals(target)){
					ArrayList<Person> path=new ArrayList<>();
					while (!u.equals(start)){
						path.add(u);
						u=parent.get(u);
					}

					Collections.reverse(path);
					return path;
				}

				u.getContacts().sort(Comparator.comparing(Person::getInfectiveness));

				for (Person contact : u.getContacts()) {
					if(!visited.contains(contact)){
						visited.add(contact);
						stack.push(contact);
						parent.put(contact,u);
					}
				}
			}

			return null;

		}else{
			throw new PersonDoesNotExist("Person Does Not Exist");
		}
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
	public int countContacts(Person start) throws PersonDoesNotExist {
		if(!vertices.contains(start)){
			throw new PersonDoesNotExist("Person Does Not Exist");
		}

		HashSet<Person> people=new HashSet<>();

		for (Person contact : start.getContacts()) {
			for (Person contactContact : contact.getContacts()) {
				if(!contactContact.equals(start))people.add(contactContact);
			}
		}

		return people.size();
	}
}
