package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam27 {
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		String cro = br.readLine();
		int answer = 0;
		for(int i = 0; i < cro.length(); i++) {
			char c = cro.charAt(i);
			
			if(c == 'c') {
				if(i < cro.length() - 1) {
					if(cro.charAt(i + 1) == '=' || cro.charAt(i + 1) == '-') {
						i++;
					}
				}
			}else if(c == 'd') {
				if(i < cro.length() - 1) {
					if(cro.charAt(i + 1) == 'z') {
						if(i < cro.length() - 2) {
							if(cro.charAt(i + 2) == '=') {
								i += 2;
							}
						}
					}else if(cro.charAt(i + 1) == '-') {
						i++;
					}
				}
			}else if(c == 'l') {
				if(i < cro.length() - 1) {
					if(cro.charAt(i + 1) == 'j') {
						i++;
					}
				}
			}else if(c == 'n') {
				if(i < cro.length() - 1) {
					if(cro.charAt(i + 1) == 'j') {
						i++;
					}
				}

			}else if(c == 's') {
				if(i < cro.length() - 1) {
					if(cro.charAt(i + 1) == '=') {
						i++;
					}
				}
			}else if(c == 'z') {
				if(i < cro.length() - 1) {
					if(cro.charAt(i + 1) == '=') {
						i++;
					}					
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
}
