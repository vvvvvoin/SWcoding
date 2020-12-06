package programers_Lv3;

import java.util.ArrayList;


public class Exam09 {
//	static int n = 3;
//	static int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
	static int n = 3;
	static int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
	public static void main(String[] args) {
		ArrayList<Integer>[] list = new ArrayList[n];
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < computers.length; i++) {
			for(int j = 0; j < n; j++) {
				if(computers[i][j] != 0 && i != j) {
					list[i]	.add(j);
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < list.length; i++){
			if(visited[i] == false) {
				dfs(i, list, visited);
				answer++;				
			}
		}
		System.out.println(answer);
	}
	private static void dfs(int start, ArrayList<Integer>[] list, boolean[] visited) {
		visited[start] = true;
		
		for(int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			if(visited[next] == false) {
				dfs(next, list, visited);
			}
		}
	}

}

	