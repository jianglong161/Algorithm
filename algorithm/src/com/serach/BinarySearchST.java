package com.serach;
/**
 * 二分查找，基于有序数据
 * @author Still2Almost
 *
 */
public class BinarySearchST <Key extends Comparable<Key>, Value>{
	private Key[] keys;
	private Value[] values;
	private int N;
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Comparable[capacity];
	}
	public int size(){
		return N;
	}
	public Value get(Key key){
		if(isEmpty()){
			return null;
		}
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0)
			return values[i];
		else {
			return null;
			
		}
	}
	public int rank(Key key){
		int lo = 0;
		int hi = N - 1;
		while (lo <= hi ) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0)
				hi = mid -1;
			else if(cmp > 0)
				lo = mid + 1;
			else {
				return mid;
			}
		}
		return lo;
	}
	public boolean isEmpty(){
		if(N == 0)
			return true;
		return false;
	}
	public void put(Key key , Value value){
		//查找键，找到更新值，否则创建新的元素
		int i = rank(key);
		if(i < N && keys[i].compareTo(key) == 0){
			values[i] = value;
			return;
		}
		for(int j = N; j > i; j--){
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}
	public void deleted(Key key){}
}
