package sw_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam11_CountNum {
	static BufferedReader br;
	static BufferedWriter bw;
	static int a, b, c;
	public static void main(String[] args)  throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		
		String result = "" + (a * b * c);
		System.out.println(result);
		int[] array = new int[10];
		
		for(int i = 0; i<result.length(); i++) {
			array[result.charAt(i)-'0']++;
		}
		
		for(int i = 0; i< 10; i++) {
			System.out.println(array[i]);
		}
		
		
	}
}
