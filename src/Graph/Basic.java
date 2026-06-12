package Graph;
import java.util.*;

class Graph{
	int vertices;
	List<List<Integer>> adj;
	public Graph(int v) {
		vertices=v;
		adj=new ArrayList<>();
		for(int i=0; i<vertices; i++) {
			adj.add(new ArrayList<>());
		}
	}
	void addEdge(int source, int destination) {
		adj.get(source).add(destination); //directed
		//adj.get(destination).add(source); //bi-directed
	}
	
	void printGraph() {
		for(int i=0; i<vertices; i++) {
			System.out.print(i+"-->");
			for(int ele:adj.get(i)) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}
	}
	void bfs(int start) {
		boolean[] visited = new boolean[vertices];
		Queue <Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start]=true;
		while(!q.isEmpty()) {
			int temp=q.poll();
			System.out.print(temp+" ");;
			for(int neigh:adj.get(temp)) {
				if(!visited[neigh]) {
					visited[neigh]=true;
					q.offer(neigh);				
				}
			}
		}
	}
	void dfs(int start) {
		boolean[] visited = new boolean[vertices];
		Stack <Integer> s = new Stack<>();
		s.push(start);
		visited[start]=true;
		while(!s.isEmpty()) {
			int temp=s.pop();
			System.out.print(temp+" ");;
			for(int neigh:adj.get(temp)) {
				if(!visited[neigh]) {
					visited[neigh]=true;
					s.push(neigh);				}
			}
		}
	}
		
		public void topologicalSort() {
			int[] indegree = new int[vertices];
			for(int i=0; i<vertices; i++) {
				for(int neigh:adj.get(i)) {
					indegree[neigh]++;
				}
			}
			Queue <Integer> q=new LinkedList<>();
			for(int i=0; i<vertices; i++) {
				if(indegree[i]==0) {
					q.offer(i);
				}
			}
			List<Integer> result=new ArrayList<>();
			while(!q.isEmpty()) {
				int temp = q.poll();
				result.add(temp);
				for(int neigh:adj.get(temp)) {
					indegree[neigh]--;
					if(indegree[neigh]==0) {
						q.offer(neigh);
					}
				}
			}
			System.out.println(result);
		}
		
		void shortestPath(int start, int end) {
			boolean[] visited = new boolean[vertices];
			Queue<Integer> q = new LinkedList<>();
			int[] distance = new int[vertices];
			q.offer(start);
			visited[start]=true;
			distance[start]=0;
			while(!q.isEmpty()) {
				int temp=q.poll();
				for(int neigh:adj.get(temp)) {
					if(!visited[neigh]) {
						visited[neigh]=true;
						distance[neigh]=distance[temp]+1;
						q.offer(neigh);
					}
				}
			}
			System.out.println(distance[end]);
	
		}
		
	}


public class Basic {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(3,2);
		g.addEdge(2,4);
		g.printGraph();
		g.bfs(0);
		System.out.println();
		g.dfs(0);
		System.out.println();
		g.topologicalSort();
		g.shortestPath(0,2);
	}

}

/*
class Graph {
    HashMap<Integer, List<Integer>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    void addVertex(int vertex) {
        adj.putIfAbsent(vertex, new ArrayList<>());
    }

    void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);

        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    void printGraph() {
        for (int ele : adj.keySet()) {
            System.out.print("ele"+ --> ");

            for (int value : adj.get(ele)) {
                System.out.print(value+ " ");
            }

            System.out.println();
        }
    }
}
*/
