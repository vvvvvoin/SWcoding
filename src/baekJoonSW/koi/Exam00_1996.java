package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Exam00_1996 {
	static BufferedReader br;
	static int n;
	static boolean[][] check;
	static int[][] apart;
	static int[] dirX = {0, 0, 1, -1};
	static int[] dirY = {1, -1, 0, 0};
	
	static int cntApart = 0;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		apart = new int[Integer.parseInt(input)][Integer.parseInt(input)];
		check = new boolean[Integer.parseInt(input)][Integer.parseInt(input)];
		for(int i = 0; i < apart.length; i++) {
			String temp = br.readLine();
			for(int j = 0; j < apart[0].length; j++) {
				apart[i][j] = Integer.parseInt(temp.charAt(j)+"");
			}
		}
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i = 0; i < apart.length; i++) {
			for(int j = 0; j < apart[0].length; j++) {
				if(apart[i][j] != 0 && check[i][j] == false) {
					check[i][j] = true;
					answer.add(solution(i, j));
				}
			}
		}
		Collections.sort(answer);
		System.out.println(cntApart);
		for(int value : answer) {
			System.out.println(value);
		}
	}
	private static Integer solution(int i, int j) {
		cntApart++;
		Stack<Pos> stack = new Stack<Pos>();
		stack.add(new Pos(i ,j));
		while(!stack.isEmpty()) {
			Pos temp = stack.pop();
			for(int o = 0; o < 4; o++) {
				int nextI = temp.i + dirX[o];
				int nextJ = temp.j + dirY[o];
				if(nextI >= 0 && nextJ >= 0 && nextI < apart.length && nextJ < apart.length && !check[nextI][nextJ] && apart[nextI][nextJ] == 1) {
					check[nextI][nextJ] = true;
					stack.add(new Pos(nextI, nextJ));
					cnt++;
				}
			}
			 
		}
		return cnt;
	}
	
	static class Pos{
		private int i;
		private int j;
		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
}
