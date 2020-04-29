package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam06_치즈 {
	static BufferedReader br;
	static StringTokenizer st;
	static int ROW, COL;
	static int map[][];
	static boolean checkMap[][];
	static int[] dirI = { 0, 0, -1, 1 };
	static int[] dirJ = { -1, 1, 0, 0 };
	static int TIME;
	static int cheeze;
	static boolean flag;

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
			}
		}
		TIME = 0;
		cheeze = 0;
		flag = true;
		while(bfs(0, 0)) {
			cheeze =  checkCheeze();
		}
		System.out.println(TIME);
		System.out.println(cheeze);

	}// end of main

	static Queue<Pos> q = new LinkedList<>();

	static boolean bfs(int i, int j) {
		checkMap[i][j] = true;
		q.add(new Pos(i, j));
		while (!q.isEmpty()) {
			Pos temp = q.poll();
			for (int p = 0; p < 4; p++) {
				int nextI = temp.getI() + dirI[p];
				int nextJ = temp.getJ() + dirJ[p];
				if (nextI < 0 || nextJ < 0 || nextI >= ROW || nextJ >= COL || checkMap[nextI][nextJ])
					continue;
				if (map[nextI][nextJ] == 1 && !checkMap[nextI][nextJ]) {
					map[nextI][nextJ] = 0;
					checkMap[nextI][nextJ] = true;
				}
				if (map[nextI][nextJ] == 0 && !checkMap[nextI][nextJ] ) {
					checkMap[nextI][nextJ] = true;
					q.add(new Pos(nextI, nextJ));
				}
			}
		}

		return init();
	}

	static boolean init() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (checkMap[i][j]) {
					checkMap[i][j] = false;
				}
			}
		}
		TIME++;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (map[i][j] ==1) {
					return true;
				}
			}
		}
		return false;
	}
	
	static int checkCheeze() {
		cheeze = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (map[i][j] == 1) {
					cheeze++;
				}
			}
		}
		return cheeze;
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
}
