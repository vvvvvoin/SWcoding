package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam44 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] arr;
	static int[] oper;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		arr = new int[n];
		oper = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.valueOf(st.nextToken());
		}


		solution(1, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void solution(int index, int sum) {
		if(index == arr.length) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(oper[i] > 0) {
				oper[i] -= 1;
				if(i == 0) {
					solution(index + 1, sum+arr[index]);
				}else if(i == 1) {
					solution(index + 1, sum-arr[index]);
				}else if(i == 2) {
					solution(index + 1, sum*arr[index]);
				}else if(i == 3) {
					solution(index + 1, sum/arr[index]);
				}
				oper[i] +=1;
			}
		}
		
	}


}
