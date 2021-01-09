package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam54_2 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		int size = input.length();
		char[] arr =new char[size + 1];
		boolean[][] dp = new boolean[size + 1][size + 1];
		
		for(int i = 1; i <= size; i++){
			arr[i] = input.charAt(i - 1);
		}
		
		for(int i = 1; i <= size; i++) {
			dp[i][i] = true;
		}
		
		for(int i = 1; i < size; i++) {
			if(arr[i] == arr[i + 1]) {
				dp[i][i + 1] = true;
			}
		}
		
		for(int i = 2; i < size; i++) {
			for(int j = 1; j <= size - i; j++) {
				if(arr[j] == arr[i + j] && dp[j + 1][j + i - 1]) {
					dp[j][i + j] = true;
				}
			}
		}
		
		int temp = -1;
		for(int i = 1; i <= size; i++) {
			if(dp[i][size] == true) {
				temp = Math.max(temp, size - i + 1);
			}
		}
		
		System.out.println(size + size - temp);

	}


}
