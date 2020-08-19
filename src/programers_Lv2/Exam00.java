package programers_Lv2;

public class Exam00 {
	static int n = 759;
	static int[] array = {1, 2, 4};
	public static void main(String[] args) {
		String answer = "";
		int rest = 0;
		while(n > 0) {
			rest = n %10;
			n = n / 10;
			
			if(rest == 0) {
				n -= 1;
				rest = 10;
			}
			
			answer = rest + answer;
		}
		System.out.println(answer);
	}
}
