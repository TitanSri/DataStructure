package week6;

import java.util.Scanner;

/**
 * The Fibonacci sequence begins with fibonacci(0)=0 and fibonacci(1) = 1 as its respective first and second terms. 
 * After these first two elements, each subsequent element is equal to the sum of the previous two elements.
Here is the basic information you need to calculate fibonacci(n):
fibonacci(0) = 0
fibonacci(1) = 1
fibonacci(n) = fibonacci(n-1)+fibonacci(n-2)
Task Given n, complete the fibonacci function so it returns.
Input Format
Locked stub code in the editor reads a single integer denoting the value of n and passes it to the fibonacci function.
Constraints
0
Output Format
Locked stub code in the editor prints the value of fibonacci(n) returned by the fibonacci function.
Sample Input 0
3
Sample Output 0
2
Explanation 0
Consider the Fibonacci sequence: 
fibonacci(0)=1 
fibonacci(1)=1 
fibonacci(2)=(0+1)=1 
fibonacci(3)=(1+1)=2 
fibonacci(4)=(1+2)=3 ... 
we want to know the value of fibonacci(3). if we look at the sequency above, fibonacci(3) evaluates to 2. Thus we print 2 as our answer.
 * @author admin
 *
 */
public class RecursiveFibonacci {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        
        System.out.println(fib(f));
	}
	// fibonacci method which is f(n-1) + f(n-2)
    static int fib(int n){
        if (n==0)
            return 0;
        else if (n==1)
            return 1;
        return (fib(n-1) + fib(n-2));
    }
    
}

