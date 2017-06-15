package com.serach;
/**
 * 顺序查找，基于无序列表
 * @author Still2Almost
 *
 * @param <Key>
 * @param <Value>
 */

public class SequenetialSearchST<Key,Value> {
	private Node first;	//链表的首结点
	private class Node{
		//链表结点的定义
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.val = value;
			this.next = next;
		}
	}
	public Value get(Key key){
		for(Node x = first; x != null; x = x.next){
			if (key.equals(x.key)) {
				return x.val;	//命中
			}
		}
		return null;	//没有命中
		
	}
	public void put(Key key,Value value){
		for(Node x = first; x != null; x = x.next){
			if(key.equals(x.key)){
				x.val = value;
				return;
			}
			
		}
		first = new Node(key, value, first);
	}
	

}
