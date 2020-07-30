package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam01_VirusLab {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] checkMap;
	static int initR, initC, ROW, COL, nextR, nextC;
	static int max;
	static int[] dirR = { 0, 0, -1, 1 };
	static int[] dirC = { -1, 1, 0, 0 };
	static int safeCnet;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());

		map = new int[ROW][COL];
		checkMap = new boolean[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < COL; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==0) safeCnet++;
			}
		}
		max = 0;

		dfs(0, 0, 0);
		
		System.out.println(max-3);

	}// end of main

	static void dfs(int i, int j, int cnt) {
		if (cnt == 3) {
			checkVirus();
			return;
		}
		if (j >= COL) {
			dfs(i + 1, 0, cnt);
			return;
		}
		if (i >= ROW) {
			return;
		}

		if (map[i][j] == 0) {
			map[i][j] = 1;
			dfs(i, j + 1, cnt+1);
			map[i][j] = 0;
		}
		dfs(i, j + 1, cnt);
	}

	static void checkVirus() {
		init();
		Queue<Pos> q = new LinkedList<Pos>();
		int safe = safeCnet;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (map[i][j] == 2) {
					checkMap[i][j] = true;
					q.add(new Pos(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			Pos temp = q.poll();
			for (int p = 0; p < 4; p++) {
				nextR = temp.getI() + dirR[p];
				nextC = temp.getJ() + dirC[p];
				if (nextR < 0 || nextC < 0 || nextR >= ROW || nextC >= COL)	continue;
				if (checkMap[nextR][nextC])	continue;
				if (map[nextR][nextC] == 0) {
					checkMap[nextR][nextC] = true;
					q.add(new Pos(nextR, nextC));
					safe--;
				}
			}
		}

		max = Math.max(max, safe);
	}// end of checkVirus()

	static void init() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				checkMap[i][j] = false;
			}

		}
	}

	static class Pos {
		private int i, j;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}
} // end of class
