package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exam34_2009 {
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
		
		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			if(!set.contains(arr[i])) {
				set.add(arr[i]);
				int sum = 0;
				for(int j = 0; j < n; j++) {
					sum += Math.abs(arr[i] - arr[j]);
				}
				min = Math.min(min, sum);
				map.put(arr[i], sum);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int key : map.keySet()) {
			if(map.get(key) == min) {
				list.add(key);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
