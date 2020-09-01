package programers_Lv2;

import java.util.Arrays;


public class Exam30 {
	static int[] A = {1, 4, 2};
	static int[] B = {5, 4, 4};
	public static void main(String[] args) {
		int answer = 0;

		
		Arrays.sort(A);
		Arrays.sort(B);
		int index = B.length - 1;
		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[index];
			index--;
		}
		
		System.out.println(answer);
	}
}
