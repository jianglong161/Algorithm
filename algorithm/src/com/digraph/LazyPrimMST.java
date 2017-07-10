package com.digraph;

import com.graph.Edge;
import com.graph.EdgeWeightedGraph;

/**
 * 最小生成树的prim算法的延迟实现
 * @author Still2Almost
 *
 */
public class LazyPrimMST {
	private boolean[] marked;	//最小生成树的顶点
	private Queue<Edge> mst;	//最小生成树的边
	private MinPQ<Edge> pq;		//横切边(包括失效的边)
	public LazyPrimMST(EdgeWeightedGraph G) {
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		visit(G,0);	//假设G是连通的
		while(!pq.isEmpty()){
			Edge e = pq.delMin();	//从pq中得到权重最小的边
			int v = e.either(), w = e.Other(v);	//跳过失效的边
			if(marked[v] && marked[w])
				continue;
			mst.enqueue(e);	//将边添加到树在中
			if(!marked[v])
				visit(G,v);
			if(!marked[w])
				visit(G,w);	
		}
	}	
	public void visit(EdgeWeightedGraph G,int v){
		//标记顶点v并将所有连接v和未被标记顶点的边加入pq
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
