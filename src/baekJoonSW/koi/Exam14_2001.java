package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam14_2001 {
	static BufferedReader br;
	static int[][] array;
	static int X, Y;
	static int N;
	static StringTokenizer st;
	static ArrayList<Integer> vertical;
	static ArrayList<Integer> horizontal;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		array = new int[X][Y];
		vertical = new ArrayList<Integer>();
		horizontal = new ArrayList<Integer>();
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 0) {
				horizontal.add(Integer.parseInt(st.nextToken()));				
			}else {
				vertical.add(Integer.parseInt(st.nextToken()));
			}	
		}
		horizontal.add(Y);
		vertical.add(X);
		Collections.sort(horizontal);
		Collections.sort(vertical);
		
		int x = 0 , y = 0;
		int nextX = 0, nextY = 0;
		int answer = 0;
		int cnt = 0;
		for(int i = 0; i < vertical.size(); i++) {
			nextY = vertical.get(i);		
			for(int j = 0; j < horizontal.size(); j++) {
				nextX = horizontal.get(j);
				for(int col = y; col < nextY; col++) {
					for(int row = x; row < nextX; row++) {
						cnt++;						
					}
				}
				answer  = Math.max(cnt, answer);
				cnt = 0;
				x = nextX;
			}
			x = 0;
			y = nextY;
		}
		
		System.out.println(answer);
	}

}
