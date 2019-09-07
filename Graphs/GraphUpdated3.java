package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

	static int v = 5;
	private int nodes;
	private LinkedList<Integer>[] adj;
	
	public Graph() {
		this(0);
	}
	
	public Graph(int nodes) {
		this.nodes = nodes;
		//creating array of linked list
		adj = new LinkedList[nodes];
		//instantiating objects at very array index
		for(int i = 0; i < nodes; i++)
			adj[i] = new LinkedList<>();
	}
	
	public Graph addEdge(int v, int u) {
		System.out.println("\nAdding edge: "+v+" - "+u);
		try {
			if(v >= nodes || u >= nodes)
				throw new ArrayIndexOutOfBoundsException("adding the edge isn't permmisible!");
			adj[v].add(u);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception bound cross "+e);
			System.out.println("You can have max of "+nodes+" nodes starting"
					+ "from 0 to "+(nodes-1));
			e.printStackTrace();
		}
		return this;
	}
	
	public void dfsUtil(boolean[] visited, int v) {
		visited[v] = true;
		System.out.print(v+" ");
		
		//Iterator<Integer> i = adj[v].iterator();
		for(Integer i : adj[v]) {
			if(!visited[i])
				dfsUtil(visited, i);
		}
	}
	
	public void dfs(int v) {
		System.out.println("\nDFS Recurssion:");
		boolean visited[] = new boolean[nodes];
		dfsUtil(visited, v);
	}
	
	public boolean isCyclic() {
		System.out.println("\nChecking for cyclic: \n");
		for(int i = 0; i < nodes; i++) {
			Stack<Integer> s = new Stack<>();
			System.out.println("\nChecking with node: "+i);
			if(isCyclicUtil(i, s)) {
				System.out.println("\nCyclic, start node: "+i);
				return true;
			}
		}
		System.out.println("\nNot Cyclic");
		return false;
	}
	
	private boolean isCyclicUtil(int v, Stack<Integer> s) {
		System.out.println("Current Stack: "+s);
		if(s.contains(v))
			return true;
		
		s.push(v);
		
		while(!s.isEmpty()) {
			for(int i = 0; i < adj[v].size(); i++) 
				return isCyclicUtil(adj[v].get(i), s);
			
			s.pop();
		}
		
		return false;
	}

	public void dfsStackUtil(int v, Stack<Integer> s, boolean[] visited) {
		System.out.print(v+" ");
		s.push(v);
		
		while(!s.isEmpty()) {
			int n = s.pop();
			visited[n] = true;
			
			for(Integer i : adj[n]) {
				if(!visited[i]) {
					s.push(i);
					dfsStackUtil(i, s, visited);
				}
			}
		
		}
	}
	
	public void dfsStack(int v) {
		System.out.println("\nStack dfs:");
		Stack<Integer> s = new Stack<>();
		boolean[] visited = new boolean[nodes];
		dfsStackUtil(v, s, visited);
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
		list.get(u).add(v);
		list.get(v).add(u);
	}
	
	public static void addGraph(ArrayList<ArrayList<Integer>> list) {
		list.add(new ArrayList<Integer>());
	}
	
	public static void bfs(ArrayList<ArrayList<Integer>> list) {
		boolean[] visited = new boolean[list.size()];
		for(int i = 0; i < list.size(); i++)
			visited[i] = false;
		
		//maintaining queue for bfs
		LinkedList<Integer> queue = new LinkedList<>();
		//beginning from 0
		queue.add(0);
		
		while(queue.size() != 0) {
			
			int cur = queue.poll();
			visited[cur] = true;
			
			for(int i = 0; i < list.get(cur).size(); i++) {
				if(!visited[list.get(cur).get(i)]) {
					queue.add(list.get(cur).get(i));
					visited[list.get(cur).get(i)] = true;
				}
			}
			
			System.out.print(cur+" ");
		}
	}
	
	public static void main(String[] args) {
		// initial size as v
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(v);
		
		for(int i = 0; i < v; i++)
			addGraph(list);
		
		addEdge(list, 0, 1);
		addEdge(list, 0, 4);
        addEdge(list, 1, 2);
        addEdge(list, 1, 3);
        addEdge(list, 1, 4);
        addEdge(list, 2, 3);
        addEdge(list, 3, 4);
        
        
        printGraph(list);
        
        System.out.println("BFS:");
		bfs(list);
		
		//dfs routine with object of the class implementation
		Graph g = new Graph(4);
        g.addEdge(0, 1).addEdge(0, 2).addEdge(1, 2).addEdge(3, 0)
        .addEdge(2, 3).addEdge(3, 3);
        
        //starting vertice as 2
        g.dfs(2);
        
        //dfs stack
        g.dfsStack(2);
        
        //cycle detection graph
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        
        graph.isCyclic();g.isCyclic();
        
        //not cyclic
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1).addEdge(1, 2).addEdge(2, 3).addEdge(3, 4);
        g1.printGraph();
        g1.isCyclic();
	}

	private void printGraph() {
		for(int i = 0; i < nodes; i++) {
			System.out.println("Graph:"+i+" Adjacencies: ");
			for(int j = 0; j < adj[i].size(); j++) {
				System.out.print(adj[i].get(j)+" ");
			}
			System.out.println();
		}
		
	}

	public static void printGraph(ArrayList<ArrayList<Integer>> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println("Graph:"+i+" Adjacencies: ");
			for(int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
	}

	
}
