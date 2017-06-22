package com.serach;

import javax.naming.InitialContext;

/**
 * x`
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
	public Key min(){
		return min(root).key;
	}
	private Node min(Node x){
		if(x.left == null)
			return x;
		return min(x.left);
	}
	public Key floor(Key key){
		Node x = floor(root, key);
		if(x == null)
			return null;
		return x.key;
	}
	private Node floor(Node x, Key key){
		if(x == null)
			return null;
		int com = key.compareTo(x.key);
		if(com < 0)
			return floor(x.left, key);
		else if(com == 0)
			return x;
		Node t = floor(x.right, key);
		if(t != null)
			return t;
		else
			return x;
	}
	public Key select(int k){
		return select(root,k).key;
	}
	private Node select(Node x, int k){
		//返回排名为k的结点
		if(x == null){
			return null;
		}
		int t = size(x.left);
		if(t > k){
			return select(x.left, k);
		}else if(t < k){
			return select(x.right, k-t-1);
		}else {
			return x;
		}
	}
	public int rank(Key key){
		return rank(key,root);
	}
	private int rank(Key key, Node x){
		if(x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			return rank(key,x.left);
		else if(cmp > 0){
			return 1+size(x.left)+rank(key,x.right);
		
		}
		else {
			return size(x.left);
		}
	}
	public void deleMin(){
		root = deleMin(root);
	}
	private Node deleMin(Node x){
		if(x.left == null)
			return x.right;
		x.left = deleMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public void delete(Key key){
		root = delete(root,key);
	}
	/**
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private Node delete(Node x, Key key){
		if (x == null) {
			return null;
		}
		/**
		 *  将指向即将被删除的结点的连接保存为t；
			将x指向它的后继结点min(t.right);
			将x的右链接（原本指向一颗所有结点都大于x.key的二叉查找树）指向deleteMin（t.right）
		   	也就是删除后所有的结点仍然都大于x.key的子二叉查找树；
			将x的左连接（本为空）设为t.left（其下所有的键都小于被删除的结点和它的后继结点）
		 */
		int cmp = key.compareTo(x.key);
		if(cmp < 0)
			x.left =delete(x.left, key);
		else if(cmp > 0)
			x.right = delete(x.right, key);
		else {
			if(x.left == null){
				return x.left;
			} 
			if(x.right == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) +1;
		return x;
		
	}
}
