package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam56_2016 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		dp = new int[n + 1][n +1];
		
		if(m != 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				int index = Integer.parseInt(st.nextToken());
				arr[index] = -1;
			}
		}
		
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < n +1; j++) {
				dp[i][j] = -1;
			}
		}
		
		int answer = solve(1, 0);
		System.out.println(answer);
	}
	
	static int solve(int d, int c) {
		//날이 초과하면 계산을 멈추고 비교
		if(d > n) return 0;
		
		if(dp[d][c] != -1) return dp[d][c];
		
		dp[d][c] = 999999999;
		//쉬는날일 경우

		if(arr[d] == -1) {
			dp[d][c] = Math.min(dp[d][c], solve(d + 1, c));
		}
		
		dp[d][c] = Math.min(dp[d][c], solve(d + 5, c + 2) + 37000);
		dp[d][c] = Math.min(dp[d][c], solve(d + 3, c + 1) + 25000);
		dp[d][c] = Math.min(dp[d][c], solve(d + 1, c) + 10000);
		
		if(c >= 3) {
			dp[d][c] = Math.min(dp[d][c], solve(d + 1, c - 3));
		}
		return dp[d][c];
	}
}
