package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam54_2016 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] girl = new int[7];
		int[] boy = new int[7];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("0")) {
				girl[Integer.parseInt(st.nextToken())]++;
			}else{
				boy[Integer.parseInt(st.nextToken())]++;				
			}
		}
		
		int answer = 0;
		for(int i = 1; i < 7; i++) {
			answer += girl[i] / k;
			answer += (girl[i] % k != 0) ? 1 : 0;
			answer += boy[i] / k;
			answer += (boy[i] % k != 0) ? 1 : 0;
		}
		System.out.println(answer);
	}
}
