package week5;
/**
 * package week5;
 * 
 * 26/3/22
 */
import java.util.Iterator;

public class TestLinkedBag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBag<String> studentList = new LinkedBag<String>();
		studentList.add("ABC"); // adds to the head
		studentList.add("ZXC"); // adds to the head
		studentList.add("WWW"); // adds to the head
		
		//iterator application
		for(String student: studentList)
			System.out.println(student);
	
		
	}

}