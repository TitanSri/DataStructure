/*
 * Assessment item 3 - Social Network Program
 */
package ITC322_A3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;

/**
 * 
 * @author Nanthaphone Toby Sriratanakoul
 * Student id: 11485513
 *
 */
public class A3Graph extends Graph{
	static int size; // the size from the super label is not public
	
	/** Constructor for the graph
	 * 
	 * @param n - size of teh graph
	 */
	public A3Graph(int n) {
		super(n);
		this.size = n;
	}
	
	/** create a non-directed graph
	 * 
	 * @param graph - bring in the graph to create the edge
	 * @param source - one member vertex
	 * @param target - second member vertex
	 */
	public static void addEdge(Graph graph, int source, int target){
    	graph.addEdge(source, target);
    	graph.addEdge(target, source);
    }
	
	/** get the vertex number for the member, this also ignores the upper or lower case
	 * 
	 * @param graph - graph to look in 
	 * @param member - members name
	 * @return the vertex number or else -1 if not found
	 */
	public static int getVertex(Graph graph, String member) {
		for (int i = 0; i < size; i++) {
			String name = (String) graph.getLabel(i);
			//System.out.println("Checking : " + name); // used to check list
			if (member.equalsIgnoreCase(name))
				return i;
		}
		return -1;
	}
	
	/** get two members friends that they both know
	 * 
	 * @param graph - graph to look in 
	 * @param member - first member
	 * @param member2 - second member
	 */
	public static void checkBoth(Graph graph, int member, int member2){
		for (int i = 0; i < size; i++) {
			// used to check members friends
//			System.out.println("Checking: " + graph.getLabel(i));
//			System.out.println(graph.isEdge(member, i)); // used to check friends
//			System.out.println(graph.isEdge(member2, i)); // used to check friends
			if ((graph.isEdge(member, i)) && (graph.isEdge(member2, i)))
				System.out.println(graph.getLabel(i));
		}
    }
	
	/** print friends and "friends' of friends"
	 * 
	 * @param graph - graph to look in 
	 * @param start - the member 
	 */
	public static void friendsOfFriendsPrint(Graph graph, int start){
		int [] neighbor = graph.neighbors(start);
		Set<Integer> set = new HashSet<Integer>(); // create a set to ensure no duplicate
		for (int i = 0; i < neighbor.length; i++) { // gets the first degree of friends
			int num = neighbor[i];
			if (!(set.contains(num))) { // make sure it is not in the set before printing
				set.add(num);
				System.out.println(graph.getLabel(num));
			}
			int [] neighbors = graph.neighbors(num);
			for (int j = 0; j < neighbors.length; j++) { // second degree of friends
				int nums = neighbors[j];
				if(nums != start && !(set.contains(nums))) { // make sure it is not the member and not in the set
					System.out.println(graph.getLabel(nums));
					set.add(nums);
				}
			}
		}
//		// print the set to check
//		for (Integer e : set)
//			System.out.println("Set: " + e);	      
	}
	
	/** delete a member's edges and the label
	 * 
	 * @param graph - graph to work with 
	 * @param v - vertex number
	 */
	public static void deleteMember(Graph graph, int v){
		for (int i = 0; i < size; i++) {
			graph.removeEdge(v, i);
//			System.out.println(graph.isEdge(v, i)); // check edge deletion 
			graph.removeEdge(i, v);
//			System.out.println(graph.isEdge(i, v)); // check edge deletion 
		}
		graph.setLabel(v, null);
//		System.out.println(graph.getLabel(v)); // check label deletion 
	}
	
	/** get the total of neighbors than add to a hash map for each member for popularity list
	 * 
	 * @param graph - graph to look in
	 */
	public static void popularity(Graph graph) {
		// create a hash map for the popularity list
		HashMap<String, Integer> popList = new HashMap<String, Integer>();
		for (int i = 0; i < size; i++) {
			int[ ] connections = graph.neighbors(i);
			if (graph.getLabel(i) != null)
				popList.put((String) graph.getLabel(i), connections.length);
		}
		// sort the hash map by using a map
		 Map<String,Integer> sortedMap = sortByValueDesc(popList);
		 System.out.println("Social Netowrk Popularity list:");
		 System.out.println("--------------------------------");
		 System.out.println("   Name		 Popularity");
		 System.out.println("--------------------------------");
		 for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			 	System.out.println(String.format("%-20s %s",entry.getKey(), entry.getValue()));
	        }
	}
	
	/** method to sort the hash map using Collection.sort
	 * 
	 * @param map - map to sort
	 * @return the sorted map
	 */
	public static Map<String, Integer> sortByValueDesc(Map<String, Integer> map) {
		// create a linked list to be used for the collection
	    List<Map.Entry<String, Integer>> list = new LinkedList(map.entrySet());
	    // sort the hash map by name ascending order
	    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	        @Override
	        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	            return o1.getKey().compareTo(o2.getKey());
	        }
	    });
	    // sort by value descending order
	    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	        @Override
	        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	            return o2.getValue().compareTo(o1.getValue());
	        }
	    });
	    
	    // create a map to be returned
	    Map<String, Integer> result = new LinkedHashMap<>();
	    for (Map.Entry<String, Integer> entry : list) {
	        result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	}

	/** get the size
	 * 
	 * @return size of graph
	 */
	public int getSize( ){
	    return size;
	}
	
	/** check if the graph is empty
	 * 
	 * @param graph - the graph to work with
	 * @return a true or false 
	 */
	public static boolean isEmpty(Graph graph) {
		for (int i = 0; i < size; i++) {
			if (graph.getLabel(i) != null)
				return false;
		}
		return true;
	}
	
	/** sets the members to the graph
	 * 
	 * @param input - scanner to use
	 * @param friend - A3Graph to work with 
	 * @param numOfFriends - number friends in the list
	 */
	public static void setMembers(Scanner input, A3Graph friend, int numOfFriends) {		
		int checkIndicesRead = 0;
		for ( int i = 0; i < numOfFriends; i++) {
			int num = input.nextInt();
			String name = input.next();
//			System.out.println(num + " " + name); // check the list
			checkIndicesRead++;
			friend.setLabel(num, name);
		}
		
		System.out.println("Members: " + numOfFriends + " out of " + checkIndicesRead);
		
//		// check members created
//		for ( int i = 0; i < numOfFriends; i++) {
//			String name = (String) friend.getLabel(i);
//			System.out.println("Create: " + name); // check the label
//		}
		
	}
	
	/**
	 * 
	 * @param input2 - scanner to use
	 * @param friend - A3Graph to work with
	 * @param numOfEdges - number of edges to create
	 */
	public static void setEdges(Scanner input2, A3Graph friend, int numOfEdges) {
		int checkEdgesCreated = 0;
		for (int j = 0 ; j < numOfEdges; j++) {
			int source = input2.nextInt();
			int target = input2.nextInt();
//			System.out.println(source + " " + target); // check edge
			A3Graph.addEdge(friend, source, target);
			checkEdgesCreated++;
			// check the if the new edge exist
//			System.out.println(friend.isEdge(source, target)); // check creation
//			System.out.println(friend.isEdge(target, source)); // check creation
		}
		
		System.out.println("Edges: " + numOfEdges + " out of " + checkEdgesCreated);
	}
	
	/** checks if the friend file exits
	 * 
	 * @param input4 - scanner for friend file 
	 * @param input3 - scanner for user input
	 * @return the scanner for the friend file
	 */
	public static Scanner checkFriendFile(Scanner input4, Scanner input3) {
		// loop until friend file is found
				while(input4 == null){
					try {
						System.out.print("Enter the friends file(i.e. friend.txt): ");
						File friendsFile = new File(input3.next());
						input4 = new Scanner(friendsFile);
					}catch(FileNotFoundException ex) { 
						System.err.println(ex.getMessage());
					}
				}
				return input4;
	}
	
	/** checks if the index file exits
	 * 
	 * @param input5 - scanner for index file
	 * @param input3 - scanner for user input
	 * @return the scanner for the index file
	 */
	public static Scanner checkIndexFile(Scanner input5, Scanner input3) {
		// loop until friend file is found
				while(input5 == null){
					try {
						System.out.print("Enter the index file(i.e. index.txt): ");
						File indexFile = new File(input3.next());
						input5 = new Scanner(indexFile);
					}catch(FileNotFoundException ex) { 
						System.err.println(ex.getMessage());
					}
				}
				return input5;
	}
}
