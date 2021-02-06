package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam63 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		double a = Double.valueOf(st.nextToken());
		double b = Double.valueOf(st.nextToken());
		double v = Double.valueOf(st.nextToken());

		double value = (v - b) / (a - b);
		if((v - b) % (a - b) != 0) {
			value = value + 1;
		}

		System.out.println((int)value);
	}


}
