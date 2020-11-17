package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam48_2014 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] answer = new int[n + 1];
		int[][] arr = new int[1001][1001];
		
		int cnt = 1;
		int row = 0;
		int col = 0;
		int width = 0;
		int height = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			for(int j = row; j < row + height; j++) {
				for(int k = col; k < col + width; k++) {
					arr[j][k] = cnt;
				}
			}
			cnt++;
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				answer[arr[i][j]]++;
			}
		}
		
		if(answer.length == 1) {
			System.out.println(0);
		}else {
			for(int i = 1; i < answer.length; i++) {
				System.out.println(answer[i]);
			}
		}

	}
}
