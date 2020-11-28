package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam58_2017 {
	static BufferedReader br;
	static StringTokenizer st;
	static boolean flag = false;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int[] arr = new int[3];
		arr[0] = Integer.parseInt(str[0]);
		arr[1] = Integer.parseInt(str[1]);
		arr[2] = Integer.parseInt(str[2]);
		int person = Integer.parseInt(str[3]);
		

		for(int i = 0; i <= 300; i++) {
			for(int j = 0; j <= 200; j++) {
				for(int k = 0; k <= 100; k++) {
					if(arr[0] * i + arr[1] * j + arr[2] * k  == person ) {
						System.out.println(1);
						return;
					}
				}
				
			}
		}
		System.out.println(0);
	}

}
