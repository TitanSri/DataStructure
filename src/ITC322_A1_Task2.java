import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

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

public class ITC322_A1_Task2 {
	
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
				/*while (num < 1) { // non-natural number(not required)
					// Non-file input or a file with sufficient input
					//System.out.println("You entered a negative number, please enter the positive numbers for the array: "); // testing purpose
					num = s.nextInt();
					
					// File input (not required if the file has sufficient input)
					//System.out.println("You entered a negative number, the system is closing... ");
					//s.close(); // close the scanner
					//System.exit(0);
				}*/
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

	/**
	 * @param args - in case there is an argument when using the class
	 * @throws FileNotFoundException - a description of the file error
	 */
	public static void main(String[] args){
		try {
			File file = new File("task2.txt");
			Scanner sc = new Scanner(file); //read data from a file
			//Scanner sc = new Scanner(System.in); //read data from console
			//System.out.println("How many list do you have? "); // testing purpose
			int t = sc.nextInt(); // number of list
			if ( t < 1)
				System.out.println("The number of list is less than 1");
			//System.out.println(t); // testing purpose - check the input from the file
			int j = 1; // the list number to differentiate from each list 
			for (int i = 0; i < t; i++) { // loop each list
				//System.out.println("\nHow numbers in the list " + j); // testing purpose
				int n = sc.nextInt(); // list size
				//System.out.println(n); // testing purpose - check the input from the file
				//System.out.println("\nEnter the list: "); // testing purpose
				SinglyLinkedList myList = new SinglyLinkedList();
				myList.listSize(n); // set the list size
				myList.initializeList(sc); // read data from a file and initialize list
				/* testing purpose - test without using a method
				while (sc.hasNextInt()) {
					int num = sc.nextInt();
					myList.insertNodeAtEnd(num);
				}*/
				//SinglyLinkedList.printLinkedList(myList.head);
				//System.out.println("\nThe list is: "); // testing purpose - check the input from the file
				//SinglyLinkedList.printLinkedList(myList.head); //testing purpose - print the list
				SinglyLinkedListNode headOfReverseList = SinglyLinkedList.reverse(myList.head); //reverse myList
				//System.out.println("\nThe reverse list is: "); // testing purpose
				SinglyLinkedList.printLinkedList(headOfReverseList); //print the reverse list
				System.out.println(""); // create a newline for next list to reverse
				j++;
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage() + " in the specified directory.");
		    System.exit(0);
		} catch (InputMismatchException ex2) {
		    System.out.println("The input had a non-integer value, the program had to stop!!!");
		} catch(NullPointerException ex3) {
			System.out.println("You have entered a negative number for the array size!!!");
		}
		
	}

}
