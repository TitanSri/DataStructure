package Week12Searching;
/**Hash Table
 * 
 * @author admin
 *
 */

public class TestTable {
	public static void main(String[] args){
		Table table = new Table(5); // max index number 0 to 5, 6 elements
		
		System.out.println("Add index 0: " + table.put(0, 10));
		System.out.println("Add index 199: " + table.put(199, 20));
		System.out.println("Add index 299: " + table.put(299, 30));
		System.out.println("Add index 399: " + table.put(399, 40));
		System.out.println("Add index 0: " + table.put(4, 50));
		
		System.out.println("Contains 199: " + table.containsKey(199));
		System.out.println("Element 199: " + table.get(199));
		System.out.println("Contains 4: " + table.containsKey(4));
		System.out.println("Element 4: " + table.get(4));
		System.out.println("Remove 4: " + table.remove(4));
		System.out.println("Contains 4: " + table.containsKey(4));
		System.out.println("Element 4: " + table.get(4));
		
		System.out.println("Element 0: " + table.get(0));
		System.out.println("Put 0: 100");
		System.out.println("Override the old element: " + table.put(0, 100));
		System.out.println("Element 0: " + table.get(0));
		
		System.out.println("Add one more and return old element: " + table.put(5, 60));
		System.out.println("Element 5: " + table.get(5));
		//System.out.println("Element 1: " + table.get(1));
		
	}
	

}
