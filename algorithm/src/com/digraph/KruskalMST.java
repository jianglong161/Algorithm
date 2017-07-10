package com.digraph;

import java.net.URI;

import com.graph.Edge;
import com.graph.EdgeWeightedGraph;
/**
 * ��С��������Kruskal�㷨
 * @author Still2Almost
 *
 */
public class KruskalMST {
	private Queue<Edge> mst;
	public KruskalMST(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new  MinPQ<Edge>();
		UF uf = new UF(G.V());
		while(!pq.isEmpty() && mst.size() < G.V() -1){
			Edge edge = pq.delMin();
			int v = edge.either(),w = edge.Other(v);
			if(uf.connected(v, w))
				continue;	//����ʧЧ�ı�
			uf.union(v, w);	//�ϲ�����
			mst.enqueue(edge);	//������ӷ�������С��������
		}
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight(){
		return 0;
	}
}
