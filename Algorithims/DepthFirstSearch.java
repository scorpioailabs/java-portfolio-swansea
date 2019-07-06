// Depth First Search --> Graph traversal
public class DepthFirstSearch {
	private Graph G;
	// marked[v] = is there an s-v path?
	private boolean[] marked;
	// edgeTo[v] = last edge on s-v path
	private int[] edgeTo;
	// source vertex		
	private final int s;
	// constuctor		
	public DepthFirstSearch(Graph G, int s)
	{
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	// depth first search from v
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		LinkedList adj = G.adj(v);
		for (int i=0; i < adj.count(); i++)
		{
			int w = adj.getData(i);
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3);
		System.out.println("Following is DF traversal " + "(starting from vertex 2)");
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.dfs(g.Grapth(2),2);
	}
}