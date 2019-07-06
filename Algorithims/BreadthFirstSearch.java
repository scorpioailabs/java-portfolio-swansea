// breadth first search
public class BreadthFirstSearch {
	private boolean[] marked;
	Graph G = new Graph();
	//BFS from single source
	public void bfs(Graph G, int s)
	{
		Queue q = new Queue();
		marked[s] = true;
		q.enqueue(new Integer(s));

		while (!q.isEmpty())
		{
			int v = (int)q.dequeue();
			LinkedList adj = G.adj(v);
			int count = adj.count();
			for(int i =0; i < count; i++) {
				int w = adj.getData(i);
				if(!marked[w]) {
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}
}