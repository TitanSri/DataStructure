import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class QueueUsingTwoStacks {
	public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		File file = new File("Queue.txt");
		Scanner sc = new Scanner(file); //read data from a file
        int queues = sc.nextInt();
        
        LinkedList<Integer> list = new LinkedList<>();
        
        while (queues-- > 0){
            int ops = sc.nextInt();
            switch(ops){
                    case 1: 
                    	int num = sc.nextInt();
                        list.add(num);
                        System.out.println("After adding " + num + list);
                        break;
                    case 2: 
                        list.pollFirst();
                        System.out.println("After removing "  + list);
                        break;
                    case 3:
                        System.out.println("The first number on the list: " + list.getFirst());
                        break;
                    
            }
            
                    
        }
            
        
    }
}
