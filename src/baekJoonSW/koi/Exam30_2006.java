package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam30_2006 {
	static BufferedReader br;
	static StringTokenizer st;

	static int[][] ice;
	static int[][] melt;
	static boolean[][] visited;
	
	static int[] dirX = {1, -1, 0, 0};
	static int[] dirY = {0 , 0, -1, 1};
	
	static int piece = 0;
	static int year = 0;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		ice = new int[row][col];
		
		for(int i = 0; i < ice.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < ice[0].length; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag;
		while(true) {
			flag = false;
			piece = 0;
			visited = new boolean[row][col];
			melt = new int[row][col];
			for(int i = 0; i < ice.length; i++) {
				for(int j = 0; j < ice[0].length; j++) {
					if(ice[i][j] != 0 && visited[i][j] == false) {
						bfs(i, j);
						flag = true;
					}
				}
			}
			if(piece >= 2) break;
			if(flag == false) break;
			year++;
		}

		if(flag == false) {
			System.out.println(0);
		}else {
			System.out.println(year);
		}
	}
	
	private static void bfs(int row, int col) {
		melt(row, col);
		visited[row][col] = true;
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(row, col));
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = temp.i + dirX[i];
				int nextY = temp.j + dirY[i];
				if(nextX >= ice.length || nextY >= ice[0].length || nextX < 0 || nextY < 0 || visited[nextX][nextY] == true || ice[nextX][nextY] == 0) continue;
				melt(nextX, nextY);
				visited[nextX][nextY] = true;
				q.add(new Pos(nextX, nextY));
			}
		}		
		piece++;
		melt();
	}
	
	private static void melt() {
		for(int i = 0; i < ice.length; i++) {
			for(int j = 0; j < ice[0].length; j++) {
				if(ice[i][j] != 0) {
					ice[i][j] -= melt[i][j];
					if(ice[i][j] < 0) ice[i][j] = 0;
				}
			}
		}
	}
	
	private static void melt(int row, int col) {
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			int nextX = row + dirX[i];
			int nextY = col + dirY[i];
			if(nextX >= ice.length || nextY >= ice[0].length || nextX < 0 || nextY < 0) continue;
			if(ice[nextX][nextY] == 0) cnt++;
		}
		melt[row][col] = cnt;
	}

	private static class Pos{
		int i;
		int j;
		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
}
