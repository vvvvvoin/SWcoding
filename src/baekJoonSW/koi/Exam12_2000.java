package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam12_2000 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] switchArray;
	static int M;
	static int switchNumber;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		switchArray = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < switchArray.length; i++) {
			switchArray[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 1) {
				man(Integer.parseInt(st.nextToken()));
			}else {
				woman(Integer.parseInt(st.nextToken()));
			}
			
		}
		String answer = "";
		int cnt = 0;
		for(int i = 0; i < switchArray.length; i++) {
			answer += switchArray[i] + " ";
			cnt++;
			if(cnt == 20) {
				System.out.println(answer.trim());
				answer = "";
				cnt = 0;
			}
		}
		System.out.println(answer.trim());
	}
	
	static void man(int value) {
		for(int i = value - 1; i < switchArray.length; i = i + value) {
			switchArray[i] = (switchArray[i] == 1) ? 0 : 1;
		}
	}
	
	static void woman(int index) {
		int a = index - 1;
		int b = index - 1;
		while(true) {
			if(b + 1 >= switchArray.length || a - 1 < 0) break;
			if(switchArray[a - 1] == switchArray[b + 1]) {
				a -= 1;
				b += 1;
			}else {
				break;
			}
		}
		for(int i = a; i <= b; i++) {
			switchArray[i] = (switchArray[i] == 1) ? 0 : 1;
		}
	}
}
