package sw_AdvancedTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exam02_FindWayQueue {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int start, end, flag;
	static boolean[][] check;
	static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(st.nextToken());
		check = new boolean[100][100];
		flag = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < size; j++) {
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				check[start][end] = true;
			}
			dfs(0);
			bw.write("#" + n + " " + flag);
		}
		
		
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}
		bw.flush();
		bw.close();

	}

	public static void dfs(int a) {
		queue = new LinkedList<Integer>();
		queue.offer(a);
		System.out.println(a);
		for(int i = 0; i < 100; i++) {
			if(check[a][i] == true) {
				check[a][i] = false;
				if(i == 99) {
					flag = 1;
					return;
				}
				else dfs(i);
			}
		}
		
	}
}














