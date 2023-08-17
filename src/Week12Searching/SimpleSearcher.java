package Week12Searching;

public class SimpleSearcher {
	  /**
	   * The main method prints a table of test results, searching for numbers
	   * in an array that contains 2, 4, 6, 8, 10, 12, and 14.
	   * The <CODE>String</CODE> arguments (<CODE>args</CODE>) are not used 
	   * in this implementation.
	   **/
	   public static void main(String[ ] args)
	   {
	      final double[ ] DATA = { 2, 14, 6, 8, 10, 12, 4 };
	      final double[ ] EMPTY = new double[0];
	      final int MINIMUM = -1;
	      final int MAXIMUM = 16;
	      
	      int target;

	      System.out.println("Searching for numbers in an array.");
	      for (target = MINIMUM; target <= MAXIMUM; target++)
	      {
	          System.out.print("Is " + target + " in the array? ");
	          System.out.println(search(DATA, target));
	      }
	      
	      System.out.println("Searching for 0 in an empty array. ");
	      System.out.println("Search: " + search(EMPTY, 0));
	      System.out.println("Search2: " + search2(EMPTY, 0));

	      System.out.println("End of searching.");
	   }
	 
	        
	   /**
	   * Search an array for a specified number.
	   * @param <CODE>data</CODE> 
	   *   an array of double numbers
	   * @param <CODE>target</CODE>
	   *   a particular number that we are searching for
	   * @return
	   *   <CODE>true</CODE> (to indicate that <CODE>target</CODE> occurs
	   *   somewhere in the array)
	   *   or <CODE>false</CODE> (to indicate that <CODE>target</CODE>
	   *   is not in the array)
	   **/
	   public static boolean search(double[ ] data, double target)
	   {
	      int i;

	      for (i = 0; i < data.length; i++)
	      {  // Check whether the target is at data[i].
	         if (data[i] == target)
	             return true;
	      }
	      
	      // The loop finished without finding the target.
	      return false;
	   }

	   /**
	   * Search an array for a specified number.  This implementation
	   * uses the new form of a for-loop to iterate through the elements
	   * of an array.
	   * @param <CODE>data</CODE> 
	   *   an array of double numbers
	   * @param <CODE>target</CODE>
	   *   a particular number that we are searching for
	   * @return
	   *   <CODE>true</CODE> (to indicate that <CODE>target</CODE> occurs
	   *   somewhere in the array)
	   *   or <CODE>false</CODE> (to indicate that <CODE>target</CODE>
	   *   is not in the array)
	   **/
	   public static boolean search2(double[ ] data, double target)
	   {
	      for (double d : data)
	      {  // Check whether the target is at data[i].
	         if (d == target)
		    return true;
		 else
		    d = 0;  
	      }
	      
	      // The loop finished without finding the target.
	      return false;
	   }

}
