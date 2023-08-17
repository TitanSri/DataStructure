package week7;

import java.util.*;
import java.io.*;
/**
 * https://www.hackerrank.com/contests/itc322tree/challenges
 * Sample Input

6
4 2 3 1 7 6
1 7

 * @author admin
 *
 */
public class BinarySearchTree {
	public static Node insert(Node root,int data) {
        if (root == null) {
                root = new Node(data);
        }
        else if (root.data > data){
            if (root.left == null){
                Node left = new Node(data);
                root.left = left;
            }
            else insert(root.left, data);   
        }
        else if (root.data < data){
            if (root.right == null){
                Node right = new Node(data);
                root.right = right;
            }
            else insert(root.right, data);
        }
         return root;    
    }
	
	public static void preOrder( Node root ) {	      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }
	
	public static void inOrder(Node root) {
	    if (root == null) 
	        return;
	    inOrder(root.left);
	    System.out.print(root.data + " ");
	    inOrder(root.right);
	}
	
	public static void postOrder(Node root) {
        if (root == null) { return; }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
	
	public static Node lca(Node root, int v1, int v2) {
      	// compare the two with the parent
        int min = Math.min(v1, v2);
        int max = Math.max(v1, v2);
        if (root.data >= min && root.data <= max)
             return root;
        else if (root.data > min && root.data > max)
            return lca(root.left, v1, v2);
        else return lca(root.right, v1, v2);
             
    }
	
	public static int height(Node root) {
      	// The root is depth/height 0
        if (root == null)
            return -1;
        else return 1+Math.max(height(root.left), height(root.right));
        
    }
	
	static boolean checkBST(Node root) {  
        // start the check with min and max value
        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
     
    
    private static boolean checkBSTHelper(Node n, int min, int max) {
        if (n == null) return true;
        if (n.data <= min || n.data >= max) return false;
        return checkBSTHelper(n.left, min, n.data) && checkBSTHelper(n.right, n.data, max);
    }
    
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println("\nLower Common Ancestor: " + ans.data);
      	System.out.println("\nPreorder: ");
      	preOrder(root);
      	System.out.println("\nInorder: ");
      	inOrder(root);
      	System.out.println("\nPostorder: ");
      	postOrder(root);
      	System.out.println("\n\nDepth: " + height(root));
      	System.out.println("\nCheck Bianry Search Tree: " + checkBST(root));
    }	

}
