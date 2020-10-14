package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam19_2002 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		int n = Integer.parseInt(br.readLine());
		int bottom = 0;
		int left = 0;
		int right = 0;
		int answer = 0;
		// right >= left >= bottom
		for (int i = 1; i <= n - 1; i++) {
			for(int j = i; i <= n -1; j++) {
				bottom = i;
				left = j;
				right =  n - (i + j);
				if(right < left) break;
				if(right < bottom + left) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
