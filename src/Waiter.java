/**
 * You are a waiter at a party. There is a pile of numbered plates. Create an empty answers array. At each iteration, i, 
 * remove each plate from the top of the stack in order. Determine if the number on the plate is evenly divisible by the i-th prime number. 
 * If it is, stack it in pile Bi. Otherwise, stack it in stack Ai. Store the values in Bi from top to bottom in answers. In the next iteration, 
 * do the same with the values in stack Ai. Once the required number of iterations is complete, store the remaining values in Ai in answers, 
 * again from top to bottom. Return the answers array.
https://www.hackerrank.com/contests/201830itc322week4/challenges/waiter/problem
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Waiter {
	public static void main(String[] args) throws IOException {
		File file = new File("waiter.txt");
		Scanner sc = new Scanner(file); //read data from a file
		
		// declaration 
		int N=sc.nextInt(), Q=sc.nextInt();
		
		// create a stack by looping through the list
        Stack<Integer> pile=new Stack<Integer>();
        for(int i=0; i<N; i++)
            pile.push(sc.nextInt());
        
        // convert to a list by casting
        List<Stack<Integer>> piles=new ArrayList<Stack<Integer>>();
        piles.add(pile);
        
        waiter(piles, Q);
        output(piles);
    }
    public static void waiter(List<Stack<Integer>> piles, int Q) {
        List<Integer> primes=getQPrimes( Q ); // get the primes i.e. id q is 1 than 2, q is 2 than 2 and 3...
        for(int p: primes){ // loops through the primes
            Stack<Integer> stack=piles.remove(piles.size()-1); // create a new stack
            System.out.println("The stack is: " + stack);
            Stack<Integer> divisable=new Stack<Integer>(); // stack for divisible
            Stack<Integer> notdivzab=new Stack<Integer>(); // stack for not divisible
            while(!stack.empty()) {
                int t=stack.pop(); // take the top number
                if(t%p==0) // divided by the primes
                    divisable.push(t); // add to divisible 
                else
                    notdivzab.push(t); // add to not divisible 
            }
            // the list will have 2 arrays i.e. [1,2][3,4,5]
            piles.add(divisable); // add the divisible first
            piles.add(notdivzab); // add the rest
            System.out.println("The list of stacks is: " + piles);
        }
    }
    
    // method to display the string
    public static void output(List<Stack<Integer>> piles) {
        StringBuilder sb=new StringBuilder();
        for(Stack<Integer> stack: piles) {
            while(!stack.empty())
                sb.append(stack.pop()+"\n"); // pop from the top of the stack
        }
        System.out.println(sb);
    }
    public static List<Integer> getQPrimes(int q) {
        List<Integer> res=new ArrayList<Integer>();
        BigInteger bi = BigInteger.valueOf(1);
        for(int i=0; i<q; i++){
            bi=bi.nextProbablePrime();//\\
            System.out.println("The Big Integer is: " + bi);
            res.add(bi.intValue());
        }
        System.out.println("The QPrimes: " + res);
        return res;
    }
}
	


