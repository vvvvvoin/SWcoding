package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam43_2012 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i = 0 ; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			arr[i] = value;
			max += value;
			
		}
		int money = Integer.parseInt(br.readLine());
		
		
		int sum = 0;
		
		Arrays.sort(arr);
		if(max <= money) {
			System.out.println(arr[n - 1]);
		}else {
			int current = 0;
			for(int i = 0 ; i < arr.length; i++) {
				current = arr[i] * (n - i);
				if(sum + current < money) {
					sum += arr[i];
				}else {
					System.out.println((money - sum) / (n - i));
					break;
				}
			}
		}

	}
}
