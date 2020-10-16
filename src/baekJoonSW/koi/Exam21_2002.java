package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam21_2002 {
	static BufferedReader br;
	static StringTokenizer st;

	static int m;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		Coin[] coin = new Coin[101];
		int[][] dp = new int[10001][101];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			coin[i] = new Coin(value, cnt);
		}
		
		//각 동전부터
		for(int i = 1; i <= n; i++) {
			//구하고자 하는 m의 경우까지
			int value = coin[i].value;
			int cnt = coin[i].cnt;
			//동전 개수를 1개부터 cnt까지
			dp[0][i - 1] = 1;
			for (int j = 1; j <= cnt; j++) {
				for (int k = value * j; k <= m; k++) {
					// value = coin[i]와 같다.
					//k - (value * j) 했을 경우 이전 동전까지 교환할때 가지의 경우의 수
					dp[k][i] += dp[k - (value * j)][i - 1];
				}
			}
			//이전에 계산했던 가지 수를 누적시켜준다
			for (int j = 1; j <= m; j++) {
				dp[j][i] += dp[j][i - 1];
			}

		}
		System.out.println(dp[m][n]);
	}
	
	private static class Coin{
		private int value;
		private int cnt;
		public Coin(int value, int cnt) {
			super();
			this.value = value;
			this.cnt = cnt;
		}
		
	}

}
