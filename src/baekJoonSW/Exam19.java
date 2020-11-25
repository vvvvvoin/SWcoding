package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//참고 https://zoonvivor.tistory.com/131
public class Exam19 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] arr;
	static int[] dirR = { 0, 0, 1, -1 };
	static int[] dirC = { 1, -1, 0, 0 };
	static int answer = 0;
	static Queue<Pos> q = new LinkedList<Pos>();

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		bfs();
	}

	private static void bfs() {
		find();
		while (!q.isEmpty()) {
			Pos pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextR = pos.i + dirR[i];
				int nextC = pos.j + dirC[i];
				if(nextR < arr.length && nextC < arr[0].length && nextR >= 0 && nextC >= 0 && 
						 arr[nextR][nextC] == 0) {
					arr[nextR][nextC] = arr[pos.i][pos.j] + 1;
					q.add(new Pos(nextR, nextC));
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				answer = Math.max(answer, arr[i][j]);
			}
		}
		System.out.println(answer - 1);
	}

	private static void find() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) q.add(new Pos(i, j));
			}
		}
	}

	private static class Pos {
		int i;
		int j;

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
