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
	static ArrayList<Set> list;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		tc = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for(int i = 0; i <tc; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			operate = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			if(operate == 0) {
				for(int p =0; p < list.size(); p++) {
					if(!list.get(p).set.contains(n1)) {
						list.add(new Set(new ArrayList<Integer>()));
						
					}
				}
			}else if(operate == 1) {
				if(list.contains(n1) || list.contains(n2)) {
					System.out.println("YES");
				}else System.out.println("NO");
			}
		}
		
	}
	static class Set{
		private ArrayList<Integer> set;

		public ArrayList<Integer> getSet() {
			return set;
		}

		public void setSet(ArrayList<Integer> set) {
			this.set = set;
		}

		public Set(ArrayList<Integer> set) {
			super();
			this.set = set;
		}
		
	}
}
