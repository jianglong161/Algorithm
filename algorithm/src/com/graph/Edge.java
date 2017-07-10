package com.graph;

import java.util.Iterator;

import javax.management.RuntimeErrorException;
import javax.print.attribute.standard.MediaSize.Other;

/**
 * ��Ȩ�صıߵ���������
 * @author Still2Almost
 *
 */
public class Edge implements Iterable<Edge>{
	private final int v;//����֮һ
	private final int w;//��һ������
	private final double weight;	//�ߵ�Ȩ��
	private static EdgeWeightedGraph G;
 
	public Edge(int v,int w,double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	
	public double weight(){
		return weight;
	}
	public int either(){
		return v;
	}
	public int Other(int vertex){
		if(vertex == v)
			return w;
		else if(vertex == w)
			return v;
		else{
			throw new RuntimeException( "Inconsitant edge");
		}
	}
	public int comparetTo(Edge that){
		if(this.weight() < that.weight())
			return -1;
		else if (this.weight() > that.weight()) {
			return 1;
		}else{
			return 0;
		}
	}
	public String toString(){
		return String.format("%d-%d %.2f",v,w,weight);
	}
	
	@Override
	public Iterator<Edge> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
