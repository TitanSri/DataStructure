import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**You have an empty sequence, and you will be given  queries. Each query is one of these three types:

1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.
Function Description

Complete the getMax function in the editor below.

getMax has the following parameters:
- string operations[n]: operations as strings

Returns
- int[]: the answers to each type 3 query

Input Format

The first line of input contains an integer, . The next  lines each contain an above mentioned query.

Constraints

Constraints



All queries are valid.

Sample Input

STDIN   Function
-----   --------
10      operations[] size n = 10
1 97    operations = ['1 97', '2', '1 20', ....]
2
1 20
2
1 26
1 20
2
3
1 91
3
Sample Output

26
91
 * 
 * @author https://hackerranksolution.in/maximumelementds/
 * @author Toby Sriratanakoul (editor)
 *
 */


public class MaximumElement {
    public static void main(String[] args) throws IOException {
    	File file = new File("MaxElement.txt");
		Scanner sc = new Scanner(file); //read data from a file
		
        int n = Integer.parseInt(sc.nextLine().trim()); // the array size from the input

        List<String> ops = new ArrayList<>(); 
        
        // loop through the file and add to the list
        for (int i = 0; i < n; i++) {
            String opsItem = sc.nextLine();
            ops.add(opsItem);
        }

        List<Integer> res = getMax(ops);
        System.out.println("The numbers in the max stack are: " + res);
    }
    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> ops) {
    // Write your code here
        Stack<Integer> stack = new Stack<Integer>(); // create a new stack 
        Stack<Integer> onlyMaxs = new Stack<Integer>(); // create a new stack for max
        List<Integer> resultStack = new ArrayList<>(); // create a new stack for max  
        List<String> tempList = ops; // copy the list
        System.out.println(tempList);
        int temp = 0;
        String type = null;
		for (int i = 0 ; i < tempList.size(); i++) {
	        type = tempList.get(i); // get the first index string
	        System.out.println(type);
	        String[] split = type.split(" "); // split the first index 
	        switch(split[0])
            {
                case "1": // add to the stack
                temp = Integer.parseInt(split[1]);
                stack.push(temp);
                 if(onlyMaxs.isEmpty() || onlyMaxs.peek() <= temp)
                     onlyMaxs.push(temp);
                break;
                case "2": // remove from the stack
                temp = stack.pop();
                if(temp == onlyMaxs.peek())
                    onlyMaxs.pop();
                break;
                case "3": // display the max and add to the result stack
                System.out.println(onlyMaxs.peek());
                temp = onlyMaxs.peek();
                resultStack.add(temp);
            }
	        System.out.println("The numbers in the stack are: " + stack);
			System.out.println("The numbers in the max stack are: " + onlyMaxs);
        }
        return resultStack;
    }
}
