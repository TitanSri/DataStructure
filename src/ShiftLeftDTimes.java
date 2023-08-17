import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ShiftLeftDTimes {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = rotateLeft(d, arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        System.out.println(result);
    }
	

	    /*
	     * Complete the 'rotateLeft' function below.
	     *
	     * The function is expected to return an INTEGER_ARRAY.
	     * The function accepts following parameters:
	     *  1. INTEGER d
	     *  2. INTEGER_ARRAY arr
	     */

	 public static List<Integer> rotateLeft(int d, List<Integer> arr) {
	    // Write your code here
	        Integer[] temp = new Integer[arr.size()]; //converts the list to an array
	        arr.toArray(temp); // copies the list to the array
	        
	        for (int j = 0; j < d; j++){ // shift amount of d times
	            int t = temp[0]; // saves the first index
	            for (int i=0; i<temp.length-1; ++i) {
	                temp[i] = temp[i+1]; // shifts left
	            }
	            temp[temp.length-1] = t; // copyies the first to the last index
	        }
	        List<Integer> returnList = Arrays.asList(temp); // converts the array to a list
	        return returnList;
	    

	}
}


