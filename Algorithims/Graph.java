// graph
public class Graph {
	private int V; // vertex
	private LinkedList[] adj; // No. of vertices
	//Constuctor
	public Graph(int V) 
	{
		this.V = V;
		adj = new LinkedList[V];
		for(int v = 0; v < V; v++)
			adj[v] = new LinkedList(); // create empty graph with V vertices
	}

	public void addEdge(int v, int w)
	{
		// add two directed edge v->w, w->v to represent an undirected edge
		adj[v].insert(w);
		adj[w].insert(v);
	}

	public void addDirectedEdge(int v, int w)
	{
		adj[v].insert(w); //Add one directed edge v->w
	}

	public LinkedList adj(int v)
	{	return adj[v];	}


	// // driver
	// public static void main(String[] args) {
	// 	Reader in = new Reader(args[0]);
	// 	Graph G = new Graph(in);
	// 	for (int v =0; v < G.V(); v++) {
	// 		int count = G.adj(v).count();
	// 		for (int i =0; i < count; i++) {
	// 			System.out.println(v + " -> " + G.adj(v).getData(i));
	// 		}
	// 	}
	// }
}