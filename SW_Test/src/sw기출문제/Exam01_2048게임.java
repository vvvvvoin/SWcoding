package sw기출문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam01_2048게임 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static boolean[][] checkMap;
	static int[] dirI = { 0, 0, -1, 1 };
	static int[] dirJ = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		checkMap = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(map));
	}

	static Queue<Pos> q = new LinkedList<>();
	static int MAX2;
	static int solution(int[][] map) {
		q.add(new Pos(map, 0));
		while (q.isEmpty()) {
			Pos temp = q.poll();
			if (temp.cnt > 5) {
				MAX2 = Math.max(MAX2, find(temp.map)) ;
			}
			for (int p = 0; p < 4; p++) {
				int[][] tempMap = temp.map;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (tempMap[i][j] == 0)
							continue;
						int nextI = i + dirI[p];
						int nextJ = j + dirJ[p];
						while (true) {
							if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= N) {
								nextI -= dirI[p];
								nextJ -= dirJ[p];
								break;
							}
							if (tempMap[nextI][nextJ] == 0) {
								nextI += dirI[p];
								nextJ += dirJ[p];
							} else {
								if (tempMap[nextI][nextJ] == tempMap[nextI + dirI[p]][nextJ + dirJ[p]]) {
									tempMap[nextI][nextJ] = 0;
									tempMap[nextI + dirI[p]][nextJ + dirJ[p]] *= 2;
								} else {
									break;
								}
							}
						}
					}
				}
				q.add(new Pos(tempMap, temp.cnt + 1));
			}
		}
		return MAX2;
	}

	static int MAX;

	static int find(int[][] map2) {
		MAX = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				MAX = Math.max(MAX, map2[i][j]);
			}
		}
		return MAX;
	}

	static class Pos {
		int[][] map;
		int cnt;

		public Pos(int[][] map, int cnt) {
			super();
			this.map = map;
			this.cnt = cnt;
		}

	}
}
