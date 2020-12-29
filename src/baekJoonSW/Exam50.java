package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam50 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int row;
	static int col;
	
	static int[][] arr;
	static int[][] visited;
	static int[] dirR = {0, 0, -1, 1};
	static int[] dirC = {1, -1, 0, 0};
	
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		row = Integer.valueOf(st.nextToken());
		col = Integer.valueOf(st.nextToken());
		
		arr = new int[row][col];
		visited = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			String str = br.readLine();
			for(int j = 0; j < col; j++) {
				arr[i][j] = str.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		visited[0][0] = 0;
		bfs(new Pos(0, 0, 1, 0));
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);			
		}
	}

	private static void bfs(Pos pos) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(pos);
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			if(isCome(temp.i, temp.j)) {
				answer =  temp.cnt;
				break;
			}
			for (int o = 0; o < 4; o++) {
				int nextR = temp.i + dirR[o];
				int nextC = temp.j + dirC[o];
				if(isValid(nextR, nextC)) {
					if(visited[nextR][nextC] <= temp.breakCnt) {
						if(arr[nextR][nextC] == 0) {
							visited[nextR][nextC] = temp.breakCnt;
							q.add(new Pos(nextR, nextC, temp.cnt + 1, temp.breakCnt));
						}else {
							if(temp.breakCnt == 0) {
								visited[nextR][nextC] = temp.breakCnt + 1;
								q.add(new Pos(nextR, nextC, temp.cnt + 1, temp.breakCnt + 1));
							}
							
						}
					}
				}
			}
		}		
	}
	
	private static boolean isCome(int nextR, int nextC) {
		if(nextR == row - 1 && nextC == col - 1) return true;
		else return false;
	}
	
	private static boolean isValid(int nextR, int nextC) {
		if(nextR >= 0 && nextC >= 0 && nextR < row && nextC < col) return true;
		else return false;
	}
	
	private static class Pos{
		int i;
		int j;
		int cnt;
		int breakCnt;
		public Pos(int i, int j, int cnt, int breakCnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.breakCnt = breakCnt;
		}
		
	}
}
