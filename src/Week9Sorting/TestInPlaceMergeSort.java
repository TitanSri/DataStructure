package Week9Sorting;

public class TestInPlaceMergeSort {
	   public static void main(String[ ] args)
	   {
		  
	      final String BLANKS = "  "; // A String of two blanks
	      int i;                      // Array index

	      Integer[ ] data = { 80, 10, 50, 70, 60, 90, 20, 30, 40, 0};
	      Integer[ ] dataInPlace = { 80, 10, 50, 70, 60, 90, 20, 30, 40, 0};
	      
	      // Print the array before sorting:
	      System.out.println("Here is the entire original array:");
	      for (i = 0; i < data.length; i++)
	         System.out.print(data[i] + BLANKS);
	      System.out.println( );

	      // Sort the numbers, and print the result with two blanks after each number.
	      MergeSortAdvance.sort(data);
	      System.out.println("I have sorted all numbers.");
	      System.out.println("The numbers are now:");
	      for (i = 0; i < data.length; i++)
	         System.out.print(data[i] + BLANKS);
	      System.out.println( );

	      // Sort the numbers, and print the result with two blanks after each number.
	      MergeSortAdvance.inPlaceSort(dataInPlace);
	      System.out.println("\nIn Place Sort - I have sorted all numbers.");
	      System.out.println("The numbers are now:");
	      for (i = 0; i < dataInPlace.length; i++)
	         System.out.print(dataInPlace[i] + BLANKS);
	      System.out.println( );
	   
	   }
}
