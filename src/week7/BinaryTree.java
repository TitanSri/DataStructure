package week7;

/**
 * http://www.sanfoundry.com/java-program-implement-binary-tree/
 * @author Dell
 *
 * @param <E>
 */

public class BinaryTree <E>{
	     private BTNode <E> root;	     

	     /* Constructor */

	     public BinaryTree ()
	     {
	         root = null;
	     }

	     /* Function to check if tree is empty */
	     public boolean isEmpty()
	     {
	         return root == null;
	     }

	     /* Functions to insert data */
	     public void insert(E data)
	     {
	         root = insert(root, data);
	     }

	     /* Function to insert data recursively */
	     private BTNode <E> insert(BTNode <E> node, E data)
	     {
	         if (node == null)
	             node = new BTNode <E> (data, null, null);
	         else {
	             if (node.getRight() == null)
	                 node.setRight(insert(node.getRight(), data));
	             else
	                 node.setLeft(insert(node.getLeft(), data));       
	         }

	         return node;

	     }     

	     /* Function to search for an element */

	     public boolean search(E val)
	     {
	         return search(root, val);
	     }

	     /* Function to search for an element recursively */

	     private boolean search(BTNode <? super E> node, E val)
	     {
	         if (node.getData().equals(val))
	             return true;

	         if (node.getLeft() != null)
	             if (search(node.getLeft(), val))
	                 return true;

	         if (node.getRight() != null)
	             if (search(node.getRight(), val))
	                 return true;

	         return false;         
	     }

	     /* Function for inorder traversal */

	     public void inorder()
	     {
	         inorder(root);
	     }

	     private void inorder(BTNode <? super E> node)
	     {
	         if (node != null)
	         {
	             inorder(node.getLeft());
	             System.out.print(node.getData() +" ");

	             inorder(node.getRight());
	         }

	     }

	     /* Function for preorder traversal */

	     public void preorder()
	     {
	         preorder(root);
	     }

	     private void preorder(BTNode <? super E> node)
	     {
	         if (node != null)
	         {
	             System.out.print(node.getData() +" ");
	             preorder(node.getLeft());             
	             preorder(node.getRight());

	         }

	     }

	     /* Function for postorder traversal */

	     public void postorder()
	     {
	         postorder(root);
	     }

	     private void postorder(BTNode <? super E> node)
	     {
	         if (node != null)
	         {
	             postorder(node.getLeft());             
	             postorder(node.getRight());
	             System.out.print(node.getData() +" ");
	         }

	     }     
	 }