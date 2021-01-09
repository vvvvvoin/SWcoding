package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam59 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		int answer = 0;
		int stickCnt = 0;
		for(int i = 0;  i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				stickCnt ++;
			}else {
				if(input.charAt(i - 1) == '(') {
					stickCnt--;
					answer += stickCnt;
				}else {
					answer++;
					stickCnt--;
				}
			}	
		}
		System.out.println(answer);
	}

}
