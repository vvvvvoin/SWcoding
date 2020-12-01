package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam62_2018 {
	static BufferedReader br;
	static StringTokenizer st;
	// 이 솔루션도 문제는 풀어지지만
	// 2차원 배열로 그래프의 경로를 저장한고 있는데
	// 크기가 거질 수록 메모리부족 현상이 나타난다.
	// Exam62_2018_2에서 1차원 배열로 선언후 ArrayList를 넣어주어 해결했다
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int START = Integer.parseInt(s[1]);
		int END = Integer.parseInt(s[2]);
		if(n == 1 || START == END) {
			System.out.println(0);
			return;
		}
		int[][] arr = new int[n + 1][n + 1];
		boolean[] visited = new boolean[n + 1];
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			arr[a][b] = d;
			arr[b][a] = d;
		}
		
		Queue<Distance> q = new LinkedList<Distance>();
		q.add(new Distance(START, 0, 0));
		visited[START] = true;
		Distance temp = null;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.pos == END) {
				System.out.println(temp.length - temp.maxLength);
				return;
			}
			for(int i = 0; i <arr.length; i++) {
				if(visited[i] == false && arr[temp.pos][i] != 0) {
					visited[i] = true;
					q.add(new Distance(i, temp.length + arr[temp.pos][i], Math.max(arr[temp.pos][i], temp.maxLength)));
				}
			}
		}
	}
	
	private static class Distance{
		int pos;
		int length;
		int maxLength;
		public Distance(int pos, int length, int maxLength) {
			super();
			this.pos = pos;
			this.length = length;
			this.maxLength = maxLength;
		}
		
	}
}
