package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam63_2019 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		int top = 0;
		int index = 0;
		for(int i = 0; i < n; i++) {
			int value = Integer.valueOf(br.readLine());
			arr[i] = value;
			if(value > top) {
				top = value;
				index = i;
			}
		}
		int t = arr[arr.length - 1];
		int answer = 1;
		for(int i = arr.length - 1; i >= index; i--) {
			if(arr[i] > t) {
				answer++;
				t = arr[i];
			}
		}
		System.out.println(answer);
		
	}
}
