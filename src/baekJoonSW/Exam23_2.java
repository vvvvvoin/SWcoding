package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exam23_2 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] arr;
	static int[] rank;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n + 1];
		rank = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
			rank[i] = 0;
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 1; i < arr.length; i++) {
			System.out.print(find(arr[i]) + " ");
		}
		System.out.println();
		for(int i = 1; i < arr.length; i++) {
			set.add(find(arr[i]));
		}
		System.out.println(set.size());
	}
	
	private static int find(int x) {
		if(x == arr[x]) return x;
		return arr[x] = find(arr[x]);
	}
	
	private static void union(int x, int y) {
		if(find(x) == find(y)) return;
		if(rank[x] < rank[y]) {
			arr[x] = y;
		}else if(rank[x] > rank[y]) {
			arr[y] = x;
		}else {
			arr[y] = x;
			rank[x] += 1;
		}
	}
	
}
