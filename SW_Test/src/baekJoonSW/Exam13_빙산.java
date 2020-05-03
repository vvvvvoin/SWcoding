package baekJoonSW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam13_빙산 {
	static Scanner sc;
	static int map[][];
	static boolean checkMap[][];
	static int I, J;
	static int[] dirI = { 0, 0, -1, 1 };
	static int[] dirJ = { -1, 1, 0, 0 };
	static int TIME, ICE;
	static boolean flag;
	static Queue<Pos> q;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		I = sc.nextInt();
		J = sc.nextInt();

		map = new int[I][J];
		checkMap = new boolean[I][J];
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		TIME = 0;
		ICE = 0;
		flag = true;
		while (checkIce()) {
			melting();
		}

		System.out.println(TIME);

	}

	static void melting() {
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				if (map[i][j] != 0) {
					int cnt = 0;
					for (int p = 0; p < 4; p++) {
						int nextI = i + dirI[p];
						int nextJ = j + dirJ[p];
						if (nextI < 0 || nextJ < 0 || nextI >= I || nextJ >= J)
							continue;
						if (map[nextI][nextJ] == 0) {
							cnt++;
						}
					}
					map[i][j] = map[i][j] - cnt;
					if (map[i][j] <= 0)
						map[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				if (map[i][j] == -1)
					map[i][j] = 0;
			}
		}
		TIME++;
	}

	static boolean checkIce() {
		ICE = 0;
		checkMap = new boolean[I][J];
		q = new LinkedList<Pos>();
		for (int i = 0; i < I; i++) {
			for (int j = 0; j < J; j++) {
				if (map[i][j] != 0) {
					if (!checkMap[i][j]) {
						checkMap[i][j] = true;
						ICE++;
						q.add(new Pos(i, j));
						while (!q.isEmpty()) {
							Pos temp = q.poll();
							for (int p = 0; p < 4; p++) {
								int nextI = temp.i + dirI[p];
								int nextJ = temp.j + dirJ[p];
								if (nextI >= 0 && nextJ >= 0 && nextI < I && nextJ < J && !checkMap[nextI][nextJ]
										&& map[nextI][nextJ] > 0) {
									checkMap[nextI][nextJ] = true;
									q.add(new Pos(nextI, nextJ));
								}
							}
						}
					}
				}
			}
		}
		if (ICE == 0)
			return false;
		if (ICE >= 2)
			return false;
		return true;
	}

	static class Pos {
		int i, j;

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}
}
