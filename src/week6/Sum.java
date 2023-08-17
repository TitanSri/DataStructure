package week6;

public class Sum{
// Evaluate the sum of the first n integers
	public static long recursiveSum( int n ){
		if( n == 1 ) {
			System.out.println( n );	
			return 1;
		}
		else {
			System.out.println( n );
			return recursiveSum( n - 1 ) + n;		
			}
	}
	// Testing
	public static void main( String [ ] args ){
	System.out.println( recursiveSum( 5 ) );
	}
}