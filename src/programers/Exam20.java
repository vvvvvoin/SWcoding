package programers;

public class Exam20 {
	static long n = 12345;
	public static void main(String[] args) {
		
		String str = ""+ n;
		
		String[] array = str.split("");

		int[] answer = new int[array.length];
		int temp = 0;
		for(int i = array.length-1; i>=0; i--) {
			answer[temp] = Integer.parseInt(array[i]);
			temp++;
		}

		for(int a : answer){
			System.out.println(a);
		}
	}
}
