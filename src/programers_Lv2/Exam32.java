package programers_Lv2;

public class Exam32 {
//	static int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
//	static int[][] arr2 = { { 3, 3 }, { 3, 3 } };

	static int[][] arr1 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
	static int[][] arr2 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };

	public static void main(String[] args) {
		// 햇갈릴 수 있는 문제이다
		// 행렬 3*2와 2*4 를 계산하는 법을 종이에 쓰고 하면 쉽다
		
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int k = 0; k < arr2[0].length; k++) {
				for (int j = 0; j < arr1[0].length; j++) {
					answer[i][k] += arr1[i][j] * arr2[j][k];
				}
			}
		}

		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				System.out.print(answer[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}
}
