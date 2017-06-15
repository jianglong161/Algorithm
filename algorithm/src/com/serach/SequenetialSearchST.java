package com.serach;
/**
 * ˳����ң����������б�
 * @author Still2Almost
 *
 * @param <Key>
 * @param <Value>
 */

public class SequenetialSearchST<Key,Value> {
	private Node first;	//������׽��
	private class Node{
		//������Ķ���
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
				return x.val;	//����
			}
		}
		return null;	//û������
		
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
