package com.digraph;

import java.util.Stack;

import com.graph.In;
/**
 * Ѱ������
 * @author Still2Almost
 *
 */
public class DirectedCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;//���������ж���
	private boolean[] onStack;	//�ݹ����ջ�ϵ����ж���
	public DirectedCycle(Digraph G) {
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V();v++){
			if(!marked[v])
				dfs(G,v);
		}
		
	}
	/**
	 * �����һ���������͵�����onStack[]������ݹ�����ڼ��ջ�ϵ����ж���
	 * �����ҵ���һ����v��w������w��ջ�У������ҵ���һ����
	 * @param G
	 * @param v
	 */
	private void dfs(Digraph G, int v){
		onStack[v] = true;
		marked[v] = true;
		for(int w : G.adj(v)){
			if(this.hasCycle()	)
				return;
			else if(onStack[w]){
				cycle = new Stack<Integer>();
				for(int x = v; x != w;x = edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
			onStack[w] = false;
		}
	}
	public boolean hasCycle(){
		return cycle != null;
	}
	public Iterable<Integer> cycle(){
		return cycle;
	}
}
