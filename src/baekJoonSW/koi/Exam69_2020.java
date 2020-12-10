package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 테스트 케이스가 맞는데도 틀린 답이 나와 굳이 swap을 해야했다.

public class Exam69_2020 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		//int[] arr = {60, 10, -10, 1, -1};
		int[] arr = {-1, 1, -10, 10, 60};
		for(int i = 0 ; i < n; i++) {
			int value = Integer.valueOf(br.readLine());
			int[] answer = new int[5];
			int sum = 0;
			answer[4] = value/60;
			value %= 60;
			while(true) {
				if(sum == value) break;
				int index = 0;
				int temp = 100000000;
				
				for(int j = 0; j < arr.length; j++) {
					if(temp > Math.abs(value - (sum + arr[j]))) {
						temp = Math.abs(value - (sum + arr[j]));
						index = j;
					}
				}
				sum += arr[index];
				answer[index]++;
			}
			swap(answer);
			for (int a : answer) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}
	//int[] arr = {60, 10, -10, 1, -1};
	//int[] arr = {-1, 1, -10, 10, 60};
	private static void swap(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[4];
		arr[4] = temp;
		
		temp = arr[1];
		arr[1] = arr[3];
		arr[3] = temp;
		
	}
}
