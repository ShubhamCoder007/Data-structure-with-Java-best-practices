package graphs;

public class BellmanFord {

	int V, E;
	int[] dist;
	Edge[] edge;
	
	class Edge{
		int src;
		int dest;
		int wt;
		
		public Edge() {
			this(0,0,0);
		}

		public Edge(int i, int j, int k) {
			// TODO Auto-generated constructor stub
			this.src = i;
			this.dest = j;
			this.wt = k;
		}
	}
	
	public BellmanFord(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[E];
		for(int i = 0; i < E; i++)
			edge[i] = new Edge();
		dist = new int[V];
		for(int i = 0; i < V; i++) 
			dist[i] = Integer.MAX_VALUE;
	}
	
	public void bellmanFord(int src) {
		int[] prev = new int[V];
		
		dist[src] = 0;
		
		for(int i = 0; i < V; i++) {
			int sum = 0;
			for(int j = 0; j < E; j++) {
				int u = edge[j].src;
				int v = edge[j].dest;
				int w = edge[j].wt;
				
				//computation would be useless if parent isn't calculated
				if(dist[u] != Integer.MAX_VALUE && (dist[u] + w) < dist[v]) 
					dist[v] = dist[u] + w;
					
				sum += dist[v] - prev[v];
				
				if(j > 0)
					prev = dist;
			}
			if(sum == 0)
				break;
		}
		
		int sum = 0;
		for(int j = 0; j < E; j++) {
			int u = edge[j].src;
			int v = edge[j].dest;
			int w = edge[j].wt;
			
			//computation would be useless if parent isn't calculated
			if(dist[u] != Integer.MAX_VALUE && (dist[u] + w) < dist[v]) 
				dist[v] = dist[u] + w;
			
			sum += dist[v] - prev[v];
		}
		
		if(sum != 0) {
			System.out.println("There's a negative cycle!");
			return;
		}
		
		display();
		
	}
	
	public void display() {
		System.out.println("Vertex   Distance from Source");
		for(int i = 0; i < V; i++)
			System.out.println(i+"\t\t"+dist[i]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 5;
		int e = 8;
		
		BellmanFord graph = new BellmanFord(v, e);
		
		// add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].wt = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].wt = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].wt = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].wt = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].wt = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].wt = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].wt = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].wt = -3;

        graph.bellmanFord(0);
	}

}
