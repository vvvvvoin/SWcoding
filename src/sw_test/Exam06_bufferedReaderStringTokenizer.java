package sw_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam06_bufferedReaderStringTokenizer {
	static StringTokenizer st;
	static BufferedReader br;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == 0 && b ==0) break;
			sb.append(a + b + "\n");
		}
		System.out.println(sb.toString());
	}
}
