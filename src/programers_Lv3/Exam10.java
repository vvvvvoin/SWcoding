package programers_Lv3;

public class Exam10 {
	static int n = 8;
	static long answer = 0;
	public static void main(String[] args) {
		System.out.println(find(n));
	}
	
	private static long find(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		int a = 2;
		int b = 1;
		int value = 0;
		
		for(int i = 0; i < n - 2; i++) {
			value = (a + b) % 1234567;
			b = a;
			a = value;
		}
		return value;
	}
}
