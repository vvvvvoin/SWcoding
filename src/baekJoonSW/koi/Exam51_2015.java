package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam51_2015 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		double first = 1;
		double second = 1;
		double answer = 1;

		boolean flip = false;
		for(int o = 0; o < n ; o++) {
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			if(Integer.parseInt(st.nextToken()) == 1) {
				flip = !flip;
			}
			System.out.println(answer);
			answer = answer * second / first;

		}
		System.out.println((flip == true ? "1" : "0") + " " + String.valueOf(Math.round(answer)) );
	}
}
