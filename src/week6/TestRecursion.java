package week6;

public class TestRecursion {
	
	public static long factorial(long n) {
		//complete this implementation using recursion
		if(n==1)
			return 1;
		else
			return n * factorial(n-1);				
		
	}
	
	public static void towerOfHanoi(int n, String source, String target, String aux)
	{
		//complete this implementation using recursion
		if(n==1)
			System.out.println(" 1 move disk "+n+" from "+source+" to "+target);
		else {
			//System.out.println("Before Disk: "+n+" Source: "+source+" Target: "+target+" Aux: "+aux);
			towerOfHanoi(n-1, source, aux, target); // swaps the target
			System.out.println("move disk "+n+" from "+source+" to "+target);
			towerOfHanoi(n-1, aux, target, source); // swaps the source with the aux
			System.out.println("Aux move disk "+n+" from "+source+" to "+target);
			
		}
	}
	
	public static void numToPattern(int n, int m){ //two input parameter
        if (n<=0)
            return;
        else {
            System.out.print(new String(new char[m]).replace("\0", "*"));
            System.out.println();
            numToPattern(n-1,m+1);
            System.out.print(new String(new char[m]).replace("\0", "*"));
            System.out.println();
        }
    }

	public static void main(String[] args) {
//		System.out.println("Factorial: " + factorial(4));
//		towerOfHanoi(3, "A", "C", "B");
		numToPattern(6,2);
	}

}
