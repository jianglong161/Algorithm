package com.serach;

import javax.naming.InitialContext;

/**
 * x`
 * @author Still2Almost
 *
 */
public class BST <Key extends Comparable<Key> ,Value>{
	private Node root;	//����������ĸ��ڵ�
	private class Node{
		private Key key; //��
		private Value val;	//ֵ
		private Node left, right;	//ָ������������
		private int N; 	//�Ըý��Ϊ���������еĽ������
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
	 * ���Ҹ����
	 * @param key
	 * @return
	 */
	public Value get(Key key){
		return get(root,key);
	}
	/**
	 * ��xΪ���ڵ�������в��Ҳ�����key�Ķ�Ӧֵ
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
		//����key���ҵ����������ֵ������Ϊ������һ���µĽڵ�
		root = put(root, key, val);
	}
	private Node put(Node x, Key key, Value val){
		//���key��������xΪ���ڵ����������������ֵ
		//������key��valueΪ�¼�ֵ���뵽������
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
		//��������Ϊk�Ľ��
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
		 *  ��ָ�򼴽���ɾ���Ľ������ӱ���Ϊt��
			��xָ�����ĺ�̽��min(t.right);
			��x�������ӣ�ԭ��ָ��һ�����н�㶼����x.key�Ķ����������ָ��deleteMin��t.right��
		   	Ҳ����ɾ�������еĽ����Ȼ������x.key���Ӷ����������
			��x�������ӣ���Ϊ�գ���Ϊt.left���������еļ���С�ڱ�ɾ���Ľ������ĺ�̽�㣩
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
