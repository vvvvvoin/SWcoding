package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam37_2010 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int[][] arr;
	static boolean[][] visited;
	static int answer;
	static int cnt;
	
	static int[] dirI = {0, 0, 1 ,-1};
	static int[] dirJ = {-1, 1, 0 ,0};
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		visited = new boolean[n][n];
		answer = 0;
		cnt = 0;
		int maxH = 0;
		for(int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < arr.length; j++) {
				int value = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, value);
				arr[i][j] = value;
			}
		}
		
		Queue<Pos> q = new LinkedList<Pos>();
		for(int k = 0; k <= maxH; k++ ) {
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr.length; j++) {
					if(arr[i][j] > k && visited[i][j] == false ) {
						cnt++;
						solution(i, j, k, q);
					}
				}
			}
			answer = Math.max(answer, cnt);
			//초기화
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					visited[i][j] = false;
				}
			}
			cnt = 0;
			q.clear();
		}

		
		System.out.println(answer);
	}

	private static void solution(int row, int col, int height, Queue<Pos> q) {
		visited[row][col] = true;
		q.add(new Pos(row, col));
		
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nextRow = temp.i + dirI[i];
				int nextCol = temp.j + dirJ[i];
				if(nextRow < arr.length && nextCol < arr.length && nextRow >=0 &&nextCol >= 0 && 
						arr[nextRow][nextCol] > height && visited[nextRow][nextCol] == false) {
					visited[nextRow][nextCol] = true;
					q.add(new Pos(nextRow, nextCol));
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
