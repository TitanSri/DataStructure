import java.io.IOException;
import java.util.Stack;


/**Main, (2012), Section 6.2, pp. 309-313 for the basic algorithm description.
You need to understand:
what the problem is;
how the algorithm solves the problem using a stack.
You shall be able to present the algorithm in pseudocode.

The algoritm implementation is straightforward. Work through the design and implementation in the figure below to find how it is done.

Postcondition: A true return value indicates that the parentheses in the 
given expression are balanced. Otherwise, the return value is false. 
Note that characters other than ( ), { }, and [ ] are ignored. 

 @author Topic 4 text book main(2012)
 
 */

public class IsBalanced {
	 public static void main(String[] args) throws IOException {
	    	
    	String s = "{A(1{cat}2)(dog)[rabbit]B}";
    	System.out.println(IsBalanced.isBalanced(s));
	    			
    }
    //A Method Implementation 
    public static boolean isBalanced(String expression) { 
  
    	// Meaningful names for characters 
    	final char LEFT_NORMAL = '('; final char RIGHT_NORMAL = ')'; 
    	final char LEFT_CURLY = '{'; final char RIGHT_CURLY = '}'; 
    	final char LEFT_SQUARE = '['; final char RIGHT_SQUARE = ']'; 
    	Stack<Character> store = new Stack<Character>(); // From java.util.Stack 
    	int i; // An index into the string 
    	boolean failed = false; // Change to true for a mismatch  
    	for (i = 0; !failed && (i  < expression.length( )); i++){
    		switch (expression.charAt(i)) { 
    			case LEFT_NORMAL: 
    			case LEFT_CURLY: 
    			case LEFT_SQUARE: 
    					store.push(expression.charAt(i)); 
    					break; 
    			case RIGHT_NORMAL: 
    				if (store.isEmpty( ) || (store.pop() != LEFT_NORMAL)) // pops the stack than checks
    						failed = true; 
    				break; 
    			case RIGHT_CURLY: 
    				if (store.isEmpty( ) || (store.pop() != LEFT_CURLY))  // pops the stack than checks
    						failed = true; 
    				break; 
    			case RIGHT_SQUARE: 
    				if (store.isEmpty( ) || (store.pop() !=  LEFT_SQUARE))  // pops the stack than checks
    						failed = true; 
    					break; 
    			} 
    	} 
    	System.out.println("Is the store empty? " + store.isEmpty());
    	System.out.println(!failed);
    	return (store.isEmpty( ) && !failed); 
    }
}


