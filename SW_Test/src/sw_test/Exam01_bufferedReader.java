package sw_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam01_bufferedReader {
	static BufferedReader br;
	static BufferedWriter bw;
	static int count, a, b;
	static String[] strs;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		count = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i <count; i++) {
			String str = br.readLine();
			strs = str.split(" ");
			a = Integer.parseInt(strs[0]);
			b = Integer.parseInt(strs[1]);
			bw.write(a +b + "\n");
		}
		bw.flush();
		bw.close();

	}
}
