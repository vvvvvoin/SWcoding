package programers_Lv2;

import java.util.ArrayList;

public class Exam49 {
	static int n = 16;	// n진수
	static int t = 16;	// 미리구할 갯수
	static int m = 2; // 게임에 참가하는 인원
	static int p = 2; // 튜브의 순서
	public static void main(String[] args) {
		ArrayList<String> answerList = new ArrayList<String>();
		String character = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String temp = "";
		int number = 0;
		int size = 0;
		answerList.add("0");
		for (int i = 1; i <= t * m; i++) {
			number = i;
			while(number != 0) {
				temp = character.charAt(number%n) + temp;
				number /= n;
			}
			answerList.add(temp);
			size += temp.length();
			temp = "";
			if(size >= t * m) break;
		}
		StringBuilder sb = new StringBuilder();
		for(String value : answerList) {
			sb.append(value);
		}
		String result = sb.toString();
		String answer = "";
		int cnt = 0;
		for(int i = 0; i < result.length(); i++) {
			if(cnt == t) break;
			if(i % m == p - 1) {
				answer += result.charAt(i);
				cnt++;
			}
		}
		System.out.println(answer);
	}
}
