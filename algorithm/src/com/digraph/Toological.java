package com.digraph;
/**
 *	Õÿ∆À≈≈–Ú
 * @author Still2Almost
 *
 */
public class Toological {
	private Iterable<Integer> order;	//∂•µ„µƒÕÿ∆À≈≈–Ú
	public Toological(Digraph G) {
		DirectedCycle directedCycle  = new DirectedCycle(G);
		if(!directedCycle.hasCycle()){
			DepthFirstOreder dfs = new DepthFirstOreder(G);
			order = dfs.reversePost();
		}
	}
	public Iterable<Integer> order(){
		return order;
	}
	public boolean isDAG(){
		return order != null;
	}
}
