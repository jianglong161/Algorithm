package com.digraph;
/**
 * ����ǿ��ͨ������Kosaraju�㷨
 * @author Still2Almost
 *
 */
public class KosarajsSCC {
	private boolean[] marked;//�Ѿ����ʹ��Ķ���
	private int[] id;//ǿ��ͨ�����ı�ʶ��
	private int count;//ǿ��ͨ����������
	public KosarajsSCC(Digraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOreder oreder = new DepthFirstOreder(G);
		for(int s: oreder.reversePost()){
			if(!marked[s]){
				dfs(G,s);
				count ++;
			}
		}
	}
	public void dfs(Digraph G, int v){
		marked[v] = true;
		id[v]  =  count;
		for(int w: G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
	}
	public boolean stronglyConnected(int v,int w){
		return id[v] == id[w];
	}
	public int id(int v){
		return id[v];
	}
	public int count(){
		return count ++ ;
	}
}
