package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam21 {
	static BufferedReader br;
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		int m = Integer.valueOf(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		dfs(1);
		int answer = 0;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == true) answer++;
		}
		System.out.println(answer - 1);
	}

	private static void dfs(int start) {
		visited[start] = true;
		if(start == arr.length) return;
		for(int i = 1; i < arr.length; i++) {
			if(arr[start][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
		
	}
	
}
