//Given an Undirected Graph. The task is to find the count of the number
//of strongly connected components in the given Graph. A Strongly Connected 
//Component is defined as a subgraph of this graph in which every pair of
//vertices has a path in between.

package graphs;

import java.util.LinkedList;

public class StrongConnected {

	int V;
	LinkedList<Integer>[] adj;
	
	public StrongConnected() {
		this(0);
	}
	
	public StrongConnected(int v) {
		this.V = v;
		//array of linked list where number if array is the vertices
		//stores its adjacents in a linked fashion
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new LinkedList<>();
	}
	
	public StrongConnected addEdge(int src, int dest) {
		//unidirected
		adj[src].add(dest);
		adj[dest].add(src);
		return this;
	}
	
	public void dfsUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v+" ");
		for(int i : adj[v]) {
			if(!visited[i]) 
				dfsUtil(i, visited);
		}
	}
	
	public void connected() {
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				dfsUtil(i, visited);
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StrongConnected g = new StrongConnected(5);
		
		g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        System.out.println("Following are connected components");
        g.connected();
		
	}

}
