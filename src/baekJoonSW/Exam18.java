package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam18 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] arr;
	static int[] dirR = {0, 0, 1 ,-1};
	static int[] dirC = {1, -1, 0, 0};
	static int answer = 0;
	static Queue<Pos> q = new LinkedList<Pos>();
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		for(int i = 0; i < row; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		bfs(0, 0, new boolean[row][col]);
		System.out.println(arr[row - 1][col - 1]);
	}

	private static void bfs(int row, int col, boolean[][] visited) {
		int R = arr.length;
		int C = arr[0].length;
		q.add(new Pos(row, col));
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			visited[pos.i][pos.j] = true;
			for(int i = 0; i < 4; i++) {
				int nextR = pos.i + dirR[i]; 
				int nextC = pos.j + dirC[i]; 
				if(nextR < R && nextC < C && nextR >= 0 && nextC >= 0 && 
						visited[nextR][nextC] == false && arr[nextR][nextC] == 1) {
					visited[nextR][nextC] = true;
					q.add(new Pos(nextR, nextC));
					arr[nextR][nextC] = arr[pos.i][pos.j] + 1;
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
