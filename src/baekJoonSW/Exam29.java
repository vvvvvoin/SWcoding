package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam29 {
	static BufferedReader br;
	static StringTokenizer st;
	static String[] str1;
	static String[] str2;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine().split("");
		str2 = br.readLine().split("");
		
		int[][] dp = new int[str1.length + 1][str2.length + 1];
		
		for(int i = 1; i < str1.length + 1; i++) {
			for(int j = 1; j < str2.length + 1; j++) {
				if(str1[i - 1].equals(str2[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[str1.length][str2.length]);
		Stack<String> stack = new Stack<String>();
		int i = str1.length;
		int j = str2.length;
		while(i >= 1 && j >= 1) {
			if(dp[i][j] == dp[i - 1][j]) {
				i--;
			}else if(dp[i][j] == dp[i][j - 1]) {
				j--;
			}else {
				stack.add(str1[i - 1]);
				i--;
				j--;
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}

}
