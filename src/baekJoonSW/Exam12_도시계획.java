package baekJoonSW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exam12_도시계획 {
	static int[] parent;
	static int N, M;
	static Scanner sc;
	static int sum, size;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		parent = new int[N+1];
		for(int i =1; i<=N;i++) {
			parent[i] = i;
		}
		
		ArrayList<Pos> list = new ArrayList<Pos>();
		for(int i = 0; i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			list.add(new Pos(a, b,c));
		}
		
		Collections.sort(list);
		sum =0;
		size = 0;
		for(int i = 0; i < M; i++) {
			Pos temp = list.get(i);
			if(!isSame(temp.i, temp.j)) {
				union(temp.i, temp.j);
				size++;
				sum += temp.cost;
			}
			if(size >= N - 2 ) break;
		}
		
		System.out.println(sum);
		
	}
	static void union(int i, int j) {
		i = find(i);
		j = find(j);
		if(i > j) {
			parent[j] = i;
		}else parent[i] = j;
	}
	
	static int find(int a) {
		if(parent[a] == a) {
			return a;
		}else {
			parent[a] = find(parent[a]);
			return parent[a];
		}
	}
	
	static boolean isSame(int i, int j) {
		if(find(i) == find(j)) return true;
		else return false;
	}
	
	static class Pos implements Comparable<Pos>{
		int i, j, cost;

		public Pos(int i, int j, int cost) {
			super();
			this.i = i;
			this.j = j;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cost - o.cost;
		}
		
	}
}













