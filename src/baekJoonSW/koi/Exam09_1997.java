package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam09_1997 {
	static BufferedReader br;
	static int[] output;
	static int[] array;
	static int N;
	static boolean flag = false;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		solution("");
		
	}

	static void solution(String str) {
		if(flag == true) return;
		if(str.length() == N) {
			System.out.println(str);		
			flag = true;
			return;
		}
		for(int i = 1; i <= 3; i++) {
			if(check(str + i)) {
				solution(str + i);
			}
		}
		
	}

	static boolean check(String string) {
		for(int j = 0; j <= string.length(); j++) {
			String str = string.substring(j, string.length());
			for(int i = 1; i <= str.length()/2; i++) {
				String temp1 = str.substring(str.length() -i -i, str.length() - i);
				String temp2 = str.substring(str.length() - i, str.length());
				String temp3 = str.substring(0, i);
				String temp4 = str.substring(i, i+i);
				
				if(temp1.equals(temp2) || temp3.equals(temp4)) return false;
			}
		}
		
		return true;
	}

}
