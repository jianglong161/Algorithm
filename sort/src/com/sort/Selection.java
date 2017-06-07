package com.sort;
/**
 * 选择排序
 * @author Still2Almost
 *
 */
public class Selection {
	public static void sort(int [] a){
		for(int i=0;i<a.length;i++){
			int min=i;	//将当前坐标定义为最小值
			for(int j=i+1;j<a.length;j++){
				if(a[j]< a[min]){/*如果有小于当前最小值的关键字*/
					min=j;/*将此关键字的下标赋值给min*/
				}
			}
			if(i!=min){/* 若min不等于i,说明找到最小值，交换*/
				int t=a[i];
				a[i]=a[i+1];
				a[i+1]=t;
			}
		}
	}
}
