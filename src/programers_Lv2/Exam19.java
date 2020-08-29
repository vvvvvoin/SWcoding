package programers_Lv2;

public class Exam19 {
	static int brown = 24;
	static int yellow = 24;
	public static void main(String[] args) {
		int[] answer = new int[2];
		int sum = brown + yellow;
		int x = 0;
		int y = 0;
		int small = 0;
		for(int i = 3; i <= sum/2; i++) {
			y = i;
			if(sum%y != 0) continue;
			x = sum/y;
			small = (x - 2) * (y - 2);
			if(small == yellow) {
				answer[0] = x;
				answer[1] = y;
				break;
			}			
		}
		System.out.println(answer[0] + "   " + answer[1]);
	}
}
