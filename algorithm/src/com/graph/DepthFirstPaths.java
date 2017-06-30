package com.graph;

import java.util.Stack;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

/**
 * ʹ�����������������ͼ�е�·��
 * @author Still2Almost
 *
 */
public class DepthFirstPaths {
	private boolean[] marked;	//��������ϵ��ù�dfsô
	private int[] edgeTo;	//����㵽һ���������ֱ·�������һ������
	private final int s;	//���s
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
