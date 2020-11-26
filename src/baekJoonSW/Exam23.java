package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam23 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		int answer = 0;
		for(int i = 1; i < arr.length; i++) {
			if(visited[i] == false) {
				answer++;
				dfs(i);							
			}
		}
		System.out.println(answer);
	}
	private static void dfs(int start) {
		visited[start] = true;
		for(int i = 1; i <arr.length; i++) {
			if(visited[i] == false && arr[start][i] == 1) {
				dfs(i);
			}
		}
		
	}
	
}
