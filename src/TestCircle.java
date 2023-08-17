
public class TestCircle {
	public static void main(String[] args) {
    	Circle myCircle = new Circle(5.0);
        System.out.println("The area of the circle of radius " + myCircle.radius + " is " + myCircle.getArea());
        Circle yourCircle = new Circle();
        System.out.println("The area of the circle of radius " + yourCircle.radius + " is " + yourCircle.getArea());
        Circle yourCircleCloned = (Circle) yourCircle.clone();
        System.out.println(yourCircle);
        System.out.println("Is your cloned = yourcircle? " + yourCircleCloned.equals(yourCircle));
        System.out.println("Is your cloned = mycircle? " + yourCircleCloned.equals(myCircle));
        
   }
}

