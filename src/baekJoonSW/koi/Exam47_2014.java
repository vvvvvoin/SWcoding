package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam47_2014 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int value = Integer.parseInt(br.readLine());
		int[] arr = new int[3];
		
		if(0 == makeCook(value, arr)){
			for(int cnt : arr){
				System.out.print(cnt + " ");
			}
		}else{
			System.out.println(-1);
		}
	}
	static Integer makeCook(int value, int[] arr){
		while(value >= 300){
			arr[0]++;
			value -= 300;
		}
		while(value >= 60){
			arr[1]++;
			value -= 60;
		}
		while(value >= 10){
			arr[2]++;
			value -= 10;
		}
		return value;
	}
}
