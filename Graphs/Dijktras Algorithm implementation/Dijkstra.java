package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

	//min distances of every nodes
	private int[] dist;
	private List<List<Nodes>> adj;
	private Set<Integer> settled;
	//number of vertices
	private int V;
	private PriorityQueue<Nodes> pq;
	
	public Dijkstra(int V) {
		this.V = V;
		dist = new int[V];
		this.settled = new HashSet<Integer>();
		//passing the class type for casting
		//by default size is 11
		pq = new PriorityQueue<Nodes>(V, new Nodes());
		
	}
	
	public void dijkstra(List<List<Nodes>> adj, int src) {
		this.adj = adj;
		
		for(int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;
		
		//starting node is src and distance set as 0
		dist[src] = 0;
		//dist is finalized and is being set to min heap
		pq.add(new Nodes(src, 0));
		
		//all the relaxed nodes is added to the settled set
		while(settled.size() != V) {
			//removing the minimum node from the heap
			int u = pq.remove().node;
			//adding it to settled since it is finalized
			settled.add(u);
			//computing for its neighbouring edges
			eNeighbours(u);
		}
	}
	
	public void eNeighbours(int u) {
		int newDistance = -1;
		
		for(int i = 0; i < adj.get(u).size(); i++) {
			
			Nodes v = adj.get(u).get(i);
			
			//if current node is not processed
			if(!settled.contains(v.node)) {
				newDistance = dist[u] + v.cost;
				
				if(dist[v.node] > newDistance)
					dist[v.node] = newDistance;
				
				//add the current node to the queue
				pq.add(new Nodes(v.node, dist[v.node]));
			}
			
		}
	}
	
	public static void main(String[] args) {
		int source = 0;
		int V = 5;
		List<List<Nodes>> adj = new ArrayList<List<Nodes>>();
		
		for(int i = 0; i < V; i++)
			adj.add(new ArrayList<Nodes>());
		
		adj.get(0).add(new Nodes(1, 9)); 
        adj.get(0).add(new Nodes(2, 6)); 
        adj.get(0).add(new Nodes(3, 5)); 
        adj.get(0).add(new Nodes(4, 3)); 
  
        adj.get(2).add(new Nodes(1, 2)); 
        adj.get(2).add(new Nodes(3, 4)); 
  
        // Calculate the single source shortest path 
        Dijkstra dpq = new Dijkstra(V); 
        dpq.dijkstra(adj, source); 
        
        // Print the shortest path to all the nodes 
        // from the source node 
        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < dpq.dist.length; i++) 
            System.out.println(source + " to " + i + " is "
                               + dpq.dist[i]); 
	}

}
