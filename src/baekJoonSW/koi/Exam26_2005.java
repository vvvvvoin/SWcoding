package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Exam26_2005 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static HashMap<Integer, Integer> map ;
	static ArrayList<Integer> list;
	static int max;
	static int answerMax;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		list = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[5];
			boolean[] visited = new boolean[5];
			for(int j = 0; j < 5; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			com(arr, visited, 0, 3, i + 1);
		}
		for(int key : map.keySet()) {
			String str = map.get(key) + "";
			int lastValue = Integer.parseInt(str.substring(str.length() - 1, str.length()));
			if(lastValue == answerMax) {
				list.add(key);
			}
		}
		if(list.size() == 1) {
			System.out.println(list.get(0));
		}else {
			if(map.size() == 0) {
				System.out.println(n);
			}else {
				System.out.println(list.get(list.size() - 1));
			}
			
		}
	}
	private static void com(int[] arr, boolean[] visited, int start, int n, int m) {
		if(n == 0) {
			int value = 0;
			String str = "";
			for(int i = 0; i < visited.length; i++) {
				if(visited[i] == true) {
					value += arr[i];
				}
			}
			str = value + "";
			int first = Integer.parseInt(str.substring(str.length() - 1, str.length()));
			if(first > max) {
				max = first;
				map.put(m, value);
				if(answerMax < first) {
					answerMax = first;
				}
			}
			return;
		}
		for(int i = start; i < arr.length; i++) {
			visited[i] = true;
			com(arr, visited, i + 1, n - 1, m);
			visited[i] = false;
			
		}
		
	}
}
