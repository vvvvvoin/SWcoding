package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam51 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int row;
	static int col;
	
	static char[][] arr;
	static boolean[][][][] visited;
	static int[] dirR = {0, 0, -1, 1};
	static int[] dirC = {1, -1, 0, 0};
	
	static int Ri, Rj, Bi, Bj;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		row = Integer.valueOf(st.nextToken());
		col = Integer.valueOf(st.nextToken());
		
		arr = new char[row][col];
		visited = new boolean[row][col][row][col];
		for(int i = 0; i < row; i++) {
			String str = br.readLine();
			for(int j = 0; j < col; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'R') {
					Ri = i;
					Rj = j;
				}
				if(arr[i][j] == 'B') {
					Bi = i;
					Bj = j;
				}
			}
		}
		solution();
	}
	private static void solution() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(Ri, Rj, Bi, Bj, 1));
		visited[Ri][Rj][Bi][Bj] = true;
		while(!q.isEmpty()) {
			Pos temp = q.poll();
			
			if(temp.cnt > 10) {
				System.out.println(-1);
				return;
			}
			for(int o = 0; o < 4; o++) {
				int nextRi = temp.ri;
				int nextRj = temp.rj;
				int nextBi = temp.bi;
				int nextBj = temp.bj;
				
				while (arr[nextBi + dirR[o]][nextBj + dirC[o]] != '#') {
					nextBi += dirR[o];
					nextBj += dirC[o];
					if (arr[nextBi][nextBj] == 'O') {
						break;
					}

				}
				while (arr[nextRi + dirR[o]][nextRj + dirC[o]] != '#') {
					nextRi += dirR[o];
					nextRj += dirC[o];
					if (arr[nextRi][nextRj] == 'O') {
						break;
					}
				}
				
				if(arr[nextBi][nextBj] == 'O') continue;
				
				if(arr[nextRi][nextRj] == 'O') {
					System.out.println(temp.cnt);
					return;
				}

				if (nextRi == nextBi && nextRj == nextBj) {
					if(o == 0) {//동
						if(temp.rj > temp.bj) {
							nextBj -= 1;
						}else {
							nextRj -= 1;
						}
					}else if(o == 1) {//서
						if(temp.rj > temp.bj) {
							nextRj += 1;
						}else {
							nextBj += 1;
						}
					}else if(o == 2) {//북
						if(temp.ri > temp.bi) {
							nextRi += 1;
						}else {
							nextBi += 1;
						}
					}else if(o == 3) {//남
						if(temp.ri > temp.bi) {
							nextBi -= 1;
						}else {
							nextRi -= 1;
						}
					}
				}
				if(visited[nextRi][nextRj][nextBi][nextBj] == false) {
					visited[nextRi][nextRj][nextBi][nextBj] = true;
					q.offer(new Pos(nextRi, nextRj, nextBi, nextBj, temp.cnt+1));
				}
				
			}
		}
		System.out.println(-1);
	}
	
	private static class Pos{
		int ri;
		int rj;
		int bi;
		int bj;
		int cnt;
		public Pos(int ri, int rj, int bi, int bj, int cnt) {
			super();
			this.ri = ri;
			this.rj = rj;
			this.bi = bi;
			this.bj = bj;
			this.cnt = cnt;
		}
	}
}
