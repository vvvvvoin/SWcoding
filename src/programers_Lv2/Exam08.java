package programers_Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Exam08 {
	static int[] dirX = { 1, -1, 0, 0};
	static int[] dirY = { 0, 0, 1, -1};
	static int m = 6; 
	static int n = 4;
	static int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}};
	//static int[][] picture = {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0}, {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};
	static Queue<Pos> q;
	static boolean[][] checkArray;
	static int max;
	static int cnt;
	public static void main(String[] args) {
		//이 문제(프로그래머스 사이트에서) 솔루션 밖에 스태틱 변수가 있으면 안되더라
		//테스트 케이스는 잘되는데 이상하게 채점하면 안됨
		
		checkArray = new boolean[m][n];

		q = new LinkedList<Pos>();
		max = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(picture[i][j] != 0 && !checkArray[i][j]) {
					max = Math.max(bfs(new Pos(i, j)), max);
					cnt++;
				}
				
			}
		}
		System.out.println(max);
		System.out.println(cnt);
	}
	
	static Integer bfs(Pos pos) {
		q.offer(pos);
		int nextX = 0;
		int nextY = 0;
		int counter = 1;
		checkArray[pos.x][pos.y] = true;
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			for (int check = 0; check < 4; check++) {
				nextX = temp.x + dirX[check];
				nextY = temp.y + dirY[check];
				if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && !checkArray[nextX][nextY] && picture[nextX][nextY] == picture[temp.x][temp.y]) {
					checkArray[nextX][nextY] = true;
					counter++;
					q.offer(new Pos(nextX, nextY));
				}
			}
		}
		
		return counter;
	}
	
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
