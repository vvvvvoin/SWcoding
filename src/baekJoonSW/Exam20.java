package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam20 {
	static BufferedReader br;
	static StringTokenizer st;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[100001];
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		arr[start] = 1;
		int end = Integer.parseInt(st.nextToken());	
		
		if(start == end) {
			System.out.println(0);
			return;
		}		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()) {
			int index = q.poll();
			for(int i = 0; i < 3; i++) {
				int next = 0;
				if(i == 0) {
					next = index + 1;
				}else if(i == 1) {
					next = index - 1;
				}else {
					next = index * 2;
				}
				if(next == end) {
					System.out.println(arr[index]);
					return;
				}
				if(next >= 0 && next < arr.length && arr[next] == 0) {
					arr[next] = arr[index] + 1;
					q.add(next);
				}
			}
		}
	}
}

