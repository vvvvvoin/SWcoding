package baekJoonSW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam40 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] cnt = new int[26];
		
		String str = br.readLine();
		int countOdd = 0;
		for(char c : str.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				cnt[x]++;
				if(cnt[x] % 2 == 1) {
					countOdd++;
				}else {
					countOdd--;
				}
			}
		}
		if(countOdd > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		char[] answer = new char[str.length()];
		makeStr(answer, cnt);
		System.out.println(String.valueOf(answer));
	}
	
	
	private static void makeStr(char[] answer, int[] cnt) {
		int index = 0;
		for(int i = 0; i < cnt.length; i++) {
			if(cnt[i] > 1) {
				answer[index] = (char)(i + 'A');
				answer[answer.length - index - 1] = (char)(i + 'A');
				cnt[i] -= 2;
				index++;
				if(index == answer.length / 2) index++;
				i--;
			}else if(cnt[i] == 1){
				answer[answer.length / 2] = (char)(i + 'A');
			}
		}
	}


	private static int getCharNumber(char c) {
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');
		int value = Character.getNumericValue(c);
		if(A <= value && value <= Z) {
			return value - A;
		}
		return -1;
	}
}
