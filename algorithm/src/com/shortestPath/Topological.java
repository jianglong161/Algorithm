package com.shortestPath;

import com.digraph.Digraph;
import com.digraph.DirectedCycle;

public class Topological {

    private Iterable<Integer> order;    // topological order

    // topological sort in a digraph
    public Topological(Digraph G) {
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    // topological sort in an edge-weighted digraph
    public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    // return topological order if a DAG; null otherwise
    public Iterable<Integer> order() {
        return order;
    }

    // does digraph have a topological order?
    public boolean hasOrder() {
        return order != null;
    }


     


}
