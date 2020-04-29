package baekJoonSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exam08_일곱난쟁이 {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] array;
	static int sum;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		array = new int[9];
		for(int i = 0; i<9;i++) {
			array[i] = s.nextInt();
		}
		int checkI = -1;
		int checkj = -1;
		Arrays.sort(array);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i == j) continue;
				
				for(int k = 0; k < 9; k++) {
					if(k == i || k == j) continue;
					sum += array[k];
					
				}
				if(sum == 100) {
					checkI = i;
					checkj = j;
					break;
				}else sum = 0;
			}
			if(checkI >= 0) {
				break;
			}
		}
		for(int i = 0; i<9;i++) {
			if(i == checkI || i == checkj) continue;
			System.out.println(array[i]);
		}
	}
}
