package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam40_2011 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		int minValue = Integer.MAX_VALUE;
		int minA = 0;
		int minB = 0;
		long value = (long)a * (long)b;
		for(long i = a; i <= value; i = i + a) {
			if(value % i == 0) {
				int currA = (int) i;
				int currB = (int) (value / i);
				if(gcd(currA, currB) == a) {
						if(i + value / i < minValue) {
							minValue = currA + currB;
							minA = currA;
							minB = currB;
						}
					}
			}
		}
		
		
		
		System.out.println(minA + " " + minB);
	}

	private static Integer gcd(int a, int b) {
		while( b > 0) {
			int temp = a;
			a = b;
			b = temp%b;
		}
		return a;
	}
}
