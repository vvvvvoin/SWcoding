package baekJoonSW.koi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Exam01_1996 {
	static BufferedReader br;
	static int N = 0;
	static int[] array;
	static boolean[] check;
	static int value = 0;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		array = new int[N + 1];
		check = new boolean[N + 1];
		list = new ArrayList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		
		for(int i = 1; i <= N; i++) {
			check[i] = true;
			value = i;
			solution(i);
			check[i] = false;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int value : list) {
			System.out.println(value);
		}
	}
	
	static void solution(int i) {
		 if (!check[array[i]]) {     
	            check[array[i]] = true;     
	            solution(array[i]);
	            check[array[i]] = false; 
	        }
		 if(array[i] == value) {
			 list.add(value);
		 }
		
	}

}
