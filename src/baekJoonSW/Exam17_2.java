package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam17_2 {
	static BufferedReader br;
	static StringTokenizer st;
	static ArrayList<Integer>[] list;
	static Queue<Integer> q = new LinkedList<Integer>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[node + 1];
		for(int i = 0; i <= node; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i<=node; i++) {
			Collections.sort(list[i]);
		}
		sb = new StringBuilder();
		dfs(start, new boolean[node + 1]);
		System.out.println(sb.toString());
		sb = new StringBuilder();
		bfs(start, new boolean[node + 1]);
		System.out.println(sb.toString());
	}

	private static void bfs(int start, boolean[] visited) {
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node + " ");
			for(int i = 0; i < list[node].size(); i++) {
				int next = list[node].get(i);
				if(visited[next] == false) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}

	private static void dfs(int start, boolean[] visited) {
		visited[start] = true;
		sb.append(start + " ");
		for(int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			if(visited[next] == false) {
				dfs(next, visited);
			}
		}
	}
}
