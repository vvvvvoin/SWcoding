package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam52_2015 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int[] arr1;
	static int[] arr2;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr1 = new int[n];
		arr2 = new int[n];
		dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		
		System.out.println(solve(0, 0));

	}
	
	static int solve(int index1, int index2) {
		if(index1 >= n || index2 >= n) {
			return 0;
		}
		
		if(dp[index1][index2] != -1) {
			return dp[index1][index2];
		}
		
		dp[index1][index2] = Math.max(solve(index1 + 1, index2), solve(index1 + 1, index2 + 1));
		
		if(arr1[index1] > arr2[index2]) {
			dp[index1][index2] = Math.max(dp[index1][index2], arr2[index2] + solve(index1, index2 + 1));
		}
		return dp[index1][index2];
	}
}
