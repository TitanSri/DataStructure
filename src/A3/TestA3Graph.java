package ITC322_A3;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Nanthaphone Toby Sriratanakoul
 * Student id: 11485513
 *
 */
public class TestA3Graph {
	/**Most declarations are external for the flexibility to be used in multiple blocks.
	 * The try methods will check if the file exist or to ensure that the inputs from the console is correct.
	 * We have used the switch case to work with the menu which is easier to understand.
	 * The menu will loop until 7 is entered to exit.
	 * Check to see if the graph is empty by using isEmpty method
	 * To use the graph we need the vertex number of the member since the operations works easier with a vertex than a member's name
	 * @param args - main 
	 */
	public static void main(String[] args){
		// declaration is needed for the block code 
		Scanner input = null; // scan the file with members list
		Scanner input2 = null; // scan the file with edges
		int numOfFriends; // required to check the file to compare with the members created
		A3Graph friend; // create a non-directional graph
		int numOfEdges; // required to check the number of edges in the file to compare with the edges created
		final String INDEX = "index.txt"; // members list
		final String FRIEND = "friend.txt"; // edge list
		
		// declaration for switch cases
		Scanner input3 = new Scanner(System.in);
		int answer = 0; // zero to start the switch
		int vertex;
		int vertex2; // for the mutual friends
		String member;
		String member2; // for the mutual friends
		
		// open file and print error if required
		try {
			File file = new File(INDEX);
			input = new Scanner(file);
			File file2 = new File(FRIEND);
			input2 = new Scanner(file2);
		}catch(FileNotFoundException ex) { 
			System.err.println(ex.getMessage());
		}	
		
		// if the both files were found then create the graph
		if (input != null && input2 != null) {
			numOfFriends = input.nextInt();	// first value for the size of the graph
			numOfEdges = input2.nextInt(); // first value for the amount of edges
			friend = new A3Graph(numOfFriends); // create a graph
			A3Graph.setMembers(input, friend, numOfFriends); // set the members		
			A3Graph.setEdges(input2, friend, numOfEdges); // create the edges
		}
		
		// else create an empty graph
		else {
			friend = new A3Graph(0);
			System.err.println("The network is empty.");
		}
		
		// loop until 7 is select to exit
		do {
			// the menu
			System.out.println("----- ITC322 - Social Network -----");
			System.out.println("[1] Read new network from files");
			System.out.println("[2] List all friends of and friends of friends of a user");
			System.out.println("[3] List of friends of a user");
			System.out.println("[4] List all mutual friends of a user");
			System.out.println("[5] Delete a member from a network");
			System.out.println("[6] List all members sorted by popularity, then by name");
			System.out.println("[7] Exit");
			System.out.print("What would you like to do, 1-7?: ");
			
			// close the program if a number was not entered
			try {
				answer = input3.nextInt();
			}catch(InputMismatchException ex) { 
				System.err.println("You did not choose a number, Closing program!!!");
				break;
			}
			
			// close the program if the number was not in the list
			if (answer < 1 || answer > 7) {
				System.err.println("You choose a number out of range, Closing program!!!");
				break;	
			}
					
			switch (answer) {
				case 1:	
					Scanner input4 = null; // needs to be null to prompt the user to enter a file name
					Scanner input5 = null; // needs to be null to prompt the user to enter a file name
					input4 = A3Graph.checkFriendFile(input4, input3); // checks if the friend file exist
					input5 = A3Graph.checkIndexFile(input5, input3); // checks if the index file exist
					numOfFriends = input5.nextInt(); // read from the index file
					numOfEdges = input4.nextInt();	// read from the friend file
					friend = new A3Graph(numOfFriends); // create new graph
					A3Graph.setMembers(input5, friend, numOfFriends); // set the members		
					A3Graph.setEdges(input4, friend, numOfEdges); // create the edges
					break;
				case 2: 
					// break if the list is empty
					if (A3Graph.isEmpty(friend)) {
						System.err.println("The network is empty.");
						break;
					}
					System.out.print("What is the member's name: ");
					member = input3.next();
					vertex = A3Graph.getVertex(friend, member); // we need the vertex of the graph to work with
					// break if the member does not exist
					if (vertex == -1) {
						System.err.println(member + " does not exist, try again!!!");
						break;
					}
					System.out.println("Friends of Friends: ");
					System.out.println("-------------------");
					A3Graph.friendsOfFriendsPrint(friend, vertex);
					break;
				case 3:
					if (A3Graph.isEmpty(friend)) {
						System.err.println("The network is empty.");
						break;
					}
					System.out.print("What is the member's name: ");
					member = input3.next();
					vertex = A3Graph.getVertex(friend, member);
					if (vertex == -1) {
						System.err.println(member + " does not exist, try again!!!");
						break;
					}
					// checks for neighbors/friends than prints the name
					int [] neighbors = friend.neighbors(vertex);
					System.out.println("Friends List: ");
					System.out.println("--------------");
					for (int i = 0; i < neighbors.length; i++) {
						int num = neighbors[i];
						System.out.println(friend.getLabel(num));
					}
					break;
				case 4: 
					if (A3Graph.isEmpty(friend)) {
						System.err.println("The network is empty.");
						break;
					}
					System.out.print("What is the members' name: ");
					member = input3.next();
					vertex = A3Graph.getVertex(friend, member);
					System.out.print("What is the second members' name: ");
					member2 = input3.next();
					vertex2 = A3Graph.getVertex(friend, member2);
					if (vertex == -1) {
						System.err.println(member + " does not exist, try again!!!");
						break;
					}
					if (vertex2 == -1) {
						System.err.println(member2 + " does not exist, try again!!!");
						break;
					}
					// checks for common friends
					System.out.println("Mutual friend List: ");
					System.out.println("--------------------");
					A3Graph.checkBoth(friend, vertex, vertex2);
					break;
				case 5:
					if (A3Graph.isEmpty(friend)) {
						System.err.println("The network is empty.");
						break;
					}
					System.out.print("Which member would you like to delete: ");
					member = input3.next();
					System.err.println("Are you sure you want to delete? Yes/No");
					String answer2 = input3.next();
					// makes sure the answer is contains yes
					if (answer2.contains("Yes") || answer2.contains("yes")) {
						vertex = A3Graph.getVertex(friend, member);
						if (vertex == -1) {
							System.err.println(member + " does not exist, try again!!!");
							break;
						}
						A3Graph.deleteMember(friend, vertex);
						break;
					}
					// else abort the mission
					else {
						System.out.println("Deletion Aborted!!!");
						break;
					}
				case 6:
					if (A3Graph.isEmpty(friend)) {
						System.err.println("The network is empty.");
						break;
					}
					// prints the popularity list
					A3Graph.popularity(friend);
					break;
				case 7:
					// advise the user that the program is shutting down
					System.out.println("Closing program!!!");
					break;		
			}
		}while (answer != 7);		
	}
}
