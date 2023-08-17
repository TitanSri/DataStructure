package week6;
/**Objective
In this challenge, we learn how to compute GCD using the Euclidean algorithm.
Given two integers,  and , a recursive technique to find their GCD is the Euclidean Algorithm.
The algorithm states that, for computing the GCD of two positive integers  and , if  and  are equal, . Otherwise  if . There are a few optimizations that can be made to the above logic to arrive at a more efficient implementation.
Task
Given the starter code, you need to complete a function body that returns the GCD of two given integers  and .
The task of reading in input and printing the output will be handled by us.
Programming Language Support
At this point of time, we have a template for Scala. This means that we provide the code required to accept the input and display the output.
Input Format
One line of input containing  space separated integers.
Output Format
Output one integer, the GCD of the two given numbers.
Sample Input
1 5 
Sample Output
1
Explanation
Sample Return Values:
GCD(1,5) = 1  
GCD(10,100) = 10  
GCD(22,131) = 1
GCD(1701,3768) = 3

https://www.hackerrank.com/contests/201830itc322week6/challenges/functional-programming-warmups-in-recursion---gcd
 */
import java.util.Scanner;

public class ComputingTheGCD {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int gcd = findGCD(x,y);
        System.out.println(gcd);
    }     
	
	// GCD, we divide the high by the low and the remainder becomes the new low, the previous low becomes the new high
    public static int findGCD(int x,int y){
        if (x==y)
            return x;
        int lowPrime = Math.max(x,y)%Math.min(x,y); // switch x and y if required; make the remainder the low prime
        System.out.println("Remainder(new Low): "+lowPrime);
        if (lowPrime == 0) // return the low number if the remainder is zero
        	return y;
        int highPrime = Math.min(x,y); // next highest number
        System.out.println("Low (new High): "+highPrime);
        System.out.println("Next loop is "+highPrime+" divided by "+lowPrime);
        return findGCD(highPrime,lowPrime);

    }
    
}