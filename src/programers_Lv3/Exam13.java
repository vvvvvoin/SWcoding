package programers_Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class Exam13 {
	static int n = 5; 
	static int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
	public static void main(String[] args) {
		int answer = 0;
		int[][] arr = new int[n + 1][n + 1];
		for(int i = 0; i < results.length; i++) {
			int a = results[i][0];
			int b = results[i][1];
			arr[a][b] = 1;
			arr[b][a] = -1;
		}
		
		for(int i = 1; i <=n ; i++) {
			Queue<Integer> q = new  LinkedList<Integer>();
			boolean[] visited = new boolean[n + 1];
			visited[i] = true;
			q.add(i);
			int cnt = 0;
			while(!q.isEmpty()) {
				int temp = q.poll();
				for(int j = 1; j < arr.length; j++) {
					if(visited[j] == false && arr[temp][j] == 1) {
						visited[j] = true;
						q.add(j);
						cnt++;
					}
				}
			}
			q.add(i);
			while(!q.isEmpty()) {
				int temp = q.poll();
				for(int j = 1; j < arr.length; j++) {
					if(visited[j] == false && arr[temp][j] == -1) {
						visited[j] = true;
						q.add(j);
						cnt++;
					}
				}
			}
			if(cnt == n - 1) answer++;
		}
		System.out.println(answer);
	}
}
