package com.graph;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用广度优先搜索查找图中的路径
 * @author Still2Almost
 *
 */
public class BreadthFirstPaths {
	private boolean[] marked;	//到达该顶点的最短路径已知么？
	private int[] edgeTo;	//到达该顶点的已经路径上最后一个点
	private final int s;	//起点
	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	public void bfs(Graph G, int s){
		Queue<Integer> queue = new Queue<Integer>() {
			
			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Iterator<Integer> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean addAll(Collection<? extends Integer> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Integer remove() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer poll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer peek() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean offer(Integer e) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Integer element() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean add(Integer e) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		marked[s] = true; //标记起点
		queue.add(s);//将它加入队列
		while(!queue.isEmpty()){
			int v = queue.remove();//从队列中删除下一顶点
			for(int w: G.adj(v)){
				if(!marked[w]){		//对于每个没有被标记的相邻顶点
					edgeTo[w] = v;	
					marked[w] = true;//标记它，因为最短路径已经直到
					queue.add(w);	//并将它添加到队列中
				}
			}
		}
	}
	public boolean hasPath(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPath(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
