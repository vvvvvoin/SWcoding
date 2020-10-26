package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam33_2008 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int[] game1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] game2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int[] win = new int[6];
	static int[] draw = new int[6];
	static int[] defeat = new int[6];
	static boolean flag; 
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String answer = "";
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int w = 0;
			int d = 0;
			int f = 0;
			flag = false;
			for(int j = 0; j < 6; j++) {
				win[j]  = Integer.parseInt(st.nextToken());
				w += win[j] ;
				draw[j] = Integer.parseInt(st.nextToken());
				d += draw[j];
				defeat[j] = Integer.parseInt(st.nextToken());
				f += defeat[j];
			}
			
			if(w + d + f != 30) {
				flag = false;
			}else {
				solution(0);
			}
			
			if(flag == true) {
				answer += "1 ";
			}else {
				answer += "0 ";				
			}
			
			
		}
		System.out.println(answer);
	}
	
	private static void solution(int g) {
		if(flag == true) return;
		if(g == 15) {
			flag = true;
			return;
		}
		
		int a = game1[g];
		int b = game2[g];
		
		if(win[a] > 0 && defeat[b] > 0) {
			win[a]--;
			defeat[b]--;
			solution(g + 1);
			win[a]++;
			defeat[b]++;
		}
		if(win[b] > 0 && defeat[a] > 0) {
			win[b]--;
			defeat[a]--;
			solution(g + 1);
			win[b]++;
			defeat[a]++;
		}
		if(draw[a] > 0 && draw[b] > 0) {
			draw[a]--;
			draw[b]--;
			solution(g + 1);
			draw[a]++;
			draw[b]++;
		}
	}
}//https://jaejin89.tistory.com/41
