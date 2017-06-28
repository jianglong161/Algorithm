package com.serach;
/**
 * 基于线性探测的符号表
 * @author Still2Almost
 *
 * @param <Key>
 * @param <Value>
 */
public class LinearProbingHashST<Key,Value>{
	private int N;	//符号表中 键值对的大小
	private int M = 16; //线性探测表中的大小
	private Key[] keys;	//键
	private Value[] values; //值
	public LinearProbingHashST() {
		keys = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
	}
	private int hash(Key key){
		return (key.hashCode() & 0x7ffffff) % M;
	}
	/**
	 * 扩大倍数
	 */
	private void resize(int cap){
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<Key,Value>();
		for(int i = 0; i< M;i++){
			if(keys[i] != null)
				t.put(keys[i], values[i]);
		}
		keys = t.keys;
		values = t.values;
		M =t.M;
	}
	public void put(Key key, Value value){
		if(N >= M/2)
			resize(2 * M);
		int i;
		for(i = hash(key); keys[i] != null; i=(i + 1) % M){
			if(keys[i].equals(key)){
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}
	public Value get(Key key){
		int i;
		for(i = hash(key); keys[i] != null; i=(i + 1) % M){
			if(keys[i].equals(key))
				return values[i];
		}
		return null;
	}
}
