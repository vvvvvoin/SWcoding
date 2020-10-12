package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam16_2001 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] array;
	static int n;
	static int blue;
	static int white;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		array = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < n; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		blue = 0;
		white = 0;
		solution(0, 0, n, 1);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void solution(int x, int y, int n, int m) {
		for (int i = 0; i < m; i++) { 
			int X = x;
			int Y = y;
			int nextX = x;
			int nextY = y;
			if(i == 1) {
				nextY += n * 2;
				nextX += n;
				Y += n;
			}else if(i == 2) {
				nextX += n * 2;
				nextY += n;
				X += n;
			}else if(i == 3) {
				X += n;
				Y += n;
				nextX += n * 2;
				nextY += n * 2;
			}else {
				nextX += n;
				nextY += n;
			}
			if (check(X , Y, nextX, nextY) == true) {
				if (array[X][Y] == 1)	blue++;
				else	white++;
			} else {
				if(i == 1) {
					solution(x, y + n, n / 2, 4);
				}else if(i == 2) {
					solution(x + n, y, n / 2, 4);
				}else if(i == 3) {
					solution(x + n, y + n, n / 2, 4);
				}else {
					solution(x, y, n / 2, 4);
				}
			}
		}


	}
	
	private static boolean check(int x, int y, int nextX, int nextY) {
		if(nextX > n || nextY > n ) return false;
		int temp = array[x][y];
		for(int i = x; i < nextX; i++) {
			for(int j = y; j < nextY; j++) {
				if(array[i][j] != temp) {
					return false;
				}
			}
		}
		System.out.println(x + "  " + nextX + "  " + y + "  " + nextY);
		return true;
	}
}
//8
//1 1 0 0 0 0 1 1
//1 1 0 0 0 0 1 1
//0 0 0 0 1 1 0 0
//0 0 0 0 1 1 0 0
//1 0 0 0 1 1 1 1
//0 1 0 0 1 1 1 1
//0 0 1 1 1 1 1 1
//0 0 1 1 1 1 1 1
