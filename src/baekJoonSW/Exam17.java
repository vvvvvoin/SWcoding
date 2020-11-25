package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam17 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] arr;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		arr = new int[node + 1][node + 1];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		dfs(start, new boolean[node + 1]);
		System.out.println();
		bfs(start, new boolean[node + 1]);
		
	}

	private static void dfs(int start, boolean[] visited) {
		System.out.print(start + " ");
		visited[start] = true;
		
		if(start == arr.length) return;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[start][i] == 1 && visited[i] == false) {
				dfs(i, visited);
			}
		}
	}
	
	private static void bfs(int start, boolean[] visited) {
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for(int i = 1; i < arr.length; i++) {
				if(arr[temp][i] == 1 && visited[i] == false) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}
