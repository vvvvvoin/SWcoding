package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam46 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int answer = 0;
		String input = br.readLine();
		int n = Integer.valueOf(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if((str + str).contains(input)) answer++;
		}
		System.out.println(answer);
	}
}
