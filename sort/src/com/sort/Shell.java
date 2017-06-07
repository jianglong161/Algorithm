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
}
