package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exam41 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int max = 0;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		
		solution(str1, str2, str3);
	}
	private static void solution(String str1, String str2, String str3) {
		int[][][] dp = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];
		for(int i = 1; i < str1.length() + 1; i++) {
			for(int j = 1; j < str2.length() + 1; j++) {
				for(int k = 1; k < str3.length() + 1; k++) {
					if(str1.charAt(i - 1) == str2.charAt(j - 1) && str2.charAt(j - 1) == str3.charAt(k - 1)) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					}else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}
		Stack<Character> stack = new Stack<Character>();
		int i = str1.length();
		int j = str2.length();
		int k = str3.length();
		while(i >= 1 && j >= 1 &&  k >= 1) {
			if(dp[i][j][k] == dp[i - 1][j][k]) {
				i--;
			}else if(dp[i][j][k] == dp[i][j - 1][k]) {
				j--;
			}else if(dp[i][j][k] == dp[i][j][k - 1]) {
				k--;
			}else {
				stack.add(str1.charAt(i - 1));
				i--;
				j--;
				k--;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString().length());
	}
}
