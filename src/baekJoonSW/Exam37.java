package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam37 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();

		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length; i++) {
			stack.add(str[i]);
			
			if(stack.size() >= bomb.length) {
				boolean flag = true;
				for(int j = 0; j < bomb.length; j++) {
					if(stack.get(stack.size() - bomb.length + j) != bomb[j]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j = 0; j < bomb.length; j++) {
						stack.pop()						;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char ch : stack) {
			sb.append(ch);
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}


}
