package com.graph;

import java.util.Stack;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

/**
 * 使用深度优先搜索查找图中的路径
 * @author Still2Almost
 *
 */
public class DepthFirstPaths {
	private boolean[] marked;	//这个顶点上调用过dfs么
	private int[] edgeTo;	//从起点到一个顶点的已直路径上最后一个顶点
	private final int s;	//起点s
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}
	public void dfs(Graph G, int v){
		marked[v] = true;
		for(int w: G.adj(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
