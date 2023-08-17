package week6;

public class WriteVertical {
	public static void writeVertical(int number){
		if (number<10)
			System.out.println("num" + number); // write one digit
		else {
			writeVertical(number/10); // write all but the last digit by loop to the first number 
			System.out.println("loop"+number%10); // write the last digit which is the second number then repeat to third, fourth and so on...
		}

	}

	// Testing
		public static void main( String [ ] args )
		{
		writeVertical(5123456);
		}
}