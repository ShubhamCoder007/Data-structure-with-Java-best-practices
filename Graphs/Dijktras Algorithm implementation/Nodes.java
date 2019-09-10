package graphs;

import java.util.Comparator;

public class Nodes implements Comparator<Nodes>{

	int cost;
	int node;
	
	public Nodes() {
		this(0,0);
	}
	
	public Nodes(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compare(Nodes o1, Nodes o2) {
		if(o1.cost < o2.cost)
			return -1;
		if(o1.cost > o2.cost)
			return 1;
		return 0;
	}
	
	
}
