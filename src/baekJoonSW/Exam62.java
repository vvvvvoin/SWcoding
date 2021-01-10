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

public class Exam62 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Memory[] arr = new Memory[n + 1];
		int[][] dp = new int[n + 1][100001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int useM = Integer.parseInt(st.nextToken());
			arr[i] = new Memory(useM, 0);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int deleM = Integer.parseInt(st.nextToken());
			arr[i].deleteMemory = deleM;
		}
		
		int answer = 9999999;
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= 100000; j++) {
				if(j >= arr[i].deleteMemory) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i].deleteMemory] + arr[i].useMemory);
				}else {
					dp[i][j] = dp[i - 1][j];
				}
				
				if(dp[i][j] >= m) answer = Math.min(answer, j) ;
			}
		}
		System.out.println(answer);

	}

	private static class Memory {
		int useMemory;
		int deleteMemory;
		public Memory(int useMemory, int deleteMemory) {
			super();
			this.useMemory = useMemory;
			this.deleteMemory = deleteMemory;
		}
	}
}
