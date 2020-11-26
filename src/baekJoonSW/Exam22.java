package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam22 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] dirR = { 0, 0, 1, -1 };
	static int[] dirC = { 1, -1, 0, 0 };
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T;  t++) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			arr = new int[row][col];
			visited = new boolean[row][col];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				arr[r][c] = 1;
			}
			int answer = 0;
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[0].length; j++) {
					if(visited[i][j] == false && arr[i][j] == 1) {
						answer++;
						bfs(i, j);						
					}
				}
			}
			System.out.println(answer);
		}
	}

	private static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(r, c));
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			visited[temp.i][temp.j] = true;
			for(int i = 0; i < 4; i++) {
				int nextR = temp.i + dirR[i];
				int nextC = temp.j + dirC[i];
				if(nextR < arr.length && nextC < arr[0].length && nextR >=0 && nextC >= 0 && arr[nextR][nextC] == 1 && visited[nextR][nextC] == false) {
					q.add(new Pos(nextR, nextC));
					visited[nextR][nextC] = true;
				}
			}
		}		
	}
	private static class Pos{
		int i;
		int j;
		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
}
