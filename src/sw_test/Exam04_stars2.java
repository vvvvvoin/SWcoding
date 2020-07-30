package sw_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam04_stars2 {
	
	static BufferedReader br;
	static BufferedWriter bw;
	static int count;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		count = Integer.parseInt(br.readLine().trim());
		
		for(int i = 1 ; i<= count; i++) {
			for(int j = count-1; j >= i; j--) {
				bw.write("  ");
			}
			for(int j = 0; j<i; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}

}
