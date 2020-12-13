package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Exam32 {
	static BufferedReader br;
	static StringTokenizer st;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < str.length(); i++) {
			list.add(str.substring(i, str.length()));
		}
		Collections.sort(list);
		for(String s : list) {
			bw.write(s);
			bw.write("\n");
		}
		bw.flush();
	}
}
