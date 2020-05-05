package sw기출문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exam00_구슬탈출2 {
	static StringTokenizer st;
	static BufferedReader br;
	static Scanner sc;
	static char[][] map;
	static boolean[][] checkMap;
	static int N, M, RI, RJ, BI, BJ;
	static int[] dirI = { 0, 0, -1, 1 };
	static int[] dirJ = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		checkMap = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					RI = i;
					RJ = j;
				}
				if (map[i][j] == 'B') {
					BI = i;
					BJ = j;
				}
			}
		}
		
		System.out.println(solution(RI, RJ, BI, BJ, 0));

	}

	static Queue<Pos> q = new LinkedList<>();
	static int MIN;

	static int solution(int ri, int rj, int bi, int bj, int cnt) {
		q.add(new Pos(ri, rj, bi, bj, 0));
		checkMap[ri][rj] = true;
		MIN = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Pos temp = q.poll();
			System.out.println(temp.ri + " : " + temp.rj);
			System.out.println(temp.bi + " : " + temp.bj);
			if(temp.cnt > 10) continue;
			if(map[temp.bi][temp.bj]  == 'O') continue;
			if(map[temp.ri][temp.rj]  == 'O') return temp.cnt;
			
			
			for (int p = 0; p < 4; p++) {
				int nextRI = temp.ri;
				int nextRJ = temp.rj;
				int nextBI = temp.bi;
				int nextBJ = temp.bj;
				
				while(true) {
					if(map[nextRI][nextRJ] != '#' && map[nextRI][nextRJ] != 'O') {
						nextRI += dirI[p];
						nextRJ += dirJ[p];
					}else {
						if(map[nextRI][nextRJ] == '#') {
							nextRI -= dirI[p];
							nextRJ -= dirJ[p];
						}
						break;
					}
				}
				
				while(true) {
					if(map[nextBI][nextBJ] != '#' && map[nextBI][nextBJ] != 'O') {
						nextBI += dirI[p];
						nextBJ += dirJ[p];
					}else {
						if(map[nextBI][nextBJ] == '#') {
							nextBI -= dirI[p];
							nextBJ -= dirJ[p];
						}
						break;
					}
				}
				
				if(nextRI == nextBI && nextRJ == nextBJ) {
					if(map[nextRI][nextRJ] != 'O') {
						int red = Math.abs(temp.ri - nextRI) + Math.abs(temp.rj - nextRJ);
						int blue = Math.abs(temp.bi - nextBI) + Math.abs(temp.bj - nextBJ);
						if(red > blue) {
							nextRI -= dirI[p];
							nextRJ -= dirJ[p];
						} else {
							nextBI -= dirI[p];
							nextBJ -= dirJ[p];
						}
					}
				}
				if(!checkMap[nextRI][nextRJ]) {
					checkMap[nextRI][nextRJ] = true;
					q.add(new Pos(nextRI, nextRJ, nextBI, nextBJ, temp.cnt + 1));
				}

			}
		}
		return -1;
	}

	static class Pos {
		int ri, rj, bi, bj, cnt;

		public Pos(int ri, int rj, int bi, int bj, int cnt) {
			super();
			this.ri = ri;
			this.rj = rj;
			this.bi = bi;
			this.bj = bj;
			this.cnt = cnt;
		}



	}

}
