package com.digraph;

import com.graph.Edge;
import com.graph.EdgeWeightedGraph;

/**
 * ��С��������prim�㷨���ӳ�ʵ��
 * @author Still2Almost
 *
 */
public class LazyPrimMST {
	private boolean[] marked;	//��С�������Ķ���
	private Queue<Edge> mst;	//��С�������ı�
	private MinPQ<Edge> pq;		//���б�(����ʧЧ�ı�)
	public LazyPrimMST(EdgeWeightedGraph G) {
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		visit(G,0);	//����G����ͨ��
		while(!pq.isEmpty()){
			Edge e = pq.delMin();	//��pq�еõ�Ȩ����С�ı�
			int v = e.either(), w = e.Other(v);	//����ʧЧ�ı�
			if(marked[v] && marked[w])
				continue;
			mst.enqueue(e);	//������ӵ�������
			if(!marked[v])
				visit(G,v);
			if(!marked[w])
				visit(G,w);	
		}
	}	
	public void visit(EdgeWeightedGraph G,int v){
		//��Ƕ���v������������v��δ����Ƕ���ı߼���pq
		marked[v] = true;
		for(Edge e: G.adj(v))
			if(!marked[e.Other(v)])
				pq.insert(e);
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight(){
		return 0;
	}
}
