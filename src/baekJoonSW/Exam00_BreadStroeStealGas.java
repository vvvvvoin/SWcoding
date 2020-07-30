package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam00_BreadStroeStealGas {
	static BufferedReader br;
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] checkMap;
	static int initR, initC, ROW, COL, nextR, nextC;
	static int ans;
	static int[] dirR = {-1, 0, 1};
	static int[] dirC = {1, 1, 1};
			
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		
		map = new char[ROW][COL];
		
		for(int i = 0; i <ROW; i++) {
			String str = br.readLine();
			for(int j = 0; j < COL; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		ans = 0;
		checkMap = new boolean[ROW][COL];
		for(int i = 0; i <ROW; i++) {
				checkMap[i][0] = true;
				dfs(i, 0);
		}
		
		System.out.println(ans);
		
		
	}// end of main

	static void dfs(int i, int j) {
		for(int p = 0; p < 3; p++) {
			int nextR = i + dirR[p];
			int nextC = j + dirC[p];
			if(nextR >= 0 && nextR < ROW && nextC >= 0 && nextC < COL && !checkMap[nextR][nextC] && map[nextR][nextC] != 'x') {
				if(nextC == COL-1) {
					ans++;
					return;
				}
				checkMap[nextR][nextC] = true;
				dfs(nextR, nextC);
			}
		}
		
	}

}

























