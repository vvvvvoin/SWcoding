package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Exam04_1996 {
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String regEx01 = "(10(0)+(1)+|01)+";
		
		boolean flag = Pattern.matches(regEx01, input);
		
		if(flag == true) {
			System.out.println("SUBMARINE");
		}else {
			System.out.println("NOISE");
		}
	}
}
