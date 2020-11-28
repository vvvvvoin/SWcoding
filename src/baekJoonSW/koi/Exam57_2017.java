package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam57_2017 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] temp = null;
		for(int o = 0; o < n; o++) {
			int[] a = new int[5];
			int[] b = new int[5];
			temp = br.readLine().split(" ");
			for(int i = 1; i < temp.length; i++) {
				a[Integer.parseInt(temp[i])] += 1;
			}
			
			temp = br.readLine().split(" ");
			for(int i = 1; i < temp.length; i++) {
				b[Integer.parseInt(temp[i])] += 1;
			}
			
			boolean flag = true;
			for(int i = 4; i >= 1; i--) {
				if(a[i] > b[i]) {
					flag = false;
					System.out.println("A");
					break;
				}else if(a[i] < b[i]){
					flag = false;
					System.out.println("B");
					break;
				}
			}
			if(flag) {
				System.out.println("D");
			}
		}
	}
}
