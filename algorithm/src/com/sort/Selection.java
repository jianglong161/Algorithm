package com.sort;
/**
 * ѡ������
 * @author Still2Almost
 *
 */
public class Selection {
	public static void sort(int [] a){
		for(int i=0;i<a.length;i++){
			int min=i;	//����ǰ���궨��Ϊ��Сֵ
			for(int j=i+1;j<a.length;j++){
				if(a[j]< a[min]){/*�����С�ڵ�ǰ��Сֵ�Ĺؼ���*/
					min=j;/*���˹ؼ��ֵ��±긳ֵ��min*/
				}
			}
			if(i!=min){/* ��min������i,˵���ҵ���Сֵ������*/
				int t=a[i];
				a[i]=a[i+1];
				a[i+1]=t;
			}
		}
	}
}
