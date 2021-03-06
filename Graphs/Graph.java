package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

	static int v = 5;
	
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
