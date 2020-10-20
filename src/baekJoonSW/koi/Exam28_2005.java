package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam28_2005 {
	static BufferedReader br;
	static StringTokenizer st;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[] seats;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		seats = new int[n + 1];
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			int seat = Integer.parseInt(br.readLine());
			seats[seat] = 9;
		}
		int[] dp = new int[n + 1];
		int b = 1;
		int a = 1;
		int index = 2;
		for(int i = 0; i < dp.length; i++) {
			dp[index] = a + b;
			a = b;
			b = dp[index];
			if(index >= dp.length - 1) break;
			index++;
		}
		int cnt = 0;
		for(int i = 1; i < seats.length; i++) {
			if(seats[i] == 0) {
				cnt++;
			}else {
				if(i == 1) continue;
				if(cnt == 1) {
					list.add(1);
				}else {
					list.add(dp[cnt]);					
				}
				cnt = 0;
			}
		}
		if(cnt != 0) list.add(dp[cnt]);
		System.out.println(list);
		int answer = 1;
		for(int value : list) {
			if(value == 0) continue;
			answer *= value;
		}
		if(answer == 0) {
			System.out.println(1);
		}else {
			System.out.println(answer);			
		}
	}

}
