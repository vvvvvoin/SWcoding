package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam05_1996 {
	static BufferedReader br;
	static boolean[][] visited;
	public static void main(String[] args)  throws Exception{
		//스위핑 문제인데 단순하게 풀이했다
		//추후에 스위핑 개념을 익히고 다시 풀어야 한다.
		br = new BufferedReader(new InputStreamReader(System.in));
		visited = new boolean[10001][10001];
		double answer = 0;
		int cnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = (int) (Double.parseDouble(st.nextToken()) * 10);
			int startY =(int) (Double.parseDouble(st.nextToken()) * 10);
			int endX = (int) (Double.parseDouble(st.nextToken()) * 10);
			int endY =(int) (Double.parseDouble(st.nextToken())  * 10);
			for(int j = startX; j < startX + endX; j++) {
				for(int k = startY; k < startY+ endY; k++) {
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
		answer /= 100;
		System.out.println(answer);
		double compareValue = (double)Math.ceil(answer * 10) / 10.0;
		System.out.println(compareValue);
		if(compareValue == answer ){
			System.out.println((int)answer);
		}else {
			System.out.printf("%.2f", answer);			
		}
	}
}
