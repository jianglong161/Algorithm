package com.serach;
/**
 * 基于二叉查处树的符号表
 * @author Still2Almost
 *
 */
public class BST <Key extends Comparable<Key> ,Value>{
	private Node root;	//二叉查找树的根节点
	private class Node{
		private Key key; //键
		private Value val;	//值
		private Node left, right;	//指向子树的连接
		private int N; 	//以该结点为根的子树中的结点总数
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	public int size(){
		return size(root);
	}
	private int size(Node x){
		if(x == null)
			return 0;
		else
			return x.N;
	}
	/**
	 * 查找根结点
	 * @param key
	 * @return
	 */
	public Value get(Key key){
		return get(root,key);
	}
	/**
	 * 以x为根节点的子树中查找并返回key的对应值
	 * @param x
	 * @param key
	 * @return
	 */
	private Value get(Node x,Key key){
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			return get(x.left,key);
		else if(cmp > 0)
			return get(x.right,key);
		else {
			return x.val;
		}
	}
	public void put(Key key, Value val){
		//查找key，找到则更新它的值，否则为它创建一个新的节点
		root = put(root, key, val);
	}
	private Node put(Node x, Key key, Value val){
		//如果key存在于以x为根节点子树中则更新它的值
		//否则以key和value为新键值插入到子树中
		if(x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			x.left = put(x.left, key,val);
		else if(cmp > 0){
			x.right = put(x.right, key, val);
	
		}
		else{
			x.val = val;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

}
