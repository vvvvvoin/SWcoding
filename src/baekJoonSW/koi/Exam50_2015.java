package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam50_2015 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int student = 0;
		int apple = 0;
		int answer = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			student = Integer.parseInt(st.nextToken());
			apple = Integer.parseInt(st.nextToken());
			answer += apple % student;
		}
		System.out.println(answer);
	}
}
