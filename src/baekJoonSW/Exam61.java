package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam61 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Stuff[] arr = new Stuff[n + 1];
		int[][] dp = new int[n + 1][m + 1];
		
		
		for(int i = 1; i  <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			arr[i] = new Stuff(weight, value);
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(j - arr[i].weight >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i].weight] + arr[i].value);
				}else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		System.out.println(dp[n][m]);		
		
	}

	private static class Stuff {
		int weight;
		int value;
		public Stuff(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

	}
}
