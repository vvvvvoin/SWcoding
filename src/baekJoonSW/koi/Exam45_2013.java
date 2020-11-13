package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam45_2013 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Nation[] arr = new Nation[n];

		int who = 0;
		int gold = 0;
		int silver = 0;
		int bronz = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			who = Integer.parseInt(st.nextToken());
			gold = Integer.parseInt(st.nextToken());
			silver = Integer.parseInt(st.nextToken());
			bronz = Integer.parseInt(st.nextToken());
			Nation nation = new Nation(who, gold, silver, bronz);
			arr[i] = nation;
		}

		Arrays.sort(arr);
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i].who + "  " + arr[i].gold + "  " + arr[i].silver + "  " + arr[i].bronz);
			if(arr[i].who == k) {
				int cnt = 0;
				for(int j = i; j >= 0; j--) {
					if(!(arr[j].gold == arr[i].gold && arr[j].silver == arr[i].silver && arr[j].bronz == arr[i].bronz)) {
						cnt++;
					}
				}
				System.out.println(cnt + 1);
				return;
			}
		}
	}

	private static class Nation implements Comparable<Nation> {
		int who;
		int gold;
		int silver;
		int bronz;

		public Nation(int who, int gold, int silver, int bronz) {
			super();
			this.who = who;
			this.gold = gold;
			this.silver = silver;
			this.bronz = bronz;
		}

		@Override
		public int compareTo(Nation o) {
			if (this.gold > o.gold) {
				return -1;
			} else if(this.gold == o.gold) {
				if(this.silver > o.silver) {
					return -1;
				}else if(this.silver == o.silver) {
					if(this.bronz > o.bronz) {
						return -1;
					}else if(this.bronz == o.bronz){
						return 0;
					}else {
						return 1;
					}
				}else {
					return 1;
				}
			}else {
				return 1;
			}

		}
	}
}
