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
	public static void merge(Comparable[] a, int lo,int mid,int hi){
		//将a[lo...mid]和[mid+1...hi]合并
		Comparable[] aux = null;
		int i = lo;
		int j= mid + 1;
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];     //将a复制到aux
		}
		for(int k = lo; k<= hi; k++){
			if(j > mid)	//左半边用尽，取右边元素
				a[k] = aux[j++];
			else if(j > hi)//右半边用尽，取左边元素
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))//右半边的当前元素小于左半边的当前元素，取右边元素
				a[k] = aux[j++];
			else {
				a[k] = aux[i++];
			}
				
			
		}
	}
}
