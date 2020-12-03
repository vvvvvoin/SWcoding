package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 좀 더 가벼운 자료구조를 통해 빠르게 풀 수 있는 방법이 있을듯 하다.
// 백준 풀이에서 이 코드보다 약 2배 빠른 코드가 있는데 보고 배워야할듯

public class Exam67_2019 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static ArrayList<Integer>[] arr1;
	static ArrayList<Integer>[] arr2;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int x = Integer.valueOf(st.nextToken());
		
		arr1 = new ArrayList[n + 1];
		arr2 = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = new ArrayList<Integer>();
			arr2[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			arr1[a].add(b);
			arr2[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		visited[x] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i = 0; i < arr1[temp].size(); i++) {
				int next = arr1[temp].get(i);
				if(visited[next] == false) {
					cnt++;
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		int worst = n - cnt;
		int best = 1;
		q.add(x);
		visited[x] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i = 0; i < arr2[temp].size(); i++) {
				int next = arr2[temp].get(i);
				if(visited[next] == false) {
					best++;
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		System.out.println(best + " " + worst);
	}
}
