package Week9Sorting;
// File: Insert.java
// A Java application to illustrate the use of an insertion sort
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/Insert.html
 
/******************************************************************************
* The <CODE>Insert</CODE> Java application illustrates an insertion sort.
*
* <p><b>Java Source Code for this class:</b>
*   <A HREF="../applications/Insert.java">
*   http://www.cs.colorado.edu/~main/applications/Insert.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class Insert
{
   /**
   * The main method illustrates the use of an insertion sort to sort a 
   * small array.
   * @param args
   *   not used in this implementation
   **/
   public static void main(String[ ] args)
   {
      final String BLANKS = "  "; // A String of two blanks
      int i;                      // Array index

      //int[ ] data = { 80, 10, 50, 70, 60, 90, 20, 30, 40, 0};
      //int[ ] data = { 60, 50, 40, 30, 20, 10};
      //int[ ] data = { 10, 40, 20, 30, 40, 30};
//      int[ ] data = { 30, 60, 40, 45, 43, 44};
      int[ ] data = { 10, 60, 20, 50, 30, 40};
      
      // Print the array before sorting:
      System.out.println("Here is the entire original array:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );

      // Sort the numbers, and print the result with two blanks after each number.
      insertionsort(data);
      System.out.println("I have sorted all but the first and last numbers.");
      System.out.println("The numbers are now:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );
   }
   
   
   /**
   * Sort an array of integers from smallest to largest, using an insertion sort
   * algorithm.
   * @param data
   *   the array to be sorted
   * @param first
   *   the start index for the portion of the array that will be sorted
   * @param n
   *   the number of elements to sort
   * <b>Precondition:</b>
   *   <CODE>data[first]</CODE> through <CODE>data[first+n-1]</CODE> are valid
   *   parts of the array.
   * <b>Postcondition:</b>
   *   If <CODE>n</CODE> is zero or negative then no work is done. Otherwise, 
   *   the elements of <CODE>data</CODE> have been rearranged so that 
   *   <CODE>data[first] &lt;= data[first+1] &lt;= ... &lt;= data[first+n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>first+n-1</CODE> is an index beyond the end of the
   *   array.
   * */
   public static void insertionsort(int[ ] data)
   {
      int i, j;   // Loop control variables
      int entry;  // The element that is currently being inserted
      int shift_count = 0;
         
      int n = data.length;
      int first = 0;
      
      for (i = 1; i < n; i++)
      {
         entry = data[first+i];
         shift_count = 0;
         for (j = first+i; (j>first) && (data[j-1] > entry); j--){ // keep moving left till you hit the entry
        	 System.out.println("j: " + data[j] + " is more than first " + data[first]);
        	 System.out.println("j-1: " +data[j-1] + " is more than entry " + entry);
        	shift_count++;
            data[j] = data[j-1]; // move left
         }
         data[j] = entry;
         System.out.println("shift count" + shift_count); // moves to the left
      }
      
      
  } 
   
}


