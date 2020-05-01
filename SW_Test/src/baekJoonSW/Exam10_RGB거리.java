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
		
		for(int i =0; i<TC; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		
		
		System.out.println(MIN);
		
	}

}
