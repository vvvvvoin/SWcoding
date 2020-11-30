package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam61_2018 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			arr[color - 1].add(index);
		}
		for (int i = 0; i < n; i++) {
			Collections.sort(arr[i]);			
		}

		int ans = 0;
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < arr[j].size(); i++) {
				if(i ==0) {
					ans += arr[j].get(i + 1) - arr[j].get(i);
				}else if(i == arr[j].size() - 1) {
					ans += arr[j].get(i) - arr[j].get(i - 1);				
				}else {
					int back = arr[j].get(i + 1) - arr[j].get(i);
					int front = arr[j].get(i) - arr[j].get(i - 1);
					ans += back > front ? front : back;
				}
			}
		}
		

		System.out.println(ans);
		
	}

}
