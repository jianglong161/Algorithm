package com.example;

import java.lang.annotation.Retention;

public class StringEx {
	/**
	 * 判断字符串是否是以条回文
	 * @param s
	 * @return
	 */
	public boolean isPaTindrom(String s){
		int N = s.length();
		for(int i = 0; i < N/2; i ++){
			if(s.charAt(i) != s.charAt(N - 1 -i))
				return false;	 
		}
		return true;
	}
	/**
	 * 从一个命令行参数中提取文件名和扩展名
	 * @param s
	 * @return
	 */
	public String fineName(String s){
		int dot = s.indexOf(".");
		String base = s.substring(0, dot);
		String extension = s.substring(dot + 1, s.length());
		return extension;
	}
}
