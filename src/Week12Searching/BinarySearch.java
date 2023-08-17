package Week12Searching;

public class BinarySearch {
	public static int binarySearchRec(int []a, int first, int size, int target){ //recursive 
		int middle;
		System.out.println(a[first] + " Rec size: " + size);
		if(size<=0)
			return -1;
		else
		{
			middle = first + size/2; // the middle index
			System.out.println("Middle: " + a[middle]);
			if(target == a[middle])
				return middle;
			else if(target<a[middle]) {
				System.out.println("Size/2: " + size/2);
				return binarySearchRec(a, first, size/2, target);
			}
			else {
				System.out.println("Size-1/2: " + (size-1)/2);
				return binarySearchRec(a, middle+1, (size-1)/2, target);
			}
		}
	}
	
	public static int binarySearch(int []a, int first, int last, int target){ // using the middle then middle of middle
		int middle;
		while(first<=last)
		{
			middle = (first+last)/2;
			if(target==a[middle])
				return middle;
			else if(target < a[middle])
				last = middle-1;
			else
				first = middle+1;
		}
		
		return -1;
	}
	

	public static void main(String[] args) {
		int data[] = {2, 3, 6, 9, 11, 19, 27, 30};
		
		// insert the array, first, index size, target
		System.out.println(binarySearch(data, 0, 7, 35));
		System.out.println(binarySearch(data, 0, 7, 30));
		System.out.println(binarySearch(data, 0, 7, 2));
		System.out.println(binarySearchRec(data, 0, 7, 11));

	}

}
