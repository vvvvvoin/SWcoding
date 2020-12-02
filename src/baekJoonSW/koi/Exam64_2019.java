package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam64_2019 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			System.out.println(isPalindrome(s, 0, s.length() - 1) ? "0" : (isPossible(s) ? "1" : "2"));
		}
	}

	private static boolean isPossible(String s) {
		int i = 0;
		int j = s.length() - 1;
		for(; i < j; i++, j--) {
			if(s.charAt(i) != s.charAt(j)) {
				boolean check1 = isPalindrome(s, i + 1, j);
				boolean check2 = isPalindrome(s, i, j - 1);
				if(check1 == true || check2 == true) {
					return true;
				}else {
					return false;
				}
			}
		}
		return true;
	}
	


	private static boolean isPalindrome(String s, int i, int j) {
		for(; i < j; i++, j--) {
			if(s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}
}
