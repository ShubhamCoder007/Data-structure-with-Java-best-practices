package graphs;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	public static class DataLine{
		private int parent;
		private int child;
		
		public DataLine() {
		}
		
		public DataLine(int p, int c) {
			parent = p;
			child = c;
		}
		
		public int getParent() {
			return this.parent;
		}
		
		public int getChild() {
			return this.child;
		}
		
		public boolean isSame(DataLine ob) {
			if(parent == ob.getParent() && child == ob.getChild())
				return true;
			return false;
		}
	}
	
	public Graph addEdge(int v, int u) {
		adj[v].add(u);
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
	
//	private boolean isCyclicUtil(int v) {
//		boolean[] visited = new boolean[nodes];
//		LinkedList<DataLine> list = new LinkedList<>();
//		//list.add(v);
//		
//		do {
//			
//			//int n = list.poll();
//			
//			for(Integer i : adj[n]) {
//				DataLine ob = new DataLine(v,i);
//				list.add(ob);
//				
//				if(visited[i])
//					return true;
//				visited[i] = true;
//				//list.add(i);
//			}
//			
//		}while(!list.isEmpty());
//		
//		return false;
//	}
	
	public boolean isCyclic() {
		for(int i = 0; i < nodes; i++) {
			if(isCyclicUtil(i)) {
				System.out.println("\nCyclic");
				return true;
			}
		}
		System.out.println("\nNot Cyclic");
		return false;
	}
	
	private boolean isCyclicUtil(int v) {
	// TODO Auto-generated method stub
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
