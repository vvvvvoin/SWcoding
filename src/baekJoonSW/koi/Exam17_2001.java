package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam17_2001 {
	static BufferedReader br;

	public static void main(String[] args) throws Exception {		
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		int[] dp = new int[N];
		for(int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		dp[0] = 1;
		for(int i = 1; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(array[i] >= array[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);				
				}
			}
			max = Math.max(max,dp[i]);
		}
		System.out.println(N - max);
	}
}
