package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam30 {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		String[] noHear = new String[n];
		for(int i = 0; i < n; i++) {
			noHear[i] = br.readLine();
		}
		Arrays.sort(noHear);
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			if(Arrays.binarySearch(noHear, str) >= 0) {
				list.add(str);
			}
		}
		Collections.sort(list);
		StringBuilder sb= new StringBuilder();
		sb.append(list.size() + "\n");
		for(String str : list) {
			sb.append(str + "\n");
		}
		System.out.println(sb.toString());
	}
}
