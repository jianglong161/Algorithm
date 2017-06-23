package com.serach;

import com.example.Noe_RedBlackTree;

/**
 * ������Ĳ����㷨
 * @author Still2Almost
 *
 * @param <Key>
 * @param <Value>
 */

public class RedBlacBST <Key extends Comparable<Key>, Value>{
	private Node root;
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	/**
	 * ������Ķ���
	 * @author Still2Almost
	 *
	 */
	private class Node{
		Key key;
		Value val;
		Node left,right;
		int N;
		boolean color;
		public Node(Key key, Value value, int N, boolean color){
			this.key = key;
			this.val = value;
			this.N = N;
			this.color =color;
		}
	
	}
	/**
	 * �ж��Ƿ�Ϊ����
	 * @param x
	 * @return
	 */
	public boolean isRed(Node x){
		if(x == null)
			return false;
		return x.color = RED;
	}
	/**
	 * ����תh��������
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	/**
	 * ����תh��������
	 * @param h
	 * @return
	 */
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	private void flipColors(Node h){}
	
	private int size(){
		return size(root);
	}
	public int size(Node x){
		if(x == null)
			return 0;
		else{
			return x.N;
		}
	}
	public void put(Key key, Value value){
		//����key���ҵ�������ֵ������Ϊ���½�һ�����
		root = put(root,key, value);
		root.color = BLACK;
	}
	private Node put(Node h, Key key, Value value){
		if(h == null){
			//��׼�Ĳ��붯���͸��ڵ��ú���������
			return new Node(key, value, 1, RED);
		}
		int com = key.compareTo(h.key);
		if(com < 0)
			h.left = put(h.left, key, value);
		else if(com > 0)
			h.right = put(h.right, key, value);
		else 
			h.val = value;
		if(isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right))
			flipColors(h);
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
}
