package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam14 {
	// https://www.acmicpc.net/problem/11404
	static BufferedReader br;
	static StringTokenizer st;
	static final int INF = 9999999;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][n + 1];

		// 초기화
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (i == j)	continue;
				arr[i][j] = INF;
			}
		}

		// 입력
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			arr[a][b] = Math.min(arr[a][b], value);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			String str = "";
			for (int j = 1; j <= n; j++) {
				if(arr[i][j] >= INF) {
					str += 0 + " ";
				}else {
					str += arr[i][j] + " "; 					
				}
			}
			System.out.println(str.trim());
		}
	}
}
