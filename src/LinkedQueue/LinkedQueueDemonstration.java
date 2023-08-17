package LinkedQueue;

/**
 * 
 */

/**
 * @author Suryani Lim
 * @version 28 March 2016
 *  To demonstrate the use of Queues implemented using arrays as described in (Main 2016)
 *  
 *
 */
public class LinkedQueueDemonstration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedQueue<Integer> intQueue = new LinkedQueue<Integer>();
		System.out.println("Enqueue  8 4 6 9 ");
		intQueue.add(8);
		intQueue.add(4);
		intQueue.add(6);
		intQueue.add(9);
		
		System.out.println("Dequeu");
		System.out.print(intQueue.remove() + "  ");
		System.out.print(intQueue.remove() + "  ");
		System.out.println(intQueue.remove());
		
		System.out.println("Enqueue  12 15 18");
		intQueue.add(12);
		intQueue.add(15);
		intQueue.add(18);
		
		System.out.println("Dequeu");
		System.out.print(intQueue.remove() + "  ");
		System.out.print(intQueue.remove() + "  ");
		System.out.println(intQueue.remove());		
		
		System.out.print(intQueue.remove() + "  ");
		//System.out.println(intQueue.remove());
		
		
		//Using an iterator
		System.out.println("\n\nEnqueue  8 4 6 9 ");
		intQueue.add(8);
		intQueue.add(4);
		intQueue.add(6);
		intQueue.add(9);
		
		System.out.println("Dequeu using an iterator");
		Lister <Integer> iterate = intQueue.iterator();  // the iterator() method must be defined in LinkedBag
	    int count = 0;
	      while(iterate.hasNext()){
	    	  System.out.print(iterate.next() + " ");
	    	  count++;
	      }   
	}

}
