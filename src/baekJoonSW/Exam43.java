package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam43 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split(":");
		while(true) {
			int gcd = findGcd(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
			if(gcd == 1) break;
			arr[0] = Integer.parseInt(arr[0]) / gcd + "";
			arr[1] = Integer.parseInt(arr[1]) / gcd + "";
		}
		bw.write(arr[0]);
		bw.write(":");
		bw.write(arr[1]);
		bw.flush();
		bw.close();
	}
	private static int findGcd(int a, int b) {
		int temp = 0;
		while(b > 0) {
			temp = a;
			a = b;
			b = temp%b;
		}
		return a;
	}
}
