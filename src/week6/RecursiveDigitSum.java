package week6;
import java.util.*;
/**https://www.hackerrank.com/contests/201830itc322week6/challenges/recursive-digit-sum
 * We define super digit of an integer  using the following rules:
Given an integer, we need to find the super digit of the integer.
If  has only  digit, then its super digit is .
Otherwise, the super digit of  is equal to the super digit of the sum of the digits of .
For example, the super digit of  will be calculated as:
	super_digit(9875)   	9+8+7+5 = 29 
	super_digit(29) 	2 + 9 = 11
	super_digit(11)		1 + 1 = 2
	super_digit(2)		= 2  
Example
The number  is created by concatenating the string   times so the initial .
    superDigit(p) = superDigit(9875987598759875)
                  9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
    superDigit(p) = superDigit(116)
                  1+1+6 = 8
    superDigit(p) = superDigit(8)
All of the digits of  sum to . The digits of  sum to .  is only one digit, so it is the super digit.
Function Description
Complete the function superDigit in the editor below. It must return the calculated super digit as an integer.
SuperDigit has the following parameter(s):
string n: a string representation of an integer
int k: the times to concatenate  to make 
Returns
int: the super digit of  repeated  times
Input Format
The first line contains two space separated integers,  and .
Constraints
Sample Input 0
148 3
Sample Output 0
3
Explanation 0
Here  and , so .
super_digit(P) = super_digit(148148148) 
               = super_digit(1+4+8+1+4+8+1+4+8)
               = super_digit(39)
               = super_digit(3+9)
               = super_digit(12)
               = super_digit(1+2)
               = super_digit(3)
               = 3
Sample Input 1
9875 4
Sample Output 1
8
Sample Input 2
123 3
Sample Output 2
9
Explanation 2
Here  and , so .
super_digit(P) = super_digit(123123123) 
               = super_digit(1+2+3+1+2+3+1+2+3)
               = super_digit(18)
               = super_digit(1+8)
               = super_digit(9)
               = 9
 * @author admin
 *
 */
public class RecursiveDigitSum {
	public static void main(String[] args) {
		// RecursiveDigitSum s = new RecursiveDigitSum(); //no need for casting at ^^^ and changed the method
		Scanner sc = new Scanner(System.in);
		
		String str_n = sc.next();
		int k = sc.nextInt();
		
		int pSum = Integer.parseInt(superDigit(str_n)); // create the sum of the string (^^^ removed s.superDigit)
		pSum *= k; // multiple the total of the string by k times
		System.out.println("The pSum is: "+ pSum);
		
		String lastDigit = Integer.toString(superDigit(pSum)); // add the each digit until one digit total is given(^^^ removed s.superDigit)
		
		System.out.println(lastDigit);
	}
	
	// work with a string for the total of the original string (^^^ made the method static)
	static String superDigit(String n) {
		System.out.println("The n is: "+ n);
		// the stopper for the recursive
		if(n.length() == 1)
			return n; 
		// add each character to get a total
		else {
			int sum = 0; // the sum 
			for(int i = 0; i < n.length(); i++) {
				sum += Character.getNumericValue(n.charAt(i));
			}
			System.out.println("The sum is: "+ sum);
			return superDigit(Integer.toString(sum)); // do it again until one digit is left
		}
	}
	// work with a integer(pSum) string total times k (^^^ made the method static)
	static int superDigit(int n) {
		System.out.println("The n2 is: "+ n);
		// if the last digit
		if(n/10==0)
			return n;
		else {
			int r = 0; // the remainder
			while (n>0) {
				System.out.println("The remainder is: "+ r);
				r += n%10; 
				n /= 10; // loop until the remainder is one digit
				System.out.println("The n2 is: "+ n);
			}
			System.out.println("The total of remainder is: "+ r);
			return superDigit(r); // loop if r is not one digit
		}
		
	}
	

}
