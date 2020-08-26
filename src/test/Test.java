package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
	static String w= "()";
	public static void main(String[] args) {
		int left = 0;
		int right = 0;
		String u = "";
		String v = "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < w.length(); i++) {
			if(w.charAt(i) == '(') {
				sb.append("(");
				left++;
			}else {
				sb.append(")");
				right++;
			}
			
			if(left != 0 && right != 0 && right == left) {
				u = sb.toString();
				v = w.substring(left+right, w.length());
				sb.delete(0, sb.length());
				break;
			}
		}
		
		System.out.println(u);
		System.out.println(v);
	}
}
