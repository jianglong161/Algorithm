package com.digraph;


/**
 * 有向图中基于深度优先搜索的顶点排序
 * @author Still2Almost
 *
 */
public class DepthFirstOreder {
	private boolean[] marked;
	private Queue<Integer> pre;	//所有顶点的前序排列
	private Queue<Integer> post;	//所有顶点的后续排序
	private Queue<Integer> reversePost;	//所有顶点的逆后续排列
	public DepthFirstOreder(Digraph G) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Queue<Integer>();
		marked = new boolean[G.V()];
		for(int v = 0; v <G.V();v++){
			if(!marked[v])
				dfs(G,v);
		}
	}
	
	public void dfs(Digraph G,int v){
		pre.enqueue(v);
		marked[v] = true;
		for(int w: G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
		post.enqueue(v);
		reversePost.enqueue(v);
	}
	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
}
