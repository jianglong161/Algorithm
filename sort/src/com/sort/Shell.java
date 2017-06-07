package com.sort;
/**
 * Ï£¶ûÅÅÐò
 * @author Still2Almost
 *
 */
public class Shell {
	public static void sort(int[] data){
		int j = 0;
		int temp = 0;
		for(int increment=data.length/2;increment>0;increment/=2){
			for(int i=increment;i<data.length;i++){
				temp=data[i];
				for(j=i-increment;j>0;j++){
					if(temp<data[j]){
						data[j+increment]=data[j];
					}else {
						break;
					}
				}
			}
			data[j+increment] = temp;
		}
		for(int i=0;i<data.length;i++){
			System.out.println(data[i]+ " ");
		}
	}
	public static void sortOther(int[] data){
		int h = 1;
		while (h <= data.length / 3) {
			h = h * 3 + 1;
		}
		while (h>0) {
			for(int i=h;i<data.length;i+=h){
				if(data[i]<data[i-1]){
					int temp = data[i];
					int j = i - h;
					while(j > 0 && data[j]>temp){
						data[j + h] = data[j];
						j -= h;
					}
					data[j + h] = temp;
				}
			}
			h = (h - 1) / 3;
		}
	}
}
