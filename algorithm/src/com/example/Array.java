package com.example;

import java.util.Arrays;

public class Array {
	public int[] a;
	/**
	 * �ҵ���������Ԫ��
	 * @param a
	 * @return
	 */
	public int findMax(int[] a){
		int max = a[0];
		for(int i = 0; i < a.length; i++){
			if(a[i] > max)
				max = a[i];
		}
		return max;
	}
	/**
	 * ��������Ԫ�ص�ƽ��ֵ
	 * @param a
	 * @return
	 */
	public double avag(int[] a){
		double sum = 0.0;
		for(int i = 0; i < a.length; i++){
			sum += a[i];
		}
		return sum/a.length;
	
	}
	/**
	 * ��������
	 * @param a
	 * @return
	 */
	public String copyArray(int[] a){
		Integer[] b = new Integer[a.length];
		for(int i = 0; i < a.length; i++){
			b[i] = a[i];
		}
		return Arrays.toString(b);
	}
	/**
	 * �ߵ������Ԫ��˳��
	 * @param a
	 */
	public void reversalArray(int[] a){
		for(int i =0;i < a.length / 2; i ++){
			int temp = a[i];
			a[i] = a[a.length - 1 -i];
			a[a.length - i - 1] = temp;
		}
	}
}