package programers;

import java.util.Arrays;

public class Exam28 {
	static int[] arr = {1,2,3,4};
	public static void main(String[] args) {
		double answer = 0;
		
		answer = Arrays.stream(arr).average().getAsDouble();
		
		
		System.out.println(answer);
	}
}
