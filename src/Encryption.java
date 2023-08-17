import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**The Caesar cipher is one of the earliest known and simplest ciphers. 
 * It is a type of substitution cipher in which each letter in the plaintext is 'shifted' a certain number of places down the alphabet. 
 * For example, with a shift of 1 (i.e., key =1), A would be replaced by B, B would become C, and so on. 
 * The method is named after Julius Caesar, who apparently used it to communicate with his generals.
 * Once the end of the alphabet is reached, the characters wrap-around to the beginning once again 
 * (e.g., for key=3, the letter that is 3 after 'x' is 'a', 3 after 'y' is 'b'). 
 * Any spaces or special characters in the message should be keep as it is. All output should be rendered in lower case.
 * To give examples, for key=3, the message "Hello" would be encrypted as "khoor"; the message "I love cats" as "l oryh fdwv".
 */

public class Encryption {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //create a scanner
        
            Scanner input = new Scanner(System.in);
            String s = input.nextLine();
            int s2 = Integer.parseInt(s);
            int s3 = s2 % 26; //wrap around for the alphabet 
            String text = input.nextLine();
            text = text.toLowerCase(); //easier to work with lowercase
        
            // more methods to work with a string    
            StringBuffer results= new StringBuffer();
            
            // exclude numbers and special characters
            for (int i=0; i<text.length(); i++){
                if ((text.charAt(i) >= ' ')  && (text.charAt(i) <= '`')){
                results.append(text.charAt(i));
                continue;                
            }
            
            // left over special characters
            if ((text.charAt(i) >= '{')  && (text.charAt(i) <= '~')){
                results.append(text.charAt(i));
                    continue;                
            }
            
            // adds the number then reset the character to zero 
            // to ensure that the answer is in lower case after ASCII number 97
            // lower case characters start at 97
            else{
                char ch = (char)(((int)text.charAt(i) +
                                s2 - 97) % 26 + 97);
                results.append(ch);
            }
        }
        System.out.println(results);
    }
}