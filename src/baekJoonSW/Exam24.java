package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//코테 - 백준의 리모콘
public class Exam24 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int answer = Integer.MAX_VALUE;
	static boolean[] number = new boolean[10];
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int channel = Integer.parseInt(br.readLine());
		
		int n = Integer.valueOf(br.readLine());
		if(n !=0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				number[Integer.valueOf(st.nextToken())] = true;
			}
		}
		
		boolean flag = false;
		int answer =Math.abs(100 - channel);
		for(int i = 0; i < 1000000; i++) {
			int c = i;
			int len = 0;
			flag = false;
			while(true) {
				if(number[c % 10] == true) break;
				len++;
				c /= 10;
				if(c == 0) {
					flag = true;
					break;
				}
			}
			if(flag) {
				int value = Math.abs(i - channel) + len;
				answer = Math.min(answer, value);
			}
		}
		
		
		System.out.println(answer);
	}
}
