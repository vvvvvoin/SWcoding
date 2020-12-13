package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam33 {
	static BufferedReader br;
	static StringTokenizer st;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		int answer = Integer.MAX_VALUE;
		int start = 0;
		while(a.length + Math.abs(start) <= b.length) {
			int index = 0 + start;
			int cnt = 0;
			for(int i = 0; i < b.length; i++) {
				if(index >= a.length) break;
				if(index >= 0) {
					if(a[index] != b[i]) {
						cnt++;
					}
				}
				
				index++;
			}
			start--;
			answer = Math.min(answer, cnt);
		}
		
		System.out.println(answer);
		
		
	}
}
