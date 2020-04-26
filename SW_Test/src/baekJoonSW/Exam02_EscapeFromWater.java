package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam02_EscapeFromWater {
	static BufferedReader br;
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] checkMap;
	static int initR, initC, ROW, COL, nextR, nextC;
	static int initWaterR, initWaterC, nextWaterR, nextWaterC;
	static int min;
	static int[] dirR = { 0, 0, -1, 1 };
	static int[] dirC = { -1, 1, 0, 0 };
	static boolean wFlag, flag;
	static int dx, dy;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		min = 10000;
		map = new char[ROW][COL];
		checkMap = new boolean[ROW][COL];

		for (int i = 0; i < ROW; i++) {
			String str = br.readLine();
			for (int j = 0; j < COL; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					initR = i;
					initC = j;
				}if(map[i][j]=='D') {
	                    dx = i;
	                    dy = j;
				} else if (map[i][j] == '*') {
					initWaterR = i;
					initWaterC = j;
					w.add(new Water(initWaterR, initWaterC));
				}
			}
		}

		solve();
		if(min == 10000) {
			System.out.println("KAKTUS");
		}else{
			System.out.println(min);
		}

	}// end of main

	static Queue<Pos> q = new LinkedList<Pos>();

	static void solve() {
		q.add(new Pos(initR, initC, 0));
		checkMap[initR][ initC] = true;
		water();
		
		while(!q.isEmpty()) {
			if(wFlag) water();
			int size = q.size();
			for(int i = 0; i <size; i++) {
				Pos temp = q.poll();
				if (temp.getI() == dx && temp.getJ() == dy) {
					min = Math.min(min, temp.getCnt());	
					flag = true;
					break;
				}
				checkMap[temp.getI()][temp.getJ()] = true;
				for (int r = 0; r < 4; r++) {
					nextR = temp.getI() + dirR[r];
					nextC = temp.getJ() + dirC[r];
					if (nextR < 0 || nextR >= ROW || nextC < 0 || nextC >= COL)		continue;
					if (map[nextR][nextC] == '*' || map[nextR][nextC] == 'X' || map[nextR][nextC] == 'S')		continue;
					if(!checkMap[nextR][nextC]) {
						q.add(new Pos(nextR, nextC, temp.getCnt() +1));
						map[nextR][nextC] = 'S';
					}
				}
			}
			wFlag = true;
			if(flag) break;
		}
		
	}

	static Queue<Water> w = new LinkedList<Water>();

	static void water() {
		int size = w.size();
		for (int i = 0; i < size; i++) {
			Water temp = w.poll();
			for (int r = 0; r < 4; r++) {
				nextWaterR = temp.getI() + dirR[r];
				nextWaterC = temp.getJ() + dirC[r];
				if (nextWaterR < 0 || nextWaterR >= ROW || nextWaterC < 0 || nextWaterC >= COL)			continue;
				if (map[nextWaterR][nextWaterC] == '*' || map[nextWaterR][nextWaterC] == 'D' || map[nextWaterR][nextWaterC] == 'X')			continue;
				map[nextWaterR][nextWaterC] = '*';
				w.add(new Water(nextWaterR, nextWaterC));
			}
		}

	}

	static class Pos {
		private int i, j, cnt;

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

		public Pos(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}

		public int getCnt() {
			return cnt;
		}

		public void setCnt(int cnt) {
			this.cnt = cnt;
		}


	}

	static class Water {
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

		public Water(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}
} // end of class
