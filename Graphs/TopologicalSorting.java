//Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering 
//of vertices such that for every directed edge uv, vertex u comes before v
//in the ordering.

package graphs;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	int V;
	LinkedList<Integer>[] adj;
	
	TopologicalSort(){
		this(0);
	}
	
	TopologicalSort(int v){
		this.V = v;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new LinkedList();
	}
	
	public void topologicalSortUtil(int v, Stack s, boolean[] visited) {
		visited[v] = true;
		for(int i : adj[v]) {
			if(!visited[i])
				topologicalSortUtil(i, s, visited);
		}
		s.push(v);
	}
	
	public void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; i++) {
			if(!visited[i])
				topologicalSortUtil(i, stack, visited);
		}
		
		System.out.println("Displaying the order: ");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6);
		
		g.adj[5].add(2);
		g.adj[5].add(0);
		g.adj[4].add(0);
		g.adj[4].add(1);
		g.adj[2].add(3);
		g.adj[3].add(1);
		
		g.topologicalSort();
	}

}
