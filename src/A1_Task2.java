import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A1_Task2 {
	
	/**
	 * @author ??
	 *
	 */
	static class SinglyLinkedListNode{
		public int data;
		public SinglyLinkedListNode next;
		
		/**
		 * @param initialData
		 * @param link
		 */
		public SinglyLinkedListNode(int initialData, SinglyLinkedListNode link) {
			data = initialData;
			next = link;
		}
	}
	
	/**
	 * @author ??
	 *
	 */
	static class SinglyLinkedList{
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;
		
		/**
		 * 
		 */
		public SinglyLinkedList() {
			head = null;
			tail = null;
		}
		
		/**
		 * @param nodeData
		 */
		public void insertNodeAtEnd(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData, null);
			
			if(head == null)
				head = node;
			else
				tail.next = node;
			
			tail = node;
		}
		
		// add additional methods if you need to
		
		
		/**
		 * @param head
		 * @return
		 */
		public static SinglyLinkedListNode reverse (SinglyLinkedListNode head) {
			// you need to complete this method
			// reverse the linked list and return the head of the reverse list
			SinglyLinkedListNode prev = null; // used to reference the previous node (for the head node this will reference null)
	        SinglyLinkedListNode current = head; // this is used to go through the list
	        SinglyLinkedListNode next = null; // this will be used to move the current node
	         while (current != null){ // we will work through the list 
	             next = current.next; // use as an anchor to work with for the next iteration
	             current.next = prev; // use to linked the current to the previous node
	             prev = current; // used as and anchor to link to for the next iteration
	             current = next; // the next iteration will start from here            
	        }
	        //SinglyLinkedListNode node = prev; // create a new node that starts from the end
	        return prev;
	    
		}
		
		/**
		 * @param head
		 */
		public static void printLinkedList(SinglyLinkedListNode head) {
			// you need to complete this method
			// this method should print a linked list starting from head, value should 
			//      be printed (in console) in a line separated by a space, for example, 10 20 30 40,
		}
		
		/**
		 * @param s
		 */
		public void initializeList(Scanner s) {
			// you need to complete this method
		}
	}

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("task2.txt");
		Scanner sc = new Scanner(file); //read data from a file
		//Scanner sc = new Scanner(System.in); //read data from console
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.initializeList(sc); // read data from a file and initialize list
		SinglyLinkedListNode headOfReverseList = SinglyLinkedList.reverse(myList.head); //reverse myList
		SinglyLinkedList.printLinkedList(headOfReverseList); //print the reverse list

	}

}
