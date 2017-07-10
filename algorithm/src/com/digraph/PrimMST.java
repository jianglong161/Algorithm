package com.digraph;

import java.beans.Visibility;

import com.graph.Edge;
import com.graph.EdgeWeightedGraph;

/**
 * ��С��������prim�㷨�ļ�ʱʵ��
 * @author Still2Almost
 *
 */
public class PrimMST {
	private Edge[] edgeTo;	//����������ı�
	private double[] distTo;	//distTo[w]=edgeTo[w].weight()
	private boolean[] marked;	//���v��������Ϊtrue
	private IndexMinPQ<Double> pq;	//��Ч�ĺ��б�
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
		//������v��ӵ����У���������
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
