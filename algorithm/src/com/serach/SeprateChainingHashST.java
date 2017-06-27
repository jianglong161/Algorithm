package com.serach;

import java.util.Iterator;


/**
 * ������������ɢ�б�
 * *
 */

public class SeprateChainingHashST <Key, Value>{
	private int N;	//��ֵ������
	private int M;	//ɢ�б�Ĵ�С
	private SeprateChainingHashST<Key,Value>[] st;//���������������
	public SeprateChainingHashST() {
		
	}
	public SeprateChainingHashST(int M) {
		//����M��������
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
