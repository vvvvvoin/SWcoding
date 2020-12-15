package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam42 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		boolean[] arr = new boolean[2000001];
		arr[0] = arr[1] = true;

		
		for(int i = 2; i * i < arr.length; i++) {
			if(!arr[i]) {
				for(int j =  i * i; j < arr.length; j += i) arr[j] = true;				
			}
		}
		
		for(int i = n; i < arr.length; i++) {
			if(arr[i] == false) {
				if(isPalindrome(String.valueOf(i))){
					System.out.println(i);
					break;
				}
			}
		}
			
	}
	
	private static boolean isPalindrome(String s) {
		for(int i = 0, j = s.length() -1; i < j; i++, j--) {
			if(s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}
}
