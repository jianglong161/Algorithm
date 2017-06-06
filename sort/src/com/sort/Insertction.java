package com.sort;
/**
 * ≤Â»Î≈≈–Ú
 * @author Still2Almost
 *
 */
public class Insertction {
	public static void sort(int[] a){
		int start=1;
		for(int i=start;i<a.length;i++){
			int j=i;
			int temp=a[i];
			while(j>0&&a[j-1]>temp){
				a[j]=a[j-1];
				j--;
			}
			a[j]=temp;
		}
	}
}
