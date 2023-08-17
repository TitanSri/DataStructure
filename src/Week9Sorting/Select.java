package Week9Sorting;
// File: Select.java
// A Java application to illustrate the use of a selection sort
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/Select.html
 
/******************************************************************************
* The <CODE>Select</CODE> Java application illustrates a selection sort.
*
* <p><b>Java Source Code for this class:</b>
*   <A HREF="../applications/Select.java">
*   http://www.cs.colorado.edu/~main/applications/Select.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class Select
{
   /**
   * The main method illustrates the use of a selection sort to sort a 
   * small array.
   * @param args
   *   not used in this implementation
   **/
   public static void main(String[ ] args)
   {
      final String BLANKS = "  "; // A String of two blanks
      int i;                      // Array index

      int[ ] data = { 80, 10, 50, 70, 60, 90, 20, 30, 40, 0 };

      // Print the array before sorting:
      System.out.println("Here is the entire original array:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );

      // Sort the numbers, and print the result with two blanks after each number.
      selectionsortsmall(data);
      //selectionsort(data); // SORT BIGGECT FROM THE RIGHT
      System.out.println("I have sorted all but the first and last numbers.");
      System.out.println("The numbers are now:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );
   }
   
   
   /**
   * Sort an array of integers from smallest to largest, using a selection sort
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
   *   <CODE>data[first] &lt;= data[first+1] &lt; ... &lt;= data[first+n-1]</CODE>.
   * @exception ArrayIndexOutOfBoundsException
   *   Indicates that <CODE>first+n-1</CODE> is an index beyond the end of the
   *   array.
   * */
   public static void selectionsort(int[ ] data)
   {
      int i, j; // Loop control variables
      int big;  // Index of largest value in data[first]...data[first+i]
      int temp; // Used during the swapping of two array values
      int first = 0;
     
      //      
      for (i = data.length-1; i > 0; i--) // START FROM THE RIGHT!!!
      {  
         // Calculate big as the index of the largest value in data[first]...data[first+i]:
         big = first;
         for (j = first+1; j <= first+i; j++)
            if (data[big] < data[j])
               big = j;
      
         // swap data[first+i] with data[big]:	
         temp = data[first+i];
         data[first+i] = data[big]; //place at the end i.e. i is right to left
         System.out.println("big is index" + big + "  data[big] is " + data [big]);
         data[big] = temp;
      }
   } 
   // selection sort, order from small to large
   public static void selectionsortsmall(int[ ] data)
   {
      int itemCount,// no of passes 
      j; // Loop control variables
      int small;  // Index of largest value in data[first]...data[first+i]
      int temp; // Used during the swapping of two array values

      for (itemCount = 0; itemCount < data.length-1; itemCount++) // START FROM THE LEFT!!!
      {  
         // Calculate big as the index of the largest value in data[first]...data[first+i]:
         small = itemCount;
         for (j = itemCount+1; j < data.length; j++)
            if (data[small] > data[j])
               small = j;
      
         // swap data[first+i] with data[big]:
         temp = data[itemCount];
         data[itemCount] = data[small]; // place at the start i.e. i is left to right
         System.out.println("small is index " + small + "  data[small] is " + data [small]);
         data[small] = temp;
      }
   } 
   
}


