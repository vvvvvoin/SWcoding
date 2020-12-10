package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exam26 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int answer = 0;
		for(int i = 0; i < n; i++) {
			boolean[] check = new boolean[26];
			boolean flag = false;
			
			String str = br.readLine();
			check[str.charAt(0) - 'a'] = true;
			for(int j = 1; j < str.length(); j++) {
				char c = str.charAt(j);
				if(c != str.charAt(j - 1)) {
					if(check[c - 'a']) {
						flag = true;
						break;
					}else {
						check[c - 'a'] = true;
					}
				}
			}
			if(flag != true) answer++;
		}
		System.out.println(answer);
	}
}
