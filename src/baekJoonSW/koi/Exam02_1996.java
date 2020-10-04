package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam02_1996 {
	static BufferedReader br;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		visited = new boolean[101][101];
		int answer = 0;
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			for(int j = startX; j < endX; j++) {
				for(int k = startY; k < endY; k++) {
					visited[j][k] = true;
				}
			}
		}
		for(int i = 0; i < visited.length; i++) {
			for(int j = 0; j < visited[0].length; j++) {
				if(visited[i][j] == true) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
