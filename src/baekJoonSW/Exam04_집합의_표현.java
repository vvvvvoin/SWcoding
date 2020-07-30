package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam04_집합의_표현 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, tc;
	static int operate, n1,n2;
	static int[] parent;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		tc = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		
		for(int i = 1; i<=N ; i++) {
			parent[i] = i;
		}
		
		
		for(int i = 0; i <tc; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			operate = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			if(operate == 0) {
				union(n1, n2);
			}else {
				same(n1, n2);
			}

		}
		
	}
	
	static int find(int a) {
		if(a == parent[a]) {
			return a;
		}else 
			parent[a] = find(parent[a]);
			return parent[a];
	}
	
	static void union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i > j) {
			parent[i] = j;
		}else parent[j] = i;
	}

	static void same(int i, int j) {
		i = find(i);
		j = find(j);
		if(i == j) {
			System.out.println("YES");
		}else System.out.println("NO");
	}
}








