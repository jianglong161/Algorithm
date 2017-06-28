package com.graph;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 图
 */
public class Graph {
	private final int V;	//顶点数目
	private int E;	//边的数目
	private Set<Integer>[] adj;
	InputStream in = null;
	public Graph(int V) {
		this.V = V;
		adj = new Set[V];	//创建相邻表
		for(int v = 0; v < V; v++){	//将所有的 链表都初始化为空
			adj[v] = new HashSet<Integer>();
		}
	}
	public Graph(InputStream in) throws IOException{
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
		adj[v].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	/**
	 * 计算v的度数
	 * 
	 */
	public static int degree(Graph c, int v){
		
		int degree = 0;
		for(int w:c.adj(v) )
			degree++;
		return degree;
	}
	/**
	 * 计算所有顶点的最大度数
	 * @param g
	 * @return
	 */
	public static int maxDegred(Graph g){
		int max = 0;
		for(int v = 0; v < g.V; v++){
			if(degree(g, v) > max)
				max = degree(g, v);
		}
		return max;
	}
	/**
	 * 计算所有顶点的平均度数
	 * @param graph
	 * @return
	 */
	public static double avgDegred(Graph graph){
		return 2 * graph.E() / graph.V();
	}
	/**
	 * 计算自环的个数
	 * @param graph
	 * @return
	 */
	public static int numberOfSelfLoops(Graph graph){
		int count = 0;
		for(int v = 0; v < graph.V(); v++){
			for(int w : graph.adj(v))
				if(v == w)
					count ++;
		}
		return count / 2;
	}
}
