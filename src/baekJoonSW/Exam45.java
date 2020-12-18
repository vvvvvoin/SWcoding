package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam45 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		int len = Integer.valueOf(br.readLine());
		char[] str = br.readLine().toCharArray();
		
		int answer = 0;
		int cnt = 0;
		for(int i = 1; i < len - 1; i++) {
			if(str[i - 1] == 'I' && str[i] == 'O' && str[i+1] == 'I') {
				cnt++;
				if(cnt == n) {
					cnt--;
					answer++;
				}
				i++;
			}else {
				cnt = 0;
			}
		}
		System.out.println(answer);
	}
}
