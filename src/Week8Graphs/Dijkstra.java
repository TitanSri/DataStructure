package Week8Graphs;

import java.util.ArrayList;

public class Dijkstra {
	
	public static int[] dijkstra(WeightedGraph g, int s) {
		final int[] dist = new int[g.size()];
		final int[] pred = new int[g.size()];
		// an array if vertex is visited 
		final boolean[] visited = new boolean[g.size()];
		
		// sets the distance array to the max value
		for(int i=0; i<dist.length; ++i)
			dist[i] = Integer.MAX_VALUE;
		
		// the start index (vertex number) value is zero
		dist[s] = 0;
		
		for(int i=0; i<dist.length; ++i) {
			final int next = minVertex(dist, visited); // sends the distance and visited array 
			visited[next] = true; // the vertex has been visited
			
			final int[] neigh = g.neighbors(next); // gets all the neighbors of the visited vertex
			// goes through all the neighbors
			for(int j=0; j<neigh.length; ++j) { 
				final int v = neigh[j];
				final int d = dist[next] + g.getWeight(next, v); // the distance of the visited vertex and adds the distance from the neighbor
				System.out.println("Visted: " + next + " " + dist[next] );
				System.out.println("Neighbor: " + neigh[j] + " " + g.getWeight(next, v));
				System.out.println("Distance: "+d);
				System.out.println("Neighbor Distance: " + dist[v]);
				if(d < dist[v]) { // if the new distance is less than the neighbors distance (initial distance is max)
					System.out.println("Less than current distance: "+d);
					dist[v] = d; // change the neighbors distance 
					System.out.println("Change " + v +" to " + d);
					pred[v] = next; // change source of the path 
					System.out.println("Change path " + v +" to " + next);
				}
			}
		}
		for (int i = 0; i < dist.length; i++) {
			System.out.println("Vertex " + i + " : " + dist[i]);
		}
		return pred;
		
	}

	private static int minVertex(int[] dist, boolean[] visited) {
		int x = Integer.MAX_VALUE;
		int y =-1;
		for(int i=0; i<dist.length; ++i) {
			// if not visited and distance is less than x (current max)
			if(!visited[i] && dist[i] < x) {
				y = i; // y is the index in visited (vertex number)
				x = dist[i]; // the distance in the vertex (weight)
			}
		}
		return y; // return the vertex number
	}
	
	public static void printPath (WeightedGraph g, int[] pred, int sourceVertex, int targetVertex) {
		final ArrayList<Object> path = new ArrayList<Object>();
		int x = targetVertex;
		while (x != sourceVertex) {
			path.add(0,g.getLabel(x)); // adds the vertex to the front of the list from the target
			x = pred[x];
		}
		path.add(0,g.getLabel(sourceVertex)); // adds the source vertex to the front of the list
		for(Object s: path)
			System.out.print(s+" ");
	}

}
