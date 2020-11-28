package companySWTest.nhn;


class Nhn02 {
	// 옆으로 세나기지 않아야 하는 조건으로
	// 왼쪽과 오른쪽 해당 값은 다음값보다 항상 높다
	static int ciment = 0;

	private static void solution(int day, int width, int[][] blocks) {
		int[] arr = new int[width];
		for (int i = 0; i < day; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				arr[j] += blocks[i][j];
			}

			int maxIndex = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] >= arr[maxIndex]) {
					maxIndex = j;
				}
			}

			int start = 0;
			for (int j = 0; j < maxIndex; j++) {
				if (arr[j] > arr[start]) {
					start = j;
				} else if (arr[j] < arr[start]) {
					ciment += arr[start] - arr[j];
					arr[j] = arr[start];
				}
			}

			start = arr.length - 1;
			for (int j = arr.length - 1; j > maxIndex; j--) {
				if (arr[j] > arr[start]) {
					start = j;
				} else if (arr[j] < arr[start]) {
					ciment += arr[start] - arr[j];
					arr[j] = arr[start];
				}
			}
		}

		System.out.println(ciment);
	}
}