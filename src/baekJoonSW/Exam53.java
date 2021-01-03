package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam53 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int target = Integer.valueOf(st.nextToken());
		
		int[] coin = new int[n];
		int[] dp = new int[target + 1];
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.valueOf(br.readLine());
		}
		Arrays.fill(dp, 99999999);
		dp[0] = 0;
		for(int i = 0 ; i < n; i++) {
			for(int j = coin[i] ; j <= target; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		System.out.println(dp[target] == 99999999 ? -1 : dp[target]);
	}
}
