package com.sort;
/**
 * —°‘Ò≈≈–Ú
 * @author Still2Almost
 *
 */
public class Selection {
	public static void sort(int [] a){
		for(int i=0;i<a.length;i++){
			int min=i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]< a[min]){
					min=j;
				}
			}
			if(i!=min){
				int t=a[i];
				a[i]=a[i+1];
				a[i+1]=t;
			}
		}
	}
}
