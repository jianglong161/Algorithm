package com.ADT;

import java.io.ObjectInputStream.GetField;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.lang.model.type.PrimitiveType;

import org.omg.CORBA.Any;
import org.omg.CORBA.Current;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class MyLinkedList<AnyType> implements Iterable<AnyType>{
	private int theSize;
	private int modCount;	//自构造器依赖对链表所改变的次数
	private Node<AnyType> beginMarker; 	//头节点
	private Node<AnyType> endMark;		//尾节点
	/**
	 * 链表表示类
	 * @author Long
	 *
	 * @param <AnyType>
	 */
	private static class Node<AnyType>{
		public AnyType data;	//节点上的数据
		public Node<AnyType> prev;	//上一个节点
		public Node<AnyType> next;
		public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
			data = d;
			prev = p;
			next = n;
		}
	}
	public MyLinkedList() {
		clear();
	}
	/**
	 * 清空中间链表，只留头和尾
	 */
	public void clear(){
		beginMarker = new Node<AnyType>(null, null, null);
		endMark = new Node<AnyType>(null, beginMarker, null);
		beginMarker.next = endMark;
		
		theSize = 0;
		modCount ++;
	}
	
	/**
	 * 表示链表的数量
	 * @return
	 */
	public int size(){
		return theSize;
	}
	
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size() == 0;
	}
	
	/**
	 * 判断是否能添加新元素
	 * @param x
	 * @return
	 */
	public boolean add(AnyType x){
		add(size(), x);
		return true;
	}
	public void add(int idx, AnyType x){
		addBefore(getNode(idx), x);
	}
	
	private void addBefore(Node<AnyType> p, AnyType x){
		Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize ++;
		modCount ++;
	}
	private AnyType remove(Node<AnyType> p){
		p.next.prev = p.prev;	//next.prev有用吗
		p.prev.next = p.next;
		theSize --;
		modCount ++;
		return p.data;
	}
	private Node<AnyType> getNode(int idx){
		Node<AnyType> p;
		if(idx < 0 || idx > size())
			throw new IndexOutOfBoundsException();
		if(idx < size() / 2){
			p = beginMarker.next;
			for(int i = 0 ; i< idx; i ++){
				p = p.next;
			}
			
		}else{
			p = endMark;
			for( int i = size(); i > idx; i--){
				p = p.prev;
			}
		}
		return p;
	}
	public AnyType get(int idx){
		return getNode(idx).data;
	}
	public AnyType Set(int idx, AnyType newVal){
		Node<AnyType> p = getNode(idx);
		AnyType oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	public AnyType remove(int idx){
		return remove(getNode(idx));
	}
	@Override
	public Iterator<AnyType> iterator() {
		return new LinkedlistIterator();
	}
	private class LinkedlistIterator implements Iterator<AnyType>{
		private Node<AnyType> current = beginMarker.next;
		private int expecteModCount = modCount;
		private boolean okToRemove = false;
		@Override
		public boolean hasNext() {
			return current != endMark;
		}

		@Override
		public AnyType next() {
			if(modCount != expecteModCount)
				throw new ConcurrentModificationException();
			if(!hasNext())
				throw new NoSuchElementException();
			AnyType nextItme = current.data;
			current = current.next;
			okToRemove = true;
			return nextItme;
		}
		public void remove(){
			if(modCount != expecteModCount)
				throw new ConcurrentModificationException();
			if(!hasNext())
				throw new NoSuchElementException();
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expecteModCount ++;
		}
		
	}
}
