package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam32_2008 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		double[] arr = new double[n];
		for(int i = 0; i < n ; i++) {
			arr[i] =  Double.parseDouble(br.readLine());
		}
		
		Arrays.sort(arr);
		
		//절사평균
		double avg1 = 0.0;
		for(int i = k; i < arr.length - k; i++) {
			avg1 += arr[i];
		}
		
		
		//보정편균
		for(int i = 0; i < k; i++) {
			arr[i] = arr[k];
		}
		for(int i = arr.length - k; i < arr.length; i++) {
			arr[i] = arr[arr.length - k - 1];
		}
		
		double avg2 = 0.0;
		for(int i = 0; i < arr.length; i++) {
			avg2 += arr[i];
		}

		System.out.println(String.format("%.2f", avg1 / (arr.length - 2 * k) + 1e-8));
		System.out.println(String.format("%.2f", avg2 / arr.length + 1e-8));
	}
}
