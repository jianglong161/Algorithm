package com.example;
/**
 * ºìºÚÊ÷µÄ¶¨Òå
 * @author Still2Almost
 *
 */
public class Noe_RedBlackTree <Key extends Comparable<Key>, Value>{
	private  static final boolean RED = true;
	private static final boolean BLACK = false;
	Key key;
	Value val;
	Noe_RedBlackTree left,right;
	int N;
	boolean color;
	public Noe_RedBlackTree(Key key, Value value, int N, boolean color) {
		this.key = key;
		this.val = value;
		this.N = N;
		this.color =color;
	}
	public boolean isRed(Noe_RedBlackTree x){
		if(x == null)
			return false;
		return x.color = RED;
	}
}
