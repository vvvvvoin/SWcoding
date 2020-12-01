package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam62_2018_2 {
	static BufferedReader br;
	static StringTokenizer st;
	static ArrayList<Pos>[] list;
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
		list = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Pos>();
		}
		
		boolean[] visited = new boolean[n + 1];
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list[a].add(new Pos(b, d));
			list[b].add(new Pos(a, d));
		}
		
		Queue<Distance> q = new LinkedList<Distance>();
		q.add(new Distance(START, 0, 0));
		visited[START] = true;
		Distance temp = null;
		while(!q.isEmpty()) {
			temp = q.poll();
			int tempIdx = temp.pos;
			
			if(temp.pos == END) {
				System.out.println(temp.length - temp.maxLength);
				return;
			}
			for(int i = 0; i <list[tempIdx].size(); i++) {
				int index = list[tempIdx].get(i).pos;
				int length = list[tempIdx].get(i).length;
				if(visited[index] == false) {
					visited[index] = true;
					q.add(new Distance(index, temp.length + length, Math.max(length, temp.maxLength)));
				}
			}
		}
	}
	private static class Pos{
		int pos;
		int length;
		public Pos(int pos, int length) {
			super();
			this.pos = pos;
			this.length = length;
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
