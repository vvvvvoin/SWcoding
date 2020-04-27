package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam03_HowManyWord {
	static BufferedReader br;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int max = 0;
		int idxmax = 0;
		boolean flag = false;
		int[] a = new int[26];
		for(int i = 0; i < str.length(); i++) {
			a[str.charAt(i) - 'A']++;
		}
		
		for(int i = 0; i <a.length; i++) {
			if(a[i] > max) {
				max = a[i];
				idxmax = i;
			}
			else if(a[i] == max) {
				flag = true;
			}
		}
		
		if(flag) System.out.println("?");
		else {
			System.out.println((char)(idxmax + 'A'));
		}
		
	}

}
