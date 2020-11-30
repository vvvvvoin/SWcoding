package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam60_2018 {
	static BufferedReader br;
	static StringTokenizer st;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>(n + 1);
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			list.add(Integer.parseInt(st.nextToken()));
			if(value > MAX) MAX = value;
			if(value < MIN) MIN = value;
		}
		System.out.println(MAX - MIN);
		
		System.out.println(Collections.max(list) - Collections.min(list));
	}
}
