/**
 * R-1.5 Write a short Java method that takes an integer n and returns the sum of all positive integers less than or
 * equal to n. Note: this may take a long time to run
 * @author gdouzwt
 * @author TSrira - edited
 */
public class SumOfAllPositiveIntegers {
	/** the main to print the expression
	 * 
	 * @param args	default
	 */
	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		System.out.println("Max_Value: " + max);
        System.out.println("All Sum: " + allSum(max));
        System.out.println("Sum Of Positive:" + sumOfPositive(max));
        
    }

    /** All sum by using the sum of Arithmetic sequence equation
     * 
     * @param n	maximum integer value
     * @return	the sum of the max integer value
     */
    private static long allSum(long n) {
        if (n <= 0) {
            return 0;
        }
        return ((1 + n) * n) / 2;  // sum of Arithmetic sequence S = n(first number + last number) / 2 
    }

    /** loop to go through all the number 1 to the maximum integer
     * 
     * @param n	the maximum integer value
     * @return the sum 
     */
    private static long sumOfPositive(int n) {
        long sum = 0;
        int x = n - 1 ; // n crashes thus n - 1 is applied
        System.out.println("X_Value: " + x);
        for (int i = 1; i <= x; i++) {
            sum = sum + i;
        }
        return sum;
    }

}
