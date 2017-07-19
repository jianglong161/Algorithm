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
	private int modCount;	//�Թ������������������ı�Ĵ���
	private Node<AnyType> beginMarker; 	//ͷ�ڵ�
	private Node<AnyType> endMark;		//β�ڵ�
	/**
	 * �����ʾ��
	 * @author Long
	 *
	 * @param <AnyType>
	 */
	private static class Node<AnyType>{
		public AnyType data;	//�ڵ��ϵ�����
		public Node<AnyType> prev;	//��һ���ڵ�
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
	 * ����м�����ֻ��ͷ��β
	 */
	public void clear(){
		beginMarker = new Node<AnyType>(null, null, null);
		endMark = new Node<AnyType>(null, beginMarker, null);
		beginMarker.next = endMark;
		
		theSize = 0;
		modCount ++;
	}
	
	/**
	 * ��ʾ���������
	 * @return
	 */
	public int size(){
		return theSize;
	}
	
	/**
	 * �ж������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return size() == 0;
	}
	
	/**
	 * �ж��Ƿ��������Ԫ��
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
		p.next.prev = p.prev;	//next.prev������
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
