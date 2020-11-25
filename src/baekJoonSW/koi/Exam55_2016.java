package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam55_2016 {
	static BufferedReader br;
	static StringTokenizer st;
	static long x, y;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		x = -1;
		y = -1;
		int n = Integer.parseInt(br.readLine());
		fibo(n);
		if(x == -1 || y == -1) {
			if(n == 1) {
				System.out.println(4);
			}else {
				System.out.println(6);
			}
		}else {
			System.out.println(x * 2 + (x + y) * 2);			
		}
	}
	
	private static void fibo(int n) {
		if(n <= 2) {
			return;
		}else{
			long a = 1;
			long b = 1;
			long value = 0;
			for(int i = 0; i < n - 2; i++) {
				value = a + b;
				b = a;
				a = value;
			}
			x = value;
			y = b;
		}
	}
}
