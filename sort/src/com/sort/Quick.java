package com.sort;
/**
 * 快速排序
 * @author Still2Almost
 *
 */
public class Quick {
	public static void sort(int[] array, int lo, int hi){
		int start = lo;
		int end = hi;
		int key = array[lo];
		while(end > start){
			//从后向前比较
			while(end > start && array[end] > key){
				end --;
				}
			if(array[end] <= key){
				int temp = array[end];
				array[end] = array[start];
				array[start] = temp;
			}
			//从前向后比较
			while (end > start && array[start] <= key) {
				start ++;
			}
			if(array[start] >= key){
				int temp = array[start];
				array[start] = array [end];
				array[end] = temp;
					
			}
		}
		if(start > lo)
			sort(array, lo, start - 1);
		if(end < hi)
			sort(array, end + 1, hi);
		
	}
	
}
