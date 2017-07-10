package com.digraph;

import java.beans.Visibility;

import com.graph.Edge;
import com.graph.EdgeWeightedGraph;

/**
 * 最小生成树的prim算法的即时实现
 * @author Still2Almost
 *
 */
public class PrimMST {
	private Edge[] edgeTo;	//距离树最近的边
	private double[] distTo;	//distTo[w]=edgeTo[w].weight()
	private boolean[] marked;	//如果v在树中则为true
	private IndexMinPQ<Double> pq;	//有效的横切变
	public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
        	distTo[v] = Double.POSITIVE_INFINITY;

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
        	visit(G,pq.delMin());
		}
    }
	public void visit(EdgeWeightedGraph G,int v){
		//将顶点v添加到树中，更新数据
		marked[v] = true;
		for(Edge edge : G.adj(v)){
			int w = edge.Other(v);
			if(marked[w])
				continue;
			if(edge.weight()<distTo[w]){
				edgeTo[w] = edge;
				distTo[w] = edge.weight();
				if(pq.contains(w))
					pq.change(w, distTo[w]);
				else{
					pq.insert(w, distTo[w]);
				}
			}
		}
	}
	public Iterable<Edge> edges(){
		return null;
	}
	public double weight(){
		return 0;
	}
}
