package com.digraph;


/**
 * ����ͼ�л���������������Ķ�������
 * @author Still2Almost
 *
 */
public class DepthFirstOreder {
	private boolean[] marked;
	private Queue<Integer> pre;	//���ж����ǰ������
	private Queue<Integer> post;	//���ж���ĺ�������
	private Queue<Integer> reversePost;	//���ж�������������
	public DepthFirstOreder(Digraph G) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Queue<Integer>();
		marked = new boolean[G.V()];
		for(int v = 0; v <G.V();v++){
			if(!marked[v])
				dfs(G,v);
		}
	}
	
	public void dfs(Digraph G,int v){
		pre.enqueue(v);
		marked[v] = true;
		for(int w: G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
		post.enqueue(v);
		reversePost.enqueue(v);
	}
	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
}
