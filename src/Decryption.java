import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * The Caesar cipher is one of the earliest known and simplest ciphers. 
 * It is a type of substitution cipher in which each letter in the plaintext is 'shifted' a certain number of places down the alphabet, 
 * called Encryption. For example, with a shift of 1 (i.e., key =1), A would be replaced by B, B would become C, and so on. 
 * The method is named after Julius Caesar, who apparently used it to communicate with his generals.
 * Decryption is the reverse of Encryption. 
 * That is, each letter from the encrypted text should be replaced with the one that is 'n' (key) places earlier in the alphabet, 
 * noting the wrap-around rules, i.e., once the beginning of the alphabet is reached the characters wrap-around to the ending once again 
 * (e.g., for key=3, the letter that is 3 before 'a' is 'x', 3 before 'b' is 'y'). 
 * Any spaces or special characters in the message should be keep as it is. All output should be rendered in lower case.
 * To give examples, for key=3, the message "Khoor" would be encrypted as "hello"; the message "l oryh fdwv" as "i love cats".
 * @author Tsrira
 *
 */
public class Decryption {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    String s = input.nextLine();
	    int s2 = Integer.parseInt(s);
	    int s3 = s2 % 26; // makes sure that the alphabet wraps around from z to a
	    String text = input.nextLine();
	    text = text.toLowerCase();
	        
	    StringBuffer results= new StringBuffer();
	
	    for (int i=0; i<text.length(); i++){
	        if ((text.charAt(i) >= ' ')  && (text.charAt(i) <= '`')){
	        results.append(text.charAt(i));
	        continue;                
	        }
	            
	        if ((text.charAt(i) >= '{')  && (text.charAt(i) <= '~')){
	        	results.append(text.charAt(i));
	            continue;                
	        }
	    
	        else{
	        	int num = (((int)text.charAt(i) -
	                        s3 - 97) + 97);
	        	
	        	// if the ASCII is less than 97 which is below the lower case alphabet
	        	if (num < 97)
	        		num += 26; 
	        	char ch = (char)(num);
	        	results.append(ch);
	        }
	    
	   }
	   System.out.println(results);
	}
}
