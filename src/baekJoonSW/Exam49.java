package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam49 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int row;
	
	static int[][] arr;
	static boolean[][] visited;
	static int[] dirR = {0, 0, -1, 1};
	static int[] dirC = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		row = Integer.valueOf(br.readLine());
		
		arr = new int[row][row];
		visited = new boolean[row][row];
		
		for(int i = 0; i < row; i++) {
			String str = br.readLine();
			for(int j = 0; j < row; j++) {
				if(str.charAt(j) == 'R') {
					arr[i][j] = 1;
				}else if(str.charAt(j) == 'G') {
					arr[i][j] = 2;
				}else {
					arr[i][j] = 3;
				}
			}
		}
		int normal = solution();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < row; j++) {
				if(visited[i][j] == true) {
					visited[i][j] = false;
				}
				if(arr[i][j] == 2) arr[i][j] = 1;
			}
		}
		int abnormal = solution();
		System.out.println(normal + " " + abnormal);
	}

	private static int solution() {
		int value = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < row; j++) {
				if(visited[i][j] == false) {
					value++;
					normalDfs(i, j);				
				}
			}
		}
		return value;
	}
	
	private static void normalDfs(int i, int j) {
		visited[i][j] = true;
		for (int o = 0; o < 4; o++) {
			int nextR = i + dirR[o];
			int nextC = j + dirC[o];
			if(isValid(nextR, nextC)) {
				if (arr[i][j] == arr[nextR][nextC] && visited[nextR][nextC] == false) {
					normalDfs(nextR, nextC);
				}
			}
		}
	}

	
	private static boolean isValid(int nextR, int nextC) {
		if(nextR >= 0 && nextC >= 0 && nextR < row && nextC < row) return true;
		else return false;
	}
}
