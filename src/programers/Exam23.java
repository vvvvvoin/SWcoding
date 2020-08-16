package programers;

import java.util.Arrays;
import java.util.List;

public class Exam23 {
	static int[] arr = { 4, 3, 1, 2 ,4,3,2,9};

	public static void main(String[] args) {
		int[] answer;

		if (arr.length == 1) {
			answer = new int[1];
		} else {
			answer = new int[arr.length - 1];
		}
		int min = Integer.MAX_VALUE;
		for (int i : arr) {
			min = Math.min(i, min);
		}
		int temp = 0;
		for (int i = 0; i < answer.length; i++) {
			if (arr[i] == min) {
				temp++;
				answer[i] = arr[i+temp];
			} else {
				answer[i] = arr[i + temp];
			}
		}

		for (int i : answer) {
			System.out.println(i);
		}

	}
}
