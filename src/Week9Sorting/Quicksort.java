package Week9Sorting;
// File: Quicksort.java
// A Java application to illustrate the use of a quicksort. Part of this work
// is left as an exercise for students using "Data Structures and Other
// Objects with Java" by Michael Main.
 
/******************************************************************************
* The <CODE>Quicksort</CODE> Java application illustrates a quicksort.
* <B>Part of the implementation (the <CODE>partition</CODE> method) is left
* as a student exercise.</B>
*
* <b>Note:</b>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <p><b>Java Source Code for this class (without 
* <CODE>partition</CODE>:</b>
*   <A HREF="../applications/Quicksort.java">
*   http://www.cs.colorado.edu/~main/applications/Quicksort.java
*   </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class Quicksort
{
   /**
   * The main method illustrates the use of a quicksort to sort a 
   * small array.
   * @param args
   *   not used in this implementations
   **/
	
   static int count=0; // stores how many statements executed in loops
   public static void main(String[ ] args)
   {
      final String BLANKS = "  "; // A String of two blanks
      int i;                      // Array index


      // data to generate best case
      int[ ] data = { 50, 70, 90, 10, 60, 80, 20, 30, 100, 40, 7 };
 
      // data to generate average case
      //int[ ] data = { 40, 20, 10, 80, 60, 50, 7, 30, 100, 90, 70 };

      // data set to generate worst case: sorted (and its reverse)
      //int[ ] data = { 7,   10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
      //int[ ] data = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 7};

      // Print the array before sorting:
      System.out.println("Here is the entire original array:");
      print(data);
      
      // Sort the numbers, and print the result with two blanks after each number.
      quicksort(data, 0, data.length);
      System.out.println("swap " + count);
      
      System.out.println("I have sorted all numbers.");
      System.out.println("The numbers are now:");
      for (i = 0; i < data.length; i++)
         System.out.print(data[i] + BLANKS);
      System.out.println( );
   }


  
  
   /**
   * This method cannot be used until the student implements 
   * <CODE>partition</CODE>.
   * Sort an array of integers from smallest to largest, using a quicksort
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
   public static void quicksort(int[ ] data, int first, int n)
   {
      int pivotIndex; // Array index for the pivot element
      int n1;         // Number of elements before the pivot element
      int n2;         // Number of elements after the pivot element
      
      System.out.println("Array size N: " + n);
      if (n > 1)
      {
         // Partition the array, and set the pivot index.
         pivotIndex = partition(data, first, n);
         print(data); // print what data is like after a partition
         
         // Compute the sizes of the two pieces.
         n1 = pivotIndex - first; 
         System.out.println("PI " + pivotIndex + " - first " + first + " = N1: " + n1);
         n2 = n - n1 - 1;
         System.out.println("N " + n + " - N1 " + n1 + " -1 = N2: " + n2);
         
         // Recursive calls will now sort the two pieces.
         quicksort(data, first, n1);
         System.out.println("Increase the pivot when Array is less than 1: " + data[pivotIndex + 1]);
         quicksort(data, pivotIndex + 1, n2);
      }
   }
   
   private static int partition(int[ ] data, int first, int n)
   // Precondition: n > 1, and data has at least n elements starting at
   // data[first].
   // Postcondition: The method has selected some "pivot value" that occurs
   // in data[first]. . .data[first+n-1]. The elements of data have then been
   // rearranged and the method returns a pivot index so that
   //   -- data[pivot index] is equal to the pivot;
   //   -- each element before data[pivot index] is <= the pivot;
   //   -- each element after data[pivot index] is > the pivot.
   {
      
	   int pivot = data[first];
	   int tooBigIndex = first+1; //index of element after pivot
	   int tooSmallIndex = first + n -1; // index of last element

	   System.out.println("pivot is "+ pivot);
	   System.out.println("tooBigIndex " + data[tooBigIndex] + " tooSmallIndex " + data[tooSmallIndex]);
	   while(tooBigIndex <= tooSmallIndex){		  
		   while(tooBigIndex < first+n-1 && data[tooBigIndex] < pivot ){ // we are looking for a number larger than the pivot
			   count++;
		       tooBigIndex++; // move right from the pivot
		       System.out.println("tooBigIndex " + data[tooBigIndex]);
		   }    			   
		   
		   while (data[tooSmallIndex] > pivot){ // we are looking for a number smaller than the pivot
			    count++;
		    	tooSmallIndex--; // move left from the tail
		    	System.out.println("tooSmallIndex " + data[tooSmallIndex]);
		   }
	
		  if(tooBigIndex <= tooSmallIndex){ // swap the number so the largest is at the tail
			  count++;	  
		      swap(data, tooBigIndex, tooSmallIndex);
		      System.out.println("Swap: tooBigIndex " + data[tooBigIndex] + " tooSmallIndex " + data[tooSmallIndex]);
		      
 	         tooBigIndex++; // move right from the pivot
 	         System.out.println("tooBigIndex " + data[tooBigIndex]);
		  }
	   }
	   
	   // reached the cross point 
	   System.out.println("Swap: first " + data[first] + " tooSmallIndex " + data[tooSmallIndex]);
	   data[first]=data[tooSmallIndex]; // the last from the right is the 
	   System.out.println("The new tail is: " + pivot);
   	   data[tooSmallIndex]= pivot; // new pivot
   	   System.out.println("tooSmallIndex: " + tooSmallIndex);
   	 
	   return tooSmallIndex;  
	}
   
   private static void swap(int[ ] data, int tooBigIndex, int tooSmallIndex)
   {
	   int temp = data[tooBigIndex]; // store the value before overwriting
	   
	   data[tooBigIndex] = data[tooSmallIndex];
	   data[tooSmallIndex] = temp;
   }
   
   private static void print (int [] data)
   {
	  
	  for (int i = 0; i < data.length; i++){
		 System.out.print(data[i] + " ");  
	  }
	  System.out.println("\n");
   }
}
