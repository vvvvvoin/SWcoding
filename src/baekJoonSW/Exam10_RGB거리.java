package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam10_RGB거리 {
	static BufferedReader br;
	static StringTokenizer st;
	static int TC, MIN;
	static int[][]map;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		map = new int[TC][3];
		int[][] ans = new int[TC][3];
		
		for(int i =0; i<TC; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		ans[0][0] = map[0][0];
		ans[0][1] = map[0][1];
		ans[0][2] = map[0][2];
		
		for(int i = 1; i<TC; i++){
			ans[i][0] = Math.min(ans[i-1][1], ans[i-1][2]) + map[i][0];
			ans[i][1] = Math.min(ans[i-1][0], ans[i-1][2]) + map[i][1];
			ans[i][2] = Math.min(ans[i-1][0], ans[i-1][1]) + map[i][2];
		}
		
		
		System.out.println(Math.min(ans[TC-1][0], Math.min(ans[TC-1][1], ans[TC-1][2])));		
	}

}
