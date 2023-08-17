import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**Task 1 - Array Left Rotation (40 marks).
 * A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left. 
 * For example, if 2 left rotations are performed on the array [1, 2, 3, 4, 5] the array would become [3, 4, 5, 1, 2]. 
 * Given an array of n integers and a number, d, perform d left rotations on the array. 
 * Then print the updated array as a single line of space-separated integers.
 * Input Format:
 * The first line contains two space-separated integers denoting the respective values of n (the number of integers) 
 * and d (the number of left rotations you must perform).
 * The second line contains n space-separated integers describing the respective elements of the array's initial state.
 * Input will be always valid data.
 * Constraints:
 * {@code
 * 1 <= n <= 10^5, 
 * 1 <= d <= n.}
 * Output Format:
 * Print a single line of n space-separated integers denoting the final state of the array 
 * after performing d left rotations.
 * 
 * @author Toby Sriratanakoul 11485513
 * 
 *
 */
/**Task 2 - Reverse a Linked List (60 marks)
 * You’re given the pointer to the head node of a linked list
 * (you will be provided with supporting Java code, the code will be uploaded to the interact2 site). 
 * Task 2.1 - You need to implement SinglyLinkedListNode and SinglyLinkedList classes. 
 * The linkedlist class should implement methods to read data from stadin/console and output data to staout/console 
 * (recommend to use java.util.Scanner Java class)
 * Task 2.2 - You have to complete a SinglyLinkedListNode reverse (SinglyLinkedListNode head) 
 * method which takes one argument - the head of the linked list. 
 * Input Format:
 * The input format is as follows:
 * The first line contains an integer t, denoting the number of test cases.
 * Each test case is of the following format:
 * The first line contains an integer n, denoting the number of elements in the linked list.
 * The next n lines contain an integer each, denoting the elements of the linked list.
 * Input will be always valid data.
 * Constrains:
 * {@code
 * 1 <= t<= 10
 * 1 <= n <= 1000
 * 1 <= listi <= 1000, where listi is the ith element in the list}
 * Output Format:
 * The output format is as follows:
 * For each test case, print in a new line the elements of the linked list after reversing it, separated by spaces.
 * 
 * @author Toby Sriratanakoul 11485513
 *
 */

public class ITC322_A1 {
	
	// Task 1
	/**The static method shiftLeft will take an List 
	 * and return the List with the elements shifted 
	 * left the a amount of times 
	 * 
	 * @param array - the array to shift left
	 * @param d = the amount of times to shift left
	 * @return List
	 */
	public static List<Integer> shiftLeft(List<Integer> array, int d) {
		Integer [] tempArray = new Integer[array.size()]; // create a new array that works with an index value
		array.toArray(tempArray); // copies the list to the array
		
		for (int i = 0; i < d; i++) { // performs a loop amount of times for the shift 
			int temp= tempArray[0]; // requires to copy the value in index zero or the first value
			for (int j = 0; j < tempArray.length-1; j++) { // loop the length of the array minus 1 because we will 
				// add the first index value to the last index later 
				tempArray[j] = tempArray[j+1]; // move the value left i.e. index 1 value to index 0
			}
			tempArray[tempArray.length-1] = temp; // move the value that was copied previous at index 0 to the last index
		}
		List<Integer> returnArray = Arrays.asList(tempArray); // we need to return the array as a list of integers
		return returnArray;
	}
	
	
	// Task 2
	private static int manyNodes; // this is used in the initialization of the list 
	
	static class SinglyLinkedListNode{ // create a node
		public int data; // the value in the node
		public SinglyLinkedListNode next; // the link to the next node
		
		/**
		 * @param initialData - the value
		 * @param link - the link to the next node
		 */
		public SinglyLinkedListNode(int initialData, SinglyLinkedListNode link) { // create a node with a link
			data = initialData;
			next = link;
		}
	}
	
	/** 
	 * create a head and tail node for the list
	 */
	static class SinglyLinkedList{
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;
		
		public SinglyLinkedList() {
			head = null;
			tail = null;
		}
		
		/**
		 * @param nodeData
		 */
		public void insertNodeAtEnd(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData, null); // create a new node with the link to null
			
			if(head == null) // if there is no head
				head = node; // make this node the head
			else
				tail.next = node; // make the tail link to this node
			
			tail = node; // the new tail is now the node
		}
		
		// add additional methods if you need to
		
		
		/**
		 * @param head
		 * @return
		 */
		public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
			// you need to complete this method
			// reverse the linked list and return the head of the reverse list
			SinglyLinkedListNode prev = null; // used to reference the previous node (for the head node this will reference null)
	        SinglyLinkedListNode current = head; // this is used to go through the list
	        SinglyLinkedListNode next = null; // this will be used to move the current node
	         while (current != null){ // we will work through the list 
	             next = current.next; // use as an anchor to work with for the next iteration
	             current.next = prev; // use to linked the current to the previous node(the first node will point to null)
	             prev = current; // used as and anchor to link to for the next iteration
	             current = next; // the next iteration will start from here            
	        }
	        //SinglyLinkedListNode node = prev; // create a new node that starts from the end(not required)
	        return prev; // the head is returned
	    
		}
		
		/**
		 * @param head
		 */
		public static void printLinkedList(SinglyLinkedListNode head) {
			// you need to complete this method
			// this method should print a linked list starting from head, value should 
			// be printed (in console) in a line separated by a space, for example, 10 20 30 40,
			System.out.print(head.data + " "); // adds a space
	        while (head.next != null){
	            System.out.print(head.next.data + " "); // display the next node
	            head = head.next; // move to the link which is the next node
	        }
		}
		
		/**
		 * 
		 * @param s - scanner argument
		 */
		public void initializeList(Scanner s) {
			// you need to complete this method
			SinglyLinkedList list = new SinglyLinkedList(); // new list to work with
			for ( int i = 0; i < manyNodes; i++) { // loop through the list using the size we set earlier
				int num = s.nextInt(); // collects the next input
				list.insertNodeAtEnd(num); // add the value to the list
			}
			head = list.head; // we need to assign the head to the Singly Link List
		}
		
		/**
		 * 
		 * @param size - used for the scanning the list during the initialization list process
		 */
		public void listSize(int size) {
			manyNodes = size;
		}
	}
	/** This will run a program asking the user to enter an array and the amount to be shifted left
	 * Before the shift occurs the user will be asked to verify the list
	 * If the list is wrong then the program is required to run again
	 * 
	 * @param args - this is in case another class decides to run this class
	 * @throws IOException - provides a more descriptive error message
	 */
	/**
	 * 
	 * @param args - in case there is an argument when using the class
	 * @throws IOException - description of input and output error
	 * @throws FileNotFoundException - description of file error
	 */
	public static void main(String[]args) throws IOException, FileNotFoundException{ // displays more readable description of the error
		// Task 1
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the length of the array and the amount to shift the array left: ");
		int n = input.nextInt(); // the first input will determine the array length
		int d = input.nextInt(); // the next input will be the shift amount (d)
		
		List<Integer> list = new ArrayList<>(); // we need a new list to work with that will add the integer 
		// if we used an array then we will need to loop the array and add the next input and this is not efficient
		// also when we display the list, the process is more efficient than an array
		
		System.out.println("Enter the positive numbers for the array: ");
		
		for (int i = 0; i < n; i++) { // loop through the input and add the integer to the list
			int item = input.nextInt(); // the next item to work with
			while (item < 1) {
				System.out.println("You entered a negative number, please enter the positive numbers for the array: ");
				item = input.nextInt();
			}
			list.add(item); // add the item to the list
		}
		
		System.out.println("The original list: " + list); // make sure that the list is correct since the negative numbers will be ignored 
		// and the new number will be added at the end 
		System.out.println("The list will be shifted to the left " + d + " times.");	// double check the shift amount
		System.out.println("Are you sure the list is in the correct order? ('yes' to continue)");
		String answer = input.next();
		if (!(answer.equals("yes"))) {
			System.out.println("Run the program again!!!");
			input.close(); // close the scanner
			System.exit(0);
		}
		List<Integer> result = shiftLeft(list, d); // take the list and user the method shiftLeft
		
		/* for testing purposes
		 System.out.println("The returned list: " + result); // display the list
		 */
		
		for (Integer c: result) {
			System.out.print(c + " ");
		}
		
		// Task 2
		File file = new File("task2.txt");
		Scanner sc = new Scanner(file); //read data from a file
		//Scanner sc = new Scanner(System.in); //read data from console
		System.out.println("\nHow many list do you have? ");
		int t = sc.nextInt();
		System.out.println(t); // check the input from the file
		int j = 1; // the list number to differentiate the list 
		for (int i = 0; i < t; i++) { // loop each list
			System.out.println("\nHow numbers in the list " + j);
			int n2 = sc.nextInt();
			System.out.println(n2); // check the input from the file
			System.out.println("\nEnter the list: ");
			SinglyLinkedList myList = new SinglyLinkedList();
			myList.listSize(n2); // set the list size
			myList.initializeList(sc); // read data from a file and initialize list
			/* testing purpose
			while (sc.hasNextInt()) {
				int num = sc.nextInt();
				myList.insertNodeAtEnd(num);
			}*/
			//SinglyLinkedList.printLinkedList(myList.head);
			System.out.println("\nThe list is: "); // check the input from the file
			SinglyLinkedList.printLinkedList(myList.head); //print the reverse list
			SinglyLinkedListNode headOfReverseList = SinglyLinkedList.reverse(myList.head); //reverse myList
			System.out.println("\nThe reverse list is: ");
			SinglyLinkedList.printLinkedList(headOfReverseList); //print the reverse list
			j++;
		}

	}
	
}