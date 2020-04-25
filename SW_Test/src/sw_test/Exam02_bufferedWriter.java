package sw_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam02_bufferedWriter {
	static BufferedReader br;
	static BufferedWriter bw;
	static int a;
	static String str;
	
	public static void main(String[] args) throws Exception {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		str = br.readLine();
		a= Integer.parseInt(str);
		for(int i =1;i<=a;i++) {
			bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
	}

}
