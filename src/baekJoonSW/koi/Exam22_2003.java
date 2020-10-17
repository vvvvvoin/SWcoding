package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam22_2003 {
	static BufferedReader br;
	static StringTokenizer st;

	static int[][] arr = new int[19][19];
	static int[] dirI = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dirJ = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static boolean flag = false;
	static int answer = 0;
	static String answer2 = "";

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (flag)	break;
				if (arr[i][j] != 0)
					solution(i, j, arr[i][j]);
			}
			if (flag)	break;
		}
		if (flag) {
			System.out.println(answer);
			System.out.println(answer2);
		} else {
			System.out.println(0);
		}
	}

	private static void solution(int i, int j, int bw) {
		Pos pos = new Pos(i, j);
		for (int d = 0; d < 8; d++) {
			if (flag)	break;
			int cnt1 = 0;
			int nextI = pos.i;
			int nextJ = pos.j;
			
			while (true) {
				nextI += dirI[d];
				nextJ += dirJ[d];
				if (nextI >= 19 || nextJ >= 19 || nextI < 0 || nextJ < 0) {
					nextI -= dirI[d];
					nextJ -= dirJ[d];
					break;
				}
				if (arr[nextI][nextJ] == bw) {
					cnt1++;
				} else {
					if (cnt1 == 0) {
						nextI = i;
						nextJ = j;
					} else {
						nextI += dirI[d];
						nextJ += dirJ[d];
					}
					break;
				}
			}

			int cnt2 = 0;
			int nextI2 = pos.i;
			int nextJ2 = pos.j;
			while (true) {
				nextI2 -= dirI[d];
				nextJ2 -= dirJ[d];
				if (nextI2 >= 19 || nextJ2 >= 19 || nextI2 < 0 || nextJ2 < 0) {
					nextI2 += dirI[d];
					nextJ2 += dirJ[d];
					break;
				}
				if (arr[nextI2][nextJ2] == bw) {
					cnt2++;
				} else {
					if (cnt2 == 0) {
						nextI2 = i;
						nextJ2 = j;
					} else {
						nextI2 += dirI[d];
						nextJ2 += dirJ[d];
					}
					break;
				}

			}

			if (cnt1 + cnt2 + 1 == 5) {
				flag = true;
				answer = bw;
				int x = 0;
				int y = 0;
				//System.out.println(i + "  " + j);
				//System.out.println(nextI + "  "  + nextJ + "  "+ nextI2 + "  "  + nextJ2);
				if(nextJ2 < nextJ) {
					x = nextI2 + 1;
					y = nextJ2 + 1;
				}else {
					x = nextI + 1;
					y = nextJ + 1;
				}
				answer2 = x + " " + y; 
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
