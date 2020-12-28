package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam48 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int row;
	static int col;
	
	static int[][] arr;
	static	 boolean[] visited;
	static int[] dirR = {0, 0, -1, 1};
	static int[] dirC = {1, -1, 0, 0};
	static int answer = 1;
	static int temp = 1;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		row = Integer.valueOf(st.nextToken());
		col = Integer.valueOf(st.nextToken());
		visited = new boolean[26];
		arr = new int[row][col];
		for(int i = 0; i < row; i++) {
			String str = br.readLine();
			for(int j = 0; j < col; j++) {
				arr[i][j] = str.charAt(j) - 'A';
			}
		}
		visited[arr[0][0]] = true;
		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int i, int j) {

		if (temp > answer) {
			answer = temp;
		}

		for (int o = 0; o < 4; o++) {
			int nextR = i + dirR[o];
			int nextC = j + dirC[o];
			if (nextR >= 0 && nextC >= 0 && nextR < row && nextC < col) {
				int next = arr[nextR][nextC];
				if (visited[next] == false) {
					temp++;
					visited[next] = true;
					dfs(nextR, nextC);
					visited[next] = false;
					temp--;
				}

			}
		}

	}
}
