package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam15_2001 {
	static BufferedReader br;
	static StringTokenizer st;
	
	static	 int[] weight;
	static boolean flag = false;
	static String answer;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int weightCnt= Integer.parseInt(br.readLine());
		weight  = new int[weightCnt];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < weight.length; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		int max = 500 * 30;
		boolean[] check = new boolean[max + 1];
		boolean[] save = new boolean[max + 1];
		int add01 = 0;
		int add02 = 0;
		check[0] = true;
		save[0] = true;
		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j <= max; j++) {
				if (check[j] == true) {
					add01 = Math.abs(weight[i] - j);
					add02 = Math.abs(weight[i] + j);
					save[add01] = true;
					save[add02] = true;
					save[weight[i]] = true;
				}
			}
			
			for(int j = 0 ; j <= max ; j++)
				check[j] = save[j];
			
		}

		int beadLength =  Integer.parseInt(br.readLine());
		answer = "";		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < beadLength; i++) {
			int value = Integer.parseInt(st.nextToken());
			if(value <= max && check[value] == true) {
				answer += "Y ";
			}else {
				answer += "N ";
			}
		}
		
		System.out.println(answer.trim());
	}

}
