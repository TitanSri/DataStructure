package Week8Graphs;


public class TestGraph {

	public static void main(String[] args) {
		// Normal Graph
		Graph graph = new Graph(9);
		
		for (int i=0; i < graph.size(); i++)
			graph.setLabel(i, Integer.toString(i+1));

		addUndirectedEdge(graph, 0, 4);
		addUndirectedEdge(graph,4, 3);
		addUndirectedEdge(graph,4, 5);
		
		addUndirectedEdge(graph,3, 2);
		addUndirectedEdge(graph,3, 6);
		
		addUndirectedEdge(graph,2, 1);
		addUndirectedEdge(graph,2, 8);
		
		addUndirectedEdge(graph,5, 7);
		addUndirectedEdge(graph,6, 8);

		System.out.println("\nStart is 0");
		Graph.depthFirstPrint(graph, 0);
		
		System.out.println("\nStart is 3");
		Graph.depthFirstPrint(graph, 3);
		
		System.out.println("\nNeighbours of node 3");
		int [] neighbours = graph.neighbors(3);
		
		for (int i = 0; i < neighbours.length; i++)
			System.out.println(neighbours[i]);
		
		// To demonstrate the depth first graph (no labels) traversal 
		// and breadth first traversal?
//		Graph graph750 = new Graph(7);
//
//		for (int i=0; i < graph750.size(); i++)
//			graph750.setLabel(i, Integer.toString(i));
//		
//		graph750.addEdge(0, 1);
//		graph750.addEdge(0, 4);
//		
//		graph750.addEdge(1, 3);
//		
//		graph750.addEdge(2, 0);
//		
//		graph750.addEdge(3, 0);
//		graph750.addEdge(3, 5);
//		graph750.addEdge(3, 6);
//		
//		graph750.addEdge(6, 1);
//
//		System.out.println("\n\nStart is 0");
//		Graph.depthFirstPrint(graph750, 0);
		
		/*
		 * Graph g = new Graph(9);
		 * 
		 * for(int i=0; i<9; ++i) g.setLabel(i, "Person"+(i+1));
		 * 
		 * g.addEdge(0, 4); g.addEdge(4, 0);
		 * 
		 * g.addEdge(4, 5); g.addEdge(5, 4);
		 * 
		 * g.addEdge(5, 7); g.addEdge(7, 5);
		 * 
		 * g.addEdge(4, 3); g.addEdge(3, 4);
		 * 
		 * g.addEdge(3, 2); g.addEdge(2, 3);
		 * 
		 * g.addEdge(2, 1); g.addEdge(1, 2);
		 * 
		 * g.addEdge(3, 6); g.addEdge(6, 3);
		 * 
		 * g.addEdge(6, 8); g.addEdge(8, 6);
		 * 
		 * g.addEdge(2, 8); g.addEdge(8, 2);
		 * 
		 * //Graph.depthFirstPrint(g, 0); displayFriends(g, "Person4");
		 */
		
		/*
		 * g.setLabel(0, "1"); g.setLabel(1, "2"); g.setLabel(2, "3");
		 */
		
		// test Dijkstra
		WeightedGraph g = new WeightedGraph(9);
		for(int i=0; i<9; ++i) 
			g.setLabel(i, (i+1)+"");
		
		 g.addEdge(0, 4, 4); g.addEdge(4, 0, 4);
		 
		 g.addEdge(4, 5, 7); g.addEdge(5, 4, 7);
		 
		 g.addEdge(5, 7, 12); g.addEdge(7, 5, 12);
		  
		 g.addEdge(4, 3, 3); g.addEdge(3, 4, 3);
		  
		 g.addEdge(3, 2, 11); g.addEdge(2, 3, 11);
		  
		 g.addEdge(2, 1, 5); g.addEdge(1, 2, 5);
		 
		 g.addEdge(1,  4, 4); g.addEdge(4, 1, 4);
		  
		 g.addEdge(3, 6, 9); g.addEdge(6, 3, 9);
		  
		 g.addEdge(6, 8, 6); g.addEdge(8, 6, 6);
		  
		 g.addEdge(2, 8, 8); g.addEdge(8, 2, 8);
		 
		 g.addEdge(6, 7, 2); g.addEdge(7, 6, 2);
		 
		 int[] vertexlist = Dijkstra.dijkstra(g, 0); // returns an array with all the paths for all vertices
		 System.out.println("\nDijkstra's path: ");
		 Dijkstra.printPath(g, vertexlist, 0, 8); // prints only the path not the whole array
		 
		 // get neighbor of vertex
		 int vertex = 3;
		 System.out.println("\n\nVertex: " + vertex);
		 int [] answer = g.neighbors(vertex);
		 for (int i = 0; i < answer.length; i++) {
			 int num = answer[i];
			 System.out.println("The neighbor is:" + num);
		 }

	}

    public static void addUndirectedEdge(Graph graph, int source, int target){
    	graph.addEdge(source, target);
    	graph.addEdge(target, source);
    }
    
    public static void displayFriends(Graph g, Object user) {
		int[] friends = g.neighbors(g.getVertexIndex(user));
		for(int j = 0; j < friends.length; ++j)
			System.out.print(g.getLabel(friends[j])+" ");
	}
}

		
		
		