package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam09_상담 {
	static BufferedReader br;
	static StringTokenizer st;
	static int TC;
	static int[] T, P;
	static int MAX, money;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		T = new int[TC];
		P = new int[TC];
		MAX = 0;
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			T[tc] = Integer.parseInt(st.nextToken());
			P[tc] = Integer.parseInt(st.nextToken());
		}
		
		solution(0, 0);
		
		System.out.println(MAX);
	}
	static void solution(int day, int money) {
		if(day >= TC) {
			MAX = Math.max(money, MAX);
			return;
		}
		if(day + T[day] <= TC) {
			solution(day + T[day], money+ P[day]);
		}
		solution(day+1, money);
	}
}
