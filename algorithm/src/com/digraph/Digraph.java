package com.digraph;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 有向图
 */
public class Digraph {
	private final int V;	//顶点数目
	private int E;	//边的数目
	private Set<Integer>[] adj;
	InputStream in = null;
	public Digraph(int V) {
		this.V = V;
		adj = new Set[V];	//创建相邻表
		for(int v = 0; v < V; v++){	//将所有的 链表都初始化为空
			adj[v] = new HashSet<Integer>();
		}
	}
	public Digraph(InputStream in) throws IOException{
		this(in.read());
		int E = in.read();
		for(int i = 0; i < E; i++){
			int v = in.read();
			int w = in.read();
			addEdge(v, w);
		}
		
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(int v, int w){
		adj[v].add(w);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	/**
	 * 计算v的度数
	 * 
	 */
	public static int degree(Digraph c, int v){
		
		int degree = 0;
		for(int w:c.adj(v) )
			degree++;
		return degree;
	}
	public Digraph reverse(){
		Digraph R = new Digraph(V);
		for(int v = 0; v < V; v++){
			for(int w: adj(v))
				R.addEdge(w, v);
		}
		return R;
	}
}
