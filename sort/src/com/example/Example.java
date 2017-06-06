package com.example;
/**
 * 排序算法的模版
 * @author Still2Almost
 *
 */
public class Example {
	public static void sort(Comparable[] a){
		
	}
	private static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	public static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Comparable[] a){
		//打印数据
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	private static boolean isSort(Comparable[] a){
		for(int i=1;i<a.length;i++){
			if(less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
}
