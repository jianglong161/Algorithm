package com.digraph;

import java.net.URI;

import com.graph.Edge;
import com.graph.EdgeWeightedGraph;
/**
 * 最小生成树的Kruskal算法
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
				continue;	//忽略失效的边
			uf.union(v, w);	//合并分量
			mst.enqueue(edge);	//将边添加分量到最小生成树中
		}
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight(){
		return 0;
	}
}
