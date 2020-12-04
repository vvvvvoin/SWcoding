package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
//https://korean-otter.tistory.com/entry/
public class Exam68_2020 {
	static BufferedReader br;
	static StringTokenizer st;

	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		int sum = 0;
		for(int i = 1; i <= k; i++) {
			sum += i;
		}
		n -= sum;
		
		if(n < 0) {
			System.out.println(-1);
		}else {
			if(n % k == 0) {
				System.out.println(k - 1);
			}else {
				System.out.println(k);
			}
		}
	}
}
