package com.shortestPath;

import com.graph.In;
import com.serach.Bag;

/**
 * 加权有向图的数据类型
 * @author Still2Almost
 *
 */
public class EdgeWeightedDigraph {
	private final int V;	//顶点总数
	private int E;	//边的总数
	private Bag<DirectedEdge>[] adj;//邻接表
	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new Bag[V];
		for(int v =0;v < V; v++){
			adj[v] = new Bag<DirectedEdge>();
		}
	}
	public EdgeWeightedDigraph(In in){

        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectedEdge(v, w, weight));
        }
    
		
	}
	 public int V() {
	        return V;
	}
	 public int E() {
	        return E;
	}
     public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
        E++;
     }
     public Iterable<DirectedEdge> adj(int v) {
         return adj[v];
     }

    /**
      * Return all edges in this graph as an Iterable.
      * To iterate over the edges, use foreach notation:
      * <tt>for (DirectedEdge e : graph.edges())</tt>.
      */
     public Iterable<DirectedEdge> edges() {
         Bag<DirectedEdge> list = new Bag<DirectedEdge>();
         for (int v = 0; v < V; v++) {
             for (DirectedEdge e : adj(v)) {
                 list.add(e);
             }
         }
         return list;
     } 

    /**
      * Return number of edges leaving v.
      */
     public int outdegree(int v) {
         return adj[v].size();
     }

}
