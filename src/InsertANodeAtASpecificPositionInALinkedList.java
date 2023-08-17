import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class InsertANodeAtASpecificPositionInALinkedList {
	static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }
    
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
            int currentNodePosition = 0; // used to move the node position
            SinglyLinkedListNode head = llist; // used to delete the first node if required
            SinglyLinkedListNode currentNode = llist; // the node to modify the link
            
            if (position == 0){
                head = head.next;
                return head; // return the node after the first one
            }
            while (currentNodePosition < position -1){ // gets the node before the position, if it is the position 1 then skip
                currentNode = currentNode.next; // move to the next one
                currentNodePosition++; // increment the current node position
            }
            
            if (currentNode.next != null && currentNode.next.next != null){
                currentNode.next = currentNode.next.next; // skips the node and acts like a delete
            }
            
            return head;
    }
    
    //  after this method everything should point backwards i.e. the last to second last, second last to third last and so on...
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    // Write your code here
        SinglyLinkedListNode prev = null; // used to reference the previous node (for the head node this will reference null)
        SinglyLinkedListNode current = llist; // this is used to go through the list
        SinglyLinkedListNode next = null; // this will be used to move the current node
         while (current != null){ // we will work through the list 
             next = current.next; // use as an anchor to work with for the next iteration
             current.next = prev; // use to linked the current to the previous node
             prev = current; // used as and anchor to link to for the next iteration
             current = next; // the next iteration will start from here            
        }
        //SinglyLinkedListNode node = prev; // NOT required: create a new node that starts from the end
        return prev;
    }




    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }


	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
	    SinglyLinkedListNode node = new SinglyLinkedListNode(data); // node to work with
	    if (position == 0){
	        node.next = llist.next; // add the link to the node
	        llist = node; // the new head is the node
	    }
	    else {
	        SinglyLinkedListNode aux = new SinglyLinkedListNode(0); // use for loop position
	        aux.next = llist; // reference the parameter
	        for(int i =0 ; i < position; i++)
	            aux=aux.next; // jumps the to location
	        node.next = aux.next; // insert the link for the node
	        aux.next = node; // makes the aux node the node (data)
	    }
	    return llist;
	    
	}
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
	    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("IOFile//numbers.txt"));
	
	    SinglyLinkedList llist = new SinglyLinkedList();
	
	    int llistCount = scanner.nextInt();
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	
	    for (int i = 0; i < llistCount; i++) {
	        int llistItem = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	
	        llist.insertNode(llistItem);
	    }
	
	    int data = scanner.nextInt();
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	
	    int position = scanner.nextInt();
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	
	    SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);
	
	    printSinglyLinkedList(llist_head, " ", bufferedWriter);
	    bufferedWriter.newLine();
	
	    bufferedWriter.close();
	
	    scanner.close();
	}
}

