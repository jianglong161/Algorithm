package com.sort;
/**
 * 自顶向下归并排序
 * @author Still2Almost
 *
 */
import com.example.Example;;
public class Merge {
	private static Comparable[] aux;	//归并需要的辅助数组‘
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length] ;
		sort(a, 0, a.length-1);
	}
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi <= lo)
			return;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, lo);
		Example.merge(a, lo, mid, hi);
	}
}
