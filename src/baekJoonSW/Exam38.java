package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam38{
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String origin = br.readLine();
		String compa = br.readLine();
		int cnt = 0;
		int index = 0;
		while(true) {
			index = origin.indexOf(compa);
			if(index == -1) break;
			cnt++;
			origin = origin.substring(index + compa.length());
		}
		System.out.println(cnt);
	}
}
