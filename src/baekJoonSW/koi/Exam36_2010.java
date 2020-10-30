package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam36_2010 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int a = 0;
		int b = n - 1;
		int left = 0;
		int right = 0;
		int value = Integer.MAX_VALUE;
		while(a < b) {
			if(Math.abs(arr[a] + arr[b]) < value) {
				value =Math.abs(arr[a] + arr[b]);
				left = arr[a];
				right = arr[b];
			}
			
			if(arr[a] + arr[b] < 0) {
				a++;
			}else {
				b--;
			}
		}
		
		System.out.println(left + " " + right);
	}
}
