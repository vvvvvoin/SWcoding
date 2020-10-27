package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam16 {
	// https://www.acmicpc.net/problem/2252
	static BufferedReader br;
	static StringTokenizer st;
	static ArrayList<Integer>[] list;
	static Queue<Integer> queue;
	static int[] targetNordCnt;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		targetNordCnt = new int[n + 1];
		list = new ArrayList[n + 1];
		queue = new LinkedList<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i = 1; i <= n; i ++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			targetNordCnt[b]++;
		}
		
		for(int i = 1; i <= n; i++) {
			if(targetNordCnt[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			for(int i = 0; i < list[current].size(); i++) {
				int getNord = list[current].get(i);
				targetNordCnt[getNord]--;
				
				if(targetNordCnt[getNord] == 0) {
					queue.add(getNord);
				}
			}
		}

	}
}
