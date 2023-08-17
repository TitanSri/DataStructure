import java.io.IOException;

/**Given a string of lowercase letters in the range ascii[a-z], 
 * determine the index of a character that can be removed to make the string a palindrome. 
 * There may be more than one solution, but any will do. 
 * If the word is already a palindrome or there is no solution, return -1. 
 * Otherwise, return the index of a character to remove.
 * 
 * @author Tsrira
 *
 */

public class Palindrome {
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		String s = "qwertrewq"; // set the string
        sb.append(s);
         		   
	    //System.out.println(isPalindrome(sb));
	    System.out.println(palindromeIndex(s));
	    
	}
	/**
	 * 
	 * @param sb1
	 * @return
	 */
	public static boolean isPalindrome(StringBuffer sb1) {
	    // Write your code here
	        
	        boolean flag = true;
	        if (sb1.toString().equals(sb1.reverse().toString())) { // this will reverse the string buffer
	        		System.out.println("isPalidrome true: " + sb1);
	        		sb1.reverse(); // reverse the string buffer back
	        		System.out.println("isPalidrome true after reverse: " + sb1);
	                flag = true;
	        }
	        else flag = false;
	        sb1.reverse(); // reverse the string buffer back
	        System.out.println("exiting isPalindrome: " + sb1 + " " + flag);
	        return flag;
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	public static int palindromeIndex(String s) {
        StringBuffer sb2 = new StringBuffer();
        sb2.append(s);
        char ch = 'z';
        System.out.println("palindromeIndex start: " + sb2);
        if (isPalindrome(sb2)) {
        	System.out.println("No need to check: " + sb2);
            return -1;
        }
        else {
            for (int i = 0; i < sb2.length()+1; i++){
            	System.out.println("i is: " + i);
                
            	if (i-1 >= 0) {
            		sb2.insert(i-1, ch);
            		System.out.println("after inserting: " + ch + " at " + i + "-1 is " + sb2);
            	}
                
            	ch = sb2.charAt(i);
            	System.out.println("ch is: " + ch);
                System.out.println("before deleting a character at: " + i + " "+ sb2);
                sb2.deleteCharAt(i);
                System.out.println("after deleting a character: " + sb2);
                if (isPalindrome(sb2)) {
                	sb2.reverse();
                	System.out.println("Successful after removing index: ");
                    return i;
                }
                else {
                	System.out.println("looping");
                }
            }
            
        }
        return 99;
    }    
}