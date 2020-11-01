package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam39_2011 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = k - 1;
		int value = 0;
		int answer = Integer.MIN_VALUE;
		for(int i = left; i <= right; i++) {
			value += arr[i];
		}
		answer = Math.max(value, answer);
		
		while(true) {
			value -= arr[left];
			right++;
			if(right >= arr.length) break;
			value += arr[right];
			answer = Math.max(value, answer);
			left++;
			
		}
		System.out.println(answer);
	}
}
