package programers;

import java.util.Arrays;

public class Exam33 {
	static int[] a= {2,2,2,3};
	static int budget = 10;
	public static void main(String[] args) {
		Arrays.sort(a);
		int answer = 0;
		int temp = 0;
		for(int i = 0; i<a.length; i++) {
			temp += a[i];
			if(temp > budget) {
				break;
			}
			answer++;
		}
		
		System.out.println(answer);
	}
}
