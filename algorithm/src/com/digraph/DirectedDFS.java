package com.digraph;
/**
 * 有向图的可达性
 * @author Still2Almost
 *
 */
public class DirectedDFS {
	private boolean[] marked;	//这个顶点上调用过dfs么
	public DirectedDFS(Digraph G,int s) {
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	public  DirectedDFS(Digraph G,Iterable<Integer> source){
		marked = new boolean[G.V()];
		for(int s: source){
			if(!marked[s])
				dfs(G,s);
		}
	}
	public void dfs(Digraph G,int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
	}
	public boolean marked(int v){
		return marked[v];
		
	}
}
