package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam49_2014 {
	static BufferedReader br;
	static StringTokenizer st;
	static int answer = 0;
	static int[][] arr;
	static int rK, cK;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[row + 1][col + 1];
		rK = -1;
		cK = -1;
		
		arr[0][1] = 1;
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j -1];
			}
		}

		
		if (k == 0) {
			System.out.println(arr[row][col]);
		} else {
			rK = (k - 1) / col + 1;
			cK = (k - 1) % col + 1;
			System.out.println(arr[rK][cK] * arr[row - rK +1][col -cK +1] );
		}
	}

}
