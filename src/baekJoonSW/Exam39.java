package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam39 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String st = br.readLine();
		boolean check = false;
		for(int i = 0; i < st.length(); i++) {
			char c = st.charAt(i);
			if(c == '<') {
				bw.write(sb.reverse().toString());
				sb.delete(0, sb.length());
				bw.write("<");
				check = true;
			}else if(c == '>') {
				bw.write(">");
				check = false;
			}else {
				if(check == true) {
					bw.write(c);
				}else {
					if(c == ' ') {
						bw.write(sb.reverse().toString());
						bw.write(" ");
						sb.delete(0, sb.length());
					}else {
						sb.append(c);						
					}
				}
			}
		}
		bw.write(sb.reverse().toString());
		bw.flush();
	}
}
