package com.sort;
/**
 * ��������
 * @author Still2Almost
 *
 */
public class Quick {
	public static void sort(int[] array, int lo, int hi){
		int start = lo;
		int end = hi;
		int key = array[lo];
		while(end > start){
			//�Ӻ���ǰ�Ƚ�
			while(end > start && array[end] > key){
				end --;
				}
			if(array[end] <= key){
				int temp = array[end];
				array[end] = array[start];
				array[start] = temp;
			}
			//��ǰ���Ƚ�
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
