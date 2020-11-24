package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam53_2015 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[m][m];

		for (int o = 0; o < n; o++) {
			st = new StringTokenizer(br.readLine());
			int value0 = Integer.parseInt(st.nextToken());
			int value1 = Integer.parseInt(st.nextToken());
			int value2 = Integer.parseInt(st.nextToken());

			for (int i = arr.length - 1; i >= 0; i--) {
				if (value0 != 0) {
					value0--;
				} else if (value1 != 0) {
					arr[i][0] += 1;
					value1--;
				} else if (value2 != 0) {
					arr[i][0] += 2;
					value2--;
				}
			}
			for (int i = 1; i < arr.length; i++) {
				if (value0 != 0) {
					value0--;
				} else if (value1 != 0) {
					arr[0][i] += 1;
					value1--;
				} else if (value2 != 0) {
					arr[0][i] += 2;
					value2--;
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[i][j] = Math.max(arr[i - 1][j], Math.max(arr[i][j - 1], arr[i - 1][j - 1]));
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[i][j] + 1 + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
