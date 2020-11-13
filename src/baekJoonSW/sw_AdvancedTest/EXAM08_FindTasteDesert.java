package sw_AdvancedTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class EXAM08_FindTasteDesert {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] checkMap;
	static int N, ROW, COL, initR, initC;
	static int nextR, nextC;
	static int[] dirRow = { -1, -1, 1, 1 };
	static int[] dirCol = { -1, 1, 1, -1};
	static int MAX;
	static Stack<Integer> checkStack;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			MAX = -1;
			checkMap = new boolean[N][N];
			checkStack = new Stack<Integer>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					checkMap[i][j] = true;
					initR = i;
					initC = j;
					dfs(i, j, 0);
					checkMap[i][j] = false;
				}
			}

			sb.append("#" + tc + " " + MAX + "\n");
		} // end of for tc
		System.out.println(sb.toString());
	} // end of main

	static void dfs(int i, int j, int d) {
		for (int r = d; r < d + 2 && r < 4; r++) {
			int nextR = i + dirRow[r];
			int nextC = j + dirCol[r];

			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)  continue;
			if(checkStack.contains(map[nextR][nextC])) continue;
			if (initR == nextR && initC == nextC) {
				int cnt = 0;
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < N; m++) {
						if (checkMap[n][m]) {
							cnt++;
						}
					}
				}
				MAX = Math.max(cnt, MAX);
				return;
			}
			if (!checkMap[nextR][nextC]) {
				checkMap[nextR][nextC] = true;
				checkStack.add(map[nextR][nextC]);
				dfs(nextR, nextC, r);
				checkMap[nextR][nextC] = false;
				if(!checkStack.isEmpty()) {
					checkStack.pop();
				}
			}

		}

	}


}