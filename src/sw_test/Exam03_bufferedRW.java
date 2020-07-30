package sw_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam03_bufferedRW {
	static BufferedReader br;
	static BufferedWriter bw;
	static int count, a, b;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		count = Integer.parseInt(br.readLine().trim());
		for(int i = 1; i <= count; i++ ) {
			String str = br.readLine();
			String[] strs = str.split(" ");
			a = Integer.parseInt(strs[0]);
			b = Integer.parseInt(strs[1]);
			bw.write("Case #" + i + " : " + (a + b) + "\n");
		}
		bw.flush();
		bw.close();
		
		
	}
}
