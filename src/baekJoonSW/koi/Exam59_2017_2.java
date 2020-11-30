package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam59_2017_2 {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static int TIME;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		TIME = Integer.parseInt(st.nextToken());
		dp = new int[n][TIME + 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int a  = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			int d = Integer.parseInt(s[3]);
			
			if(i == 0) {
				dp[0][a] = b;
				//a == c일 경우 dp[0][c]에 큰 값을 넣는다.
				//다를 경우 -1로 초기화 했으므로 d가 대입된다.
				dp[0][c] = Math.max(dp[0][c], d);
			}else {
				for(int t = 0; t <= TIME; t++) {
					if(dp[i - 1][t] == -1) continue;
					else {
						if(a + t <= TIME) {
							dp[i][t + a] = Math.max(dp[i][t + a], dp[i - 1][t] + b);
						}
						if(c + t <= TIME) {
							dp[i][t + c] = Math.max(dp[i][t + c], dp[i - 1][t] + d);
						}
					}
				}
			}			
		}
		int answer = 0;
		for(int i = 1; i<= TIME; i++) {
			answer = Math.max(answer, dp[n - 1][i]);
		}
		

		System.out.println(answer);
	}
}
