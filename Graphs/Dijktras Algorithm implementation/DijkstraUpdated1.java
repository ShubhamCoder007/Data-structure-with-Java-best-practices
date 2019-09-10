package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraUpdated1 {

	private int V;
	private int source;
	private int[] dist;
	private Set<Integer> relaxed;
	private List<List<Nodes>> adj;
	private PriorityQueue<Nodes> pq;
	
	public Dijkstra1() {
		this(0);
	}
	
	public Dijkstra1(int V) {
		this.V = V;
		dist = new int[V];
		relaxed = new HashSet<Integer>();
		pq = new PriorityQueue<Nodes>(V, new Nodes());
		for(int i = 0; i < V; i++) 
			dist[i] = Integer.MAX_VALUE;
	}
	
	public void dijkstra(List<List<Nodes>> adj, int source) {
		this.adj = adj;
		this.source = source;
		dist[source] = 0;
		pq.add(new Nodes(source, 0));
		
		while(relaxed.size() != V) {
			//extracting the root of min heap
			int u = pq.remove().node;
			//relaxing it, adding to the relaxed set
			relaxed.add(u);
			//compute for its adjoint and add to the min heap
			computeNeighbours(u);
		}
	}
	
	private void computeNeighbours(int u) {
		for(int i = 0; i < adj.get(u).size(); i++) {
			int newDistance = -1;
			Nodes v = adj.get(u).get(i);
			
			if(!relaxed.contains(v.node)) {
				newDistance = dist[u] + v.cost;
				
				if(newDistance < dist[v.node])
					dist[v.node] = newDistance;
				
				pq.add(new Nodes(v.node, dist[v.node]));
			}
		}
	}
	
	public void display() {
		System.out.println("The shorted path from node :"); 
	    for (int i = 0; i < dist.length; i++) 
	          System.out.println(source + " to " + i + " is "
	                               + dist[i]); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
        Dijkstra1 dpq = new Dijkstra1(V); 
        dpq.dijkstra(adj, source); 
        
        dpq.display();
	}

}
