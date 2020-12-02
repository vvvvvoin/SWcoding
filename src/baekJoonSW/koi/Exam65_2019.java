package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam65_2019 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int answer = 0;
		for(int i = 1; i <= n; i++) {
			int value = i;
			while(value > 0) {
				int temp = value % 10;
				if(temp == 3 || temp == 6 || temp == 9 ) {
					answer++;
				}
				value /= 10;
			}
		}
		System.out.println(answer);
	}
}
