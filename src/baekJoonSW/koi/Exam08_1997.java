package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam08_1997 {
	static BufferedReader br;
	static final int INF = 9999999;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] array = new int[n + 1][n + 1];
		
		for(int i = 0 ; i < array.length; i++) {
			for(int j = 0 ; j < array.length; j++) {
				if(i == j) continue;
				array[i][j] = INF;
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1) break;
			array[a][b] = array[b][a] = 1;
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					array[i][j] = Math.min(array[i][k] + array[k][j], array[i][j]);
				}
			}
		}
		
		int[] score = new int[n + 1];
		int max = 0;
		int min = INF;
		for(int i = 1; i <= n; i++) {
			max = 0;
			for(int j = 1; j <= n; j++) {
				if(array[i][j] == INF) continue;
				max = Math.max(array[i][j], max);
			}
			score[i] = max;
			min = Math.min(score[i], min);
		}
		int minCnt = 0;
		String temp = "";
		for(int i = 1; i <= n; i++) {
			if(score[i] == min) {
				minCnt++;
				temp += i + " ";
			}
		}
		System.out.println(min + " " + minCnt);
		System.out.println(temp.trim());
	}
}
