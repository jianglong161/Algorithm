package com.sort;
/**
 * 自底向上的归并排序
 * @author Still2Almost
 *
 */
import com.example.Example;
public class MergeBU {
	private static Comparable[] aux;
	public static void sort(Comparable<Integer>[] a){
		//进行lgN次两两排序
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz < N; sz = sz + sz){
			for(int lo = 0; lo < N-sz; lo+=sz + sz){
				Example.merge(a, lo, lo+sz-1, Math.min(lo + sz + sz + 1, N - 1));
			}
		}
	}
}
