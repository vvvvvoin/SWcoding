package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam66_2019 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.valueOf(br.readLine());
		char[] str = br.readLine().toCharArray();
		int answer = 0;
		int cnt = 0;
		int redMax = 0;
		int blueMax = 0;
		
		// 최적의 상황을 고려하지 않고 가장 적은 공을 한쪽으로 몰아내는 경우
		for(int i = 0; i < str.length; i++) {
			if(str[i] == 'R') redMax++;
			else blueMax++;
		}
		answer = Math.min(redMax, blueMax);
		
		// 다른 상황을 고려한다면 이미 처음쪽에 몰려있는 경우를 생각해서
		// 처음에 몰려있는 공에 갯수를 구하고 처음쪽에 공에 종류에 맞게
		// 해당 공의 전체 갯수에서 빼주면 나머지 연속되지 않은 공을 머리쪽으로
		// 이동시키는 결과가 된다.
		// 반대편도 마찬가지로
		for(int i = 0; i < str.length; i++) {
			if(str[0] != str[i]) break;
			cnt++;
		}
		if(str[0] == 'R') answer = Math.min(answer, redMax - cnt);
		else answer = Math.min(answer, blueMax - cnt);
		
		cnt = 0;
		for(int i = length - 1; i >= 0; i--) {
			if(str[length - 1] != str[i]) break;
			cnt++;
		}
		if(str[length - 1] == 'R') answer = Math.min(answer, redMax - cnt);
		else answer = Math.min(answer, blueMax - cnt);
		
		System.out.println(answer);
	}
}
