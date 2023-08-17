
public class TestStringNode {
	public static void main(String[] args) {
	    // Create a File instance
	    StringNode citylist = new StringNode("Sydney", null);
	    citylist.addNodeAfter("Beijing");
	    citylist.addNodeAfter("Melbourne");
	    System.out.println("The total number of elements is " + StringNode.listLength(citylist));
	    StringNode copyList = StringNode.listCopy(citylist);
	    StringNode targetNode = StringNode.listSearch(copyList, "Beijing");
	    System.out.println("The city is " + targetNode.getData());
	    System.out.println("The link is " + targetNode.getLink());
	    
	    // prints the whole list
	    for (int i = 1; i <= StringNode.listLength(citylist); i++) {
	    	StringNode targetNode9 = StringNode.listPosition(citylist, i);
	    	System.out.println("The city is " + targetNode9.getData());
	    }
	    
	    /** too long
	    StringNode targetNode1 = StringNode.listPosition(citylist, 1);
	    StringNode targetNode2 = StringNode.listPosition(citylist, 2);
	    StringNode targetNode3 = StringNode.listPosition(citylist, 3);
	    System.out.println("The city is " + targetNode1.getData());
	    System.out.println("The city is " + targetNode2.getData());
	    System.out.println("The city is " + targetNode3.getData());
	    */
	    
	    System.out.println("The city list is " + StringNode.toString(citylist));
	    
	}
}



