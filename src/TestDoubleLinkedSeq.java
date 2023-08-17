
public class TestDoubleLinkedSeq {
	public static void main(String[] args) {
	    // Create a File instance
	    DoubleLinkedSeq mymarks = new DoubleLinkedSeq();  
	    mymarks.addAfter(85.9);
	    mymarks.addAfter(74.3);
	    mymarks.addAfter(61.7);
	    mymarks.addBefore(90.2);
	    //add a few lines to print out those values on the sequence 
	    
	    // prints the current and onwards
	  	DoubleLinkedSeq.display(mymarks);
	   
	    	
	    mymarks.start(); // resets the head
	    System.out.println("----------------------");
	    DoubleLinkedSeq.display(mymarks); // prints the list from the start
	    
	    mymarks.start(); // resets the head
	    mymarks.advance(); // moves forward the current position
	    System.out.println("----------------------");
	    DoubleLinkedSeq.display(mymarks);
	    
	    mymarks.start(); // resets the head
	    mymarks.advance(); // moves forward the current position
	    mymarks.removeCurrent(); // removes the current
	    //add a few lines to check which value has been removed. 
	    System.out.println("----------------------");
	    DoubleLinkedSeq.display(mymarks);
	    
	}
}