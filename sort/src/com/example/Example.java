package com.example;
/**
 * �����㷨��ģ��
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
		//��ӡ����
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
		//��a[lo...mid]��[mid+1...hi]�ϲ�
		Comparable[] aux = null;
		int i = lo;
		int j= mid + 1;
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];     //��a���Ƶ�aux
		}
		for(int k = lo; k<= hi; k++){
			if(j > mid)	//�����þ���ȡ�ұ�Ԫ��
				a[k] = aux[j++];
			else if(j > hi)//�Ұ���þ���ȡ���Ԫ��
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))//�Ұ�ߵĵ�ǰԪ��С�����ߵĵ�ǰԪ�أ�ȡ�ұ�Ԫ��
				a[k] = aux[j++];
			else {
				a[k] = aux[i++];
			}
				
			
		}
	}
}
