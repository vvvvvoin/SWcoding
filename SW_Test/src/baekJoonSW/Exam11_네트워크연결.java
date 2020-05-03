package baekJoonSW;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Exam11_네트워크연결 {
	static int N, M;
	static int money;
	static int[] parent;
	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		money = 0;
		ArrayList<Pos> array = new ArrayList<Exam11_네트워크연결.Pos>();
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			array.add(new Pos(a, b, c));
		}
		
		Collections.sort(array);
		
		for (int i = 0; i < M; i++) {
			Pos temp = array.get(i);
			if(!isSame(temp.i, temp.j)) {
				union(temp.i, temp.j);
				money += temp.cost;
			}
		}
		
		System.out.println(money);
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		else {
			parent[a] = find(parent[a]);
			return parent[a];
		}
	}

	static void union(int i, int j) {
		i = find(i);
		j = find(j);

		if (i > j)
			parent[i] = j;
		else
			parent[j] = i;
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
