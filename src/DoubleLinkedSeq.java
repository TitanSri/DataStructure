// File: DoubleLinkedSeq.java from the package edu.colorado.collections

// This is an assignment for students to complete after reading Chapter 4 of
// "Data Structures and Other Objects Using Java" by Michael Main.

// Check with your instructor to see whether you should put this class in
// a package. At the moment, it is declared as part of edu.colorado.collections:
// package edu.colorado.collections;

/******************************************************************************
* This class is a homework assignment;
* A DoubleLinkedSeq</CODE> is a collection of double</CODE> numbers.
* The sequence can have a special "current element," which is specified and 
* accessed through four methods that are not available in the sequence class 
* (start, getCurrent, advance and isCurrent).
*
* @Limitations:
*   Beyond Int.MAX_VALUE</CODE> elements, the size</CODE> method
*   does not work.
*
* @Note:
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @Outline of Java Source Code for this class:
*   <A HREF="../../../../edu/colorado/collections/DoubleLinkedSeq.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/DoubleLinkedSeq.java
*
* @version
*   Jan 24, 1999
******************************************************************************/
public class DoubleLinkedSeq implements Cloneable
{
   private int manyNodes;
   private DoubleNode head;  // reference to the first node on the list
   private DoubleNode tail;  // reference to the last node on the list
   private DoubleNode cursor; // reference to the node with the current element
   private DoubleNode precursor; // reference to the node before the current element.
                                 // It is null if there is no current element or the current 
                                 // element is the first node.
   
   /**
   * Initialize an empty sequence.
   * @param - none
   * @Postcondition:
   *   This sequence is empty.
   **/   
   public DoubleLinkedSeq( )
   {
      head = null;
      tail = null;
      cursor = null;
      precursor = null;
      manyNodes = 0;
   }
    
 
   /**
   * Add a new element to this sequence, after the current element. 
   * @param element</CODE>
   *   the new element that is being added
   * @Postcondition:
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed after the current
   *   element. If there was no current element, then the new element is placed
   *   at the end of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addAfter(double element)
   {
      // Implemented by student.
	   DoubleNode mylink;
	   if (head == null){    // Add the element to the empty sequence
		   mylink = new DoubleNode((double)element, head);
		   head = mylink;
		   cursor = mylink;
		   tail = mylink;
		   precursor = null;
	   }
	   else if (cursor == null){
		   mylink = new DoubleNode((double)element, null);
	       precursor = tail;   // There is an element, so tail is not null
		   tail.setLink(mylink);
	       tail = mylink;
	       cursor = mylink;
	   }    
	   else {
		   mylink = new DoubleNode((double)element, cursor.getLink());
	   	   precursor = cursor;
	       cursor.setLink(mylink);  // The Current Element links to the new element
	       cursor = mylink;
	   }
	   manyNodes++;
	   
   }
   
   public void addAfterV2(double element)
   {
     
		DoubleNode aNode = new DoubleNode((double)element, null);
		if (cursor == null)
			cursor = aNode;
        aNode.setLink(cursor.getLink());
        aNode.setData(element);
        
        cursor.setLink(aNode);
        
        cursor = aNode;
		  
		  //check to see if new node is at the end of the list, if so then have tail
		  //be equal to cursor
		  if(cursor.getLink() == null)
		  {
		  
		  		tail = cursor;
		  
		  }//end if
		  
		  manyNodes++;
	  
   }//end addAfter method


   /**
   * Add a new element to this sequence, before the current element. 
   * @param element</CODE>
   *   the new element that is being added
   * @Postcondition:
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed before the current
   *   element. If there was no current element, then the new element is placed
   *   at the start of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addBefore(double element)
   {
      // Implemented by student.
	   DoubleNode mylink; // create a new node
	   if (cursor == null){ // no current
		   head = new DoubleNode((double)element, head); // new element will be the head
	       precursor = null; // no previous element 
	       cursor = head;  // the head will be the current
	   }    
	   else if(precursor == null)    // Actually the cursor is pointing to the head element
	   {   
		   head = new DoubleNode((double)element, head); 
	       precursor = null;
	       cursor = head;  
	   }
	   else { // moves the front to the back
		   mylink = new DoubleNode((double)element, precursor.getLink()); // add element to node and set the previous as link
		   precursor.setLink(mylink); // the new node is the new Node link
		   cursor = mylink; // the new node is the current 
	   }
	   manyNodes++;
   }
   
   
   /**
   * Place the contents of another sequence at the end of this sequence.
   * @param addend</CODE>
   *   a sequence whose contents will be placed at the end of this sequence
   * @Precondition:
   *   The parameter, addend</CODE>, is not null. 
   * @Postcondition:
   *   The elements from addend</CODE> have been placed at the end of 
   *   this sequence. The current element of this sequence remains where it 
   *   was, and the addend</CODE> is also unchanged.
   * @exception NullPointerException
   *   Indicates that addend</CODE> is null. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of this sequence.
   **/
   public void addAll(DoubleLinkedSeq addend)
   {
      // Implemented by student.
	   tail.setLink(addend.head);
	   tail = addend.tail;
   }   
   
   
   /**
   * Move forward, so that the current element is now the next element in
   * this sequence.
   * @param - none
   * @Precondition:
   *   isCurrent()</CODE> returns true. 
   * @Postcondition:
   *   If the current element was already the end element of this sequence 
   *   (with nothing after it), then there is no longer any current element. 
   *   Otherwise, the new element is the element immediately after the 
   *   original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   advance</CODE> may not be called.
   **/
   public void advance( )
   {
      // Implemented by student.
	   if ( cursor == null || cursor.getLink()==null  )
	   {
		   cursor = null;
		   precursor = null;
	   }
	   else {
	       precursor = cursor;
	       cursor = cursor.getLink();
	   }
   }
   
   
   /**
   * Generate a copy of this sequence.
   * @param - none
   * @return
   *   The return value is a copy of this sequence. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to a DoubleLinkedSeq</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public Object clone( )
   {  // Clone a DoubleLinkedSeq object.
      // Student will replace this return statement with their own code:
      
      DoubleLinkedSeq answer;
      
      try
      {
         answer = (DoubleLinkedSeq) super.clone( );
      }
      catch (CloneNotSupportedException e)
      {  // This exception should not occur. But if it does, it would probably
         // indicate a programming error that made super.clone unavailable.
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      answer.head = DoubleNode.listCopy(head);
      
      return answer;
      
   }
   

   /**
   * Create a new sequence that contains all the elements from one sequence
   * followed by another.
   * @param s1</CODE>
   *   the first of two sequences
   * @param s2</CODE>
   *   the second of two sequences
   * @Precondition:
   *   Neither s1 nor s2 is null.
   * @return
   *   a new sequence that has the elements of s1</CODE> followed by the
   *   elements of s2</CODE> (with no current element)
   * @exception NullPointerException.
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new sequence.
   **/   
   public static DoubleLinkedSeq catenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
   {
      // Student will replace this return statement with their own code:
	  //DoubleLinkedSeq answer = new DoubleLinkedSeq(); 
	  
	  DoubleLinkedSeq answer = (DoubleLinkedSeq) s1.clone();
	  DoubleLinkedSeq tmp2 = (DoubleLinkedSeq) s2.clone();
	  answer.tail.setLink(tmp2.head);
	  answer.tail = tmp2.tail;
	  answer.manyNodes = s1.size() + s2.size();
	  return answer;
   }


   /**
   * Accessor method to get the current element of this sequence. 
   * @param - none
   * @Precondition:
   *   isCurrent()</CODE> returns true.
   * @return
   *   the current capacity of this sequence
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   getCurrent</CODE> may not be called.
   **/
   public double getCurrent( )
   {
      // Student will replace this return statement with their own code:
	  if ( cursor == null )
		  return -1;     // For testing
	  else
		  return cursor.getData();
   }


   /**
   * Accessor method to determine whether this sequence has a specified 
   * current element that can be retrieved with the 
   * getCurrent</CODE> method. 
   * @param - none
   * @return
   *   true (there is a current element) or false (there is no current element at the moment)
   **/
   public boolean isCurrent( )
   {
      // Student will replace this return statement with their own code:
      if (cursor == null) 
         return false;
      else
    	 return true;
   }
              
   /**
   * Remove the current element from this sequence.
   * @param - none
   * @Precondition:
   *   isCurrent()</CODE> returns true.
   * @>Postcondition:
   *   The current element has been removed from this sequence, and the 
   *   following element (if there is one) is now the new current element. 
   *   If there was no following element, then there is now no current 
   *   element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   removeCurrent</CODE> may not be called. 
   **/
   public void removeCurrent( )
   {
      // Implemented by student.
	   if ( cursor == null ){   // no element to remove
	   }
	   else if ( cursor.getLink()==null  )
	   {   
		   if ( precursor == null )   //which means only one element on sequence
		   {
			   head = null;
			   cursor = null;
			   tail = null;
		   }
		   else {
			   tail = precursor;
		       precursor.setLink(null);
		       cursor = null;
		       precursor = null;
	       }
		   manyNodes--;
	   }
	   else {
		   if (precursor == null )    //which means the current element is the front element
		   {   
			   //precursor = cursor;
			   head = cursor.getLink();   // remove the current element
		       cursor = cursor.getLink(); // make the next element as current
		   }
		   else
		   {
		       precursor.setLink(cursor.getLink());
		       cursor = cursor.getLink();
		   }
		   manyNodes--;
	   }
	   
   }
                 
   
   /**
   * Determine the number of elements in this sequence.
   * @param - none
   * @return
   *   the number of elements in this sequence
   **/ 
   public int size( )
   {
      // Student will replace this return statement with their own code:
      return manyNodes;
   }
   
   
   /**
   * Set the current element at the front of this sequence.
   * @param - none
   * @Postcondition:
   *   The front element of this sequence is now the current element (but 
   *   if this sequence has no elements at all, then there is no current 
   *   element).
   **/ 
   public void start( )
   {
      // Implemented by student.
	   precursor = null;
	   cursor = head;
   }
   //display() will print out the nodes of the list  
   public static void display(DoubleLinkedSeq head)
   {
       if (head == null)
       {
           System.out.println("List is empty");
       }
       else
           {
    	   
           for (int i = 0; i < head.size(); i++) // for testing change head.size() to 10
           {
               //result [--i] = head.getCurrent();
        	   System.out.println(head.getCurrent());
        	   head.advance();
           }
       }
   }
}
           