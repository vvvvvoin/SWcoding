package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam42_2012 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] a = new int[10];
		int aScore = 0;
		int bScore = 0;
		boolean aFlag = false;
		boolean bFlag = false;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a.length; i++) {
			int value = Integer.parseInt(st.nextToken());
			if(a[i] > value) {
				aScore += 3;
				aFlag = true;
				bFlag = false;
			}else if(a[i] < value) {
				bScore += 3;
				aFlag = false;
				bFlag = true;
			}else {
				aScore += 1;
				bScore += 1;
			}
		}
		
		System.out.println(aScore + " " + bScore);
		if(aScore == bScore) {
			if(aFlag) {
				System.out.println("A");				
			}else if(bFlag) {
				System.out.println("B");
			}else {
				System.out.println("D");
			}
		}else {
			System.out.println(aScore > bScore ? "A" : "B");			
		}
	}
}
