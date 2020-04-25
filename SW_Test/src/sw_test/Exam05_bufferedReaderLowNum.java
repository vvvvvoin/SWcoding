package sw_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam05_bufferedReaderLowNum {
	static BufferedReader br;
	static BufferedWriter bw;
	static int count, x;
	static String[] strs, strs2;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		strs = str.split(" ");
		count = Integer.parseInt(strs[0]);
		x = Integer.parseInt(strs[1]);

		String str2 = br.readLine();
		strs2 = str2.split(" ");
		
		for (int i = 0; i < count; i++) {
			if (Integer.parseInt(strs2[i]) < x) {
				bw.write(strs2[i]);
				bw.write(" ");
			}
		}
		bw.flush();
		bw.close();

	}
}
