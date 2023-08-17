import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * An array is a type of data structure that stores elements of the same type in a contiguous block of memory. 
 * In an array, , of size , each memory location has some unique index,  (where ), that can be referenced as  or .
 * Reverse an array of integers.
 * Note: If you've already solved our C++ domain's Arrays Introduction challenge, you may want to skip this.
 * @author HackerRank
 *
 */

public class ReverseListArray {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
        // Not sure how the input works i.e. first line has to be 1 then second line is *
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH"))); 
        // Not sure how the output works
		

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> res = Result.reverseArray(arr);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        System.out.println(res);
    }
}

class Result {

    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {
    // Write your code here
        for (int i = 0, j = a.size() - 1; i < j; i++){ // loops the through the array from from front for i
            // then moves from the back for J, this will occur while i is less than the length
            a.add(i,a.remove(j)); // adds the last index to the front i value
        }
            
        return a;
            
            

    }

}

    
