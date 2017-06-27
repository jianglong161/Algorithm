package com.serach;

import java.util.Iterator;


/**
 * 基于拉链法的散列表
 * *
 */

public class SeprateChainingHashST <Key, Value>{
	private int N;	//键值对总数
	private int M;	//散列表的大小
	private SeprateChainingHashST<Key,Value>[] st;//存放链表对象的数组
	public SeprateChainingHashST() {
		
	}
	public SeprateChainingHashST(int M) {
		//创建M条了链表
		this.M = M;
		st = new SeprateChainingHashST[M];
		for(int i= 0; i < st.length; i++){
			st[i] = new SeprateChainingHashST();
		}
	}
	
	private int hash(Key key){
		return(key.hashCode() & 0x7fffffff) % M;	
	}
	public Value get(Key key){
		return st[hash(key)].get(key);
	}
	public void put(Key key,Value value){
		st[hash(key)].put(key, value);
	}
	public Iterable<Key> keys(){
		for(SeprateChainingHashST<Key, Value> key: st){
			System.out.println(key.toString());
		}
		return keys();
		
	}

}
