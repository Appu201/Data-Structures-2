package Graph;
import java.util.*;


class Node{
	int vertex;
	int weight;
	Node(int v, int w){
		this.vertex =v;
		this.weight =w;
	}
}


class Grph{
	HashMap<Integer, List<Node>> map=new HashMap<>();
	void addEdge(int src, int des, int wei) {
		map.putIfAbsent(src, new ArrayList<>());
		map.putIfAbsent(des, new ArrayList<>());
		map.get(src).add(new Node(des,wei));
	}
	void djikstra(int start){
		HashMap<Integer,Integer> dist=new HashMap<>();
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n->n.weight));
		for(int node:map.keySet()) {
			dist.put(node,Integer.MAX_VALUE);
		}
		dist.put(start,0);
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node temp=pq.poll();
			int u=temp.vertex; //0, value
			int w=temp.weight; //0, weight
			for(Node neigh:map.get(u)) {
				int v=neigh.vertex; //1
				int we=neigh.weight; //4

				if(dist.get(u)+we<dist.get(v)) {
					dist.put(v,dist.get(u)+we);
					pq.add(new Node(v,dist.get(v)));
				}
			}	
		}
		System.out.println("Shortest Distances:");
		for(int node : dist.keySet()) {
		    System.out.println(node + " -> " + dist.get(node));
		}
	}
	
	void prims(int start){
        PriorityQueue<Node> q=new PriorityQueue<>(Comparator.comparing(n->n.weight));
        HashSet<Integer> set=new HashSet<>();
        q.add(new Node(start,0));
        int mw=0;
        while(!q.isEmpty()){
            Node temp=q.poll();
            int u=temp.vertex;
            int w=temp.weight;
            if(set.contains(u)){
                continue;
            }
            set.add(u);
            mw=mw+w;
            for(Node neigh:map.get(u)){
                if(!set.contains(neigh.vertex)){
                    q.add(new Node(neigh.vertex,neigh.weight));
                }
            }
        }
        System.out.println(mw);

    }
	void printGraph() {
		for(int node:map.keySet()) {
			System.out.println(node+"-->");
			for(Node n:map.get(node)) {
				System.out.print(n.vertex+" "+n.weight+" ");
			}
			System.out.println();
		}
	}
}

public class WeightedGraph {

	public static void main(String[] args) {
		Grph g = new Grph();
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 2, 2);
		g.addEdge(1, 3, 1);
		g.addEdge(2, 3, 5);
		g.printGraph();
		g.djikstra(0);
		g.prims(0);
	}

}
