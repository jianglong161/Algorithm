package com.graph;

import com.serach.Bag;

/**
 * 加权无向图的数据类型
 * @author Still2Almost
 *
 */
public class EdgeWeightedGraph {
	private final int V;	//顶点总数
	private int E;	//边的总数
	private Bag<Edge>[] adj;	//邻接表
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new Bag[V];
		for(int v = 0; v < V; v++){
			adj[v] = new Bag<Edge>();
		}
	}
	
    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
           // addEdge(new DirectedEdge(v, w, weight));
        }
     }
	  public int V(){
		  return V;
	  }
	  public int E(){
		  return E;
	  }
	  public void addEdge(Edge e){
		  int v = e.either(), w = e.Other(v);
		  adj[v].add(e);
		  adj[w].add(e);
		  E++;
	  }
	  public Iterable<Edge> adj(int v){
		  return adj[v];
	  }
	  
	  
	  

}
