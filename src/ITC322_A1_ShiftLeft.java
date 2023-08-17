import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;
/**Task 1 - Array Left Rotation (40 marks).
 * A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left. 
 * For example, if 2 left rotations are performed on the array [1, 2, 3, 4, 5] the array would become [3, 4, 5, 1, 2]. 
 * Given an array of n integers and a number, d, perform d left rotations on the array. 
 * Then print the updated array as a single line of space-separated integers.
 * Input Format:
 * The first line contains two space-separated integers denoting the respective values of n (the number of integers) 
 * and d (the number of left rotations you must perform).
 * The second line contains n space-separated integers describing the respective elements of the array's initial state.
 * Input will be always valid data.
 * Constraints:
 * {@code
 * 1 <= n <= 10^5, 
 * 1 <= d <= n.}
 * Output Format:
 * Print a single line of n space-separated integers denoting the final state of the array 
 * after performing d left rotations.
 * 
 * @author Toby Sriratanakoul 11485513
 * 
 *
 */

public class ITC322_A1_ShiftLeft {
	
	// the method to shift the array 
	/**The static method shiftLeft will take an List 
	 * and return the List with the elements shifted 
	 * left the a amount of times 
	 * 
	 * @param array - the array to shift left
	 * @param d = the amount of times to shift left
	 * @return List
	 */
	public static List<Integer> shiftLeft(List<Integer> array, int d) {
		Integer [] tempArray = new Integer[array.size()]; // create a new array that works with an index value
		array.toArray(tempArray); // copies the list to the array
		if ( d < 1)
			System.out.println("No shift has occured since the shift value is less than 1");
		for (int i = 0; i < d; i++) { // performs a loop amount of times for the shift 
			int temp= tempArray[0]; // requires to copy the value in index zero or the first value
			for (int j = 0; j < tempArray.length-1; j++) { // loop the length of the array minus 1 because we will 
				// add the first index value to the last index later 
				tempArray[j] = tempArray[j+1]; // move the value left i.e. index 1 value to index 0
			}
			tempArray[tempArray.length-1] = temp; // move the value that was copied previous at index 0 to the last index
		}
		List<Integer> returnArray = Arrays.asList(tempArray); // we need to return the array as a list of integers
		return returnArray;
	}
	
	/** This will run a program asking the user to enter an array and the amount to be shifted left
	 * Before the shift occurs the user will be asked to verify the list
	 * If the list is wrong then the program is required to run again
	 * 
	 * @param args - this is in case another class decides to run this class
	 * @throws IOException - provides a more descriptive error message
	 */
	public static void main(String[]args){ // displays more readable description of the error
		
		try{
			File file = new File("shiftLeft.txt");
			Scanner input = new Scanner(file); //read data from a file
			//Scanner input = new Scanner(System.in); 
			//System.out.println("Enter the length of the array and the d to shift the array left: "); // testing purpose
			int n = input.nextInt(); // the first input will determine the array length
			int d = input.nextInt(); // the next input will be the shift amount (d)
			
			List<Integer> list = new ArrayList<>(); // we need a new list to work with that will add the integer 
			// if we used an array then we will need to loop the array and add the next input and this is not efficient
			// also when we display the list, the process is more efficient than an array
			
			//System.out.println("Enter the positive numbers for the array: "); // testing purpose
			
			for (int i = 0; i < n; i++) { // loop through the input and add the integer to the list
				int item = input.nextInt(); // the next item to work with
				/*while (item < 1) { // non-natural number(not required)
					// Non-file input or a file with sufficient input
					//System.out.println("You entered a negative number, please enter the positive numbers for the array: "); // testing purpose
					item = input.nextInt();
					
					// File input (not required if the file has sufficient input)
					//System.out.println("You entered a negative number, the system is closing... ");
					//input.close(); // close the scanner
					//System.exit(0);
				}*/
				list.add(item); // add the item to the list
			}
					
			//System.out.println("The original list: " + list); // for testing purpose make sure that the list is working
			//System.out.println("The list will be shifted to the left " + d + " times.");	// for testing purpose double check the shift amount
			
			// For non-file input
			//System.out.println("Are you sure the list is in the correct order? ('yes' to continue)"); 
			//String answer = input.next();
			/*if (!(answer.equals("yes"))) {
				System.out.println("Run the program again!!!");
				input.close(); // close the scanner
				System.exit(0);
			}*/
			List<Integer> result = shiftLeft(list, d); // take the list and user the method shiftLeft
			
			/* for testing purposes
			 System.out.println("The returned list: " + result); // display the list
			 */
			
			for (Integer c: result) {
				System.out.print(c + " ");
			}
			
			input.close(); // close the scanner
			
		} catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			System.exit(0);
		} catch (InputMismatchException ex2) {
		    System.out.println("The input had a non-integer value, the program had to stop!!!");
		} catch(ArrayIndexOutOfBoundsException ex3) {
			System.out.println("You have entered a negative number for the array size!!!");
		}
		
	}
}
