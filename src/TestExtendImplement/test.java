package TestExtendImplement;

public class test extends A implements C{
	public static void main(String [] args) {
		 C a = new test();
	      a.go();
	      
	      ABC abc = new EFG(); // creates ABC object using the EFG instance 
	      abc.methodOne(); // EFG method which extends to XYZ and uses methodOne  
	      					// where the body implements methodTwo(2) using 2 as the argument  
	      					// where XYZ implements PQR
	      					// PQR methodTwo changes the 2 to an int i
	}

}
