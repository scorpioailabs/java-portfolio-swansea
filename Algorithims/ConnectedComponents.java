// connected components
public class ConnectedComponents {
	private boolean marked [];
	private int[] id;
	public ConnectedComponents(Graph G)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for (int v=0; v < G.V(); v++) {
			if (!marked[v])	{
				dfs(G, v);
				count++;
			}
		}
	}

	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		id[v] = count;
		LinkList adj = G.adj(v);
		for (int i =0; i < adj.count(); i++) {
			int w = adj.getData(i);
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}

}