package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam54 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			if(isP(str.substring(i))) {
				System.out.println(str.length() + i);
				return;
			}
		}

	}

	private static boolean isP(String s) {
		for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if(s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}

}
