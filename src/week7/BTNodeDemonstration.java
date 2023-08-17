package week7;

/**
 * 
 * To test tree traversal using the example described in the textbook section 9.4
 * 
 **/


public class BTNodeDemonstration {
	
	public static void main(String[] args) {
		
		  // setting up the tree as in page 485 of the text book, ie:
		  //
		  //                       14  
		  //                       / \
		  //                      17  11
		  //                     / \
		  //                    9   53
		  //                     \ 
		  //                     13                       
	      BTNode <Integer> leftChild = new BTNode<Integer>(17, null, null);
	      leftChild.setLeft(new BTNode<Integer>(9, null, new BTNode<Integer>( 13, null, null)));
	      leftChild.setRight(new BTNode<Integer>(53, null, null));
	      BTNode <Integer> rightChild = new BTNode<Integer>(11, null, null);
          BTNode <Integer>root = new BTNode<Integer> (14, leftChild, rightChild);

          // testing pre-order traversal
          System.out.printf("%nPre-order traversal: root, left then right%n");
	      root.preorderPrint(); // root, left then right     

          // testing in-order traversal
          System.out.printf("%nIn-order traversal: left, root, then right%n");
	      root.inorderPrint(); // root, left then right     

          // testing post-order traversal
          System.out.printf("%nPost-order traversal: left, right, then root%n");
	      root.postorderPrint(); // root, left then right  
	      
	   // testing tree-size
          System.out.printf("%nTree Size%n");
	      System.out.println(root.treeSize(root)); // root, left then right  
	}
}