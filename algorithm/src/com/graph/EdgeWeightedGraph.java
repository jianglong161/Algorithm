package com.graph;

import com.serach.Bag;

/**
 * ��Ȩ����ͼ����������
 * @author Still2Almost
 *
 */
public class EdgeWeightedGraph {
	private final int V;	//��������
	private int E;	//�ߵ�����
	private Bag<Edge>[] adj;	//�ڽӱ�
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
