package com.example;

import java.lang.annotation.Retention;

public class StringEx {
	/**
	 * �ж��ַ����Ƿ�����������
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
	 * ��һ�������в�������ȡ�ļ�������չ��
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
