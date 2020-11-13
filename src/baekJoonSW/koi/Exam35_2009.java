package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam35_2009 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String answer = "";
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		if(arr.length % 2 ==0) {
			answer += arr[arr.length / 2 - 1] + " ";
		}else {
			answer += arr[arr.length / 2] + " ";			
		}
		
		double min = Double.MAX_VALUE;
		int index = 0;
		double sum = 0;
		for(int i = 1; i <= 10000; i++) {
				sum = 0;
				for(int j = 0; j < arr.length; j++) {
					sum += Math.pow(arr[j] - i , 2);
				}
				if(min > sum) {
					min = sum;
					index = i;
				}
				if(min < sum) {
					break;
				}
				
		}
		answer += index;


		System.out.println(answer);
	}
}
