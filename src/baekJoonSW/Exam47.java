package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam47 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int row;
	static int col;
	
	static int[][] arr;
	static int[] dirR = {0, 0, -1, 1};
	static int[] dirC = {1, -1, 0, 0};
	static int answer = Integer.MIN_VALUE;
	static int safeCnt;
	static int temp;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		row = Integer.valueOf(st.nextToken());
		col = Integer.valueOf(st.nextToken());
		arr = new int[row][col];
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				if(arr[i][j] == 0) safeCnt++;
			}
		}
		
		solution(0, 0, 0);
		
		System.out.println(answer);
	}
	
	private static void solution(int i, int j, int cnt) {
		if(cnt == 3) {
			spreadVirus(new boolean[row][col]);
			return;
		}
		if(j == col) {
			solution(i + 1, 0, cnt);
			return;
		}
		if(i == row) {
			return;
		}
		
		if(arr[i][j] == 0) {
			arr[i][j] = 1;
			solution(i, j + 1, cnt + 1);
			arr[i][j] = 0;
		}
		solution(i, j + 1, cnt);
		
	}

	private static void spreadVirus(boolean[][] visited) {
		temp = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(arr[i][j] == 2) {
					dfs(i, j, visited);
				}
			}
		}
		answer = Math.max(answer, safeCnt - temp - 3);
	}
	
	private static void dfs(int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		for(int o = 0; o < 4; o++) {
			int nextR = i + dirR[o];
			int nextC = j + dirC[o];
			if(nextR >= 0 && nextC >= 0 && nextR < row && nextC < col && visited[nextR][nextC] == false && arr[nextR][nextC] == 0) {
				dfs(nextR, nextC, visited);
				temp++;
			}
		}
	}
}
