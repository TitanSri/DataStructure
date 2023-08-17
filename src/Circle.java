/**
 * Tutorial 1
 * @author admin
 *
 */
public class Circle implements Cloneable{
	double radius;
	private int [] colour = {0,0,0}; // for RGB components
	
    Circle() {
           radius = 1.0;
    }
    Circle(double newRadius) {
           radius = newRadius;
    }
    
    double getArea() {
        return radius * radius * Math.PI;
    }

	public Object clone() {
		Object obj = null;
		try {
			// Both System and Your ways of clone
			obj = super.clone();
		}
		catch(CloneNotSupportedException e){
			System.out.println(e);
		}
		return obj;
	}
	
	public boolean equals(Object obj) {
		boolean sameValue = false;
		
		if (obj instanceof Circle) {
			// your comparison. Compare all the member
			sameValue = true;		
		}
		
		return sameValue;
	}
	
	public String toString() {
		// need to add color information here
		// a string of your way of printing
		return "The radius is: " + radius + "; The color is: " + colour[0] + " "; 
	}
}


