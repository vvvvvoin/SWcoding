package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam13_2000 {
	static BufferedReader br;
	static StringTokenizer st;
	static int X;
	static int Y;
	static int[][] cheez;
	
	static int time;
	static int last;
	static boolean flag;
	
	static Queue<Pos> q;
	static int[] dirX = {1, -1 ,0 ,0};
	static int[] dirY = {0, 0, 1, -1};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		cheez = new int[X][Y];
		visited = new boolean[X][Y];
		q = new LinkedList<Pos>();
		
		for (int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Y; j++) {
				cheez[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		countCheez();
		while(true) {
			time++;
			solution();
			if(flag == true) break;
		}
		System.out.println(time);
		System.out.println(last);
	}

	private static void solution() {
		q.add(new Pos(0, 0));
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = pos.i + dirX[i];
				int nextY = pos.j + dirY[i];
				if(nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y || visited[nextX][nextY] == true) continue;
				if(cheez[nextX][nextY] == 0 && visited[nextX][nextY] == false) {
					q.add(new Pos(nextX, nextY));
					visited[nextX][nextY] = true;
				}else if(cheez[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
					visited[nextX][nextY] = true;
					cheez[nextX][nextY] = 0;
				}
			}
		}
		
		countCheez();
		visited = new boolean[X][Y];
	}

	private static void countCheez() {
		int cnt = 0;
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				if(cheez[i][j] == 1) cnt++;
			}
		}
		if(cnt == 0) flag = true;
		else last = cnt;
	}

	private static class Pos{
		private int i;
		private int j;
		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
}
