package sw_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam12_rest {
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String rest = "";
		int count = 0;
		
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = Integer.parseInt(br.readLine()) % 42;
		}

		for (int i = 0; i < 10; i++) {
			rest += "" + array[i];
		}
		
		int[] restArray = new int[10];
		for(int i =0; i < rest.length(); i++) {
			restArray[rest.charAt(i)-'0']++;
		}
		
		for(int i = 0; i < 10; i ++) {
			if(restArray[i] != 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
