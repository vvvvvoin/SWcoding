package programers;

public class Exam31 {
	static int[][] arr1 = {{1},{2}};
	static int[][] arr2 = {{3},{4}};
	public static void main(String[] args) {
		int temp = 0;
		for(int[] i : arr1) {
			temp = i.length;
		}
		int[][] answer = new int[arr1.length][temp];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < temp; j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		
		for(int[] a : answer){
			for(int b : a) {
				System.out.println(b);
			}
		}
	}
}
