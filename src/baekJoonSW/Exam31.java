package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam31 {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) break;
			if(isValid(str)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
	private static boolean isValid(String str) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '[' || c == '(') {
				stack.add(c);
			}else if(c == ']') {
				if(stack.isEmpty()) {
					return false;
				}else if(stack.peek() != '[') {
					return false;
				}else stack.pop();
			}else if(c == ')') {
				if(stack.isEmpty()) {
					return false;
				}else if(stack.peek() != '(') {
					return false;
				}else stack.pop();
			}
		}
		if(stack.size() == 0) return true;
		else return false;
	}
}
