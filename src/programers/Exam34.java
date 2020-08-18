package programers;

import java.util.Arrays;

public class Exam34 {
	static int n = 6;
	static int[] arr1 = { 46, 33, 33, 22, 31, 50 };
	static int[] arr2 = { 27, 56, 19, 14, 14, 10 };

	public static void main(String[] args) {
		// 초기화
		String[] array = new String[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = "";
		}

		// 최대값이 몇자리 수 인지 파악
		int max = Math.max(Arrays.stream(arr1).max().getAsInt(), Arrays.stream(arr2).max().getAsInt());
		max = Integer.toBinaryString(max).length();

		// 매핑
		String temp = "";
		String check = "";
		for (int i = 0; i < n; i++) {
			temp = Integer.toBinaryString(arr1[i] | arr2[i]);
			if(temp.length() < max) {
				for(int o = 0; o<max - temp.length(); o++) {
					check += "0";
				}
				temp = check + temp;
			}
			check = "";
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == '1') {
					array[i] += "#";
				} else {
					array[i] += " ";
				}
			}
		}


		for (String str : array) {
			System.out.println(str);
		}
	}
}
