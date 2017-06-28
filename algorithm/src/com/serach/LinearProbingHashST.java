package com.serach;
/**
 * ��������̽��ķ��ű�
 * @author Still2Almost
 *
 * @param <Key>
 * @param <Value>
 */
public class LinearProbingHashST<Key,Value>{
	private int N;	//���ű��� ��ֵ�ԵĴ�С
	private int M = 16; //����̽����еĴ�С
	private Key[] keys;	//��
	private Value[] values; //ֵ
	public LinearProbingHashST() {
		keys = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
	}
	private int hash(Key key){
		return (key.hashCode() & 0x7ffffff) % M;
	}
	/**
	 * ������
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
